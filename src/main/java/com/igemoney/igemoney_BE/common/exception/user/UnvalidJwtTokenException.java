package com.igemoney.igemoney_BE.common.exception.user;

public class UnvalidJwtTokenException extends RuntimeException {

    public UnvalidJwtTokenException(String message) {
        super(message);
    }
}
