package com.igemoney.igemoney_BE.attendance.dto;

public record SolvedCountResponseDto(
        boolean attendanceToday,
        Integer todaySolvedCount
) {}