package com.techlab.model;

public class BankTransaction {
	private String name;
	private double amount;
	private String type;
	private String tr_date;
	
	public BankTransaction(String name, double amount, String type, String tr_date) {
		this.name = name;
		this.amount = amount;
		this.type = type;
		this.tr_date=tr_date;
	}
	
	public BankTransaction(String name, double amount, String type) {
		this.name = name;
		this.amount = amount;
		this.type = type;
	}
	
	
	public String getName() {
		return name;
	}

	public double getAmount() {
		return amount;
	}

	public String getType() {
		return type;
	}

	public String getTr_date() {
		return tr_date;
	}
	
	
}
