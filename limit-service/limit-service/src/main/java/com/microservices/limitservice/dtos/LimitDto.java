package com.microservices.limitservice.dtos;


public class LimitDto {
	private int upper;
	private int lower;
	public LimitDto(int upper, int lower) {
		super();
		this.upper = upper;
		this.lower = lower;
	}
	public LimitDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getUpper() {
		return upper;
	}
	public void setUpper(int upper) {
		this.upper = upper;
	}
	public int getLower() {
		return lower;
	}
	public void setLower(int lower) {
		this.lower = lower;
	}
	
	
	
}
