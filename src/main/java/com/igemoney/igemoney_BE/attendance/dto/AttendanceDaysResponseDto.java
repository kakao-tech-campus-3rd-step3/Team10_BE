package com.igemoney.igemoney_BE.attendance.dto;

import java.util.List;

public record AttendanceDaysResponseDto(
        Integer year,
        Integer month,
        List<Integer> days
) {}
