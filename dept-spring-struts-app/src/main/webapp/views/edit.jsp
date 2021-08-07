<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
</head>
<body bgcolor="pink">
<h1>Edit Department Details</h1>
	<s:form action = 'doEdit' method="POST">
		<s:textfield name = 'department.deptno'  label = 'deptno'/>
		<s:textfield name = 'department.dname' label = 'dname'/>
		<s:textfield name = 'department.location' label = 'location'/>
		<s:submit value="edit" action="doEdit"/>
	</s:form>
	<p><s:property value= "error" /></p>
</body>
</html>