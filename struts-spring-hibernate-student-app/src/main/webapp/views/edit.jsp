<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>
<h1>Edit</h1>
	<s:form action = 'doEdit' method="POST">
		<s:textfield name = 'student.id'  label = 'id'/>
		<s:textfield name = 'student.name' label = 'name'/>
		<s:textfield name = 'student.cgpa' label = 'cgpa'/>
		<s:submit value="edit" action="doEdit"/>
	</s:form>
	<p><s:property value= "error" /></p>
</body>
</html>