package com.techlabs.actions;

import java.time.LocalDateTime;
import java.util.Calendar;

import com.opensymphony.xwork2.Action;

public class BrowseAction implements Action {

	private String msg;
	private LocalDateTime time=LocalDateTime.now();
		
	public LocalDateTime getTime() {
		return time;
	}
	
	public String getMsg() {
		Calendar c = Calendar.getInstance();
	    
	    int hour = c.get(Calendar.HOUR_OF_DAY);
	    
	    if(hour >= 0 && hour <=12){
	   	 msg="Good morning";
	    }
	    else if(hour >=12 && hour <= 17){
	    	msg="Good afternoon";
	    }
	    else if(hour >=17 && hour <=20){
	    	msg="Good evening";
	    }
	    else if(hour >= 21 && hour <=24){
	    	msg="Good night";
	    }
		return msg;
	}
	
	@Override
	public String execute() throws Exception {
		return this.SUCCESS;
	}

}
