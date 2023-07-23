package com.microservices.limitservice.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.limitservice.daos.LimitDao;
import com.microservices.limitservice.dtos.LimitDto;
import com.microservices.limitservice.exceptions.ResourceNotFoundException;
import com.microservices.limitservice.model.Limits;
import com.microservices.limitservice.service.LimitService;

@Service
public class LimitServiceImpl implements LimitService {
	
	@Autowired
	private LimitDao limitDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	

	@Override
	public LimitDto getLimitsByJpa(int id) {
		// TODO Auto-generated method stub
		Limits limits = this.limitDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found for id", id));
		return this.modelMapper.map(limits, LimitDto.class);
	}
	@Override
	public LimitDto saveLimits(LimitDto limits) {
		// TODO Auto-generated method stub
		return this.modelMapper.map(this.limitDao.save(this.modelMapper.map(limits, Limits.class)), LimitDto.class);
	}

}
