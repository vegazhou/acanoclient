package com.kt.acanoclient.obj;

import org.dom4j.Node;

/**
 * Created by Vega Zhou on 2017/6/14.
 */
public class LdapSync extends AcanoObject {

    private String tenant;
    private String ldapSource;
    private boolean removeWhenFinished = true;


    @Override
    public String getNewObjectPath() {
        return "/ldapSyncs";
    }

    @Override
    public String getQueryPath() {
        return "/ldapSyncs/" + id;
    }

    @Override
    public String getListXPath() {
        return "/ldapSyncs/ldapSync";
    }

    @Override
    public void parseBody(Node bodyNode) {

    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getLdapSource() {
        return ldapSource;
    }

    public void setLdapSource(String ldapSource) {
        this.ldapSource = ldapSource;
    }

    public boolean isRemoveWhenFinished() {
        return removeWhenFinished;
    }

    public void setRemoveWhenFinished(boolean removeWhenFinished) {
        this.removeWhenFinished = removeWhenFinished;
    }
}
