package com.kt.test;

import com.kt.acanoclient.StandardAcanoClient;
import com.kt.acanoclient.exception.AcanoApiException;
import com.kt.acanoclient.obj.Call;
import com.kt.acanoclient.obj.CoSpace;
import org.junit.Test;

import java.util.List;

/**
 * Created by Vega Zhou on 2017/5/22.
 */
public class TestAcanoClient {
    private static final String COSPACE_ID = "4874b129-c2ac-4545-b264-a55ef2c57900";

    private static final String CALL_ID = "bb04a119-6bd9-4232-9c1a-042bc3396ec1";

    @Test
    public void test() throws AcanoApiException {
        StandardAcanoClient client = new StandardAcanoClient("10.10.10.95", 445, "kty", "kty");

        client.createCallLeg(CALL_ID, "test2@ktsz.com");

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
