package com.otrs.security;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class OtrsSecurityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtrsSecurityServiceApplication.class, args);
	}

	@RequestMapping({ "/user", "/me" })
	public Principal user(Principal user) {
		// You can customized what part of Principal you want to expose.
		return user;
	}
}
