package com.techlab.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BankMaster {
	
	@Id
	private String name;
	private double balance;
	private String password;
	
	@OneToMany(mappedBy="name", cascade = CascadeType.ALL)
	private Set<BankTransaction> bankTransactions;
	
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

	public Set<BankTransaction> getBankTransactions() {
		return bankTransactions;
	}

	public void setBankTransactions(Set<BankTransaction> bankTransactions) {
		this.bankTransactions = bankTransactions;
	}

	
	
}
