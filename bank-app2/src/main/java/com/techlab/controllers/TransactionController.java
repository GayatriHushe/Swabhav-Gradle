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

import com.techlab.model.BankMaster;
import com.techlab.model.BankTransaction;
import com.techlab.services.CustomerService;
import com.techlab.services.IService;

@WebServlet("/transaction")
public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TransactionController() {
        super();
        System.out.println("inside transaction controller");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("transaction.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double amount=Double.parseDouble(request.getParameter("transactionAmount"));
		String type=request.getParameter("type");
		HttpSession session=request.getSession();
		String name=(String) session.getAttribute("CustomerName");
		IService service;
		service = new CustomerService();
		if(type.equals("D")) {
			service.insertBankTransaction(new BankTransaction(name,amount,type));
			service.updateBankMasterOnDeposit(new BankMaster(name,amount));	
		}
		else {
			service.insertBankTransaction(new BankTransaction(name,amount,type));
			service.updateBankMasterOnWithdraw(new BankMaster(name,amount));
		}
		try {
			System.out.println("setBalance");
			session.setAttribute("accountBalance", service.getAccountBalance(name)); //this is giving me bal after first login
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("bal from transaction : "+session.getAttribute("accountBalance"));
		response.sendRedirect("home.jsp");
		
		
	}
}
