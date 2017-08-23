package com.kt.acanoclient.obj;

import com.kt.acanoclient.util.XmlUtil;
import org.dom4j.Node;

/**
 * Created by Vega on 2017/8/23.
 */
public class Licensing extends AcanoObject {
    private int shared;
    private int personal;

    @Override
    public String getNewObjectPath() {
        return "/system/licensing";
    }

    @Override
    public String getQueryPath() {
        return "/system/licensing";
    }

    @Override
    public String getListXPath() {
        return "/licensing";
    }

    @Override
    public void parseBody(Node bodyNode) {
        shared = XmlUtil.readIntValue(bodyNode.selectSingleNode("features/shared/limit"));
        personal = XmlUtil.readIntValue(bodyNode.selectSingleNode("features/personal/limit"));
    }


    public int getShared() {
        return shared;
    }

    public void setShared(int shared) {
        this.shared = shared;
    }

    public int getPersonal() {
        return personal;
    }

    public void setPersonal(int personal) {
        this.personal = personal;
    }
}
