package com.igemoney.igemoney_BE.common.exception.user;

public class DuplicateNicknameException extends RuntimeException {

  private static final String DEFAULT_MESSAGE = "중복된 닉네임입니다.";
  public DuplicateNicknameException() {
    super(DEFAULT_MESSAGE);
  }

  public DuplicateNicknameException(String message) {
        super(message);
    }
}
