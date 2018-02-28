package com.spring.microservices.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * This class represents a Multiplication in our application.
 * This represents a Multiplication (a * b).
*/
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

	public Multiplication(int factorA, int factorB) {
		this.factorA = factorA;
		this.factorB = factorB;
	}

	public int getFactorA() {
		return factorA;
	}

	public void setFactorA(int factorA) {
		this.factorA = factorA;
	}

	public int getFactorB() {
		return factorB;
	}

	public void setFactorB(int factorB) {
		this.factorB = factorB;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
}
