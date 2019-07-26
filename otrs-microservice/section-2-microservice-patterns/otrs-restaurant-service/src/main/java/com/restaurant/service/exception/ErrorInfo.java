package com.restaurant.service.exception;

import lombok.Data;

@Data
public class ErrorInfo {
	private String url;
	private String message;

	public ErrorInfo() {
		
	}
	
	public ErrorInfo(String message) {
		this.message = message;
	}
	
	public ErrorInfo(String url, String message) {
		this.url = url;
		this.message = message;
	}	
	
}
