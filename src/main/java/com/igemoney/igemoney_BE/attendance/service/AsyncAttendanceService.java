package com.igemoney.igemoney_BE.attendance.service;

import com.igemoney.igemoney_BE.user.entity.User;
import com.igemoney.igemoney_BE.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AsyncAttendanceService {

    private static final int TODAY_TARGET_COUNT = 5;

    private final UserRepository userRepository;

    @Async
    @Transactional
    public void resetAndSaveUsers(List<User> users) {
        for (User user : users) {
            if (user.getTodayCount() < TODAY_TARGET_COUNT) {
                user.resetConsecutiveAttendance();
            }
            user.resetTodaySolvedCount();
        }
        userRepository.saveAll(users);
    }
}
