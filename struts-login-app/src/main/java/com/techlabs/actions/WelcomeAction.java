package com.techlabs.actions;

import com.opensymphony.xwork2.Action;

public class WelcomeAction implements Action {
	private String name;
	private String password;
	private String operation = "get";

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(name);
		System.out.println(password);
		System.out.println(operation);
		return this.SUCCESS;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
}
