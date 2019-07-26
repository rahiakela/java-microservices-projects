package com.restaurant.service.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class RestaurantNotFoundException extends Exception {

	private static final long serialVersionUID = -8890080495441147845L;

	private String message;
	private Object[] args;

	public RestaurantNotFoundException(String message){
		this.message = String.format("Restaurant %s is not found.", message);
	}

	public RestaurantNotFoundException(Object[] args) {
		this.args = args;
	}

	public RestaurantNotFoundException(String message, Object[] args) {
		this.message = message;
		this.args = args;
	}
	
}
