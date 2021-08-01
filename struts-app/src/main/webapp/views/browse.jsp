<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ page import ="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Browse Page</title>
</head>
<body>
<h1>Welcome to Browse Page</h1>
<s:set var="varMsg" value="msg"/>
<p><s:property value="varMsg"/></p>
<br>
<s:set var="varTime" value="time"/>
<p><s:property value="vartime"/></p>
	
</body>
</html>