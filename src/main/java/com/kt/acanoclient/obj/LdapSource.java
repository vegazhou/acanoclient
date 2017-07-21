package com.kt.acanoclient.obj;

import org.dom4j.Node;

/**
 * Created by Vega Zhou on 2017/6/14.
 */
public class LdapSource extends AcanoObject {

    private String server;
    private String mapping;
    private String tenant;
    private String baseDn;
    private String filter;

    @Override
    public String getNewObjectPath() {
        return "/ldapSources";
    }

    @Override
    public String getQueryPath() {
        return "/ldapSources/" + id;
    }

    @Override
    public String getListXPath() {
        return "/ldapSources/ldapSource";
    }

    @Override
    public void parseBody(Node bodyNode) {

    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getMapping() {
        return mapping;
    }

    public void setMapping(String mapping) {
        this.mapping = mapping;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getBaseDn() {
        return baseDn;
    }

    public void setBaseDn(String baseDn) {
        this.baseDn = baseDn;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }
}
