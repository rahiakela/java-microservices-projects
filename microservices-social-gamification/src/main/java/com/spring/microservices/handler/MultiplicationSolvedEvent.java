package com.spring.microservices.handler;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Event received when a multiplication has been solved in the system.
 * Provides some context information about the multiplication.
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class MultiplicationSolvedEvent implements Serializable{
	
	private static final long serialVersionUID = -4833223549921634815L;
	
	private final Long multiplicationResultAttemptId;
    private final Long userId;
    private final boolean correct;
    
}
