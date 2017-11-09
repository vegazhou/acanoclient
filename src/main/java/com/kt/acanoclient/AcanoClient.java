package com.kt.acanoclient;

import com.kt.acanoclient.exception.AcanoApiException;
import com.kt.acanoclient.obj.*;

import java.util.List;

/**
 * Created by Vega Zhou on 2017/5/19.
 */
public interface AcanoClient {

    SystemStatus getSystemStatus() throws AcanoApiException;

    Licensing getLicensing() throws AcanoApiException;

    Load getLoad() throws AcanoApiException;

    String createTenant(String name) throws AcanoApiException;

    void updateTenant(String tenantId, String name) throws AcanoApiException;

    String createLdapServer(String address, int port, String user, String password) throws AcanoApiException;

    void updateLdapServer(String id, String address, int port, String user, String password) throws AcanoApiException;

    String createLdapMapping(String jidMapping, String nameMapping) throws AcanoApiException;

    void updateLdapMapping(String id, String jidMapping, String nameMapping) throws AcanoApiException;

    String createLdapSource(String server, String mapping, String tenant, String baseDn, String filter) throws AcanoApiException;

    void updateLdapSource(String id, String server, String mapping, String tenant, String baseDn, String filter) throws AcanoApiException;

    String createLdapSync(String tenant, String source) throws AcanoApiException;

    String createCoSpace(CoSpace coSpace) throws AcanoApiException;

    String createCoSpace(String displayName, String passCode, ScreenLayout screenLayout,
                         String callProfileId, String callLegProfileId, String streamUrl) throws AcanoApiException;

    String createCoSpace(String displayName, String passCode, ScreenLayout screenLayout, String callId,
                         String callProfileId, String callLegProfileId, String streamUrl) throws AcanoApiException;

    void updateCoSpace(CoSpace coSpace) throws AcanoApiException;

    void updateCoSpace(String coSpaceId, String displayName, String passCode, ScreenLayout screenLayout,
                       String callProfileId, String callLegProfileId, String streamUrl) throws AcanoApiException;

    void deleteCoSpace(String coSpaceId) throws AcanoApiException;

    CoSpace getCoSpace(String coSpaceId) throws AcanoApiException;

    String createCall(String coSpaceId, int participantLimit) throws AcanoApiException;

    void deleteCall(String callId) throws AcanoApiException;

    void showMessageTextInCall(String callId, String messageText, MessagePosition position, int durationInSeconds) throws AcanoApiException;

    String addCoSpaceMember(String coSpaceId, String userJid) throws AcanoApiException;

    void removeCoSpaceMember(String coSpaceId, String userJid);

    String createCallLeg(String callId, String remoteParty) throws AcanoApiException;

    String createCallLeg(String callId, String remoteParty, String callLegProfileId) throws AcanoApiException;

    String createCallLeg(CallLeg callLeg) throws AcanoApiException;

    void updateCallLeg(CallLeg callleg) throws AcanoApiException;

    void deleteCallLeg(String callLegId) throws AcanoApiException;


    String createCallProfile(CallProfile callProfile) throws AcanoApiException;

    CallProfile getCallProfile(String callProfileId) throws AcanoApiException;

    void updateCallProfile(CallProfile callProfile) throws AcanoApiException;

    void deleteCallProfile(String callProfileId) throws AcanoApiException;

    String createCallLegProfile(CallLegProfile callLegProfile) throws AcanoApiException;

    CallLeg getCallLeg(String callLegId) throws AcanoApiException;

    CallLegProfile getCallLegProfile(String callLegProfileId) throws AcanoApiException;

    void updateCallLegProfile(CallLegProfile callLegProfile) throws AcanoApiException;

    void deleteCallLegProfile(String callLegProfileId) throws AcanoApiException;


    List<CallLeg> listCallLegs(String callId) throws AcanoApiException;

    int countAllUsers(String tenantFilter) throws AcanoApiException;

    List<User> listUsers(int offset, String tenantFilter) throws AcanoApiException;

    User getUser(String userId) throws AcanoApiException;


    void rxAudioMute(String callLegId) throws AcanoApiException;
    void rxAudioUnMute(String callLegId) throws AcanoApiException;
    void txAudioMute(String callLegId) throws AcanoApiException;
    void txAudioUnMute(String callLegId) throws AcanoApiException;

    void rxVideoMute(String callLegId) throws AcanoApiException;
    void rxVideoUnMute(String callLegId) throws AcanoApiException;
    void txVideoMute(String callLegId) throws AcanoApiException;
    void txVideoUnMute(String callLegId) throws AcanoApiException;

    void allowPresentation(String callLegId) throws AcanoApiException;
    void disallowPresentation(String callLegId) throws AcanoApiException;

    void setImportance(String callLegId, int importance) throws AcanoApiException;
}
