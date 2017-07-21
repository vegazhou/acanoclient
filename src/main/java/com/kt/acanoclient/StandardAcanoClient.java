package com.kt.acanoclient;

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
                    setDefaultCredentialsProvider(credsProvider).setMaxConnTotal(200).setMaxConnPerRoute(100).
                    build();
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }

    }

    @Override
    public SystemStatus getSystemStatus() throws AcanoApiException {
        SystemStatus systemStatus = new SystemStatus();
        systemStatus = getAcanoObject(systemStatus);
        return systemStatus;
    }

    @Override
    public String createTenant(String name) throws AcanoApiException {
        Tenant tenant = new Tenant();
        tenant.setName(name);
        String id = createAcanoObject(tenant);
        return id;
    }

    @Override
    public void updateTenant(String tenantId, String name) throws AcanoApiException {
        Tenant tenant = new Tenant();
        tenant.setId(tenantId);
        tenant.setName(name);
        updateAcanoObject(tenant);
    }

    @Override
    public String createLdapServer(String address, int port, String user, String password) throws AcanoApiException {
        LdapServer ldapServer = new LdapServer();
        ldapServer.setAddress(address);
        ldapServer.setPortNumber(port);
        ldapServer.setUsername(user);
        ldapServer.setPassword(password);
        String id = createAcanoObject(ldapServer);
        return id;
    }


    @Override
    public void updateLdapServer(String id, String address, int port, String user, String password) throws AcanoApiException {
        LdapServer ldapServer = new LdapServer();
        ldapServer.setId(id);
        ldapServer.setAddress(address);
        ldapServer.setPortNumber(port);
        ldapServer.setUsername(user);
        ldapServer.setPassword(password);
        updateAcanoObject(ldapServer);
    }

    @Override
    public String createLdapMapping(String jidMapping, String nameMapping) throws AcanoApiException {
        LdapMapping ldapMapping = new LdapMapping();
        ldapMapping.setJidMapping(jidMapping);
        ldapMapping.setNameMapping(nameMapping);
        String id = createAcanoObject(ldapMapping);
        return id;
    }


    @Override
    public void updateLdapMapping(String id, String jidMapping, String nameMapping) throws AcanoApiException {
        LdapMapping ldapMapping = new LdapMapping();
        ldapMapping.setId(id);
        ldapMapping.setJidMapping(jidMapping);
        ldapMapping.setNameMapping(nameMapping);
        updateAcanoObject(ldapMapping);
    }

    @Override
    public String createLdapSource(String server, String mapping, String tenant, String baseDn, String filter) throws AcanoApiException {
        LdapSource ldapSource = new LdapSource();
        ldapSource.setServer(server);
        ldapSource.setMapping(mapping);
        ldapSource.setTenant(tenant);
        ldapSource.setBaseDn(baseDn);
        ldapSource.setFilter(filter);
        String id = createAcanoObject(ldapSource);
        return id;
    }


    @Override
    public void updateLdapSource(String id, String server, String mapping, String tenant, String baseDn, String filter) throws AcanoApiException {
        LdapSource ldapSource = new LdapSource();
        ldapSource.setId(id);
        ldapSource.setServer(server);
        ldapSource.setMapping(mapping);
        ldapSource.setTenant(tenant);
        ldapSource.setBaseDn(baseDn);
        ldapSource.setFilter(filter);
        updateAcanoObject(ldapSource);
    }

    @Override
    public String createLdapSync(String tenant, String source) throws AcanoApiException {
        LdapSync ldapSync = new LdapSync();
        ldapSync.setTenant(tenant);
        ldapSync.setLdapSource(source);
        String id = createAcanoObject(ldapSync);
        return id;
    }

    @Override
    public String createCoSpace(String displayName, String passCode, ScreenLayout screenLayout,
                                String callProfileId, String callLegProfileId, String streamUrl)
            throws AcanoApiException {

        CoSpace coSpace = new CoSpace();
        coSpace.setName(displayName);
        coSpace.setPasscode(passCode);
        coSpace.setRequireCallId(true);
        coSpace.setCallProfile(callProfileId);
        coSpace.setCallLegProfile(callLegProfileId);
        coSpace.setDefaultLayout(screenLayout.getValue());
        if (StringUtils.isNotBlank(streamUrl)) {
            coSpace.setStreamUrl(streamUrl);
        }

        String coSpaceId = createAcanoObject(coSpace);
        return coSpaceId;
    }

    @Override
    public void updateCoSpace(String coSpaceId, String displayName, String passCode, ScreenLayout screenLayout,
                              String callProfileId, String callLegProfileId, String streamUrl)
            throws AcanoApiException {
        CoSpace coSpace = new CoSpace();
        coSpace.setId(coSpaceId);
        coSpace.setName(displayName);
        coSpace.setPasscode(passCode);
        coSpace.setCallProfile(callProfileId);
        coSpace.setCallLegProfile(callLegProfileId);
        coSpace.setDefaultLayout(screenLayout.getValue());
        coSpace.setStreamUrl(streamUrl);

        updateAcanoObject(coSpace);
    }

    @Override
    public void deleteCoSpace(String coSpaceId) throws AcanoApiException {
        CoSpace coSpace = new CoSpace();
        coSpace.setId(coSpaceId);
        deleteAcanoObject(coSpace);
    }


    @Override
    public String createCall(String coSpaceId, int participantLimit) throws AcanoApiException {
        Call call = new Call();
        call.setCoSpace(coSpaceId);
        call.setMaxCallLegs(participantLimit);
//        call.setRecording(false);
//        call.setStreaming(true);
        return createAcanoObject(call);
    }

    @Override
    public void deleteCall(String callId) throws AcanoApiException {
        Call call = new Call();
        call.setId(callId);
        deleteAcanoObject(call);
    }


    @Override
    public void showMessageTextInCall(String callId, String messageText, MessagePosition position, int durationInSeconds) throws AcanoApiException {
        Call call = new Call();
        call.setId(callId);
        call.setMessageText(messageText);
        call.setMessagePosition(position.toString());
        if (durationInSeconds > 0) {
            call.setMessageDuration(String.valueOf(durationInSeconds));
        } else {
            call.setMessageDuration("permanent");
        }
        updateAcanoObject(call);
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
    public String createCallLeg(String callId, String remoteParty, String callLegProfileId) throws AcanoApiException {
        CallLeg callLeg = new CallLeg();
        callLeg.setCallId(callId);
        callLeg.setRemoteParty(remoteParty);
        callLeg.setCallLegProfile(callLegProfileId);
        return createAcanoObject(callLeg);
    }

    @Override
    public void deleteCallLeg(String callLegId) throws AcanoApiException {
        CallLeg callLeg = new CallLeg();
        callLeg.setId(callLegId);
        deleteAcanoObject(callLeg);
    }


    @Override
    public String createCallProfile(CallProfile callProfile) throws AcanoApiException {
        return createAcanoObject(callProfile);
    }


    @Override
    public CallProfile getCallProfile(String callProfileId) throws AcanoApiException {
        return getAcanoObject(callProfileId, CallProfile.class);
    }

    @Override
    public void updateCallProfile(CallProfile callProfile) throws AcanoApiException {
        updateAcanoObject(callProfile);
    }

    @Override
    public void deleteCallProfile(String callProfileId) throws AcanoApiException {
        CallProfile callProfile = new CallProfile();
        callProfile.setId(callProfileId);
        deleteAcanoObject(callProfile);
    }

    @Override
    public String createCallLegProfile(CallLegProfile callLegProfile) throws AcanoApiException {
        return createAcanoObject(callLegProfile);
    }

    @Override
    public CallLegProfile getCallLegProfile(String callLegProfileId) throws AcanoApiException {
        return getAcanoObject(callLegProfileId, CallLegProfile.class);
    }

    @Override
    public void updateCallLegProfile(CallLegProfile callLegProfile) throws AcanoApiException {
        updateAcanoObject(callLegProfile);
    }

    @Override
    public void deleteCallLegProfile(String callLegProfileId) throws AcanoApiException {
        CallLegProfile callLegProfile = new CallLegProfile();
        callLegProfile.setId(callLegProfileId);
        deleteAcanoObject(callLegProfile);
    }

    @Override
    public List<CallLeg> listCallLegs(String callId) throws AcanoApiException {
        CallLeg callLeg = new CallLeg();
        callLeg.setCallId(callId);
        List<CallLeg> legs = listAcanoObjects(callLeg);

        List<CallLeg> details = new ArrayList<>();
        for (CallLeg leg : legs) {
            leg.setCallId(callId);
            try {
                details.add(getAcanoObject(leg));
            } catch (AcanoApiException ignore) {
                // 正在响铃状态的call leg无法获取详情
            }
        }
        return details;
    }


    @Override
    public int countAllUsers(String tenantFilter) throws AcanoApiException {
        return countAcanoUsers(new User(), tenantFilter);
    }


    @Override
    public List<User> listUsers(int offset, String tenantFilter) throws AcanoApiException {
        return listAcanoUsers(new User(), offset, tenantFilter);
    }

    @Override
    public User getUser(String userId) throws AcanoApiException {
        return getAcanoObject(userId, User.class);
    }

    @Override
    public void rxAudioMute(String callLegId) throws AcanoApiException {
        CallLeg callLeg = getAcanoObject(callLegId, CallLeg.class);
        callLeg.setRxAudioMute(true);
        updateAcanoObject(callLeg);
    }

    @Override
    public void rxAudioUnMute(String callLegId) throws AcanoApiException {
        CallLeg callLeg = getAcanoObject(callLegId, CallLeg.class);
        callLeg.setRxAudioMute(false);
        updateAcanoObject(callLeg);
    }

    @Override
    public void txAudioMute(String callLegId) throws AcanoApiException {
        CallLeg callLeg = getAcanoObject(callLegId, CallLeg.class);
        callLeg.setTxAudioMute(true);
        updateAcanoObject(callLeg);
    }

    @Override
    public void txAudioUnMute(String callLegId) throws AcanoApiException {
        CallLeg callLeg = getAcanoObject(callLegId, CallLeg.class);
        callLeg.setTxAudioMute(false);
        updateAcanoObject(callLeg);
    }

    @Override
    public void rxVideoMute(String callLegId) throws AcanoApiException {
        CallLeg callLeg = getAcanoObject(callLegId, CallLeg.class);
        callLeg.setRxVideoMute(true);
        updateAcanoObject(callLeg);
    }

    @Override
    public void rxVideoUnMute(String callLegId) throws AcanoApiException {
        CallLeg callLeg = getAcanoObject(callLegId, CallLeg.class);
        callLeg.setRxVideoMute(false);
        updateAcanoObject(callLeg);
    }

    @Override
    public void txVideoMute(String callLegId) throws AcanoApiException {
        CallLeg callLeg = getAcanoObject(callLegId, CallLeg.class);
        callLeg.setTxVideoMute(true);
        updateAcanoObject(callLeg);
    }

    @Override
    public void txVideoUnMute(String callLegId) throws AcanoApiException {
        CallLeg callLeg = getAcanoObject(callLegId, CallLeg.class);
        callLeg.setTxVideoMute(false);
        updateAcanoObject(callLeg);
    }

    @Override
    public void allowPresentation(String callLegId) throws AcanoApiException {
        CallLeg callLeg = getAcanoObject(callLegId, CallLeg.class);
        callLeg.setPresentationContributionAllowed(true);
        updateAcanoObject(callLeg);
    }

    @Override
    public void disallowPresentation(String callLegId) throws AcanoApiException {
        CallLeg callLeg = getAcanoObject(callLegId, CallLeg.class);
        callLeg.setPresentationContributionAllowed(false);
        updateAcanoObject(callLeg);
    }

    private String buildEndPoint() {
        return "https://" + host + ":" + port + "/api/v1";
    }


    private String createAcanoObject(AcanoObject object) throws AcanoApiException {
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


    private <T extends AcanoObject> T getAcanoObject(String id, Class<T> clazz) throws AcanoApiException {
        try {
            T t = clazz.newInstance();
            t.setId(id);
            return getAcanoObject(t);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new AcanoApiException(HttpStatus.SC_INTERNAL_SERVER_ERROR, e);
        }
    }


    private <T extends AcanoObject> T getAcanoObject(T object) throws AcanoApiException {
        HttpGet get = new HttpGet(buildEndPoint() + object.getQueryPath());
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


    private void updateAcanoObject(AcanoObject object) throws AcanoApiException {
        HttpPut put = new HttpPut(buildEndPoint() + object.getQueryPath());
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


    private void deleteAcanoObject(AcanoObject object) throws AcanoApiException {
        HttpDelete delete = new HttpDelete(buildEndPoint() + object.getQueryPath());
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


    private <T extends AcanoObject> int countAcanoObjects(T ao) throws AcanoApiException {
        try {
            HttpGet get = new HttpGet(buildEndPoint() + ao.getNewObjectPath());
            get.setConfig(buildDefaultRequestConfig());

            HttpResponse response = client.execute(get);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                throw new AcanoApiException(HttpStatus.SC_INTERNAL_SERVER_ERROR, EntityUtils.toString(response.getEntity()));
            }
            String xml = EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
            return countRecords(xml);
        } catch (IOException e) {
            e.printStackTrace();
            throw new AcanoApiException(HttpStatus.SC_INTERNAL_SERVER_ERROR, e);
        }
    }

    private <T extends AcanoObject> int countAcanoUsers(T ao, String tenantFilter) throws AcanoApiException {
        try {
            HttpGet get = new HttpGet(buildEndPoint() + ao.getNewObjectPath() + "?tenantFilter=" + tenantFilter);
            get.setConfig(buildDefaultRequestConfig());

            HttpResponse response = client.execute(get);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                throw new AcanoApiException(HttpStatus.SC_INTERNAL_SERVER_ERROR, EntityUtils.toString(response.getEntity()));
            }
            String xml = EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
            return countRecords(xml);
        } catch (IOException e) {
            e.printStackTrace();
            throw new AcanoApiException(HttpStatus.SC_INTERNAL_SERVER_ERROR, e);
        }
    }


    private <T extends AcanoObject> List<T> listAcanoObjects(T ao) throws AcanoApiException {
        try {
            List<T> result = new ArrayList<>();

            HttpGet get = new HttpGet(buildEndPoint() + ao.getNewObjectPath());
            get.setConfig(buildDefaultRequestConfig());

            HttpResponse response = client.execute(get);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                throw new AcanoApiException(HttpStatus.SC_INTERNAL_SERVER_ERROR, EntityUtils.toString(response.getEntity()));
            }

            String xml = EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
            result = (List<T>) parseXmlAsList(ao.getClass(), xml);
            return result;

        } catch (InstantiationException | IllegalAccessException | IOException | DocumentException e) {
            e.printStackTrace();
            throw new AcanoApiException(HttpStatus.SC_INTERNAL_SERVER_ERROR, e);
        }
    }


    private <T extends AcanoObject> List<T> listAcanoUsers(T ao, int offset, String tenantFilter) throws AcanoApiException {
        try {
            List<T> result = new ArrayList<>();

            HttpGet get = new HttpGet(buildEndPoint() + ao.getNewObjectPath() + "?offset=" + offset + "&tenantFilter=" + tenantFilter);
            get.setConfig(buildDefaultRequestConfig());

            HttpResponse response = client.execute(get);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                throw new AcanoApiException(HttpStatus.SC_INTERNAL_SERVER_ERROR, EntityUtils.toString(response.getEntity()));
            }

            String xml = EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
            System.out.println(xml);
            result = (List<T>) parseXmlAsList(ao.getClass(), xml);
            return result;

        } catch (InstantiationException | IllegalAccessException | IOException | DocumentException e) {
            e.printStackTrace();
            throw new AcanoApiException(HttpStatus.SC_INTERNAL_SERVER_ERROR, e);
        }
    }


    private <T extends AcanoObject> List<T> listAcanoObjects(T ao, int offset) throws AcanoApiException {
        try {
            List<T> result = new ArrayList<>();

            HttpGet get = new HttpGet(buildEndPoint() + ao.getNewObjectPath() + "?offset=" + offset);
            get.setConfig(buildDefaultRequestConfig());

            HttpResponse response = client.execute(get);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                throw new AcanoApiException(HttpStatus.SC_INTERNAL_SERVER_ERROR, EntityUtils.toString(response.getEntity()));
            }

            String xml = EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
            System.out.println(xml);
            result = (List<T>) parseXmlAsList(ao.getClass(), xml);
            return result;

        } catch (InstantiationException | IllegalAccessException | IOException | DocumentException e) {
            e.printStackTrace();
            throw new AcanoApiException(HttpStatus.SC_INTERNAL_SERVER_ERROR, e);
        }
    }


    private <T extends AcanoObject> List<T> listAcanoObjects(T ao, int offset, int limit) throws AcanoApiException {
        try {
            List<T> result = new ArrayList<>();

            HttpGet get = new HttpGet(buildEndPoint() + ao.getNewObjectPath() + "?offset=" + offset + "&limit=" + limit);
            get.setConfig(buildDefaultRequestConfig());

            HttpResponse response = client.execute(get);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                throw new AcanoApiException(HttpStatus.SC_INTERNAL_SERVER_ERROR, EntityUtils.toString(response.getEntity()));
            }

            String xml = EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
            System.out.println(xml);
            result = (List<T>) parseXmlAsList(ao.getClass(), xml);
            return result;

        } catch (InstantiationException | IllegalAccessException | IOException | DocumentException e) {
            e.printStackTrace();
            throw new AcanoApiException(HttpStatus.SC_INTERNAL_SERVER_ERROR, e);
        }
    }


    private int countRecords(String xml) {
        try {
            Document document = DocumentHelper.parseText(xml);
            Node totalNode = document.getRootElement().selectSingleNode("@total");

            if (totalNode == null) {
                return 0;
            } else {
                return transformToInt(totalNode.getText());
            }
        } catch (DocumentException e) {
            return 0;
        }
    }


    private <T extends AcanoObject> List<T> parseXmlAsList(Class<T> clazz, String xml)
            throws DocumentException, InstantiationException, IllegalAccessException {
        List<T> result = new ArrayList<>();
        Document document = DocumentHelper.parseText(xml);
        String xPath = clazz.newInstance().getListXPath();
        List<Node> nodes = document.selectNodes(xPath);
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
            String id = StringUtils.substring(location, StringUtils.lastIndexOf(location, "/") + 1);
            return id;
        }

    }


    private int transformToInt(String v) {
        if (v != null) {
            try {
                return Integer.valueOf(v);
            } catch (NumberFormatException e) {
                return 0;
            }
        } else {
            return 0;
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
