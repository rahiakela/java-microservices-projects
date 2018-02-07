package com.spring.microservices.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * This class represents a Multiplication in our application.
 * This represents a Multiplication (a * b).
*/
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public final class Multiplication {
	
	// Both factors
	private int factorA;
	private int factorB;
	
	// The result of the operation A * B
	private int result;

	// Empty constructor for JSON (de)serialization
	public Multiplication() {
		this(0,0);
	}

}
