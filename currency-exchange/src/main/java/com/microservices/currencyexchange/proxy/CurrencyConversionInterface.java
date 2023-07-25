package com.microservices.currencyexchange.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.currencyexchange.Dtos.CurrencyConversionDto;

@FeignClient(name = "currency-conversion", url = "localhost:8080")
public interface CurrencyConversionInterface {
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}")
	public CurrencyConversionDto exchangeCurrencyUsingFeignClient(@PathVariable String from,@PathVariable String to);

}
