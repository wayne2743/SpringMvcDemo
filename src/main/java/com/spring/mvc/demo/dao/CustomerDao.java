package com.spring.mvc.demo.dao;

import java.util.List;

import com.spring.mvc.demo.entity.Customer;

public interface CustomerDao {
	public List<Customer> getCustomers();
	public Customer findCustomerById(int id);
	public void createCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer deleteCustomerById(int id);
	
}
