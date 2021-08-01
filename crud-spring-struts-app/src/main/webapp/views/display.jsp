<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<style>
table, td, th {
	border: 1px solid black;
}


</style>
</head>
<body bgcolor="pink">
	<h1>Display Page</h1>
	<a href="addStudent">
		<button class="button-update">Add Student</button>
	</a>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Roll No</th>
			<th>CGPA</th>
			<th>Location</th>
			<th>Action</th>
		</tr>
		<s:iterator value="studentList">
			<tr>

				<td><s:property value="name" /></td>
				<td><s:property value="rollNo" /></td>
				<td><s:property value="cgpa" /></td>
				<td><s:property value="location" /></td>
				<td><a href="updateStudent?&id=<s:property value="id"/>">
						<button class="button-update">Edit</button>
				</a> <a type='button'
					onclick="return confirm('Do you want to delete ?'); "
					href="deleteStudent?id=<s:property value="id"/>">
						<button class="button-delete">Delete</button>
				</a></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>