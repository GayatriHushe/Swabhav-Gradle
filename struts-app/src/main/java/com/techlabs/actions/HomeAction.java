package com.techlabs.actions;


import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class HomeAction implements Action{
	String name = ServletActionContext.getRequest().getParameter("name");
	public String getName() {
		return name;
	}
	@Override
	public String execute() throws Exception {
		return this.SUCCESS;
	}

}
