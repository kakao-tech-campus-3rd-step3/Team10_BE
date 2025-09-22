package com.igemoney.igemoney_BE.fortest;


import com.igemoney.igemoney_BE.common.annotation.Authenticated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;


// fixme: cd가 잘 작동되는지 확인하기 위한 임시 컨트롤러입니다. 인가 기능 참고용으로 쓰고 8주차 즈음에 삭제예정입니다
@RestController
public class testController {

	@Authenticated
	@GetMapping("/test")
	public String test(@RequestAttribute("userId") Long userId) {
		return "test " + userId;
	}

	@GetMapping
	public String blankDomain() {
		return "sadajobe.shop은 이게머니 백엔드의 배포 도메인입니다.";
	}
}
