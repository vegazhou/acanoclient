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
    private static final String COSPACE_ID = "f593ecc9-2e0e-48e2-b219-2ee28c27878a";

    private static final String CALL_ID = "7dd370f7-764c-42ce-875e-2b1a98c22012";

    @Test
    public void test() throws AcanoApiException {
        StandardAcanoClient client = new StandardAcanoClient("10.10.10.95", 445, "kty", "kty");

        Call call = new Call();
        call.setId(CALL_ID);
        call.setCoSpace(COSPACE_ID);
        call.setJoinAudioMuteOverride(true);
        call.setAllowAllMuteSelf(true);
        call.setAllowAllPresentationContribution(false);
        String newCallId = client.createAcanoObject(call);

//        call = client.getAcanoObject(call);

//        Call c = client.getAcanoObject(CALL_ID, Call.class);
        return;
    }
}
