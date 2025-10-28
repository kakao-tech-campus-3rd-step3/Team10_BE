package com.igemoney.igemoney_BE.common.exception.quiz;

public class QuizNotFoundException extends RuntimeException {

    private static final String  DEFAULT_MESSAGE = "존재하지 않는 퀴즈입니다.";

    public QuizNotFoundException() {
      super(DEFAULT_MESSAGE);
    }

    public QuizNotFoundException(String message) {
        super(message);
    }
}
