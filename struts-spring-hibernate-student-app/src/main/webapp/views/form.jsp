<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form</title>
</head>
<body>
<h1>Student Registration Form</h1>
<s:form action="add" method="POST">
	<s:textfield name="student.id" label="id"/>
	<s:textfield name="student.name" label="name"/>
	<s:textfield name="student.cgpa" label="cgpa"/>
	<s:submit action="add" type="submit"/>
</s:form>
</body>
</html>