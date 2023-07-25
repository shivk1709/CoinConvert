package com.microservices.limitservice.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ResourceNotFoundException extends RuntimeException {
	private String message ;
	private int id;
	
	public ResourceNotFoundException(String message, int id) {
		super(String.format("%s not found with id : %d" , message, id));
		this.message = message;
		this.id = id;
	}
	
	
}
