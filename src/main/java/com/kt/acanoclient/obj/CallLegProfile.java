package com.kt.acanoclient.obj;

import org.dom4j.Node;

/**
 * Created by Vega Zhou on 2017/5/24.
 */
public class CallLegProfile extends AcanoObject {

    private boolean needsActivation = false;
    private String defaultLayout = "allEqual";
    private boolean changeLayoutAllowed = false;
    private boolean participantLabels = false;
    private String presentationDisplayMode = "singleStream" ; //dualStream|singleStream
    private boolean presentationContributionAllowed;
    private boolean allowAllPresentationContributionAllowed;
    private boolean presentationViewingAllowed;
    private boolean endCallAllowed;
    private boolean disconnectOthersAllowed;
    private boolean muteOthersAllowed;
    private boolean changeJoinAudioMuteOverrideAllowed;
    private boolean muteSelfAllowed;
    private boolean videoMuteOthersAllowed;
    private boolean allowAllMuteSelfAllowed;
    private boolean videoMuteSelfAllowed;
    private String videoMode = "auto"; //auto|disabled
    private boolean rxAudioMute;
    private boolean txAudioMute;
    private boolean rxVideoMute;
    private boolean txVideoMute;
    private boolean telepresenceCallsAllowed;
    private boolean sipPresentationChannelEnabled;
    private boolean callLockAllowed;
    private boolean recordingControlAllowed;
    private boolean streamingControlAllowed;

    @Override
    public String getNewObjectPath() {
        return "/callLegProfiles";
    }

    @Override
    public String getQueryPath() {
        return "/callLegProfiles/" + id;
    }

    @Override
    public String getListXPath() {
        return "/callLegProfiles/callLegProfile";
    }

    @Override
    public void parseBody(Node bodyNode) {

    }


    public boolean isNeedsActivation() {
        return needsActivation;
    }

    public void setNeedsActivation(boolean needsActivation) {
        this.needsActivation = needsActivation;
    }

    public String getDefaultLayout() {
        return defaultLayout;
    }

    public void setDefaultLayout(String defaultLayout) {
        this.defaultLayout = defaultLayout;
    }

    public boolean isChangeLayoutAllowed() {
        return changeLayoutAllowed;
    }

    public void setChangeLayoutAllowed(boolean changeLayoutAllowed) {
        this.changeLayoutAllowed = changeLayoutAllowed;
    }

    public boolean isParticipantLabels() {
        return participantLabels;
    }

    public void setParticipantLabels(boolean participantLabels) {
        this.participantLabels = participantLabels;
    }

    public String getPresentationDisplayMode() {
        return presentationDisplayMode;
    }

    public void setPresentationDisplayMode(String presentationDisplayMode) {
        this.presentationDisplayMode = presentationDisplayMode;
    }

    public boolean isPresentationContributionAllowed() {
        return presentationContributionAllowed;
    }

    public void setPresentationContributionAllowed(boolean presentationContributionAllowed) {
        this.presentationContributionAllowed = presentationContributionAllowed;
    }

    public boolean isAllowAllPresentationContributionAllowed() {
        return allowAllPresentationContributionAllowed;
    }

    public void setAllowAllPresentationContributionAllowed(boolean allowAllPresentationContributionAllowed) {
        this.allowAllPresentationContributionAllowed = allowAllPresentationContributionAllowed;
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

    public boolean isDisconnectOthersAllowed() {
        return disconnectOthersAllowed;
    }

    public void setDisconnectOthersAllowed(boolean disconnectOthersAllowed) {
        this.disconnectOthersAllowed = disconnectOthersAllowed;
    }

    public boolean isMuteOthersAllowed() {
        return muteOthersAllowed;
    }

    public void setMuteOthersAllowed(boolean muteOthersAllowed) {
        this.muteOthersAllowed = muteOthersAllowed;
    }

    public boolean isChangeJoinAudioMuteOverrideAllowed() {
        return changeJoinAudioMuteOverrideAllowed;
    }

    public void setChangeJoinAudioMuteOverrideAllowed(boolean changeJoinAudioMuteOverrideAllowed) {
        this.changeJoinAudioMuteOverrideAllowed = changeJoinAudioMuteOverrideAllowed;
    }

    public boolean isMuteSelfAllowed() {
        return muteSelfAllowed;
    }

    public void setMuteSelfAllowed(boolean muteSelfAllowed) {
        this.muteSelfAllowed = muteSelfAllowed;
    }

    public boolean isVideoMuteOthersAllowed() {
        return videoMuteOthersAllowed;
    }

    public void setVideoMuteOthersAllowed(boolean videoMuteOthersAllowed) {
        this.videoMuteOthersAllowed = videoMuteOthersAllowed;
    }

    public boolean isAllowAllMuteSelfAllowed() {
        return allowAllMuteSelfAllowed;
    }

    public void setAllowAllMuteSelfAllowed(boolean allowAllMuteSelfAllowed) {
        this.allowAllMuteSelfAllowed = allowAllMuteSelfAllowed;
    }

    public boolean isVideoMuteSelfAllowed() {
        return videoMuteSelfAllowed;
    }

    public void setVideoMuteSelfAllowed(boolean videoMuteSelfAllowed) {
        this.videoMuteSelfAllowed = videoMuteSelfAllowed;
    }

    public String getVideoMode() {
        return videoMode;
    }

    public void setVideoMode(String videoMode) {
        this.videoMode = videoMode;
    }

    public boolean isRxAudioMute() {
        return rxAudioMute;
    }

    public void setRxAudioMute(boolean rxAudioMute) {
        this.rxAudioMute = rxAudioMute;
    }

    public boolean isTxAudioMute() {
        return txAudioMute;
    }

    public void setTxAudioMute(boolean txAudioMute) {
        this.txAudioMute = txAudioMute;
    }

    public boolean isRxVideoMute() {
        return rxVideoMute;
    }

    public void setRxVideoMute(boolean rxVideoMute) {
        this.rxVideoMute = rxVideoMute;
    }

    public boolean isTxVideoMute() {
        return txVideoMute;
    }

    public void setTxVideoMute(boolean txVideoMute) {
        this.txVideoMute = txVideoMute;
    }

    public boolean isTelepresenceCallsAllowed() {
        return telepresenceCallsAllowed;
    }

    public void setTelepresenceCallsAllowed(boolean telepresenceCallsAllowed) {
        this.telepresenceCallsAllowed = telepresenceCallsAllowed;
    }

    public boolean isSipPresentationChannelEnabled() {
        return sipPresentationChannelEnabled;
    }

    public void setSipPresentationChannelEnabled(boolean sipPresentationChannelEnabled) {
        this.sipPresentationChannelEnabled = sipPresentationChannelEnabled;
    }

    public boolean isCallLockAllowed() {
        return callLockAllowed;
    }

    public void setCallLockAllowed(boolean callLockAllowed) {
        this.callLockAllowed = callLockAllowed;
    }

    public boolean isRecordingControlAllowed() {
        return recordingControlAllowed;
    }

    public void setRecordingControlAllowed(boolean recordingControlAllowed) {
        this.recordingControlAllowed = recordingControlAllowed;
    }

    public boolean isStreamingControlAllowed() {
        return streamingControlAllowed;
    }

    public void setStreamingControlAllowed(boolean streamingControlAllowed) {
        this.streamingControlAllowed = streamingControlAllowed;
    }
}
