package com.igemoney.igemoney_BE.user.service;

import com.igemoney.igemoney_BE.common.exception.user.DuplicateNicknameException;
import com.igemoney.igemoney_BE.common.exception.user.NotRegisteredUserException;
import com.igemoney.igemoney_BE.common.utils.JwtUtil;
import com.igemoney.igemoney_BE.user.dto.CreateUserRequest;
import com.igemoney.igemoney_BE.user.dto.LoginRequest;
import com.igemoney.igemoney_BE.user.dto.LoginResponse;
import com.igemoney.igemoney_BE.user.entity.User;
import com.igemoney.igemoney_BE.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final OAuthProvider oAuthProvider;
    private final JwtUtil jwtUtil;


    public LoginResponse register(CreateUserRequest req) {

        // 0. 닉네임 중복 검증
        if(userRepository.existsByNickname(req.nickname())){
            throw new DuplicateNicknameException();
        }
      
        // 1. 액세스 토큰 발급
        String accessToken = oAuthProvider.getProviderAccessToken(req.code()).accessToken();

        // 2. 발급받은 토큰으로 유저정보 조회해 oauthId 획득
        Long oauthId = oAuthProvider.getProviderUserInfo(accessToken).id();

        // 3. 닉네임, oauthId로 새 유저 등록
        User savedUser = userRepository.save(new User(req.nickname(), oauthId));

        // 4. 우리 서비스 자체 jwt accessToken 발급
        String jwtToken = jwtUtil.generateToken(savedUser);

        return new LoginResponse(jwtToken);
    }

    public LoginResponse login(LoginRequest req) {
        // 1. 액세스 토큰 발급
        String accessToken = oAuthProvider.getProviderAccessToken(req.code()).accessToken();

        // 2. 발급받은 토큰으로 유저정보 조회해 oauthId 획득
        Long oauthId = oAuthProvider.getProviderUserInfo(accessToken).id();

        // 3. 가입하지 않은 유저라면 401에러 리턴
        User user = userRepository.findByKakaoOauthId(oauthId)
            .orElseThrow(() -> new NotRegisteredUserException("가입하지 않은 유저입니다. 회원가입 해야 합니다."));

        String jwtToken = jwtUtil.generateToken(user);

        return new LoginResponse(jwtToken);
    }

}
