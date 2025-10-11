package com.igemoney.igemoney_BE.attendance.service;

import com.igemoney.igemoney_BE.user.entity.User;
import com.igemoney.igemoney_BE.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AttendanceService {

    private static final int TODAY_TARGET_COUNT = 5;

    private final UserRepository userRepository;
    private final AsyncAttendanceService asyncAttendanceService;

    @Transactional
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
        int pageSize = 10000;
        long total = userRepository.count();
        int totalPages = (int) Math.ceil((double) total / pageSize);

        for (int i = 0; i < totalPages; i++) {
            Pageable pageable = PageRequest.of(i, pageSize, Sort.by("userId").ascending());
            Page<User> page = userRepository.findAll(pageable);
            asyncAttendanceService.resetAndSaveUsers(page.getContent());
        }
    }
}
