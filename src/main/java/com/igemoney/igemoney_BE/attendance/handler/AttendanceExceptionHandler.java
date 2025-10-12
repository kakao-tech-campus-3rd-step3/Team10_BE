package com.igemoney.igemoney_BE.attendance.handler;

import com.igemoney.igemoney_BE.attendance.exception.AttendanceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.igemoney.igemoney_BE.attendance")
public class AttendanceExceptionHandler {
    @ExceptionHandler(AttendanceNotFoundException.class)
    public ResponseEntity<String> handleAttendanceNotFound(AttendanceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Attendance Error: " + ex.getMessage());
    }
}
