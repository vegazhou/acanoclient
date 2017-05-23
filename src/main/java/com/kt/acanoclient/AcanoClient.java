package com.kt.acanoclient;

import com.kt.acanoclient.exception.AcanoApiException;
import com.kt.acanoclient.obj.CallLeg;
import com.kt.acanoclient.obj.CoSpace;

import java.util.Date;
import java.util.List;

/**
 * Created by Vega Zhou on 2017/5/19.
 */
public interface AcanoClient {

    String createCoSpace(String displayName, String sipResourceId, String passCode, ScreenLayout screenLayout,
                           int participantLimit) throws AcanoApiException;

    void deleteCoSpace(String coSpaceId) throws AcanoApiException;

    String createCall(String coSpaceId) throws AcanoApiException;

    void deleteCall(String callId) throws AcanoApiException;

    String addCoSpaceMember(String coSpaceId, String userJid) throws AcanoApiException;

    void removeCoSpaceMember(String coSpaceId, String userJid);

    String createCallLeg(String callId, String remoteParty) throws AcanoApiException;

    void deleteCallLeg(String callId, String remoteParty);

    List<CallLeg> listCallLegs(String callId) throws AcanoApiException;
}
