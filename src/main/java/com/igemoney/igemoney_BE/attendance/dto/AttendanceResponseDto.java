package com.igemoney.igemoney_BE.attendance.dto;

public record AttendanceResponseDto(
        boolean attendanceToday,
        int todaySolvedCount
) {}