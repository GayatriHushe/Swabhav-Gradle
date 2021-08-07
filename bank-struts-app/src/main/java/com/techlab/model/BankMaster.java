package com.techlab.model;

public class BankMaster {
	private String name;
	private double balance;
	private String password;
	
	public BankMaster(String name,double balance,String password) {
		this.setName(name);
		this.setBalance(balance);
		this.setPassword(password);
	}
	
	public BankMaster(String name,double balance) {
		this.setName(name);
		this.setBalance(balance);
	}
	
	public BankMaster() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
