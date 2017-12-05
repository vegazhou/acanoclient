package com.kt.acanoclient.exception;

/**
 * Created by Vega on 2017/9/20.
 */
public class AcanoObjectNotFoundException extends AcanoApiException {
    public AcanoObjectNotFoundException(int statusCode, String message) {
        super(statusCode, message);
    }

    public AcanoObjectNotFoundException(int statusCode, Throwable cause) {
        super(statusCode, cause);
    }
}
