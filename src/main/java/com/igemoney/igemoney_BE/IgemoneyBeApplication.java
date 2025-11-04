package com.igemoney.igemoney_BE;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.TimeZone;


@EnableJpaAuditing
@SpringBootApplication()
@EnableScheduling
public class IgemoneyBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(IgemoneyBeApplication.class, args);
	}

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
	}

}
