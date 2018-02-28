package com.spring.microservices.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
* Identifies the attempt from a {@link User} to solve a
* {@link Multiplication}.
*/
@ToString
@EqualsAndHashCode
public final class MultiplicationResultAttempt {

	private final User user;
	private final Multiplication multiplication;
	private final int resultAttempt;
	
	// Empty constructor for JSON (de)serialization
	MultiplicationResultAttempt() {
		user = null;
		multiplication = null;
		resultAttempt = -1;
	}

	public MultiplicationResultAttempt(User user, Multiplication multiplication, int resultAttempt) {
		this.user = user;
		this.multiplication = multiplication;
		this.resultAttempt = resultAttempt;
	}

	public User getUser() {
		return user;
	}

	public Multiplication getMultiplication() {
		return multiplication;
	}

	public int getResultAttempt() {
		return resultAttempt;
	}
	
}
