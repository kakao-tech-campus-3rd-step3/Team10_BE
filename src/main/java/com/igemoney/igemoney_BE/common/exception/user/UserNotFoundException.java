package com.igemoney.igemoney_BE.common.exception.user;

public class UserNotFoundException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "존재하지 않는 유저입니다.";

    public UserNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
