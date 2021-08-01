package com.techlab.model;

public class Customer {
	private String username;
	private String password;
	
	public Customer(String username,String password) {
		this.username=username;
		this.password=password;
	}
	public String getUserName() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	@Override
	public String toString() {
		return "[username=" + username + ", password=" + password + "]";
	}
}
