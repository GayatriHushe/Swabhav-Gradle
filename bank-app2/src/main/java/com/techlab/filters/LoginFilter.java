package com.techlab.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns= {"/transaction","/passbook"})
public class LoginFilter implements Filter {

    public LoginFilter() {

    }

	public void destroy() {

	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		HttpSession session=req.getSession();
		Object customer=session.getAttribute("CustomerName");
		System.out.println("Operation : "+session.getAttribute("operation"));
		System.out.println("Customer name : "+customer);
		if(customer==null) {
			res.sendRedirect("login");
			
//			RequestDispatcher view = request.getRequestDispatcher("login.jsp");
//			view.forward(request, response);
		}
		else {
			chain.doFilter(req, res);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
