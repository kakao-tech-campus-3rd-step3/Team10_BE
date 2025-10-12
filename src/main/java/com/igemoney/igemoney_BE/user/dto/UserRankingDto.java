package com.igemoney.igemoney_BE.user.dto;

import com.igemoney.igemoney_BE.user.entity.User;

import java.util.List;

public record UserRankingDto(
        String nickname,
        Integer point
){
    public UserRankingDto(User user) {
        this(user.getNickname(), user.getRatingPoint());
    }

    public static List<UserRankingDto> listFrom(List<User> users) {
        return users.stream().map(UserRankingDto::new).toList();
    }
}
