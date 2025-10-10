package com.igemoney.igemoney_BE.attendance.scheduler;

import com.igemoney.igemoney_BE.attendance.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AttendanceScheduler {

    private final AttendanceService attendanceService;

    @Scheduled(cron = "0 0 0 * * *") // 매일 자정 실행
    public void runAttendanceUpdate() {
        attendanceService.resetAttendanceForAllUsers();
    }
}