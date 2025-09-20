package com.igemoney.igemoney_BE.common.exception;

import java.time.Instant;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorResponse {
    private final int statusCode;
    private final String message;
    private final LocalDateTime timestamp;

    @Builder
    public ErrorResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

}
