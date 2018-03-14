package com.spring.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.microservices.domain.MultiplicationResultAttempt;
import com.spring.microservices.service.MultiplicationService;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/results")
public final class MultiplicationResultAttemptController {
	
	private final MultiplicationService multiplicationService;

	@Autowired
	public MultiplicationResultAttemptController(final MultiplicationService multiplicationService) {
		this.multiplicationService = multiplicationService;
	}
	
	@PostMapping
	ResponseEntity<MultiplicationResultAttempt> postResult(@RequestBody MultiplicationResultAttempt multiplicationResultAttempt) {
		boolean isCorrect = multiplicationService.checkAttempt(multiplicationResultAttempt);
		MultiplicationResultAttempt attemptCopy = new MultiplicationResultAttempt(multiplicationResultAttempt.getUser(), multiplicationResultAttempt.getMultiplication(), multiplicationResultAttempt.getResultAttempt(), isCorrect);
		
		return ResponseEntity.ok(attemptCopy);
	}
	
	@RequiredArgsConstructor
	@NoArgsConstructor(force = true)
	@Getter
	public static final class ResultResponse {
		private final boolean correct;
	}
}
