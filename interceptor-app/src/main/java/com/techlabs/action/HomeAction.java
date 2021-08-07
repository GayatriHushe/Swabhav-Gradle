package com.techlabs.action;

import com.opensymphony.xwork2.Action;

public class HomeAction implements Action {

		public String execute() throws Exception {
	        
	        System.out.println("HomeAction is called");
	        return SUCCESS;
	        
	 	}

	
}
