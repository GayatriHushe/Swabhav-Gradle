<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body style="background-color: pink">
	<div class="container">
		<h2>Login Page</h2>
		<s:form action="addd" method="POST">
			<s:textfield name="customer.username" label="username"></s:textfield>
			<s:textfield name="customer.password" label="password"></s:textfield>
				
		<s:submit action="addd"></s:submit> 
		</s:form>
	</div>
</body>
</html>