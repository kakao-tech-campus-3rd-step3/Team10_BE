package com.igemoney.igemoney_BE.layout;


import com.igemoney.igemoney_BE.common.annotation.Authenticated;
import com.igemoney.igemoney_BE.layout.dto.HomePageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/page")
@RequiredArgsConstructor
public class PageController {

    private final PageService pageService;

    @GetMapping("/home")
    @Authenticated
    public HomePageResponse getHomeInfo(@RequestAttribute("userId") Long userId){
        return pageService.getHomeInfo(userId);
    }


}
