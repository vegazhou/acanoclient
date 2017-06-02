package com.kt.acanoclient.obj;

import org.dom4j.Node;

/**
 * Created by Vega Zhou on 2017/6/1.
 */
public class SystemStatus extends AcanoObject {

    private String softwareVersion;

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
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }
}
