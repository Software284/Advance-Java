package com.lamichhane.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class UserInformationExceptionHandler {
	
	@ExceptionHandler(UserInformationException.class)
	public ResponseEntity<ErrorResponse> handleUserInformationException(UserInformationException exception){
		return ResponseEntity.status(exception.getStatus())
				.body(new ErrorResponse(exception.getMessage(),exception.getCode()));
	}
	
	private static record ErrorResponse(String message,String errorCode) {
		
	}
}
