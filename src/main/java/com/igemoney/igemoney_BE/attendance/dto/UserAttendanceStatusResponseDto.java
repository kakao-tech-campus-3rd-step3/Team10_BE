package com.igemoney.igemoney_BE.attendance.dto;

public record UserAttendanceStatusResponseDto(
        Integer todayCount,
        Integer consecutiveAttendance
) {}