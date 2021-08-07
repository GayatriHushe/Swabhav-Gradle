<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body style="background-color: pink">
	<div class="container">
		<h2>Register Page</h2>
		<s:form action="add" method="POST">
			<s:textfield name="bankMaster.name" label="name"></s:textfield>
			<s:textfield name="bankMaster.balance" label="balance"></s:textfield>
			<s:textfield name="bankMaster.password" label="password"></s:textfield>
				
		<s:submit action="add"></s:submit> 
		</s:form>
	</div>
</body>
</html>