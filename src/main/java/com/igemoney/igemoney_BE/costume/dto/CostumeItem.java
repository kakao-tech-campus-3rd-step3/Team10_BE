package com.igemoney.igemoney_BE.costume.dto;

public record CostumeItem(
    Long id,
    boolean isWorn,
    String costumeItemImageUrl
) {
}
