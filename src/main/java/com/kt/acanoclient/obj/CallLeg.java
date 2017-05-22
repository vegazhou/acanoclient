package com.kt.acanoclient.obj;

import com.kt.acanoclient.anno.AcanoType;
import org.dom4j.Node;

/**
 * Created by Vega Zhou on 2017/5/22.
 */
@AcanoType("callLeg")
public class CallLeg extends AcanoObject {

    private String callId;
    private String remoteParty;
    private String callLegProfile;
    private boolean presentationContributionAllowed;
    private boolean presentationViewingAllowed;
    private boolean endCallAllowed;
    private boolean muteOthersAllowed;
    private boolean videoMuteOthersAllowed;
    private boolean muteSelfAllowed;
    private boolean videoMuteSelfAllowed;
    private boolean changeLayoutAllowed;


    @Override
    public String getNewObjectPath() {
        return "/calls/" + callId + "/callLegs";
    }

    @Override
    public void parseBody(Node bodyNode) {

    }


    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public String getRemoteParty() {
        return remoteParty;
    }

    public void setRemoteParty(String remoteParty) {
        this.remoteParty = remoteParty;
    }

    public String getCallLegProfile() {
        return callLegProfile;
    }

    public void setCallLegProfile(String callLegProfile) {
        this.callLegProfile = callLegProfile;
    }

    public boolean isPresentationContributionAllowed() {
        return presentationContributionAllowed;
    }

    public void setPresentationContributionAllowed(boolean presentationContributionAllowed) {
        this.presentationContributionAllowed = presentationContributionAllowed;
    }

    public boolean isPresentationViewingAllowed() {
        return presentationViewingAllowed;
    }

    public void setPresentationViewingAllowed(boolean presentationViewingAllowed) {
        this.presentationViewingAllowed = presentationViewingAllowed;
    }

    public boolean isEndCallAllowed() {
        return endCallAllowed;
    }

    public void setEndCallAllowed(boolean endCallAllowed) {
        this.endCallAllowed = endCallAllowed;
    }

    public boolean isMuteOthersAllowed() {
        return muteOthersAllowed;
    }

    public void setMuteOthersAllowed(boolean muteOthersAllowed) {
        this.muteOthersAllowed = muteOthersAllowed;
    }

    public boolean isVideoMuteOthersAllowed() {
        return videoMuteOthersAllowed;
    }

    public void setVideoMuteOthersAllowed(boolean videoMuteOthersAllowed) {
        this.videoMuteOthersAllowed = videoMuteOthersAllowed;
    }

    public boolean isMuteSelfAllowed() {
        return muteSelfAllowed;
    }

    public void setMuteSelfAllowed(boolean muteSelfAllowed) {
        this.muteSelfAllowed = muteSelfAllowed;
    }

    public boolean isVideoMuteSelfAllowed() {
        return videoMuteSelfAllowed;
    }

    public void setVideoMuteSelfAllowed(boolean videoMuteSelfAllowed) {
        this.videoMuteSelfAllowed = videoMuteSelfAllowed;
    }

    public boolean isChangeLayoutAllowed() {
        return changeLayoutAllowed;
    }

    public void setChangeLayoutAllowed(boolean changeLayoutAllowed) {
        this.changeLayoutAllowed = changeLayoutAllowed;
    }
}
