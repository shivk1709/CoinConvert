package com.microservices.limitservice.service;

import com.microservices.limitservice.dtos.LimitDto;

public interface LimitService {
	
	public LimitDto getLimitsByJpa(int id);
	public LimitDto saveLimits(LimitDto limits);

}
