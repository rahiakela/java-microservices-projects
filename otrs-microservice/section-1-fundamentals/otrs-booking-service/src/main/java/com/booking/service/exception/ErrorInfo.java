package com.booking.service.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfo {
	private String url;
	private String message;

	public ErrorInfo(String message) {
		this.message = message;
	}
	
}
