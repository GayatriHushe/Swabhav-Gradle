package com.techlab.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class HomeAction implements Action {
	private String name;
	private double balance;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpSession session=ServletActionContext.getRequest().getSession();
		System.out.println(session.getAttribute("operation"));
		if(session.getAttribute("accountHolderName")!=null)
		{
			name=(String) session.getAttribute("accountHolderName");
			balance=(double) session.getAttribute("accountBalance");
		}
		return SUCCESS;
	}
	
	public String logout()
	{
		HttpSession session=ServletActionContext.getRequest().getSession();
		if(session!=null) {
			session.invalidate();
			System.out.println("Logged Out");
		}
		return SUCCESS;
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

	
}
