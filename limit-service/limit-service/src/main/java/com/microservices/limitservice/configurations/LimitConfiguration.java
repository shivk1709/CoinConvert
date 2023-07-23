package com.microservices.limitservice.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limit-service")
public class LimitConfiguration {

	private int maxi;
	private int mini;
	public int getMaxi() {
		return maxi;
	}
	public void setMaxi(int maxi) {
		this.maxi = maxi;
	}
	public int getMini() {
		return mini;
	}
	public void setMini(int mini) {
		this.mini = mini;
	}
	public LimitConfiguration(int maxi, int mini) {
		super();
		this.maxi = maxi;
		this.mini = mini;
	}
	public LimitConfiguration() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
