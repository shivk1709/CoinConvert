package com.microservices.currencyconversion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.currencyconversion.dtos.CurrencyConversionDto;
import com.microservices.currencyconversion.services.CurrencyConversionService;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyConversionService currencyConversionService;
	
	@PostMapping("/currency-conversion")
	ResponseEntity<CurrencyConversionDto> saveCurrencyDetails(@RequestBody CurrencyConversionDto currencyConversionDto){
		CurrencyConversionDto savedCurrencyDetails = this.currencyConversionService.saveData(currencyConversionDto);
		return new ResponseEntity<CurrencyConversionDto>(savedCurrencyDetails, HttpStatus.OK);
	}
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}")
	ResponseEntity<CurrencyConversionDto> getCurrencyConversionDetails(@PathVariable String from, @PathVariable String to){
		CurrencyConversionDto currencyConversionDto = this.currencyConversionService.getData(from, to);
		return new ResponseEntity<CurrencyConversionDto>(currencyConversionDto,HttpStatus.OK);
	}

}
