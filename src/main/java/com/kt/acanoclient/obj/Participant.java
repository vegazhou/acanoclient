package com.kt.acanoclient.obj;

import org.dom4j.Node;

import static com.kt.acanoclient.util.XmlUtil.readTextValue;

/**
 * Created by Vega on 2017/8/23.
 */
public class Participant extends AcanoObject {

    private String callId;

    private String name;

    private int importance;
    protected boolean isImportanceDirty = false;

    @Override
    public String getNewObjectPath() {
        return "/participants";
    }

    @Override
    public String getQueryPath() {
        return "/participants/" + id;
    }

    @Override
    public String getListXPath() {
        return "/participants/participant";
    }

    @Override
    public void parseBody(Node bodyNode) {
        id = readTextValue(bodyNode.selectSingleNode("@id"));
        name = readTextValue(bodyNode.selectSingleNode("name"));
        callId = readTextValue(bodyNode.selectSingleNode("call"));
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
        isImportanceDirty = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImportanceDirty() {
        return isImportanceDirty;
    }

    public void setIsImportanceDirty(boolean isImportanceDirty) {
        this.isImportanceDirty = isImportanceDirty;
    }
}
