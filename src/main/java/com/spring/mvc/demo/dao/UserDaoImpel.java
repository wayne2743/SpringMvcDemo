package com.spring.mvc.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc.demo.entity.User;

@Repository
public class UserDaoImpel implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<User> getUsers() {
		Session session = sessionFactory.getCurrentSession();
		Query<User> theQuery = session.createQuery("from User");
		List<User> users = theQuery.getResultList();
		return users;
	}

	@Override
	public User findCustomerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		User currentUser = session.get(User.class, id);
		return currentUser;
	}

	@Override
	public void createCustomer(User user) {
		Session session = sessionFactory.getCurrentSession();
		user.setId(0);
		session.save(user);
	}

	@Override
	public User updateCustomer(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
		return user;
	}

	@Override
	public User deleteCustomerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		session.remove(user);
		return user;
	}

	@Override
	public List<User> getUserByAccountName(String userName) {
		Session session = sessionFactory.getCurrentSession();
		Query<User> theQuery = session.createQuery("from User u where u.userName = '" + userName+"'");
		List<User> users = theQuery.getResultList();
		return users;
	}

}
