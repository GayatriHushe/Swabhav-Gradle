<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>
	<s:form action="welcome">
		<s:textfield name="name" label="name"/>
		<s:hidden name="operation"  value="post"/>
		<s:password name="password" label="Password" />
		<s:submit />
	</s:form>
</body>
</html>