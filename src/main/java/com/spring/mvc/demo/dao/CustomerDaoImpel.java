package com.spring.mvc.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc.demo.entity.Customer;

@Repository
public class CustomerDaoImpel implements CustomerDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> theQuery = session.createQuery("from Customer order by lastName");
		List<Customer> customers = theQuery.getResultList();
		return customers;
	}


	@Override
	public Customer findCustomerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer currentCustomer = session.get(Customer.class, id);
		return currentCustomer;
	}

	@Override
	public void createCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		// set customer id as 0 to add new customer in database
		customer.setId(0);
		session.save(customer);
//		session.persist(customer);
	}

	@Override
	public Customer deleteCustomerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer deleteCustomer = session.get(Customer.class, id);
		session.remove(deleteCustomer);
		return deleteCustomer;
	}


	@Override
	public Customer updateCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.update(customer);
		return customer;
	}

}
