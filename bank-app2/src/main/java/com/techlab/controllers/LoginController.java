package com.techlab.controllers;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techlab.model.Customer;
import com.techlab.repository.CustomerRepository;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("login.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	

		String name =request.getParameter("customerName");
		String password =request.getParameter("customerPassword");
		
		Customer customer=new Customer(name, password);
		System.out.println(customer);
		session.setAttribute("Customer", customer);
		session.setAttribute("CustomerName", name);
		try {
			CustomerRepository customerRepository=new CustomerRepository();
			boolean isValidCustomer=customerRepository.isCustomer(customer);
			if(isValidCustomer)
			{
				System.out.println(customer+" is a valid customer");
				session.setAttribute("accountHolderName", name);
				double accountBal=customerRepository.getAccountBalance(name);
				session.setAttribute("accountBalance", accountBal);//first time set
				Object op = session.getAttribute("operation");
				if (op != null)
				{
					response.sendRedirect(op.toString());
					return;
				}
				response.sendRedirect("home");
			}
			else
			{
				System.out.println(customer+" is not a valid customer");
				response.sendRedirect("login");
			}
		} catch (SQLException e) {
			System.out.println("Exception from LoginController : ");
			
			e.printStackTrace();
		}
	}

}
