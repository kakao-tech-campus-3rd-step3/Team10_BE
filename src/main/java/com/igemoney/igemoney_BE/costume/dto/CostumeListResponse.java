package com.igemoney.igemoney_BE.costume.dto;

import java.util.List;

public record CostumeListResponse(
    List<CostumeItem> costumeItems
) {
}
