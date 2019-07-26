package com.booking.service.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class BookingNotFoundException extends Exception {

	private static final long serialVersionUID = -8890080495441147845L;

	private String message;
	private Object[] args;

	public BookingNotFoundException(String message){
		this.message = String.format("Booking %s is not found.", message);
	}

	public BookingNotFoundException(Object[] args) {
		this.args = args;
	}

	public BookingNotFoundException(String message, Object[] args){
		this.message = message;
		this.args = args;
	}

}
