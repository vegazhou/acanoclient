package com.kt.acanoclient.obj;

import com.kt.acanoclient.anno.AcanoType;
import org.dom4j.Node;

/**
 * Created by Vega Zhou on 2017/5/22.
 */
@AcanoType("coSpaceUser")
public class CoSpaceUser extends AcanoObject {

    private String coSpaceId;

    private String userJid;
    private String callLegProfile;
    private boolean canDestroy;
    private boolean canAddRemoveMember;
    private boolean canChangeName;
    private boolean canPostMessage;



    @Override
    public String getNewObjectPath() {
        return "/coSpaces/" + coSpaceId + "/coSpaceUsers";
    }

    @Override
    public String getQueryPath() {
        return "/coSpaces/" + coSpaceId + "/coSpaceUsers";
    }

    @Override
    public void parseBody(Node bodyNode) {

    }


    public String getCoSpaceId() {
        return coSpaceId;
    }

    public void setCoSpaceId(String coSpaceId) {
        this.coSpaceId = coSpaceId;
    }

    public String getUserJid() {
        return userJid;
    }

    public void setUserJid(String userJid) {
        this.userJid = userJid;
    }

    public String getCallLegProfile() {
        return callLegProfile;
    }

    public void setCallLegProfile(String callLegProfile) {
        this.callLegProfile = callLegProfile;
    }

    public boolean isCanDestroy() {
        return canDestroy;
    }

    public void setCanDestroy(boolean canDestroy) {
        this.canDestroy = canDestroy;
    }

    public boolean isCanAddRemoveMember() {
        return canAddRemoveMember;
    }

    public void setCanAddRemoveMember(boolean canAddRemoveMember) {
        this.canAddRemoveMember = canAddRemoveMember;
    }

    public boolean isCanChangeName() {
        return canChangeName;
    }

    public void setCanChangeName(boolean canChangeName) {
        this.canChangeName = canChangeName;
    }

    public boolean isCanPostMessage() {
        return canPostMessage;
    }

    public void setCanPostMessage(boolean canPostMessage) {
        this.canPostMessage = canPostMessage;
    }
}
