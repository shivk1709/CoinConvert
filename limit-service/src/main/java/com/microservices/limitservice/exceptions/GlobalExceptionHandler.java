package com.microservices.limitservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.microservices.limitservice.dtos.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandlerMethod(ResourceNotFoundException ex){
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
	}
	

}
