package com.techlab.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.techlab.model.BankTransaction;
import com.techlab.services.CustomerService;
import com.techlab.services.IService;

public class PassbookAction implements Action {
	private List<BankTransaction> transactions;
	private BankTransaction BankTransaction;
	private int count;

	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public List<BankTransaction> getTransactions() {
		return transactions;
	}


	public void setTransactions(List<BankTransaction> transactions) {
		this.transactions = transactions;
	}


	@Override
	public String execute() throws Exception {
		HttpSession session=ServletActionContext.getRequest().getSession();
		System.out.println("session : "+session.getAttribute("CustomerName"));
		if(session.getAttribute("CustomerName")!=null)
			return SUCCESS;
		else
			return ERROR;
	}

	public String add() throws Exception {
		HttpSession session=ServletActionContext.getRequest().getSession();
		String name=(String) session.getAttribute("CustomerName");
		IService service=new CustomerService();
		transactions=service.getTransactions(name);
		count=transactions.size();
		session.setAttribute("transactions", transactions);
		System.out.println("Transaction : "+transactions);
		return SUCCESS;
	}

	public BankTransaction getBankTransaction() {
		return BankTransaction;
	}

	public void setBankTransaction(BankTransaction bankTransaction) {
		BankTransaction = bankTransaction;
	}

}
