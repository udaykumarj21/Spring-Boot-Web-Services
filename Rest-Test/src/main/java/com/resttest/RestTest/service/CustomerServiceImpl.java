package com.resttest.RestTest.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.resttest.RestTest.model.Address;
import com.resttest.RestTest.model.Customer;

@Component
public class CustomerServiceImpl {

	static {
		ArrayList<Customer> list= new ArrayList<Customer>();
		list.add(new Customer(1, "Ramu", new Address("TOkyo", 51232)));
		list.add(new Customer(2, "Somu", new Address("TOkyo", 51232)));
		list.add(new Customer(3, "Bhimu", new Address("TOkyo", 51232)));
	}
	
	public Customer getCustomerById(int id) {
		return new Customer(1, "Ramu", new Address("TOkyo", 51232));
	}

}
