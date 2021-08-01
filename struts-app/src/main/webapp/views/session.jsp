<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Session Page</title>
</head>
<body>
<h1>Welcome to Session Page</h1>
	<s:set var="varOld" value="oldCount"/>
	<p>Old counter : <s:property value="varOld"/></p>
	<p>New counter : <s:property value="%{#session.Counter}"/></p>
	
</body>
</html>