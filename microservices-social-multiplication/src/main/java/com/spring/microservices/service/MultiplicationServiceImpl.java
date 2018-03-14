package com.spring.microservices.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.spring.microservices.domain.Multiplication;
import com.spring.microservices.domain.MultiplicationResultAttempt;
import com.spring.microservices.domain.User;
import com.spring.microservices.repository.MultiplicationResultAttemptRepository;
import com.spring.microservices.repository.UserRepository;


@Service
public class MultiplicationServiceImpl implements MultiplicationService{
	
	private RandomGeneratorService randomGeneratorService;
	private MultiplicationResultAttemptRepository attemptRepository;
	private UserRepository userRepository;
	
	@Autowired
	public MultiplicationServiceImpl(final RandomGeneratorService randomGeneratorService, final MultiplicationResultAttemptRepository attemptRepository, final UserRepository userRepository) {
		this.randomGeneratorService = randomGeneratorService;
		this.attemptRepository = attemptRepository;
		this.userRepository = userRepository;
	}

	@Override
	public Multiplication createRandomMultiplication() {
		int factorA = randomGeneratorService.generateRandomFactor();
		int factorB = randomGeneratorService.generateRandomFactor();
		
		return new Multiplication(factorA, factorB);
	}

	@Override
	public boolean checkAttempt(final MultiplicationResultAttempt resultAttempt) {
		// Check if the user already exists for that alias
		Optional<User> user = userRepository.findByAlias(resultAttempt.getUser().getAlias());
		
		// Avoids 'hack' attempts
		Assert.isTrue(!resultAttempt.isCorrect(), "You can't send an attempt marked as correct!!");
		
		// Checks if it's correct
		boolean correct = resultAttempt.getResultAttempt() == resultAttempt.getMultiplication().getFactorA() * resultAttempt.getMultiplication().getFactorB();
				
		// Creates a copy, now setting the 'correct' field accordingly
		MultiplicationResultAttempt checkedAttempt = new MultiplicationResultAttempt(user.orElse(resultAttempt.getUser()), resultAttempt.getMultiplication(), resultAttempt.getResultAttempt(), correct);
		
		// Stores the attempt
		attemptRepository.save(checkedAttempt);
		
		return correct;
	}
	
}
