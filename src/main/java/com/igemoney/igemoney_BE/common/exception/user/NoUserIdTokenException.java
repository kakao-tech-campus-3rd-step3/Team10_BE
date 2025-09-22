package com.igemoney.igemoney_BE.common.exception.user;

public class NoUserIdTokenException extends RuntimeException {

    public NoUserIdTokenException(String message) {
        super(message);
    }
}
