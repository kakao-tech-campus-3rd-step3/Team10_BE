package com.igemoney.igemoney_BE.attendance.service;

import com.igemoney.igemoney_BE.user.entity.User;
import com.igemoney.igemoney_BE.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class AttendanceService {

    private static final int TODAY_TARGET_COUNT = 5;

    private final UserRepository userRepository;

    public void incrementTodaySolvedCount(Long kakaoOauthId) {
        User user = userRepository.findByKakaoOauthId(kakaoOauthId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        user.increaseTodaySolvedCount();
        if (user.getTodayCount() == TODAY_TARGET_COUNT) {
            user.increaseConsecutiveAttendance();
        }

        userRepository.save(user);
    }

    public void resetAttendanceForAllUsers() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getTodayCount() < TODAY_TARGET_COUNT) {
                user.resetConsecutiveAttendance();
            }
            user.resetTodaySolvedCount();
        }
        userRepository.saveAll(users);
    }
}
