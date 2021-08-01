package com.techlab.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.techlab.model.BankMaster;
import com.techlab.model.BankTransaction;
import com.techlab.services.CustomerService;
import com.techlab.services.IService;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("register.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		System.out.println(name);
		double balance=Double.parseDouble(request.getParameter("balance"));
		String password1=request.getParameter("password1");
		String password2=request.getParameter("password2");
		
		if(password1.equals(password2))
		{
			
				IService service=new CustomerService();
				service.insertBankMaster(new BankMaster(name, balance, password1));
				service.insertBankTransaction(new BankTransaction(name, balance, "D"));
				response.sendRedirect("home");
			
			
		}
		else
		{
			System.out.println("Please enter correct password");
			RequestDispatcher view = request.getRequestDispatcher("mismatchPassword.jsp");
			view.forward(request, response);
		}
	}

}
