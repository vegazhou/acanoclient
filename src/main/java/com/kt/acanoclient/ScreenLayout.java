package com.kt.acanoclient;

/**
 * Created by Vega Zhou on 2017/5/19.
 */
public enum  ScreenLayout {
    ALL_EQUAL("allEqual"),
    SPEAKER_ONLY("speakerOnly"),
    TELEPRESENCE("telepresence"),
    STACKED("stacked"),
    ALL_EQUAL_QUARTERS("allEqualQuarters"),
    ALL_EQUAL_NINTHS("allEqualNinths"),
    ALL_EQUAL_SIXTEENTHS("allEqualSixteenths"),
    ALL_EQUAL_TWENTY_FIFTHS("allEqualTwentyFifths"),
    ONE_PLUS_FIVE("onePlusFive"),
    ONE_PLUS_SEVEN("onePlusSeven"),
    ONE_PLUS_NINE("onePlusNine"),
    ONE_PLUS_N("onePlusN"),
    AUTOMATIC("automatic");

    String v;

    ScreenLayout(String v) {
        this.v = v;
    }

    public String getValue() {
        return v;
    }
}
