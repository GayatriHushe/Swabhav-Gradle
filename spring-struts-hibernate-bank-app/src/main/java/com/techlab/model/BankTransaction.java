package com.techlab.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BankTransaction {
	
	@Id
	private String id;
	private String name;
	private double amount;
	private String type;

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = UUID.randomUUID().toString();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setType(String type) {
		this.type = type;
	}

	//	public BankTransaction(String name, double amount, String type) {
	//		this.name = name;
	//		this.amount = amount;
	//		this.type = type;
	//	}

	public String getName() {
		return name;
	}

	public double getAmount() {
		return amount;
	}

	public String getType() {
		return type;
	}

//	public BankMaster getBankMaster() {
//		return bankMaster;
//	}
//
//	public void setBankMaster(BankMaster bankMaster) {
//		this.bankMaster = bankMaster;
//	}
	
}
