package com.kt.acanoclient.obj;

import org.dom4j.Node;

/**
 * Created by Vega Zhou on 2017/6/14.
 */
public class LdapServer extends AcanoObject {
    private String address;
    private int portNumber;
    private String username;
    private String password;
    private boolean secure;

    @Override
    public String getNewObjectPath() {
        return "/ldapServers";
    }

    @Override
    public String getQueryPath() {
        return "/ldapServers/" + id;
    }

    @Override
    public String getListXPath() {
        return "/ldapServers/ldapServer";
    }

    @Override
    public void parseBody(Node bodyNode) {

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSecure() {
        return secure;
    }

    public void setSecure(boolean secure) {
        this.secure = secure;
    }
}
