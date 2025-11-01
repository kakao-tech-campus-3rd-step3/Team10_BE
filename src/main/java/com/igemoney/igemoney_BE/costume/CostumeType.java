package com.igemoney.igemoney_BE.costume;

import java.util.Arrays;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CostumeType {
    BUNNY(1L, "bunny"),
    COWBOY(2L, "cowboy"),
    DEVIL(3L, "devil"),
    HOODIE(4L, "hoodie"),
    WIZARD(5L, "wizard"),
    SOCCER(6L, "soccer"),
    SUITE(7L, "suite");

    private final Long id;
    private final String costumeName;

    public String getOffFileUrl() {
        return "costume_" + costumeName + ".png";
    }

    public String onFile()  {
        return "costume_" + costumeName + "_on.png";
    }

    public static CostumeType fromId(Long id) {
        return Arrays.stream(values())
            .filter(v -> v.id.equals(id))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(id+ "는 매칭되지 않는 코스튬 ID입니다 "));
    }

}
