package com.igemoney.igemoney_BE.layout;


import com.igemoney.igemoney_BE.common.annotation.Authenticated;
import com.igemoney.igemoney_BE.layout.dto.HomePageResponse;
import com.igemoney.igemoney_BE.layout.dto.MypageResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/page")
@RequiredArgsConstructor
@Tag(name = "Page", description = "페이지 레이아웃 별 데이터 관련 API")
public class PageController {

    private final PageService pageService;

    @GetMapping("/home")
    @Authenticated
    public HomePageResponse getHomeInfo(@RequestAttribute("userId") Long userId){
        return pageService.getHomeInfo(userId);
    }

    @GetMapping("/mypage")
    @Authenticated
    public MypageResponse getMyPageInfo(@RequestAttribute("userId") Long userId){
        return pageService.getMypageInfo(userId);
    }


}
