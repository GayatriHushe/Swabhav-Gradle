package com.techlab.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.techlab.services.Encryption;

@Entity
public class Customer {
	@Id
	private String id;
	private String username;
	private String password;
	
	
	public Customer(String username,String password) {
		this.id=UUID.randomUUID().toString();
		this.username=username;
		this.password=password;
	}
	
	public Customer()
	{
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password =password;
	}
	
	
}
