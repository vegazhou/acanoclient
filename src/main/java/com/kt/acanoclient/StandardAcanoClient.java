package com.kt.acanoclient;

import com.kt.acanoclient.anno.AcanoType;
import com.kt.acanoclient.exception.AcanoApiException;
import com.kt.acanoclient.obj.*;
import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vega Zhou on 2017/5/19.
 */
public class StandardAcanoClient implements AcanoClient {

    private HttpClient client;

    private String host;
    private int port;
    private String user;
    private String password;

    public StandardAcanoClient(String host, int port, String user, String password) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
        try {
            SSLContext sslcontext = SSLContext.getInstance("TLS");
            sslcontext.init(null, new TrustManager[]{truseAllManager}, null);
            CredentialsProvider credsProvider = new BasicCredentialsProvider();
            credsProvider.setCredentials(
                    new AuthScope(host, port),
                    new UsernamePasswordCredentials(user, password));

            client = HttpClientBuilder.create().
                    setSSLSocketFactory(new SSLSocketFactory(sslcontext, new AllowAllHostnameVerifier())).
                    setDefaultCredentialsProvider(credsProvider).
                    build();
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }

    }


    @Override
    public String createCoSpace(String displayName, String sipResourceId, String passCode, ScreenLayout screenLayout, int participantLimit)
            throws AcanoApiException {

        CallProfile callProfile = new CallProfile();
        callProfile.setParticipantLimit(participantLimit);
        String callProfileId = createAcanoObject(callProfile);

        CoSpace coSpace = new CoSpace();
        coSpace.setName(displayName);
        coSpace.setCallId(sipResourceId);
        coSpace.setUri(sipResourceId);
        coSpace.setPasscode(passCode);
        coSpace.setCallProfile(callProfileId);
        coSpace.setDefaultLayout(screenLayout.getValue());

        String coSpaceId = createAcanoObject(coSpace);
        return coSpaceId;
    }


    @Override
    public void deleteCoSpace(String coSpaceId) throws AcanoApiException {
        CoSpace coSpace = new CoSpace();
        coSpace.setId(coSpaceId);
        deleteAcanoObject(coSpace);
    }


    @Override
    public String createCall(String coSpaceId) throws AcanoApiException {
        Call call = new Call();
        call.setCoSpace(coSpaceId);
        return createAcanoObject(call);
    }

    @Override
    public void deleteCall(String callId) throws AcanoApiException {
        Call call = new Call();
        call.setId(callId);
        deleteAcanoObject(call);
    }

    @Override
    public String addCoSpaceMember(String coSpaceId, String userJid) throws AcanoApiException {
        CoSpaceUser coSpaceUser = new CoSpaceUser();
        coSpaceUser.setCoSpaceId(coSpaceId);
        coSpaceUser.setUserJid(userJid);
        return createAcanoObject(coSpaceUser);
    }

    @Override
    public void removeCoSpaceMember(String coSpaceId, String userJid) {

    }


    @Override
    public String createCallLeg(String callId, String remoteParty) throws AcanoApiException {
        CallLeg callLeg = new CallLeg();
        callLeg.setCallId(callId);
        callLeg.setRemoteParty(remoteParty);
        return createAcanoObject(callLeg);
    }

    @Override
    public void deleteCallLeg(String callId, String remoteParty) {

    }

    protected String buildEndPoint() {
        return "https://" + host + ":" + port + "/api/v1";
    }




    public String createAcanoObject(AcanoObject object) throws AcanoApiException {
        HttpPost post = new HttpPost(buildEndPoint() + object.getNewObjectPath());
        post.setConfig(buildDefaultRequestConfig());
        List<BasicNameValuePair> params = object.buildPostParams();
        try {
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, "UTF-8");
            post.setEntity(entity);
            HttpResponse httpResponse = client.execute(post);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                throw new AcanoApiException(statusCode, EntityUtils.toString(httpResponse.getEntity()));
            }
            return extractIdFromResponse(httpResponse);
        } catch (UnsupportedEncodingException ignore) {
        } catch (IOException e) {
            e.printStackTrace();
            throw new AcanoApiException(HttpStatus.SC_INTERNAL_SERVER_ERROR, e);
        }
        return null;
    }


    public <T extends AcanoObject> T getAcanoObject(String id, Class<T> clazz) throws AcanoApiException {
        try {
            T t = clazz.newInstance();
            t.setId(id);
            return getAcanoObject(t);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new AcanoApiException(HttpStatus.SC_INTERNAL_SERVER_ERROR, e);
        }
    }


    public <T extends AcanoObject> T getAcanoObject(T object) throws AcanoApiException {
        HttpGet get = new HttpGet(buildEndPoint() + object.getNewObjectPath() + "/" + object.getId());
        get.setConfig(buildDefaultRequestConfig());
        try {
            HttpResponse response = client.execute(get);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                throw new AcanoApiException(statusCode, EntityUtils.toString(response.getEntity()));
            }

            String xml = EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
            return parseXmlAsObject(object, xml);
        } catch (IOException | DocumentException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new AcanoApiException(HttpStatus.SC_INTERNAL_SERVER_ERROR, e);
        }
    }


    public void updateAcanoObject(AcanoObject object) throws AcanoApiException {
        HttpPut put = new HttpPut(buildEndPoint() + object.getNewObjectPath() + "/" + object.getId());
        put.setConfig(buildDefaultRequestConfig());
        String putBody = object.buildPutBody();
        put.setEntity(new StringEntity(putBody, ContentType.APPLICATION_FORM_URLENCODED));
        try {
            HttpResponse response = client.execute(put);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                throw new AcanoApiException(statusCode, EntityUtils.toString(response.getEntity()));
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new AcanoApiException(HttpStatus.SC_INTERNAL_SERVER_ERROR, e);
        }
    }


    public void deleteAcanoObject(AcanoObject object) throws AcanoApiException {
        HttpDelete delete = new HttpDelete(buildEndPoint() + object.getNewObjectPath() + "/" + object.getId());
        delete.setConfig(buildDefaultRequestConfig());
        try {
            HttpResponse response = client.execute(delete);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                throw new AcanoApiException(statusCode, EntityUtils.toString(response.getEntity()));
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new AcanoApiException(HttpStatus.SC_INTERNAL_SERVER_ERROR, e);
        }
    }



    public <T extends AcanoObject> List<T> listAcanoObjects(Class<T> clazz) throws AcanoApiException {
        try {
            List<T> result = new ArrayList<>();
            T ao = clazz.newInstance();
            HttpGet get = new HttpGet(buildEndPoint() + ao.getNewObjectPath());
            get.setConfig(buildDefaultRequestConfig());

            HttpResponse response = client.execute(get);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                throw new AcanoApiException(HttpStatus.SC_INTERNAL_SERVER_ERROR, EntityUtils.toString(response.getEntity()));
            }
            AcanoType at = clazz.getAnnotation(AcanoType.class);
            if (at == null) {
                return result;
            } else {
                String xml = EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
                result = parseXmlAsList(clazz, xml, at.value());
                return result;
            }
        } catch (InstantiationException | IllegalAccessException | IOException | DocumentException e) {
            e.printStackTrace();
            throw new AcanoApiException(HttpStatus.SC_INTERNAL_SERVER_ERROR, e);
        }
    }





    private <T extends AcanoObject> List<T> parseXmlAsList(Class<T> clazz, String xml, String acanoObjectType)
            throws DocumentException, InstantiationException, IllegalAccessException {
        List<T> result = new ArrayList<>();
        Document document = DocumentHelper.parseText(xml);
        List<Node> nodes = document.selectNodes("/" + acanoObjectType + "s/" + acanoObjectType);
        for (Node node : nodes) {
            result.add(parseNode(clazz, node));
        }
        return result;
    }

    private <T extends AcanoObject> T parseXmlAsObject(T object, String xml)
            throws DocumentException, InstantiationException, IllegalAccessException {
        Document document = DocumentHelper.parseText(xml);
        return (T) parseNode(object.getClass(), document.getRootElement());
    }


    private <T extends AcanoObject> T parseNode(Class<T> clazz, Node node) throws IllegalAccessException, InstantiationException {
        T ao = clazz.newInstance();
        ao.parseBody(node);
        return ao;
    }




    private RequestConfig buildDefaultRequestConfig() {
        return RequestConfig.custom()
                .setConnectTimeout(10000)   //设置连接超时时间
                .setConnectionRequestTimeout(10000) // 设置请求超时时间
                .setSocketTimeout(10000)
                .setRedirectsEnabled(false)//不允许自动重定向
                .build();
    }


    private String extractIdFromResponse(HttpResponse httpResponse) {
        Header locationHeader = httpResponse.getFirstHeader("Location");
        if (locationHeader == null) {
            return null;
        } else {
            String location = locationHeader.getValue();
            String id = StringUtils.substring(location, StringUtils.lastIndexOf(location, "/") + 1 );
            return id;
        }

    }



    private static TrustManager truseAllManager = new X509TrustManager() {

        public void checkClientTrusted(
                java.security.cert.X509Certificate[] arg0, String arg1)
                throws CertificateException {
        }

        public void checkServerTrusted(
                java.security.cert.X509Certificate[] arg0, String arg1)
                throws CertificateException {
        }

        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    };
}
