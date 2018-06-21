package com.spring.microservices.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.spring.microservices.dto.MultiplicationResultAttempt;

/**
* This implementation of MultiplicationResultAttemptClient interface connects to
* the Multiplication microservice via REST.
*/
public class MultiplicationResultAttemptClientImpl implements MultiplicationResultAttemptClient {
	private final RestTemplate restTemplate;
	private final String multiplicationHost;
	
	public MultiplicationResultAttemptClientImpl(final RestTemplate restTemplate, @Value("${multiplicationHost}") final String multiplicationHost) {
		this.restTemplate = restTemplate;
		this.multiplicationHost = multiplicationHost;
	}

	@Override
	public MultiplicationResultAttempt retrieveMultiplicationResultAttemptbyId(final Long multiplicationResultAttemptId) {
		return restTemplate.getForObject(multiplicationHost + "/results/" + multiplicationResultAttemptId, MultiplicationResultAttempt.class);
	}
	
}
