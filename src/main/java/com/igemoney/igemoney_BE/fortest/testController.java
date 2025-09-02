package com.igemoney.igemoney_BE.fortest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


// cd가 잘 작동되는지 확인하기 위한 임시 컨트롤러입니다. 추후 삭제예정입니다
@RestController
public class testController {
	@GetMapping("/test")
	public String test() {
		return "test";
	}

	@GetMapping
	public String blankDomain() {
		return "sadajobe.shop은 이게머니 백엔드의 배포 도메인입니다.";
	}
}
