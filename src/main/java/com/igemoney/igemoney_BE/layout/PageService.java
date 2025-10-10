package com.igemoney.igemoney_BE.layout;

import com.igemoney.igemoney_BE.common.exception.user.UserNotFoundException;
import com.igemoney.igemoney_BE.layout.dto.HomePageResponse;
import com.igemoney.igemoney_BE.user.entity.User;
import com.igemoney.igemoney_BE.user.entity.UserTier;
import com.igemoney.igemoney_BE.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PageService {

    private final UserRepository userRepository;

    public HomePageResponse getHomeInfo(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new UserNotFoundException("존재하지 않는 유저입니다."));

        // todo: 코스튬 구현 후 링크넣기
        String characterUri = "todo: 나중에 코스튬 구현하고 바꿔야함";
        String nickname = user.getNickname();
        UserTier tier = UserTier.fromRatingPoint(user.getRatingPoint());
        String testResult = "todo: 나중에 테스트 구현하고 바꿔야함";


        return HomePageResponse.of(characterUri, nickname, tier.getName(), testResult);
    }
}
