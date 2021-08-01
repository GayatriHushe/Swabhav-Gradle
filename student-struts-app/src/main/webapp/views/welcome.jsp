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
	<h1>Student's List:</h1>

	<table border="1">
		<tr>
			<th>Name</th>
			<th>RollNo</th>
			<th>CGPA</th>
		</tr>
		<s:iterator value="studentList">
			<tr>
				<td><s:property value="name"/></td>
				<td><s:property value="rollno" /></td>
				<td><s:property value="cgpa" /></td>
			</tr>
		</s:iterator>
	</table>



</body>
</html>