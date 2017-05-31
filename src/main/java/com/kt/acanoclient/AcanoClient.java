package com.kt.acanoclient;

import com.kt.acanoclient.exception.AcanoApiException;
import com.kt.acanoclient.obj.CallLeg;
import com.kt.acanoclient.obj.CallLegProfile;
import com.kt.acanoclient.obj.CallProfile;
import com.kt.acanoclient.obj.CoSpace;

import java.util.Date;
import java.util.List;

/**
 * Created by Vega Zhou on 2017/5/19.
 */
public interface AcanoClient {

    String createCoSpace(String displayName, String sipResourceId, String passCode, ScreenLayout screenLayout,
                         String callProfileId, String callLegProfileId) throws AcanoApiException;

    void deleteCoSpace(String coSpaceId) throws AcanoApiException;

    String createCall(String coSpaceId, int participantLimit) throws AcanoApiException;

    void deleteCall(String callId) throws AcanoApiException;

    String addCoSpaceMember(String coSpaceId, String userJid) throws AcanoApiException;

    void removeCoSpaceMember(String coSpaceId, String userJid);

    String createCallLeg(String callId, String remoteParty) throws AcanoApiException;

    String createCallLeg(String callId, String remoteParty, String callLegProfileId) throws AcanoApiException;

    void deleteCallLeg(String callLegId) throws AcanoApiException;


    String createCallProfile(CallProfile callProfile) throws AcanoApiException;

    CallProfile getCallProfile(String callProfileId) throws AcanoApiException;

    void updateCallProfile(CallProfile callProfile) throws AcanoApiException;

    String createCallLegProfile(CallLegProfile callLegProfile) throws AcanoApiException;

    CallLegProfile getCallLegProfile(String callLegProfileId) throws AcanoApiException;

    void updateCallLegProfile(CallLegProfile callLegProfile) throws AcanoApiException;



    List<CallLeg> listCallLegs(String callId) throws AcanoApiException;

    void rxAudioMute(String callLegId) throws AcanoApiException;
    void rxAudioUnMute(String callLegId) throws AcanoApiException;
    void txAudioMute(String callLegId) throws AcanoApiException;
    void txAudioUnMute(String callLegId) throws AcanoApiException;

    void rxVideoMute(String callLegId) throws AcanoApiException;
    void rxVideoUnMute(String callLegId) throws AcanoApiException;
    void txVideoMute(String callLegId) throws AcanoApiException;
    void txVideoUnMute(String callLegId) throws AcanoApiException;
}
