package com.resttest.RestTest.model;

public class Address {

	public String city;
	public int pinCode;
	
	public Address(String city, int pinCode) {
		this.city= city;
		this.pinCode= pinCode;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
}
