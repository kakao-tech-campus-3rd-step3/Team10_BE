package com.igemoney.igemoney_BE.common.exception;

import com.igemoney.igemoney_BE.common.exception.user.NotRegisteredUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotRegisteredUserException.class)
    public ResponseEntity<ErrorResponse> handleNotRegisteredUserException(NotRegisteredUserException e) {
        ErrorResponse errorBody = ErrorResponse.builder()
            .message(e.getMessage())
            .statusCode(HttpStatus.UNAUTHORIZED.value())
            .build();

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorBody);
    }

}
