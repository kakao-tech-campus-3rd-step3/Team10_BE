package com.igemoney.igemoney_BE.user.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateNicknameRequest(
    @NotBlank(message = "수정할 닉네임은 null일 수 없습니다")
    String nickname
) {

}
