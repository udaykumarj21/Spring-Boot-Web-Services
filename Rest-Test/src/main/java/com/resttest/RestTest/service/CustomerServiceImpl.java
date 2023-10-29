package com.resttest.RestTest.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.resttest.RestTest.model.Address;
import com.resttest.RestTest.model.Customer;

@Component
public class CustomerServiceImpl {

	private static ArrayList<Customer> list= new ArrayList<Customer>();
	private static int id= 0;
	
	static {
		
		list.add(new Customer(++id, "Ramu", new Address("TOkyo", 51232)));
		list.add(new Customer(++id, "Somu", new Address("TOkyo", 51232)));
		list.add(new Customer(++id, "Bhimu", new Address("TOkyo", 51232)));
	}
	
	public Customer getCustomerById(int id) {
		Customer cust= null;
		
		for(Customer c: list) {
			if(c.getId()==id) {
				cust=c;
			}
		}
		return cust;
	}
	
	public List<Customer> getAllCustomers(){		
		return CustomerServiceImpl.list;
	}
	
	public Customer saveCustomer(Customer cust) {
		cust.setId(++id);
		list.add(cust);
		
		return cust;
	}
	
	public int deleteCustomerById(int id) {
		int flag= 0;
		Iterator<Customer> it= list.iterator();
		
		while(it.hasNext()) {
			Customer c= it.next();
			if(c.getId()==id) {
				it.remove();
				flag++;
			}
		}
		return flag;
	}

}
