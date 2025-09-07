package com.igemoney.igemoney_BE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication()
public class IgemoneyBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(IgemoneyBeApplication.class, args);
	}

}
