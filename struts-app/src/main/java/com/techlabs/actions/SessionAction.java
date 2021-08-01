package com.techlabs.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class SessionAction implements Action {

	private int oldCount;
	
	public int getOldCount()
	{
		return oldCount;
	}
	
	@Override
	public String execute() throws Exception {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		Integer newCount=(Integer)session.getAttribute("Counter");
		if(session.isNew())
		{
			oldCount=0;
			newCount=1;
		}
		else
		{
			oldCount=newCount;
			newCount+=1;
		}
		session.setAttribute("Counter", newCount);
		return this.SUCCESS;
	}

}
