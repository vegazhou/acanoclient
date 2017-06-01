package com.kt.acanoclient.obj;

import org.dom4j.Node;

/**
 * Created by Vega Zhou on 2017/5/22.
 */
public class CallProfile extends AcanoObject {

    private int participantLimit;
    protected boolean isParticipantLimitDirty = false;

    private boolean messageBoardEnabled;
    protected boolean isMessageBoardEnabledDirty = false;

    private String recordingMode;
    protected boolean isRecordingModeDirty = false;

    private String streamingMode;
    protected boolean isStreamingModeDirty = false;


    @Override
    public String getNewObjectPath() {
        return "/callProfiles";
    }

    @Override
    public String getQueryPath() {
        return "/callProfiles/" + id;
    }

    @Override
    public String getListXPath() {
        return "/callProfiles/callProfile";
    }

    @Override
    public void parseBody(Node bodyNode) {
        id = readTextValue(bodyNode.selectSingleNode("@id"));
        participantLimit = readIntValue(bodyNode.selectSingleNode("participantLimit"));
        messageBoardEnabled = readBooleanValue(bodyNode.selectSingleNode("messageBoardEnabled"));
    }

    public int getParticipantLimit() {
        return participantLimit;
    }

    public void setParticipantLimit(int participantLimit) {
        this.participantLimit = participantLimit;
        isParticipantLimitDirty = true;
    }

    public boolean isMessageBoardEnabled() {
        return messageBoardEnabled;
    }

    public void setMessageBoardEnabled(boolean messageBoardEnabled) {
        this.messageBoardEnabled = messageBoardEnabled;
        isMessageBoardEnabledDirty = true;
    }

    public String getRecordingMode() {
        return recordingMode;
    }

    public String getStreamingMode() {
        return streamingMode;
    }

    public void setStreamingMode(String streamingMode) {
        this.streamingMode = streamingMode;
        isStreamingModeDirty = true;
    }

    public void setRecordingMode(String recordingMode) {
        this.recordingMode = recordingMode;
        isRecordingModeDirty = true;
    }
}
