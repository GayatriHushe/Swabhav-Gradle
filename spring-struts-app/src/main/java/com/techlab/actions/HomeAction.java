package com.techlab.actions;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.Action;
import com.techlabs.service.StudentService;


public class HomeAction implements Action {
	
	@Autowired
	private StudentService service;
	private int count;

	@Override
	public String execute() throws Exception {
		count=service.get().size();
		System.out.println(count);
		return SUCCESS;
	}

}
