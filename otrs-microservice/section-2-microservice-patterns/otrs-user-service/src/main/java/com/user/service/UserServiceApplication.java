package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.config.Configuration;

@SpringBootApplication
@EnableEurekaClient
@RefreshScope
@RestController
public class UserServiceApplication {
	
	// @Value("${app.greet.msg}")
	@Autowired
	Configuration config;
	
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@GetMapping("/")
	public String greet() {
		return config.getMessage();
	}
}
