package com.igemoney.igemoney_BE.attendance.repository;

import com.igemoney.igemoney_BE.attendance.entity.UserAttendanceDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;


public interface UserAttendanceDayRepository extends JpaRepository<UserAttendanceDay, Long> {
    List<UserAttendanceDay> findByUserUserIdAndAttendanceDateBetweenOrderByAttendanceDateAsc(
            Long userId, LocalDate start, LocalDate end);
}
