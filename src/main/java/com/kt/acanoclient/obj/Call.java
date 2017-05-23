package com.kt.acanoclient.obj;

import com.kt.acanoclient.anno.AcanoType;
import org.dom4j.Node;

/**
 * Created by Vega Zhou on 2017/5/22.
 */
@AcanoType("call")
public class Call extends AcanoObject {

    private String coSpace;
    private int durationSeconds;
    private int numCallLegs;
    private int maxCallLegs;
    private String presenterCallLeg;
    private boolean locked;
    private boolean recording;
    private boolean allowAllMuteSelf;
    private boolean allowAllPresentationContribution;
    private boolean joinAudioMuteOverride;
    private String messageText;
    private boolean activeWhenEmpty;


    @Override
    public String getNewObjectPath() {
        return "/calls";
    }

    @Override
    public String getQueryPath() {
        return "/calls";
    }

    @Override
    public void parseBody(Node bodyNode) {
        id = readTextValue(bodyNode.selectSingleNode("@id"));
        coSpace = readTextValue(bodyNode.selectSingleNode("coSpace"));
        durationSeconds = readIntValue(bodyNode.selectSingleNode("durationSeconds"));
        numCallLegs = readIntValue(bodyNode.selectSingleNode("numCallLegs"));
        maxCallLegs = readIntValue(bodyNode.selectSingleNode("maxCallLegs"));
        presenterCallLeg = readTextValue(bodyNode.selectSingleNode("presenterCallLeg"));
        locked = readBooleanValue(bodyNode.selectSingleNode("locked"));
        recording = readBooleanValue(bodyNode.selectSingleNode("recording"));
        allowAllMuteSelf = readBooleanValue(bodyNode.selectSingleNode("allowAllMuteSelf"));
        allowAllPresentationContribution = readBooleanValue(bodyNode.selectSingleNode("allowAllPresentationContribution"));
        joinAudioMuteOverride = readBooleanValue(bodyNode.selectSingleNode("joinAudioMuteOverride"));
        messageText = readTextValue(bodyNode.selectSingleNode("messageText"));
        activeWhenEmpty = readBooleanValue(bodyNode.selectSingleNode("activeWhenEmpty"));
    }

    public String getCoSpace() {
        return coSpace;
    }

    public void setCoSpace(String coSpace) {
        this.coSpace = coSpace;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(int durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public int getNumCallLegs() {
        return numCallLegs;
    }

    public void setNumCallLegs(int numCallLegs) {
        this.numCallLegs = numCallLegs;
    }

    public int getMaxCallLegs() {
        return maxCallLegs;
    }

    public void setMaxCallLegs(int maxCallLegs) {
        this.maxCallLegs = maxCallLegs;
    }

    public String getPresenterCallLeg() {
        return presenterCallLeg;
    }

    public void setPresenterCallLeg(String presenterCallLeg) {
        this.presenterCallLeg = presenterCallLeg;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isRecording() {
        return recording;
    }

    public void setRecording(boolean recording) {
        this.recording = recording;
    }

    public boolean isAllowAllMuteSelf() {
        return allowAllMuteSelf;
    }

    public void setAllowAllMuteSelf(boolean allowAllMuteSelf) {
        this.allowAllMuteSelf = allowAllMuteSelf;
    }

    public boolean isAllowAllPresentationContribution() {
        return allowAllPresentationContribution;
    }

    public void setAllowAllPresentationContribution(boolean allowAllPresentationContribution) {
        this.allowAllPresentationContribution = allowAllPresentationContribution;
    }

    public boolean isJoinAudioMuteOverride() {
        return joinAudioMuteOverride;
    }

    public void setJoinAudioMuteOverride(boolean joinAudioMuteOverride) {
        this.joinAudioMuteOverride = joinAudioMuteOverride;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public boolean isActiveWhenEmpty() {
        return activeWhenEmpty;
    }

    public void setActiveWhenEmpty(boolean activeWhenEmpty) {
        this.activeWhenEmpty = activeWhenEmpty;
    }
}
