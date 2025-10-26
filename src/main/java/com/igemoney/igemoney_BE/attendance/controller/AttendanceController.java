package com.igemoney.igemoney_BE.attendance.controller;

import com.igemoney.igemoney_BE.attendance.dto.AttendanceDaysRequestDto;
import com.igemoney.igemoney_BE.attendance.dto.AttendanceDaysResponseDto;
import com.igemoney.igemoney_BE.attendance.dto.UserAttendanceStatusResponseDto;
import com.igemoney.igemoney_BE.attendance.service.AttendanceCalendarService;
import com.igemoney.igemoney_BE.attendance.service.AttendanceService;
import com.igemoney.igemoney_BE.common.annotation.Authenticated;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/attendance")
@Tag(name = "Attendance", description = "사용자 출석 관련 API")
public class AttendanceController {
    private final AttendanceService attendanceService;
    private final AttendanceCalendarService attendanceCalendarService;

    @Authenticated
    @Operation(summary = "오늘 문제 풀이 수 및 누적 연속 출석일 조회")
    @GetMapping("/status")
    public ResponseEntity<UserAttendanceStatusResponseDto> getMyAttendanceStats(@RequestAttribute Long userId) {
        UserAttendanceStatusResponseDto body = attendanceService.getUserAttendance(userId);
        return ResponseEntity.ok(body);
    }

    @Authenticated
    @Operation(summary = "선택한 년월에 출석했던 날짜 목록 조회")
    @PostMapping("/calendar/days")
    public ResponseEntity<AttendanceDaysResponseDto> getMonthlyDays(
            @RequestAttribute Long userId,
            @RequestBody AttendanceDaysRequestDto requestDto
    ) {
        AttendanceDaysResponseDto body =
                attendanceCalendarService.getUserAttendanceDays(userId, requestDto.year(), requestDto.month());
        return ResponseEntity.ok(body);
    }
}
