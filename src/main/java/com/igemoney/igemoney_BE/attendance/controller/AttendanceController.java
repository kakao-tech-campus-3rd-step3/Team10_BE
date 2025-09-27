package com.igemoney.igemoney_BE.attendance.controller;

import com.igemoney.igemoney_BE.attendance.dto.AttendanceResponseDto;
import com.igemoney.igemoney_BE.attendance.service.AttendanceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/me")
@Tag(name = "User Attendence", description = "사용자 출석 API")
public class AttendanceController {

    private final AttendanceService attendanceService;

    @GetMapping("/attendance")
    public ResponseEntity<?> attendance(@RequestHeader("Authorization") String authorizationHeader) {
        try {
            Long kakaoOauthId = extractOauthIdFromJwt(authorizationHeader);
            AttendanceResponseDto response = attendanceService.getTodayAttendance(kakaoOauthId);
            return ResponseEntity.ok(response);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("해당 유저를 찾을 수 없습니다.");
        }
    }

    @PostMapping("/attendance/solve")
    public ResponseEntity<?> incrementSolvedCount(@RequestHeader("Authorization") String authorizationHeader) {
        try {
            Long kakaoOauthId = extractOauthIdFromJwt(authorizationHeader);
            attendanceService.incrementTodaySolvedCount(kakaoOauthId);
            return ResponseEntity.ok("오늘 푼 문제 수가 증가했습니다.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("해당 유저를 찾을 수 없습니다.");
        }
    }

    private Long extractOauthIdFromJwt(String token) {
        // JWT 파싱 로직 (실제로 JWT 라이브러리 사용 권장)
        // 임시
        return 1L;
    }
}
