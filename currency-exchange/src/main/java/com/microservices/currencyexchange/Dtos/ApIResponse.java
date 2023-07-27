package com.microservices.currencyexchange.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApIResponse {
	
	private String message;
	private boolean status;

}
