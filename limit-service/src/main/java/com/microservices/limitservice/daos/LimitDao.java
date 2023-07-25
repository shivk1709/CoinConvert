package com.microservices.limitservice.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservices.limitservice.model.Limits;

public interface LimitDao extends JpaRepository<Limits, Integer>{
	
}
