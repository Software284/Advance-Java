package com.lamichhane.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class UserInformationException extends RuntimeException {
	
	private HttpStatus status;
	
	private String code;
	
	public UserInformationException(String message,HttpStatus status,String code) {
		super(message);
		this.status = status;
		this.code = code;
	}
	
	
	
	
}
