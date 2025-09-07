package com.igemoney.igemoney_BE.attendance.service;

import com.igemoney.igemoney_BE.attendance.dto.AttendanceResponseDto;
import com.igemoney.igemoney_BE.user.entity.User;
import com.igemoney.igemoney_BE.attendance.repository.UserRepositoryJPA;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional
public class AttendanceService {

    private final UserRepositoryJPA userRepository;

    public AttendanceService(UserRepositoryJPA userRepository) {
        this.userRepository = userRepository;
    }

    private static final int ATTENDANCE_THRESHOLD = 5;

    public AttendanceResponseDto getTodayAttendance(String oauthId) {
        User user = userRepository.findByOauthId(oauthId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        int solvedCount = user.getTodaySolvedCount();
        boolean attendanceToday = solvedCount >= ATTENDANCE_THRESHOLD;

        return new AttendanceResponseDto(attendanceToday, solvedCount);
    }

    public void incrementTodaySolvedCount(String oauthId) {
        User user = userRepository.findByOauthId(oauthId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        int newCount = user.getTodaySolvedCount() + 1;
        user.setTodaySolvedCount(newCount);

        userRepository.save(user);
    }
}
