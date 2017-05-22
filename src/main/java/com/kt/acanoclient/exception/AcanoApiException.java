package com.kt.acanoclient.exception;

/**
 * Created by Vega Zhou on 2017/5/19.
 */
public class AcanoApiException extends Exception {

    private int statusCode;

    public AcanoApiException(int statusCode, String message) {
        super(message);
        this. statusCode = statusCode;
    }


    public AcanoApiException(int statusCode, Throwable cause) {
        super(cause);
        this. statusCode = statusCode;
    }


    @Override
    public String toString() {
        return "statusCode:" + statusCode + " " + super.toString();
    }
}
