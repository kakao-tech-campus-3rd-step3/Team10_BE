package com.igemoney.igemoney_BE.costume;


import com.igemoney.igemoney_BE.common.annotation.Authenticated;
import com.igemoney.igemoney_BE.costume.dto.CostumeListResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Authenticated
    @PostMapping("/{costumeId}")
    public void wear(@PathVariable Long costumeId, @RequestAttribute Long userId) {
        costumeService.wearCostume(userId, costumeId);
    }

}
