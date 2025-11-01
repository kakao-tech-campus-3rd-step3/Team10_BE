package com.igemoney.igemoney_BE.costume;


import com.igemoney.igemoney_BE.common.annotation.Authenticated;
import com.igemoney.igemoney_BE.costume.dto.CostumeListResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/costume")
@RequiredArgsConstructor
@Tag(name = "Costume", description = "코스튬 관련 API")
public class CostumeController {

    private final CostumeService costumeService;

    @Authenticated
    @GetMapping
    public CostumeListResponse getCostumeList(@RequestAttribute Long userId) {
        return costumeService.getCostumeList(userId);
    }

}
