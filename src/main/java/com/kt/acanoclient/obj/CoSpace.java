package com.kt.acanoclient.obj;

import org.dom4j.Node;

import static com.kt.acanoclient.util.XmlUtil.readTextValue;


/**
 * Created by Vega Zhou on 2017/5/19.
 */
public class CoSpace extends AcanoObject {

    private String name;
    protected boolean isNameDirty = false;

    private String uri;
    protected boolean isUriDirty = false;

    private String callId;
    protected boolean isCallIdDirty = false;

    private String passcode;
    protected boolean isPasscodeDirty = false;

    private String defaultLayout;
    protected boolean isDefaultLayoutDirty = false;

    private String callProfile;
    protected boolean isCallProfileDirty = false;

    private String callLegProfile;
    protected boolean isCallLegProfileDirty = false;

    private boolean requireCallId = false;

    private boolean nonMemberAccess = false;
    protected boolean isNonMemberAccessDirty = false;

    private String secret;
    protected boolean isSecretDirty = false;

    private String streamUrl;
    protected boolean isStreamUrlDirty = false;

    @Override
    public void parseBody(Node bodyNode) {
        id = readTextValue(bodyNode.selectSingleNode("@id"));
        name = readTextValue(bodyNode.selectSingleNode("name"));
        uri = readTextValue(bodyNode.selectSingleNode("uri"));
        secret = readTextValue(bodyNode.selectSingleNode("secret"));
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
        this.isNameDirty = true;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
        this.isUriDirty = true;
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
        this.isCallIdDirty = true;
    }

    public String getDefaultLayout() {
        return defaultLayout;
    }

    public void setDefaultLayout(String defaultLayout) {
        this.defaultLayout = defaultLayout;
        this.isDefaultLayoutDirty = true;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
        this.isPasscodeDirty = true;
    }

    public String getCallProfile() {
        return callProfile;
    }

    public void setCallProfile(String callProfile) {
        this.callProfile = callProfile;
        this.isCallProfileDirty = true;
    }

    public String getCallLegProfile() {
        return callLegProfile;
    }

    public void setCallLegProfile(String callLegProfile) {
        this.callLegProfile = callLegProfile;
        this.isCallLegProfileDirty = true;
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

    public boolean isNonMemberAccess() {
        return nonMemberAccess;
    }

    public void setNonMemberAccess(boolean nonMemberAccess) {
        this.nonMemberAccess = nonMemberAccess;
        this.isNonMemberAccessDirty = true;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
        isSecretDirty = true;
    }

    public String getStreamUrl() {
        return streamUrl;
    }

    public void setStreamUrl(String streamUrl) {
        this.streamUrl = streamUrl;
        isStreamUrlDirty = true;
    }
}
