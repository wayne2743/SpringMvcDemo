package com.spring.mvc.demo.services;

import java.util.List;

import com.spring.mvc.demo.entity.User;

public interface UserService {
	public List<User> getUsers();
	public User verifyAccounts(String userName, String password);
	public void createUser(User user);
	public User updateUser(User user);
	public User deleteUser(int id);
}
