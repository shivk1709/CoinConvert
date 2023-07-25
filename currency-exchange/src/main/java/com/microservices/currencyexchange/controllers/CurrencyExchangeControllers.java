package com.microservices.currencyexchange.controllers;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.currencyexchange.Dtos.CurrencyConversionDto;
import com.microservices.currencyexchange.Dtos.CurrencyExchangeDto;
import com.microservices.currencyexchange.proxy.CurrencyConversionInterface;

@RestController
public class CurrencyExchangeControllers {
	
	@Autowired
	private CurrencyConversionInterface currencyConversionInterface;

//	Method to use the another microservice using restTemplate
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}/quantity/{quantity}")
	public ResponseEntity<CurrencyExchangeDto> exchangeCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConversionDto> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8080/currency-conversion/from/{from}/to/{to}", CurrencyConversionDto.class,
				uriVariables);
		CurrencyConversionDto currencyConversionDto = responseEntity.getBody();

		return new ResponseEntity<CurrencyExchangeDto>(
				new CurrencyExchangeDto(currencyConversionDto.getId(), from, to, quantity, currencyConversionDto.getConversionMultiple(), quantity.multiply(currencyConversionDto.getConversionMultiple())), HttpStatus.OK);
	}
	
	
	@GetMapping("/currency-exchange-feign/from/{from}/to/{to}/quantity/{quantity}")
	public ResponseEntity<CurrencyExchangeDto> exchangeCurrencyUsingFeign(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity){
		CurrencyConversionDto currencyConversionDto = this.currencyConversionInterface.exchangeCurrencyUsingFeignClient(from, to);
		return new ResponseEntity<CurrencyExchangeDto>(
				new CurrencyExchangeDto(currencyConversionDto.getId(), from, to, quantity, currencyConversionDto.getConversionMultiple(), quantity.multiply(currencyConversionDto.getConversionMultiple())), HttpStatus.OK);
	}

}
