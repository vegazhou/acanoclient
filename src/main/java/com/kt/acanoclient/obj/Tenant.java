package com.kt.acanoclient.obj;

import org.dom4j.Node;

/**
 * Created by Vega Zhou on 2017/6/14.
 */
public class Tenant extends AcanoObject {

    private String name;

    @Override
    public String getNewObjectPath() {
        return "/tenants";
    }

    @Override
    public String getQueryPath() {
        return "/tenants/" + id;
    }

    @Override
    public String getListXPath() {
        return "/tenants/tenant";
    }

    @Override
    public void parseBody(Node bodyNode) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
