package com.igemoney.igemoney_BE.common.exception.user;

public class DuplicatieNicknameException extends RuntimeException {

  private static final String DEFAULT_MESSAGE = "중복된 닉네임입니다.";
  public DuplicatieNicknameException() {
    super(DEFAULT_MESSAGE);
  }

  public DuplicatieNicknameException(String message) {
        super(message);
    }
}
