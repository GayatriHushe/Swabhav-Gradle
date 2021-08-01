package com.techlab.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techlab.model.BankTransaction;
import com.techlab.services.CustomerService;
import com.techlab.services.IService;

@WebServlet("/passbook")
public class PassbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PassbookController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String name=(String) session.getAttribute("CustomerName");
		IService service=new CustomerService();
		List<BankTransaction> transactions=service.getTransactions(name);
		request.setAttribute("Transactions", transactions);
		session.setAttribute("transactions", transactions);
		System.out.println("Transaction : "+transactions);
		RequestDispatcher view = request.getRequestDispatcher("passbook.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
