package com.igemoney.igemoney_BE.attendance.service;

import com.igemoney.igemoney_BE.attendance.dto.AttendanceResponseDto;
import com.igemoney.igemoney_BE.user.entity.User;
import com.igemoney.igemoney_BE.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional
public class AttendanceService {

    private final UserRepository userRepository;

    public AttendanceService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private static final int ATTENDANCE_THRESHOLD = 5;

    public AttendanceResponseDto getTodayAttendance(Long kakaoOauthId) {
        User user = userRepository.findByKakaoOauthId(kakaoOauthId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        int solvedCount = user.getTodayCount();
        boolean attendanceToday = solvedCount >= ATTENDANCE_THRESHOLD;

        return new AttendanceResponseDto(attendanceToday, solvedCount);
    }

    public void incrementTodaySolvedCount(Long kakaoOauthId) {
        User user = userRepository.findByKakaoOauthId(kakaoOauthId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        user.increaseTodaySolvedCount();

        userRepository.save(user);
    }
}
