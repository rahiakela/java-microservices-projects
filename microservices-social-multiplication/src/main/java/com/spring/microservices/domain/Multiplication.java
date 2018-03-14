package com.spring.microservices.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This class represents a Multiplication in our application.
 * This represents a Multiplication (a * b).
*/
@ToString
@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity
public final class Multiplication {
	
	@Id
	@GeneratedValue
	@Column(name="MULTIPLICATION_ID")
	private Long id;
	
	// Both factors
	private int factorA;
	private int factorB;
	
	// The result of the operation A * B
	private int result;

	// Empty constructor for JSON (de)serialization
	/*public Multiplication() {
		this(0,0);
	}*/

	public Multiplication(int factorA, int factorB) {
		this.factorA = factorA;
		this.factorB = factorB;
	}

}
