package com.user.service.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = -8890080495441147845L;

	private String message;
	private Object[] args;

	public UserNotFoundException(String message){
		this.message = String.format("User %s is not found.", message);
	}

	public UserNotFoundException(Object[] args) {
		this.args = args;
	}

	public UserNotFoundException(String message, Object[] args){
		this.message = message;
		this.args = args;
	}

}
