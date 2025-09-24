package com.igemoney.igemoney_BE.common.exception;

import com.igemoney.igemoney_BE.common.exception.user.NoUserIdTokenException;
import com.igemoney.igemoney_BE.common.exception.user.NotRegisteredUserException;
import com.igemoney.igemoney_BE.common.exception.user.UnvalidJwtTokenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
        NotRegisteredUserException.class,
        NoUserIdTokenException.class,
        UnvalidJwtTokenException.class
    })
    public ResponseEntity<ErrorResponse> handle401Errors(RuntimeException e) {
        ErrorResponse errorBody = ErrorResponse.of(HttpStatus.UNAUTHORIZED.value(), e.getMessage());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorBody);
    }


}
