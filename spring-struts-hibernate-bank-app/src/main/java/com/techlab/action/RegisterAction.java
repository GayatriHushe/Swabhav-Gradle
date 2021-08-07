package com.techlab.action;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlab.model.BankMaster;
import com.techlab.model.BankTransaction;
import com.techlab.services.CustomerService;
import com.techlab.services.IService;

public class RegisterAction implements Action {

	@Autowired
	private CustomerService service;
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
		System.out.println(bankMaster);
		service.insertBankMaster(bankMaster);
		
		BankTransaction txn=new BankTransaction();
		txn.setId(UUID.randomUUID().toString());
		txn.setName(name);
		txn.setAmount(balance);
		txn.setType("D");
		System.out.println(txn);
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
