package com.microservices.currencyconversion.serviceImpl;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.currencyconversion.daos.CurrencyConversionDao;
import com.microservices.currencyconversion.dtos.CurrencyConversionDto;
import com.microservices.currencyconversion.models.CurrencyDetails;
import com.microservices.currencyconversion.services.CurrencyConversionService;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {
	
	@Autowired
	private CurrencyConversionDao currencyExchangeDao;
	@Autowired
	private ModelMapper modelmapper;

	@Override
	public CurrencyConversionDto saveData(CurrencyConversionDto currencyConversionDto) {
		// TODO Auto-generated method stub
		CurrencyDetails  currencyDetails =this.currencyExchangeDao.save(this.modelmapper.map(currencyConversionDto, CurrencyDetails.class));
		return this.modelmapper.map(currencyDetails, CurrencyConversionDto.class);
	}

	@Override
	public CurrencyConversionDto getData(String from, String to) {
		// TODO Auto-generated method stub
		CurrencyDetails currencyDetails = this.currencyExchangeDao.findByFromAndTo(from, to);
		return this.modelmapper.map(currencyDetails, CurrencyConversionDto.class);
	}

}
