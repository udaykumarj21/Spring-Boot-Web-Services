package com.resttest.RestTest;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.resttest.RestTest.Exceptions.CustomerNotFoundException;
import com.resttest.RestTest.model.Customer;
import com.resttest.RestTest.service.CustomerServiceImpl;

import jakarta.validation.Valid;

@RestController
public class CustomerController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private CustomerServiceImpl service;
	
	@GetMapping("/customer")
	public List<Customer> getAllCustomers(){
		return service.getAllCustomers();
	}
	
	@GetMapping("/customer/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		
		Customer c=  service.getCustomerById(id);
		
		if(c==null) {
			throw new CustomerNotFoundException("Customer Not Found");
		}
		
		return c;
	}
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer cust) {
		 Customer c=  service.saveCustomer(cust);
		
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(c.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/customers/{id}")
	public void deleteCustomerById(@PathVariable int id) {
		service.deleteCustomerById(id);
	}
	
	@GetMapping("/msg")
	public String getMessage() {
		Locale locale= LocaleContextHolder.getLocale();
		String msg= messageSource.getMessage("good.morning", null, locale);
		return msg;
	}
}
