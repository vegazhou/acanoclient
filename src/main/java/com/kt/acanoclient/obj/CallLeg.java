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
    private String name;


    private String state;
    private int durationSeconds;
    private boolean rxAudioMute;
    private boolean rxVideoMute;
    private boolean txAudioMute;
    private boolean txVideoMute;
    private boolean audioEnabled;
    private boolean videoEnabled;

    @Override
    public String getNewObjectPath() {
        return "/calls/" + callId + "/callLegs";
    }

    @Override
    public String getQueryPath() {
        return "/callLegs";
    }

    @Override
    public void parseBody(Node bodyNode) {
        id = readTextValue(bodyNode.selectSingleNode("@id"));
        name = readTextValue(bodyNode.selectSingleNode("name"));
        remoteParty = readTextValue(bodyNode.selectSingleNode("remoteParty"));

        presentationContributionAllowed = readBooleanValue(bodyNode.selectSingleNode("configuration/presentationContributionAllowed"));
        presentationViewingAllowed = readBooleanValue(bodyNode.selectSingleNode("configuration/presentationViewingAllowed"));
        muteOthersAllowed = readBooleanValue(bodyNode.selectSingleNode("configuration/muteOthersAllowed"));
        muteSelfAllowed = readBooleanValue(bodyNode.selectSingleNode("configuration/muteSelfAllowed"));
        videoMuteOthersAllowed = readBooleanValue(bodyNode.selectSingleNode("configuration/videoMuteOthersAllowed"));
        videoMuteSelfAllowed = readBooleanValue(bodyNode.selectSingleNode("configuration/videoMuteSelfAllowed"));
        endCallAllowed = readBooleanValue(bodyNode.selectSingleNode("configuration/endCallAllowed"));
        changeLayoutAllowed = readBooleanValue(bodyNode.selectSingleNode("configuration/changeLayoutAllowed"));

        state = readTextValue(bodyNode.selectSingleNode("status/state"));
        durationSeconds = readIntValue(bodyNode.selectSingleNode("status/durationSeconds"));
        audioEnabled = bodyNode.selectSingleNode("status/rxAudio") != null;
        videoEnabled = bodyNode.selectSingleNode("status/rxVideo") != null;
        rxAudioMute = readBooleanValue(bodyNode.selectSingleNode("configuration/rxAudioMute"));
        rxVideoMute = readBooleanValue(bodyNode.selectSingleNode("configuration/rxVideoMute"));
        txAudioMute = readBooleanValue(bodyNode.selectSingleNode("configuration/txAudioMute"));
        txVideoMute = readBooleanValue(bodyNode.selectSingleNode("configuration/txVideoMute"));
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

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public boolean isRxAudioMute() {
        return rxAudioMute;
    }

    public boolean isRxVideoMute() {
        return rxVideoMute;
    }

    public boolean isAudioEnabled() {
        return audioEnabled;
    }

    public boolean isVideoEnabled() {
        return videoEnabled;
    }

    public boolean isTxAudioMute() {
        return txAudioMute;
    }

    public boolean isTxVideoMute() {
        return txVideoMute;
    }

    public void setRxAudioMute(boolean rxAudioMute) {
        this.rxAudioMute = rxAudioMute;
    }

    public void setRxVideoMute(boolean rxVideoMute) {
        this.rxVideoMute = rxVideoMute;
    }

    public void setTxAudioMute(boolean txAudioMute) {
        this.txAudioMute = txAudioMute;
    }

    public void setTxVideoMute(boolean txVideoMute) {
        this.txVideoMute = txVideoMute;
    }
}
