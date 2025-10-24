package com.igemoney.igemoney_BE.user.dto;

import com.igemoney.igemoney_BE.user.entity.User;

import java.util.ArrayList;
import java.util.List;

public record UserRankingDto(
        String nickname,
        Integer point,
        Long rank
){
    public UserRankingDto(String nickname, Integer point, Long rank) {
        this.nickname = nickname;
        this.point = point;
        this.rank = rank;
    }

}
