package com.igemoney.igemoney_BE.attendance.service;

import com.igemoney.igemoney_BE.attendance.dto.AttendanceDaysResponseDto;
import com.igemoney.igemoney_BE.attendance.repository.UserAttendanceDayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AttendanceCalendarService {
    private final UserAttendanceDayRepository attendanceRepository;

    public AttendanceDaysResponseDto getUserAttendanceDays(Long userId, Integer year, Integer month) {
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate start = yearMonth.atDay(1);
        LocalDate end = yearMonth.atEndOfMonth();

        List<Integer> days = attendanceRepository
                .findByUserUserIdAndAttendanceDateBetweenOrderByAttendanceDateAsc(userId, start, end)
                .stream()
                .map(day -> day.getAttendanceDate().getDayOfMonth())
                .toList();

        return new AttendanceDaysResponseDto(year, month, days);
    }
}
