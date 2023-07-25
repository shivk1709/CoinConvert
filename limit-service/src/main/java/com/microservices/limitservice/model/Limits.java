package com.microservices.limitservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Limits {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int upper;
	private int lower;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Limits(int id, int upper, int lower) {
		super();
		this.id = id;
		this.upper = upper;
		this.lower = lower;
	}
	public Limits() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Limits(int upper, int lower) {
		super();
		this.upper = upper;
		this.lower = lower;
	}
	
	
	
	
}
