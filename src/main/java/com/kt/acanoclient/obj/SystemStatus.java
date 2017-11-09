package com.kt.acanoclient.obj;

import org.dom4j.Node;

import static com.kt.acanoclient.util.XmlUtil.*;


/**
 * Created by Vega Zhou on 2017/6/1.
 */
public class SystemStatus extends AcanoObject {

    private String softwareVersion;
    private long uptimeSeconds;
    private long callLegsActive;

    @Override
    public String getNewObjectPath() {
        return "";
    }

    @Override
    public String getQueryPath() {
        return "/system/status";
    }

    @Override
    public String getListXPath() {
        return "/status";
    }

    @Override
    public void parseBody(Node bodyNode) {
        softwareVersion = readTextValue(bodyNode.selectSingleNode("softwareVersion"));
        uptimeSeconds = readLongValue(bodyNode.selectSingleNode("uptimeSeconds"));
        callLegsActive = readLongValue(bodyNode.selectSingleNode("uptimeSeconds"));
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public long getUptimeSeconds() {
        return uptimeSeconds;
    }

    public long getCallLegsActive() {
        return callLegsActive;
    }
}
