package com.kt.acanoclient.obj;

import org.dom4j.Node;

import static com.kt.acanoclient.util.XmlUtil.readLongValue;

/**
 * Created by Vega on 2017/8/23.
 */
public class Load extends AcanoObject {
    private long mediaProcessingLoad;

    @Override
    public String getNewObjectPath() {
        return "/system/load";
    }

    @Override
    public String getQueryPath() {
        return "/system/load";
    }

    @Override
    public String getListXPath() {
        return "/load";
    }

    @Override
    public void parseBody(Node bodyNode) {
        mediaProcessingLoad = readLongValue(bodyNode.selectSingleNode("mediaProcessingLoad"));
    }

    public long getMediaProcessingLoad() {
        return mediaProcessingLoad;
    }
}
