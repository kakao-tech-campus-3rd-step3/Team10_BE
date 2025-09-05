package com.igemoney.igemoney_BE.attendance.controller;

import com.igemoney.igemoney_BE.attendance.dto.AttendanceResponseDto;
import com.igemoney.igemoney_BE.attendance.service.AttendanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.NoSuchElementException;

@RestController
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping("/api/users/me/attendance")
    public ResponseEntity<?> attendance(@RequestHeader("Authorization") String authorizationHeader) {
        try {
            String oauthId = extractOauthIdFromJwt(authorizationHeader);
            AttendanceResponseDto response = attendanceService.getTodayAttendance(oauthId);
            return ResponseEntity.ok(response);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("해당 유저를 찾을 수 없습니다.");
        }
    }

    @PostMapping("/api/users/me/attendence/solve")
    public ResponseEntity<?> incrementSolvedCount(@RequestHeader("Authorization") String authorizationHeader) {
        try {
            String oauthId = extractOauthIdFromJwt(authorizationHeader);
            attendanceService.incrementTodaySolvedCount(oauthId);
            return ResponseEntity.ok("오늘 푼 문제 수가 증가했습니다.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("해당 유저를 찾을 수 없습니다.");
        }
    }

    private String extractOauthIdFromJwt(String token) {
        // JWT 파싱 로직 (실제로 JWT 라이브러리 사용 권장)
        // 임시
        return "example_kakao_oauth_id";
    }
}
