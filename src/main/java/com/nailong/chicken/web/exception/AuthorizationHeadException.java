package com.nailong.chicken.web.exception;

public class AuthorizationHeadException extends CommonException {

    public AuthorizationHeadException(String message) {
        super(message, 100400);
    }

    public AuthorizationHeadException(String message, Throwable cause) {
        super(message, cause, 100400);
    }

    public AuthorizationHeadException(Throwable cause) {
        super(cause, 100400);
    }
}
