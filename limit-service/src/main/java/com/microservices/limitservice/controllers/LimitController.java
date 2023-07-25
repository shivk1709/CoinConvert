package com.microservices.limitservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.limitservice.configurations.LimitConfiguration;
import com.microservices.limitservice.dtos.LimitDto;
import com.microservices.limitservice.model.Limits;
import com.microservices.limitservice.service.LimitService;

@RestController
public class LimitController {
	
	@Autowired
	private LimitConfiguration limitConfiguration;
	
	@Autowired
	private LimitService limitService;
	
	@GetMapping("/limits")
	public ResponseEntity<Limits> getMinimumAndMaximumLimits(){
		return new ResponseEntity<Limits>(new Limits(10,20), HttpStatus.OK);
	}
	
	@GetMapping("/limits-from-properties")
	public ResponseEntity<LimitConfiguration> getLimitsFromPropertiesFile(){
		return new ResponseEntity<LimitConfiguration>(new LimitConfiguration(limitConfiguration.getMini(), limitConfiguration.getMaxi()), HttpStatus.OK);
	}
	
	@PostMapping("/saveLimits")
	public ResponseEntity<LimitDto> saveLimits(@RequestBody LimitDto limitDto){
		return new ResponseEntity<LimitDto>(this.limitService.saveLimits(limitDto),HttpStatus.OK);
	}
	
	@GetMapping("/limitsByJPA/{id}")
	public ResponseEntity<LimitDto> getLimitsByJpa(@PathVariable int id){
		LimitDto limitDto = this.limitService.getLimitsByJpa(id);
		return new ResponseEntity<LimitDto>(limitDto,HttpStatus.FOUND);
	}

}
