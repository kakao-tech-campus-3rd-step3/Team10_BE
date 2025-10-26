package com.igemoney.igemoney_BE.user.dto;

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
