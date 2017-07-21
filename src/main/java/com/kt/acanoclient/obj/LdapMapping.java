package com.kt.acanoclient.obj;

import org.dom4j.Node;

/**
 * Created by Vega Zhou on 2017/6/14.
 */
public class LdapMapping extends AcanoObject {
    private String jidMapping;

    private String nameMapping;

    @Override
    public String getNewObjectPath() {
        return "/ldapMappings";
    }

    @Override
    public String getQueryPath() {
        return "/ldapMappings/" + id;
    }

    @Override
    public String getListXPath() {
        return "/ldapMappings/ldapMapping";
    }

    @Override
    public void parseBody(Node bodyNode) {

    }


    public String getJidMapping() {
        return jidMapping;
    }

    public void setJidMapping(String jidMapping) {
        this.jidMapping = jidMapping;
    }

    public String getNameMapping() {
        return nameMapping;
    }

    public void setNameMapping(String nameMapping) {
        this.nameMapping = nameMapping;
    }
}
