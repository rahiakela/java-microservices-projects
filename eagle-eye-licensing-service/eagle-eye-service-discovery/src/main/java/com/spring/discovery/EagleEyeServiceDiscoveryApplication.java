package com.spring.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EagleEyeServiceDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EagleEyeServiceDiscoveryApplication.class, args);
	}

}
