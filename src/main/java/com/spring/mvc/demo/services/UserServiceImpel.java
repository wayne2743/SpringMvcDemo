package com.spring.mvc.demo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.demo.dao.UserDao;
import com.spring.mvc.demo.entity.User;

@Service
public class UserServiceImpel implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Override
	@Transactional
	public void createUser(User user) {
		userDao.createCustomer(user);
	}

	@Override
	@Transactional
	public User updateUser(User user) {
		return userDao.updateCustomer(user);
	}

	@Override
	@Transactional
	public User deleteUser(int id) {
		return userDao.deleteCustomerById(id);
	}

	@Override
	@Transactional
	public User verifyAccounts(String user, String password) {
		List<User> returnList = userDao.getUserByAccountName(user);
		for(User returnUser : returnList) {
			if(returnUser.getPassword().equals(password)) {
				return returnUser;
			}
		}
		
		return null;
	}

}
