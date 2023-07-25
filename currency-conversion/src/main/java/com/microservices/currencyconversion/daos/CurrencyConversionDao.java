package com.microservices.currencyconversion.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.currencyconversion.models.CurrencyDetails;

public interface CurrencyConversionDao extends JpaRepository<CurrencyDetails, Long> {
	
	CurrencyDetails findByFromAndTo(String from, String to);

}
