package com.spring.mvc.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.demo.dao.CustomerDao;
import com.spring.mvc.demo.entity.Customer;

@Service
public class CutomerServiceImpel implements CustomerService {
	
	@Autowired
	CustomerDao customerDao;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}


	@Override
	@Transactional
	public void createCustomer(Customer customer) {
		customerDao.createCustomer(customer);
	}

	@Override
	@Transactional
	public Customer updateCustomer(Customer customer) {
		return customerDao.updateCustomer(customer);
	}

	@Override
	@Transactional
	public Customer deleteCustomerById(int id) {
		return customerDao.deleteCustomerById(id);
	}


	@Override
	@Transactional
	public Customer findCustomerById(int id) {
		return customerDao.findCustomerById(id);
	}
	
}
