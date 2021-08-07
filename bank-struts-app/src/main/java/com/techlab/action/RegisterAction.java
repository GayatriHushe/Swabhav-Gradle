package com.techlab.action;

import com.opensymphony.xwork2.Action;
import com.techlab.model.BankMaster;
import com.techlab.model.BankTransaction;
import com.techlab.services.CustomerService;
import com.techlab.services.IService;

public class RegisterAction implements Action {

	private BankMaster bankMaster;
	private String name;
	private double balance;
	private String password;
	
	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
	}
	
	public String add() {
		name=bankMaster.getName();
		balance=bankMaster.getBalance();
		password=bankMaster.getPassword();
		
		IService service=new CustomerService();
		service.insertBankMaster(new BankMaster(name, balance, password));
		
		BankTransaction txn=new BankTransaction();
		txn.setName(name);
		txn.setAmount(balance);
		txn.setType("D");
		service.insertBankTransaction(txn);
		return SUCCESS;
	}

	public BankMaster getBankMaster() {
		return bankMaster;
	}

	public void setBankMaster(BankMaster bankMaster) {
		this.bankMaster = bankMaster;
	}


	
	
	
}
