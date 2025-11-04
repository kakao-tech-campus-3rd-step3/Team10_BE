package com.igemoney.igemoney_BE.attendance.service;

import com.igemoney.igemoney_BE.user.entity.User;
import com.igemoney.igemoney_BE.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class AsyncAttendanceService {

    private static final int TODAY_TARGET_COUNT = 5;

    private final UserRepository userRepository;

    @Async("attendanceReset")
    @Transactional
    public CompletableFuture<Void> resetAndSaveUsers(List<Long> userIds) {
        try {
            List<User> users = userRepository.findAllById(userIds);

            for (User user : users) {
                if (user.getTodayCount() < TODAY_TARGET_COUNT) {
                    user.resetConsecutiveAttendance();
                }
                user.resetTodaySolvedCount();
            }

            userRepository.saveAll(users);

            return CompletableFuture.completedFuture(null);
        } catch (Exception e) {
            log.error("Async attendance update failed", e);
            throw e;
        }
    }
}
