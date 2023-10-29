package com.resttest.RestTest.Exceptions;

public class CustomerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5470752600619969478L;

	public CustomerNotFoundException(String message) {
		super(message);
	}
}
