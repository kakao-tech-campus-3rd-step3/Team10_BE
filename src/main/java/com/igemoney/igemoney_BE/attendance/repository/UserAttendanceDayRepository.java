package com.igemoney.igemoney_BE.attendance.repository;

import com.igemoney.igemoney_BE.attendance.entity.UserAttendanceDay;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserAttendanceDayRepository extends JpaRepository<UserAttendanceDay, Long> {

}
