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
	<h4>
		Your Name :
		<s:property value="name"/>
	</h4>
	<h4>
		Your Password :
		<s:property value="password" />
	</h4>
		<h4>
		Your Password :
		<s:property value="operation" />
	</h4>
</body>
</html>