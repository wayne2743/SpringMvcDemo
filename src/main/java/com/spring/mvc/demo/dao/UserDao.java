package com.spring.mvc.demo.dao;

import java.util.List;

import com.spring.mvc.demo.entity.Customer;
import com.spring.mvc.demo.entity.User;

public interface UserDao {
	public List<User> getUsers();
	public List<User> getUserByAccountName(String userName);
	public User findCustomerById(int id);
	public void createCustomer(User user);
	public User updateCustomer(User user);
	public User deleteCustomerById(int id);
}
