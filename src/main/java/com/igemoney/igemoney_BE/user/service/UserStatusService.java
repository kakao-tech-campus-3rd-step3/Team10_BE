package com.igemoney.igemoney_BE.user.service;

import com.igemoney.igemoney_BE.common.exception.user.UserNotFoundException;
import com.igemoney.igemoney_BE.user.dto.GetConsecutiveAttendanceResponse;
import com.igemoney.igemoney_BE.user.dto.GetMyRankingResponse;
import com.igemoney.igemoney_BE.user.dto.GetUserNicknameResponse;
import com.igemoney.igemoney_BE.user.dto.TodayAttendanceResponse;
import com.igemoney.igemoney_BE.user.entity.User;
import com.igemoney.igemoney_BE.user.entity.UserTier;
import com.igemoney.igemoney_BE.user.repository.UserStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserStatusService {

    private final UserStatusRepository userStatusRepository;

    private static final int ATTENDANCE_THRESHOLD = 5;


    @Transactional(readOnly = true)
    public TodayAttendanceResponse getTodayAttendance(Long userId) {
        User user = userStatusRepository.findById(userId)
            .orElseThrow(() -> new UserNotFoundException("존재하지 않는 유저입니다."));

        int todaySolvedCount = user.getTodayCount();
        boolean isAttended = todaySolvedCount >= ATTENDANCE_THRESHOLD;

        return new TodayAttendanceResponse(isAttended, todaySolvedCount);

    }

    @Transactional(readOnly = true)
    public GetUserNicknameResponse getUserNickName(Long userId) {
        User user = userStatusRepository.findById(userId)
            .orElseThrow(() -> new UserNotFoundException("존재하지 않는 유저입니다."));

        return new GetUserNicknameResponse(user.getNickname());

    }

    @Transactional(readOnly = true)
    public GetConsecutiveAttendanceResponse getConsecutiveAttendance(Long userId) {
        User user = userStatusRepository.findById(userId)
            .orElseThrow(() -> new UserNotFoundException("존재하지 않는 유저입니다."));

        return new GetConsecutiveAttendanceResponse(user.getConsecutiveAttendance());
    }

    @Transactional(readOnly = true)
    public GetMyRankingResponse getMyRanking(Long userId) {
        User user = userStatusRepository.findById(userId)
            .orElseThrow(() -> new UserNotFoundException("존재하지 않는 유저입니다."));

        int ratingPoint = user.getRatingPoint();

        UserTier userTier = UserTier.fromRatingPoint(ratingPoint);

        return new GetMyRankingResponse(ratingPoint, userTier.getName());

    }
}
