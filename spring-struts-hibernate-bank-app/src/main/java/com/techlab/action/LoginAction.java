package com.techlab.action;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlab.model.Customer;
import com.techlab.repository.CustomerRepository;


public class LoginAction  implements Action{

	@Autowired
	private CustomerRepository customerRepository;
	private Customer customer;
	
	private static final String PASSBOOK = null;
	private static final String TRANSACTION = null;
	
	private String username;
	private String password;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
	}

	public String addd() {
		HttpSession session=ServletActionContext.getRequest().getSession();

		username=customer.getUsername();
		password=customer.getPassword();

		Customer customer1=new Customer(username, password);
		System.out.println(customer1);
		session.setAttribute("Customer", customer1);
		session.setAttribute("CustomerName", username);
		try {
			boolean isValidCustomer=customerRepository.isCustomer(customer1);
			if(isValidCustomer)
			{
				System.out.println(customer1+" is a valid customer");
				session.setAttribute("accountHolderName", username);
				double accountBal=customerRepository.getAccountBalance(username);
				session.setAttribute("accountBalance", accountBal);//first time set
				String op = (String) session.getAttribute("operation");
				System.out.println("Operation : " + op);
//				if (op != null)
//				{
//					if(op.equals("passbook"))
//						return "passbook";
//					else
//						return "transaction";
//				}
//				response.sendRedirect("home");
				return SUCCESS;
			}
			else
			{
				System.out.println(customer1+" is not a valid customer");
				return ERROR;
//				response.sendRedirect("login");
			}
		} catch (SQLException e) {
			System.out.println("Exception from LoginAction : ");

			e.printStackTrace();
			return ERROR;
		}

	}
}
