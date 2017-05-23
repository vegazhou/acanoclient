package com.kt.test;

import com.kt.acanoclient.StandardAcanoClient;
import com.kt.acanoclient.exception.AcanoApiException;
import com.kt.acanoclient.obj.Call;
import com.kt.acanoclient.obj.CallLeg;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vega Zhou on 2017/5/22.
 */
public class TestAcanoClient {
    private static final String COSPACE_ID = "4874b129-c2ac-4545-b264-a55ef2c57900";

    private static final String CALL_ID = "eab7f3f7-d65f-4c8a-b7e4-d035d3b510f4";

    @Test
    public void test() throws AcanoApiException {
        StandardAcanoClient client = new StandardAcanoClient("10.10.10.95", 445, "kty", "kty");

//        client.deleteCall(CALL_ID);

//        String callId = client.createCall(COSPACE_ID);

//        client.createCallLeg(callId, "test2@ktsz.com");
//        client.createCallLeg(CALL_ID, "test1@ktsz.com");

        CallLeg callLeg = new CallLeg();
        callLeg.setCallId(CALL_ID);
        List<CallLeg> legs = client.listAcanoObjects(callLeg);

        List<CallLeg> details = new ArrayList<>();
        for (CallLeg leg : legs) {
            leg.setCallId(CALL_ID);
            try {
                details.add(client.getAcanoObject(leg));
            } catch (AcanoApiException ignore) {
                // 正在响铃状态的call leg无法获取详情
            }
        }


//        client.createCallLeg(CALL_ID, "test2@ktsz.com");

//        client.addCoSpaceMember(COSPACE_ID, "test2@ktsz.com");



//        client.createCallLeg("")

//        Call call = new Call();
//        call.setId(CALL_ID);
//        call.setCoSpace(COSPACE_ID);
//        call.setJoinAudioMuteOverride(true);
//        call.setAllowAllMuteSelf(true);
//        call.setAllowAllPresentationContribution(false);
//        String newCallId = client.createAcanoObject(call);

//        call = client.getAcanoObject(call);

//        Call c = client.getAcanoObject(CALL_ID, Call.class);
        return;
    }
}
