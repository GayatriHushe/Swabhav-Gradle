<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction Page</title>
</head>
<body style="background-color: pink">
	<s:form action="doTransaction">
		<s:textfield name="transaction.amount" label="amount"></s:textfield>
		<s:radio list="{'D','W'}" values="{'D','W'}" name="transaction.type" multiple = 'false'></s:radio>
		<s:submit></s:submit> 
	</s:form>
</body>
</html>