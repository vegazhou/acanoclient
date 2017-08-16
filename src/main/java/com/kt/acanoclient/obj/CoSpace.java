package com.kt.acanoclient.obj;

import org.dom4j.Node;
import static com.kt.acanoclient.util.XmlUtil.readTextValue;
import static com.kt.acanoclient.util.XmlUtil.readBooleanValue;
import static com.kt.acanoclient.util.XmlUtil.readIntValue;


/**
 * Created by Vega Zhou on 2017/5/19.
 */
public class CoSpace extends AcanoObject {

    private String name;
    private String uri;
    private String callId;
    private String passcode;
    private String defaultLayout;
    private String callProfile;
    private String callLegProfile;
    private boolean requireCallId = false;

    private String streamUrl;
    protected boolean isStreamUrlDirty = false;

    @Override
    public void parseBody(Node bodyNode) {
        id = readTextValue(bodyNode.selectSingleNode("@id"));
        name = readTextValue(bodyNode.selectSingleNode("name"));
        uri = readTextValue(bodyNode.selectSingleNode("uri"));
        callId = readTextValue(bodyNode.selectSingleNode("callId"));
    }

    @Override
    public String getNewObjectPath() {
        return "/coSpaces";
    }

    @Override
    public String getQueryPath() {
        return "/coSpaces/" + id;
    }

    @Override
    public String getListXPath() {
        return "/coSpaces/coSpace";
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public String getDefaultLayout() {
        return defaultLayout;
    }

    public void setDefaultLayout(String defaultLayout) {
        this.defaultLayout = defaultLayout;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public String getCallProfile() {
        return callProfile;
    }

    public void setCallProfile(String callProfile) {
        this.callProfile = callProfile;
    }

    public String getCallLegProfile() {
        return callLegProfile;
    }

    public void setCallLegProfile(String callLegProfile) {
        this.callLegProfile = callLegProfile;
    }

    public boolean isRequireCallId() {
        return requireCallId;
    }

    public void setRequireCallId(boolean requireCallId) {
        this.requireCallId = requireCallId;
    }

    public boolean isStreamUrlDirty() {
        return isStreamUrlDirty;
    }

    public void setIsStreamUrlDirty(boolean isStreamUrlDirty) {
        this.isStreamUrlDirty = isStreamUrlDirty;
    }

    public String getStreamUrl() {
        return streamUrl;
    }

    public void setStreamUrl(String streamUrl) {
        this.streamUrl = streamUrl;
        isStreamUrlDirty = true;
    }
}
