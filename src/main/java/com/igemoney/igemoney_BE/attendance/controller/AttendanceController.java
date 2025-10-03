package com.igemoney.igemoney_BE.attendance.controller;

import com.igemoney.igemoney_BE.attendance.dto.AttendanceResponseDto;
import com.igemoney.igemoney_BE.attendance.service.AttendanceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/me")
@Tag(name = "User Attendence", description = "사용자 출석 API")
public class AttendanceController {

    private final AttendanceService attendanceService;

    @GetMapping("/attendance")
    public ResponseEntity<?> attendance(@RequestHeader("Authorization") String authorizationHeader) {
        Long kakaoOauthId = extractOauthIdFromJwt(authorizationHeader);
        AttendanceResponseDto response = attendanceService.getTodayAttendance(kakaoOauthId);
        return ResponseEntity.ok(response);
    }

    private Long extractOauthIdFromJwt(String token) {
        // JWT 파싱 로직 (실제로 JWT 라이브러리 사용 권장)
        // 임시
        return 1L;
    }
}
