package com.igemoney.igemoney_BE.attendance.scheduler;

import com.igemoney.igemoney_BE.attendance.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AttendanceScheduler {

    private final AttendanceService attendanceService;


    @Scheduled(cron = "0 0 0 * * *") // 매일 자정 실행
    public void runAttendanceUpdate() {
        log.info("Daily attendance reset started");
        attendanceService.resetAttendanceForAllUsers();
        log.info("Daily attendance reset finished");
    }
}