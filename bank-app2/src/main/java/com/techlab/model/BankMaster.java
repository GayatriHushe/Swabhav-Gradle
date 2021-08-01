package com.techlab.model;

public class BankMaster {
	private String name;
	private double balance;
	private String password;
	
	public BankMaster(String name,double balance,String password) {
		this.name=name;
		this.balance=balance;
		this.password=password;
	}
	
	public BankMaster(String name,double balance) {
		this.name=name;
		this.balance=balance;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}

	public String getPassword() {
		return password;
	}
}
