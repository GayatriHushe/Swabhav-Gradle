<%@page import="com.techlab.services.CustomerService"%>
<%@page import="com.techlab.services.IService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body style="background-color: pink">
	<nav class="navbar navbar-default" style="background-color: lightblue">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" >Bank Management</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="register">Register</a></li>
      <li><a href="passbook" <%session.setAttribute("operation", "passbook");%>>PassBook</a></li>
      <li><a href="transaction" <%session.setAttribute("operation", "transaction");%>>Transaction</a></li>
      <% 
        
      	String customer=(String)session.getAttribute("CustomerName");
      	if(customer==null)
      	{
      		 %>
      		<li><a href='login' <%session.setAttribute("operation", "home");%>>Login</a></li>
      		<%
      	}
      	else
      	{
      		 %>
      		<li><a href='logout' <%session.setAttribute("operation", "home");%>>Logout</a></li>
      		<%
      	}
      %>
    </ul>
   
    
    
  </div>
</nav>
<h1 align="center">Welcome to Home Page</h1>

 <%
    String name=(String)session.getAttribute("accountHolderName");
    IService service=new CustomerService();
    
    
      if(session.getAttribute("accountHolderName")!=null){     
      %>
      <h3>Account Holder Name : <%=name %></h3>
      <h3>Account Balance : <%=session.getAttribute("accountBalance") %></h3>
      <% }
    %>
</body>
</html>