package com.igemoney.igemoney_BE.common.exception.user;

public class NotRegisteredUserException  extends RuntimeException{
    public NotRegisteredUserException(String message) {
        super(message);
    }

}
