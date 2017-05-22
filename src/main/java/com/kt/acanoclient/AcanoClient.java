package com.kt.acanoclient;

import com.kt.acanoclient.exception.AcanoApiException;
import com.kt.acanoclient.obj.CoSpace;

import java.util.Date;

/**
 * Created by Vega Zhou on 2017/5/19.
 */
public interface AcanoClient {

    String createCoSpace(String displayName, String sipResourceId, String passCode, ScreenLayout screenLayout,
                           int participantLimit) throws AcanoApiException;

    void deleteCoSpace(String coSpaceId) throws AcanoApiException;
}
