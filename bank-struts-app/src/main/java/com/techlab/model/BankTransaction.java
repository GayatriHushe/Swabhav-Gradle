package com.techlab.model;

public class BankTransaction {
	private String name;
	private double amount;
	private String type;



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


}
