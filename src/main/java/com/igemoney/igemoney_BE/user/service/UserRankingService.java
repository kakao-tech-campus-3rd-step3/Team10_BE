package com.igemoney.igemoney_BE.user.service;

import com.igemoney.igemoney_BE.user.dto.RankingResponseDto;
import com.igemoney.igemoney_BE.user.dto.UserRankingDto;
import com.igemoney.igemoney_BE.user.entity.User;
import com.igemoney.igemoney_BE.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class UserRankingService {
    private final UserRepository userRepository;

    public RankingResponseDto getRatingPointRanking(Long userId) {
        User currentUser = userRepository.findByUserId(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        Integer ratingPoint = currentUser.getRatingPoint();

        List<User> topRankingUsers = userRepository.findTop3ByOrderByRatingPointDesc();

        List<User> aboveUsers = userRepository.findTop2ByRatingPointGreaterThanOrderByRatingPointAsc(ratingPoint);
        List<User> belowUsers = userRepository.findTop2ByRatingPointLessThanOrderByRatingPointDesc(ratingPoint);

        Collections.reverse(aboveUsers); // 위쪽 유저 오름차순 정렬이므로 내림차순 맞춤

        List<User> adjacentUsers = new ArrayList<>();
        adjacentUsers.addAll(aboveUsers);
        adjacentUsers.addAll(belowUsers);

        return new RankingResponseDto(
                new UserRankingDto(currentUser),
                UserRankingDto.listFrom(topRankingUsers),
                UserRankingDto.listFrom(adjacentUsers)
        );
    }

    public RankingResponseDto getConsecutiveAttendanceRanking(Long userId) {
        User currentUser = userRepository.findByUserId(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        Integer consecutiveAttendance = currentUser.getConsecutiveAttendance();

        List<User> topRankingUsers = userRepository.findTop3ByOrderByConsecutiveAttendanceDesc();

        List<User> aboveUsers = userRepository.findTop2ByConsecutiveAttendanceGreaterThanOrderByConsecutiveAttendanceAsc(consecutiveAttendance);
        List<User> belowUsers = userRepository.findTop2ByConsecutiveAttendanceLessThanOrderByConsecutiveAttendanceDesc(consecutiveAttendance);

        Collections.reverse(aboveUsers); // 위쪽 유저 오름차순 정렬이므로 내림차순 맞춤

        List<User> adjacentUsers = new ArrayList<>();
        adjacentUsers.addAll(aboveUsers);
        adjacentUsers.addAll(belowUsers);

        return new RankingResponseDto(
                new UserRankingDto(currentUser),
                UserRankingDto.listFrom(topRankingUsers),
                UserRankingDto.listFrom(adjacentUsers)
        );
    }
}
