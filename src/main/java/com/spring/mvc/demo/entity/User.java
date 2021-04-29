package com.spring.mvc.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ValueGenerationType;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.pl.REGON;



@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	
	@NotEmpty(message = "Please do not Empty")
	@Column(name = "user_name")
	String userName;
	
	@NotEmpty(message = "Please do not Empty")
	@Column(name = "password")
	String password;
	
	@Column(name = "reg_date")
	Date regDate;
	
	public User() {
	}
	public User(int id, String userName, String password, Date regDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.regDate = regDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
	
}
