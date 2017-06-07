package com.kt.acanoclient.obj;

import org.dom4j.Node;

/**
 * Created by Vega Zhou on 2017/5/22.
 */
public class CallLeg extends AcanoObject {

    private String callId;

    private String remoteParty;
    protected boolean isRemotePartyDirty = false;

    private String callLegProfile;

    private boolean presentationContributionAllowed;
    protected boolean isPresentationContributionAllowedDirty = false;

    private boolean presentationViewingAllowed;
    protected boolean isPresentationViewingAllowedDirty = false;

    private boolean endCallAllowed;
    protected boolean isEndCallAllowedDirty = false;

    private boolean muteOthersAllowed;
    protected boolean isMuteOthersAllowedDirty = false;

    private boolean videoMuteOthersAllowed;
    protected boolean isVideoMuteOthersAllowedDirty = false;

    private boolean muteSelfAllowed;
    protected boolean isMuteSelfAllowedDirty = false;

    private boolean videoMuteSelfAllowed;
    protected boolean isVideoMuteSelfAllowedDirty = false;

    private boolean changeLayoutAllowed;
    protected boolean isChangeLayoutAllowedDirty = false;

    private String name;

    private String state;

    private int durationSeconds;

    private boolean rxAudioMute;
    protected boolean isRxAudioMuteDirty = false;

    private boolean rxVideoMute;
    protected boolean isRxVideoMuteDirty = false;

    private boolean txAudioMute;
    protected boolean isTxAudioMuteDirty = false;

    private boolean txVideoMute;
    protected boolean isTxVideoMuteDirty = false;

    private boolean audioEnabled;

    private boolean videoEnabled;

    private String layout;

    @Override
    public String getNewObjectPath() {
        return "/calls/" + callId + "/callLegs";
    }

    @Override
    public String getQueryPath() {
        return "/callLegs/" + id;
    }

    @Override
    public String getListXPath() {
        return "/callLegs/callLeg";
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

        layout = readTextValue(bodyNode.selectSingleNode("status/layout"));
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
        isRemotePartyDirty = true;
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
        isPresentationContributionAllowedDirty = true;
    }

    public boolean isPresentationViewingAllowed() {
        return presentationViewingAllowed;
    }

    public void setPresentationViewingAllowed(boolean presentationViewingAllowed) {
        this.presentationViewingAllowed = presentationViewingAllowed;
        isPresentationViewingAllowedDirty = true;
    }

    public boolean isEndCallAllowed() {
        return endCallAllowed;
    }

    public void setEndCallAllowed(boolean endCallAllowed) {
        this.endCallAllowed = endCallAllowed;
        isEndCallAllowedDirty = true;
    }

    public boolean isMuteOthersAllowed() {
        return muteOthersAllowed;
    }

    public void setMuteOthersAllowed(boolean muteOthersAllowed) {
        this.muteOthersAllowed = muteOthersAllowed;
        isMuteOthersAllowedDirty = true;
    }

    public boolean isVideoMuteOthersAllowed() {
        return videoMuteOthersAllowed;
    }

    public void setVideoMuteOthersAllowed(boolean videoMuteOthersAllowed) {
        this.videoMuteOthersAllowed = videoMuteOthersAllowed;
        isVideoMuteOthersAllowedDirty = true;
    }

    public boolean isMuteSelfAllowed() {
        return muteSelfAllowed;
    }

    public void setMuteSelfAllowed(boolean muteSelfAllowed) {
        this.muteSelfAllowed = muteSelfAllowed;
        isMuteSelfAllowedDirty = true;
    }

    public boolean isVideoMuteSelfAllowed() {
        return videoMuteSelfAllowed;
    }

    public void setVideoMuteSelfAllowed(boolean videoMuteSelfAllowed) {
        this.videoMuteSelfAllowed = videoMuteSelfAllowed;
        isVideoMuteSelfAllowedDirty = true;
    }

    public boolean isChangeLayoutAllowed() {
        return changeLayoutAllowed;
    }

    public void setChangeLayoutAllowed(boolean changeLayoutAllowed) {
        this.changeLayoutAllowed = changeLayoutAllowed;
        isChangeLayoutAllowedDirty = true;
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
        isRxAudioMuteDirty = true;
    }

    public void setRxVideoMute(boolean rxVideoMute) {
        this.rxVideoMute = rxVideoMute;
        isRxVideoMuteDirty = true;
    }

    public void setTxAudioMute(boolean txAudioMute) {
        this.txAudioMute = txAudioMute;
        isTxAudioMuteDirty = true;
    }

    public void setTxVideoMute(boolean txVideoMute) {
        this.txVideoMute = txVideoMute;
        isTxVideoMuteDirty = true;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }
}
