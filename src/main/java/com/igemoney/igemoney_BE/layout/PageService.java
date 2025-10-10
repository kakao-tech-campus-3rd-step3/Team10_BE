package com.igemoney.igemoney_BE.layout;

import com.igemoney.igemoney_BE.common.exception.user.UserNotFoundException;
import com.igemoney.igemoney_BE.layout.dto.HomePageResponse;
import com.igemoney.igemoney_BE.layout.dto.MypageResponse;
import com.igemoney.igemoney_BE.user.entity.User;
import com.igemoney.igemoney_BE.user.entity.UserTier;
import com.igemoney.igemoney_BE.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


// todo: 코스튬, 투자성향 테스트 구현 후 채워넣기
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PageService {

    private final UserRepository userRepository;

    public HomePageResponse getHomeInfo(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(UserNotFoundException::new);


        String characterUri = "todo: 나중에 코스튬 구현하고 바꿔야함";
        String nickname = user.getNickname();
        UserTier tier = UserTier.fromRatingPoint(user.getRatingPoint());
        String testResult = "todo: 나중에 테스트 구현하고 바꿔야함";


        return HomePageResponse.of(characterUri, nickname, tier.getName(), testResult);
    }

    public MypageResponse getMypageInfo(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(UserNotFoundException::new);

        int ratingPoint = user.getRatingPoint();

        return MypageResponse.builder()
            .nickname(user.getNickname())
            .ratingPoint(ratingPoint)
            .characterUri("콩식이이미지uri 추후구현예정")
            .tierName(UserTier.fromRatingPoint(ratingPoint).getName())
            .testResult("테스트 구현하고 바꿔야함")
            .testResultDescription("테스트구현하고 바꿔야함")
            .build();

    }
}
