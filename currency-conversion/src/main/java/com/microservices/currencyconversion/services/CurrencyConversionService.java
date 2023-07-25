package com.microservices.currencyconversion.services;

import java.math.BigDecimal;

import com.microservices.currencyconversion.dtos.CurrencyConversionDto;

public interface CurrencyConversionService {
	
	public CurrencyConversionDto saveData(CurrencyConversionDto currencyExchangeDto);
	public CurrencyConversionDto getData(String from, String to);

}
