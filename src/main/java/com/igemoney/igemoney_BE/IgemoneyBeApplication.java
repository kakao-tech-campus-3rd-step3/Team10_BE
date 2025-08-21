package com.igemoney.igemoney_BE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


// todo: db 의존성 설치하면 exclude 속성 지워버리기
@SpringBootApplication(exclude={ DataSourceAutoConfiguration.class})
public class IgemoneyBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(IgemoneyBeApplication.class, args);
	}

}
