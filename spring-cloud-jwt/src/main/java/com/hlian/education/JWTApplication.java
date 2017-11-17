package com.hlian.education;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class JWTApplication {
	public static void main(String[] args) {
		SpringApplication.run(JWTApplication.class, args);
	}
}
