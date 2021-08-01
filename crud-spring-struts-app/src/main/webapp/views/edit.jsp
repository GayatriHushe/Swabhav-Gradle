<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
</head>
<body bgcolor="pink">

	<h1>Edit Page</h1>
	<s:form action="doUpdateStudent">
		<s:hidden name="student.id" />
		<s:textfield name="student.name" label="name" />
		<s:textfield name="student.rollNo" label="rollno" />
		<s:textfield name="student.cgpa" label="cgpa" />
		<s:textfield name="student.location" label="cgpa" />
		<s:submit value="Update Student" label="Add Student" />
	</s:form>

</body>
</body>

</html>