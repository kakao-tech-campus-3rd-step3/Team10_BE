package com.igemoney.igemoney_BE.user.service;

import com.igemoney.igemoney_BE.user.dto.RankingResponseDto;
import com.igemoney.igemoney_BE.user.dto.UserRankingDto;
import com.igemoney.igemoney_BE.user.entity.User;
import com.igemoney.igemoney_BE.user.repository.UserRepository;
import com.igemoney.igemoney_BE.user.type.RankingType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
public class UserRankingService {
    private final UserRepository userRepository;

    public RankingResponseDto getRatingPointRanking(Long userId) {
        User currentUser = userRepository.findByUserId(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        Integer ratingPoint = currentUser.getRatingPoint();
        Long myRank = userRepository.countUsersWithHigherRatingPoint(ratingPoint) + 1;

        List<User> topRankingUsers = userRepository.findTop3ByOrderByRatingPointDesc();

        List<User> aboveUsers = userRepository.findTop2ByRatingPointGreaterThanOrderByRatingPointAsc(ratingPoint);
        List<User> belowUsers = userRepository.findTop2ByRatingPointLessThanOrderByRatingPointDesc(ratingPoint);

        return buildRankingResponseDto(currentUser, topRankingUsers, aboveUsers, belowUsers, myRank, RankingType.RATING_POINT);
    }

    public RankingResponseDto getConsecutiveAttendanceRanking(Long userId) {
        User currentUser = userRepository.findByUserId(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        Integer consecutiveAttendance = currentUser.getConsecutiveAttendance();
        Long myRank = userRepository.countUsersWithHigherConsecutiveAttendance(consecutiveAttendance) + 1;

        List<User> topRankingUsers = userRepository.findTop3ByOrderByConsecutiveAttendanceDesc();

        List<User> aboveUsers = userRepository.findTop2ByConsecutiveAttendanceGreaterThanOrderByConsecutiveAttendanceAsc(consecutiveAttendance);
        List<User> belowUsers = userRepository.findTop2ByConsecutiveAttendanceLessThanOrderByConsecutiveAttendanceDesc(consecutiveAttendance);

        return buildRankingResponseDto(currentUser, topRankingUsers, aboveUsers, belowUsers, myRank, RankingType.CONSECUTIVE_ATTENDANCE);
    }

    private RankingResponseDto buildRankingResponseDto(
            User currentUser,
            List<User> topRankingUsers,
            List<User> aboveUsers,
            List<User> belowUsers,
            Long myRank,
            RankingType rankingType
    ) {

        Collections.reverse(aboveUsers); // 위쪽 유저 오름차순 -> 내림차순

        List<UserRankingDto> adjacentUsersRankingDtos = new ArrayList<>();

        // 위쪽 유저
        for (int i = 0; i < aboveUsers.size(); i++) {
            User u = aboveUsers.get(i);
            Long rank = myRank - (aboveUsers.size() - i);
            Integer point = (rankingType == RankingType.RATING_POINT) ? u.getRatingPoint() : u.getConsecutiveAttendance();
            adjacentUsersRankingDtos.add(new UserRankingDto(u.getNickname(), point, rank));
        }

        // 아래쪽 유저
        for (int i = 0; i < belowUsers.size(); i++) {
            User u = belowUsers.get(i);
            Long rank = myRank + i + 1L;
            Integer point = (rankingType == RankingType.RATING_POINT) ? u.getRatingPoint() : u.getConsecutiveAttendance();
            adjacentUsersRankingDtos.add(new UserRankingDto(u.getNickname(), point, rank));
        }

        // 현재 유저 DTO
        Integer currentPoint = (rankingType == RankingType.RATING_POINT) ? currentUser.getRatingPoint() : currentUser.getConsecutiveAttendance();
        UserRankingDto currentUserRankingDto = new UserRankingDto(currentUser.getNickname(), currentPoint, myRank);

        // Top3 DTO
        List<UserRankingDto> topUsersRankingDtos = new ArrayList<>();

        for (int i = 0; i < topRankingUsers.size(); i++) {
            User u = topRankingUsers.get(i);
            Long rank = i + 1L;
            Integer point = (rankingType == RankingType.CONSECUTIVE_ATTENDANCE) ? u.getConsecutiveAttendance() : u.getRatingPoint();
            topUsersRankingDtos.add(new UserRankingDto(u.getNickname(), point, rank));
        }

        return new RankingResponseDto(currentUserRankingDto, topUsersRankingDtos, adjacentUsersRankingDtos);
    }
}
