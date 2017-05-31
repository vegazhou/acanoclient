package com.kt.acanoclient.obj;

import com.kt.acanoclient.anno.AcanoType;
import org.dom4j.Node;

/**
 * Created by Vega Zhou on 2017/5/19.
 */
@AcanoType("coSpace")
public class CoSpace extends AcanoObject {

    private String name;
    private String uri;
    private String callId;
    private String passcode;
    private String defaultLayout;
    private String callProfile;
    private String callLegProfile;

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
        return "/coSpaces";
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
}
