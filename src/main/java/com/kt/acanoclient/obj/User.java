package com.kt.acanoclient.obj;

import org.dom4j.Node;
import static com.kt.acanoclient.util.XmlUtil.readTextValue;
import static com.kt.acanoclient.util.XmlUtil.readBooleanValue;
import static com.kt.acanoclient.util.XmlUtil.readIntValue;


/**
 * Created by Vega Zhou on 2017/6/1.
 */
public class User extends AcanoObject {

    private String name;

    private String userJid;


    @Override
    public String getNewObjectPath() {
        return "/users";
    }

    @Override
    public String getQueryPath() {
        return "/users/" + id;
    }

    @Override
    public String getListXPath() {
        return "/users/user";
    }

    @Override
    public void parseBody(Node bodyNode) {
        id = readTextValue(bodyNode.selectSingleNode("@id"));
        userJid = readTextValue(bodyNode.selectSingleNode("userJid"));
        name = readTextValue(bodyNode.selectSingleNode("name"));
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserJid() {
        return userJid;
    }

    public void setUserJid(String userJid) {
        this.userJid = userJid;
    }
}
