package com.microservices.limitservice.dtos;



public class ApiResponse {
	
	private String message;
	private boolean check;
	
	public ApiResponse(String message, boolean check) {
		super();
		this.message = message;
		this.check = check;
	}
	
	

}
