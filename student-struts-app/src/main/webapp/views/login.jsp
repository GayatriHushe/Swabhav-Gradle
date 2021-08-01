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
	
	<h1>Add Student To List</h1>
	<s:form action="addToList">
		<s:textfield name="student.name" label="name" />
		<s:textfield name="student.rollno" label="rollno" />
		<s:textfield name="student.cgpa" label="cgpa" />
		<s:submit value="Add Student" label="Add Student"/>
	</s:form>
	
</body>
</html>