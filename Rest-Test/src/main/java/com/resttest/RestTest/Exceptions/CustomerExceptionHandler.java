package com.resttest.RestTest.Exceptions;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleExceptions(Exception ex, WebRequest request) throws Exception {
		
		ExceptionDetails eDet= new ExceptionDetails(new Timestamp(System.currentTimeMillis()), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity(eDet, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public final ResponseEntity<Object> handleCustomerNotFoundException(Exception ex, WebRequest request) throws Exception {
		
		ExceptionDetails eDet= new ExceptionDetails(new Timestamp(System.currentTimeMillis()), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity(eDet, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		List<ObjectError> list= ex.getAllErrors();
		String msg= "";
		for(ObjectError oe: list) {
			msg= msg+oe.getDefaultMessage()+ ", ";
		}
		
		ExceptionDetails eDet= new ExceptionDetails(new Timestamp(System.currentTimeMillis()), msg, request.getDescription(false));
		
		return new ResponseEntity<Object>(eDet, HttpStatus.BAD_REQUEST);
	}
}
