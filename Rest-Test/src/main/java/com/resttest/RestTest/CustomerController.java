package com.resttest.RestTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.resttest.RestTest.model.Customer;
import com.resttest.RestTest.service.CustomerServiceImpl;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl service;
	
	
	@GetMapping("/customer/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		return service.getCustomerById(id);
	}
	
}
