package com.microservices.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(value="/api")
public class MicroservicesSimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesSimpleApplication.class, args);
	}
	
	@GetMapping("/hello/{firstName}/{lastName}")
	public String hello(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
		return String.format("{\"message\":\"Hello %s %s\"}", firstName, lastName);
	}
}
