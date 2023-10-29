package com.resttest.RestTest.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {

	private int id;
	@Size(min = 3, message = "Name Should contain atleast 3 Charector")
	private String name;
	@NotNull(message = "Please provide a valid address")
	private Address address;
	
	public Customer(int id, String name, Address address) {
		this.id= id;
		this.name= name;
		this.address= address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
