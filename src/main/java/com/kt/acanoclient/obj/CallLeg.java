package com.kt.acanoclient.obj;

import static com.kt.acanoclient.util.XmlUtil.readTextValue;
import static com.kt.acanoclient.util.XmlUtil.readBooleanValue;
import static com.kt.acanoclient.util.XmlUtil.readIntValue;
import static com.kt.acanoclient.util.XmlUtil.readLongValue;
import static com.kt.acanoclient.util.XmlUtil.readDoubleValue;

import org.dom4j.Node;

/**
 * Created by Vega Zhou on 2017/5/22.
 */
public class CallLeg extends AcanoObject {

    private String callId;

    private String remoteParty;
    protected boolean isRemotePartyDirty = false;

    private String callLegProfile;
    protected boolean isCallLegProfileDirty = false;

    private String presentationDisplayMode;
    protected boolean isPresentationDisplayModeDirty = false;

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

    private boolean rxAudioMute;
    protected boolean isRxAudioMuteDirty = false;

    private boolean rxVideoMute;
    protected boolean isRxVideoMuteDirty = false;

    private boolean txAudioMute;
    protected boolean isTxAudioMuteDirty = false;

    private boolean txVideoMute;
    protected boolean isTxVideoMuteDirty = false;

    private String layout;
    protected boolean isLayoutDirty = false;

    private String defaultLayout;
    protected boolean isDefaultLayoutDirty = false;

    private long bandwidth;
    protected boolean isBandwidthDirty = false;

    private String ownerId;
    protected boolean isOwnerIdDirty = false;

    private String qualityMain;    //unrestricted|max1080p30|max720p30|max480p30
    protected boolean isQualityMainDirty = false;

    private String qualityPresentation;
    protected boolean isQualityPresentationDirty = false;

    // =================== READ ONLY FIELDS ====================
    private String name;
    private String state;
    private boolean audioEnabled;
    private boolean videoEnabled;
    private int durationSeconds;
    private String type;
    private Configuration configuration;
    private Status status;

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
        type = readTextValue(bodyNode.selectSingleNode("type"));
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

        configuration = new Configuration();
        configuration.parseBody(bodyNode.selectSingleNode("configuration"));
        status = new Status();
        status.parseBody(bodyNode.selectSingleNode("status"));
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
        isCallLegProfileDirty = true;
    }

    public String getPresentationDisplayMode() {
        return presentationDisplayMode;
    }

    public void setPresentationDisplayMode(String presentationDisplayMode) {
        this.presentationDisplayMode = presentationDisplayMode;
        isPresentationDisplayModeDirty = true;
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

    public String getType() {
        return type;
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
        isLayoutDirty = true;
    }

    public String getDefaultLayout() {
        return defaultLayout;
    }

    public void setDefaultLayout(String defaultLayout) {
        this.defaultLayout = defaultLayout;
        isDefaultLayoutDirty = false;
    }

    public long getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(long bandwidth) {
        this.bandwidth = bandwidth;
        isBandwidthDirty = true;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
        isOwnerIdDirty = true;
    }

    public String getQualityMain() {
        return qualityMain;
    }

    public void setQualityMain(String qualityMain) {
        this.qualityMain = qualityMain;
        isQualityMainDirty = true;
    }

    public String getQualityPresentation() {
        return qualityPresentation;
    }

    public void setQualityPresentation(String qualityPresentation) {
        this.qualityPresentation = qualityPresentation;
        isQualityPresentationDirty = true;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public Status getStatus() {
        return status;
    }

    public static final class Configuration implements XmlInstantiable {
        String ownerId;
        String defaultLayout;
        String presentationDisplayMode;
        boolean rxAudioMute;
        boolean muteSelfAllowed;
        boolean telepresenceCallsAllowed;
        boolean sipPresentationChannelEnabled;
        String bfcpMode;
        String qualityMain;
        String qualityPresentation;


        @Override
        public void parseBody(Node bodyNode) {
            if (bodyNode == null) return;
            ownerId = readTextValue(bodyNode.selectSingleNode("ownerId"));
            defaultLayout = readTextValue(bodyNode.selectSingleNode("defaultLayout"));
            presentationDisplayMode = readTextValue(bodyNode.selectSingleNode("presentationDisplayMode"));
            rxAudioMute = readBooleanValue(bodyNode.selectSingleNode("rxAudioMute"));
            muteSelfAllowed = readBooleanValue(bodyNode.selectSingleNode("muteSelfAllowed"));
            telepresenceCallsAllowed = readBooleanValue(bodyNode.selectSingleNode("telepresenceCallsAllowed"));
            sipPresentationChannelEnabled = readBooleanValue(bodyNode.selectSingleNode("sipPresentationChannelEnabled"));
            bfcpMode = readTextValue(bodyNode.selectSingleNode("bfcpMode"));
            qualityMain = readTextValue(bodyNode.selectSingleNode("qualityMain"));
            qualityPresentation = readTextValue(bodyNode.selectSingleNode("qualityPresentation"));
        }

        public String getOwnerId() {
            return ownerId;
        }

        public String getDefaultLayout() {
            return defaultLayout;
        }

        public String getPresentationDisplayMode() {
            return presentationDisplayMode;
        }

        public boolean isRxAudioMute() {
            return rxAudioMute;
        }

        public boolean isMuteSelfAllowed() {
            return muteSelfAllowed;
        }

        public boolean isTelepresenceCallsAllowed() {
            return telepresenceCallsAllowed;
        }

        public boolean isSipPresentationChannelEnabled() {
            return sipPresentationChannelEnabled;
        }

        public String getBfcpMode() {
            return bfcpMode;
        }

        public String getQualityMain() {
            return qualityMain;
        }

        public String getQualityPresentation() {
            return qualityPresentation;
        }
    }



    public static final class Status implements  XmlInstantiable {
        String state;
        int durationSeconds;
        String direction;
        String layout;
        AudioStatus rxAudio;
        AudioStatus txAudio;
        VideoStatus rxVideo;
        VideoStatus rxVideoPresentation;
        VideoStatus txVideo;

        @Override
        public void parseBody(Node bodyNode) {
            if (bodyNode == null) return;
            state = readTextValue(bodyNode.selectSingleNode("state"));
            durationSeconds = readIntValue(bodyNode.selectSingleNode("state"));
            direction = readTextValue(bodyNode.selectSingleNode("direction"));
            layout = readTextValue(bodyNode.selectSingleNode("layout"));

            {
                Node rxAudioNode = bodyNode.selectSingleNode("rxAudio");
                if (rxAudioNode != null) {
                    rxAudio = new AudioStatus();
                    rxAudio.parseBody(rxAudioNode);
                }
            }

            {
                Node txAudioNode = bodyNode.selectSingleNode("txAudio");
                if (txAudioNode != null) {
                    txAudio = new AudioStatus();
                    txAudio.parseBody(txAudioNode);
                }
            }

            {
                Node rxVideoNode = bodyNode.selectSingleNode("rxVideo[@role=\"main\"]");
                if (rxVideoNode != null) {
                    rxVideo = new VideoStatus();
                    rxVideo.parseBody(rxVideoNode);
                }
            }

            {
                Node rxVideoPresentationNode = bodyNode.selectSingleNode("rxVideo[@role=\"presentation\"]");
                if (rxVideoPresentationNode != null) {
                    rxVideoPresentation = new VideoStatus();
                    rxVideoPresentation.parseBody(rxVideoPresentationNode);
                }
            }

            {
                Node txVideoNode = bodyNode.selectSingleNode("txVideo");
                if (txVideoNode != null) {
                    txVideo = new VideoStatus();
                    txVideo.parseBody(txVideoNode);
                }
            }
        }

        public String getState() {
            return state;
        }

        public int getDurationSeconds() {
            return durationSeconds;
        }

        public String getDirection() {
            return direction;
        }

        public String getLayout() {
            return layout;
        }

        public AudioStatus getRxAudio() {
            return rxAudio;
        }

        public AudioStatus getTxAudio() {
            return txAudio;
        }

        public VideoStatus getRxVideo() {
            return rxVideo;
        }

        public VideoStatus getTxVideo() {
            return txVideo;
        }

        public VideoStatus getRxVideoPresentation() {
            return rxVideoPresentation;
        }
    }


    public static final class AudioStatus implements XmlInstantiable {
        String codec;
        double packetLossPercentage;
        long jitter;
        long codecBitRate;
        long bitRate;
        long roundTripTime;

        @Override
        public void parseBody(Node bodyNode) {
            if (bodyNode == null) return;
            codec = readTextValue(bodyNode.selectSingleNode("codec"));
            packetLossPercentage = readDoubleValue(bodyNode.selectSingleNode("packetLossPercentage"));
            jitter = readLongValue(bodyNode.selectSingleNode("jitter"));
            codecBitRate = readLongValue(bodyNode.selectSingleNode("codecBitRate"));
            bitRate = readLongValue(bodyNode.selectSingleNode("bitRate"));
            roundTripTime = readLongValue(bodyNode.selectSingleNode("roundTripTime"));
        }

        public String getCodec() {
            return codec;
        }

        public double getPacketLossPercentage() {
            return packetLossPercentage;
        }

        public long getJitter() {
            return jitter;
        }

        public long getCodecBitRate() {
            return codecBitRate;
        }

        public long getBitRate() {
            return bitRate;
        }

        public long getRoundTripTime() {
            return roundTripTime;
        }
    }


    public static final class VideoStatus implements XmlInstantiable {
        String codec;
        double packetLossPercentage;
        long jitter;
        long bitRate;
        long roundTripTime;
        double frameRate;
        long width;
        long height;

        @Override
        public void parseBody(Node bodyNode) {
            if (bodyNode == null) return;
            codec = readTextValue(bodyNode.selectSingleNode("codec"));
            packetLossPercentage = readDoubleValue(bodyNode.selectSingleNode("packetLossPercentage"));
            jitter = readLongValue(bodyNode.selectSingleNode("jitter"));
            bitRate = readLongValue(bodyNode.selectSingleNode("bitRate"));
            roundTripTime = readLongValue(bodyNode.selectSingleNode("roundTripTime"));
            frameRate = readDoubleValue(bodyNode.selectSingleNode("frameRate"));
            width = readLongValue(bodyNode.selectSingleNode("width"));
            height = readLongValue(bodyNode.selectSingleNode("height"));
        }

        public String getCodec() {
            return codec;
        }

        public double getPacketLossPercentage() {
            return packetLossPercentage;
        }

        public long getJitter() {
            return jitter;
        }

        public long getBitRate() {
            return bitRate;
        }

        public long getRoundTripTime() {
            return roundTripTime;
        }

        public double getFrameRate() {
            return frameRate;
        }

        public long getWidth() {
            return width;
        }

        public long getHeight() {
            return height;
        }
    }
}
