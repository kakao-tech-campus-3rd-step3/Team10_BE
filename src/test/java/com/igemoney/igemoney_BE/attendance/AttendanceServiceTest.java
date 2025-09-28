package com.igemoney.igemoney_BE.attendance;

import com.igemoney.igemoney_BE.attendance.service.AttendanceService;
import com.igemoney.igemoney_BE.user.entity.User;
import com.igemoney.igemoney_BE.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class AttendanceServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AttendanceService attendanceService;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
        userRepository.save(new User("test1", 1L)); // todayCount 5 이상
        userRepository.save(new User("test2", 2L)); // todayCount 5 미만
    }

    @Test
    public void testUpdateAttendanceForAllUsers() {
        User user1 = userRepository.findById(1L).get();
        User user2 = userRepository.findById(2L).get();

        for(int i=0; i<5; i++) {
            user1.increaseTodaySolvedCount();
        }

        user2.increaseConsecutiveAttendance();
        for(int i=0; i<2; i++) {
            user2.increaseTodaySolvedCount();
        }

        attendanceService.updateAttendanceForAllUsers();

        assertEquals(2, user1.getConsecutiveAttendance());
        assertEquals(0, user1.getTodayCount());
        assertEquals(0, user2.getConsecutiveAttendance());
        assertEquals(0, user2.getTodayCount());
    }
}
