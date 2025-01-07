package com.example.jpamini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JpaminiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaminiApplication.class, args);
	}

}
