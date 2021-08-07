package com.techlab.action;

import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlab.model.BankMaster;
import com.techlab.model.BankTransaction;
import com.techlab.services.CustomerService;
import com.techlab.services.IService;

public class TransactionAction implements Action {
	
	@Autowired
	private CustomerService service;
	private BankTransaction transaction;
	
	public TransactionAction()
	{
		System.out.println("Txn action");
	}
	
	public BankTransaction getTransaction() {
		return transaction;
	}


	public void setTransaction(BankTransaction transaction) {
		this.transaction = transaction;
	}


	@Override
	public String execute() throws Exception 
	{
		HttpSession session=ServletActionContext.getRequest().getSession();
		if(session.getAttribute("CustomerName")!=null)
			return SUCCESS;
		else
			return ERROR;
	}

	
	public String doTransaction() throws Exception
	{
		System.out.println("doTxn");
//		try
//		{
			System.out.println(transaction.getAmount());
			String type=transaction.getType();
			System.out.println("Selected Type : "+type);
			double amount=transaction.getAmount();
			HttpSession session=ServletActionContext.getRequest().getSession();
			String name=(String) session.getAttribute("CustomerName");
			
			if(type.equals("D")) {
				BankTransaction txn = new BankTransaction();
				txn.setId(UUID.randomUUID().toString());
				txn.setName(name);
				txn.setType("D");
				txn.setAmount(amount);
				service.insertBankTransaction(txn);
				service.updateBankMasterOnDeposit(new BankMaster(name,amount));
			}
			else {
				BankTransaction txn = new BankTransaction();
				txn.setName(name);
				txn.setType("W");
				txn.setAmount(amount);
				service.insertBankTransaction(txn);
				service.updateBankMasterOnWithdraw(new BankMaster(name,amount));
			}
			try {
				System.out.println("setBalance");
				session.setAttribute("accountBalance", service.getAccountBalance(name)); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("bal from transaction : "+session.getAttribute("accountBalance"));
			return SUCCESS;
//		}
//		catch(Exception e)
//		{
//			return ERROR;
//		}
		
	}
}
