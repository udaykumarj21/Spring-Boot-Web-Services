package com.resttest.RestTest.Exceptions;

import java.sql.Timestamp;

public class ExceptionDetails {

	private Timestamp dateAndTime;
	private String message;
	private String status;
	
	public ExceptionDetails(Timestamp dateAndTime, String message, String status) {
		this.dateAndTime = dateAndTime;
		this.message = message;
		this.status = status;
	}
	
	public Timestamp getDateAndTime() {
		return dateAndTime;
	}
	public String getMessage() {
		return message;
	}
	public String getStatus() {
		return status;
	}
	
	
}
