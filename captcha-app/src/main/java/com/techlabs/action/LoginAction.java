package com.techlabs.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	
	private String userId, msg;
	private String captcha;
	private String pass;
	private String check;

	private String sessionCaptcha = (String) ServletActionContext.getRequest().getSession().getAttribute(CaptchaAction.CAPTCHA_KEY);

	@Override
	public String execute() throws Exception {
		
		if (sessionCaptcha.equals(check)) {
			if (userId.equals("gayatri") && pass.equals("gayatri")) {
				setMsg("Hello, " + userId + " You have successfully logedin.");
				System.out.println("success");
				return SUCCESS;
			} else {
				System.out.println("error");
				setMsg("Wrong user id or password");
				return ERROR;
			}
		} else {
			setMsg("You entered wrong captcha");
			return ERROR;
		}

	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCaptach() {
		return captcha;
	}

	public void setCaptach(String captcha) {
		this.captcha = captcha;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass=pass;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId=userId;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}
	
}
