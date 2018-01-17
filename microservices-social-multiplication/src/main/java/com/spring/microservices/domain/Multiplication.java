package com.spring.microservices.domain;

// This class represents a Multiplication in our application.
public class Multiplication {
	
	// Both factors
	private int factorA;
	private int factorB;
	
	// The result of the operation A * B
	private int result;

	
	public Multiplication() {
		
	}

	public Multiplication(int factorA, int factorB) {
		super();
		this.factorA = factorA;
		this.factorB = factorB;
		this.result = factorA * factorB;
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
	
	@Override
	public String toString() {
		return "Multiplication{" + "factorA=" + factorA + ", factorB=" + factorB + ", result(A*B)=" + result +'}';
	}
}
