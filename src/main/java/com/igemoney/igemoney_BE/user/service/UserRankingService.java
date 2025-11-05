package com.igemoney.igemoney_BE.user.service;

import com.igemoney.igemoney_BE.costume.CostumeType;
import com.igemoney.igemoney_BE.user.dto.RankingResponseDto;
import com.igemoney.igemoney_BE.user.dto.UserRankingDto;
import com.igemoney.igemoney_BE.user.entity.User;
import com.igemoney.igemoney_BE.user.repository.UserRepository;
import com.igemoney.igemoney_BE.user.type.RankingType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
public class UserRankingService {
    private final UserRepository userRepository;

    @Value("${app.costume.public-url-prefix:/costumes/}")
    private String publicPrefix;

    public RankingResponseDto getRatingPointRanking(Long userId) {
        User currentUser = userRepository.findByUserId(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        LocalDateTime updatedAt = currentUser.getRatingPointUpdatedAt();
        Integer ratingPoint = currentUser.getRatingPoint();
        Long myRank = userRepository.getRatingRank(ratingPoint, updatedAt) + 1;

        List<User> topRankingUsers = userRepository.findTop3ByRatingPointRank(PageRequest.of(0, 3));

        List<User> aboveUsers = userRepository.findTop2AboveByRatingPoint(
                ratingPoint, updatedAt, PageRequest.of(0, 2)
        );
        List<User> belowUsers = userRepository.findTop2BelowByRatingPoint(
                ratingPoint, updatedAt, PageRequest.of(0, 2)
        );

        return buildRankingResponseDto(currentUser, topRankingUsers, aboveUsers, belowUsers, myRank, RankingType.RATING_POINT);
    }

    public RankingResponseDto getConsecutiveAttendanceRanking(Long userId) {
        User currentUser = userRepository.findByUserId(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        LocalDateTime updatedAt = currentUser.getConsecutiveAttendanceUpdatedAt();
        Integer consecutiveAttendance = currentUser.getConsecutiveAttendance();
        Long myRank = userRepository.getConsecutiveAttendanceRank(consecutiveAttendance, updatedAt) + 1;

        List<User> topRankingUsers = userRepository.findTop3ByConsecutiveAttendanceRank(PageRequest.of(0, 3));

        List<User> aboveUsers = userRepository.findTop2AboveByConsecutiveAttendance(
                consecutiveAttendance, updatedAt, PageRequest.of(0, 2)
        );
        List<User> belowUsers = userRepository.findTop2BelowByConsecutiveAttendance(
                consecutiveAttendance, updatedAt, PageRequest.of(0, 2)
        );

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
        List<UserRankingDto> aboveDtos = new ArrayList<>();
        List<UserRankingDto> belowDtos = new ArrayList<>();

        Collections.reverse(aboveUsers);

        // 위쪽 유저
        for (int i = 0; i < aboveUsers.size(); i++) {
            User u = aboveUsers.get(i);
            Long rank = myRank - (aboveUsers.size() - i);
            Integer point = (rankingType == RankingType.RATING_POINT) ?
                    u.getRatingPoint() : u.getConsecutiveAttendance();

            aboveDtos.add(new UserRankingDto(u.getNickname(), point, rank, null));
        }

        // 아래쪽 유저
        for (int i = 0; i < belowUsers.size(); i++) {
            User u = belowUsers.get(i);
            Long rank = myRank + i + 1;
            Integer point = (rankingType == RankingType.RATING_POINT) ?
                    u.getRatingPoint() : u.getConsecutiveAttendance();

            belowDtos.add(new UserRankingDto(u.getNickname(), point, rank, null));
        }

        // 현재 유저 DTO
        Integer currentPoint = (rankingType == RankingType.RATING_POINT)
                ? currentUser.getRatingPoint()
                : currentUser.getConsecutiveAttendance();
        UserRankingDto currentUserRankingDto = new UserRankingDto(currentUser.getNickname(), currentPoint, myRank, null);

        // Top3 DTO
        List<UserRankingDto> topUsersRankingDtos = new ArrayList<>();
        for (int i = 0; i < topRankingUsers.size(); i++) {
            User u = topRankingUsers.get(i);
            Long rank = i + 1L;
            Integer point = (rankingType == RankingType.RATING_POINT)
                    ? u.getRatingPoint() : u.getConsecutiveAttendance();

            topUsersRankingDtos.add(new UserRankingDto(u.getNickname(), point, rank, getKongSkinUrl(u)));
        }

        return new RankingResponseDto(currentUserRankingDto, topUsersRankingDtos, aboveDtos, belowDtos);
    }


    private String getKongSkinUrl(User user) {
        Long wornId = user.getWornCostumeId();
        if (wornId == null) {
            return null;
        }
        return publicPrefix + CostumeType.fromId(wornId).getOnFileUrl();
    }
}
