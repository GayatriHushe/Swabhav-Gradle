<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<style>
table, td,tr{
  border: 1px solid black;
}
</style>
</head>
<body bgcolor="pink">
<h1>Department</h1>
<a href="form"><button>Add</button></a>
<table>
<tr>
  <th>Department No</th>
  <th>Department Name</th>
  <th>Location</th>
  <th>Action</th>
</tr>
<s:iterator value="departments">
<tr>
        <td><s:property value="deptno"/></td>
        <td><s:property value="dname"/></td>
        <td><s:property value="location"/></td>	
        <td>
		<s:form action = 'edit'>
		<s:hidden name = 'deptno'  label = 'deptno'/>
		<s:hidden name = 'dname' label = 'dname'/>
		<s:hidden name = 'location' label = 'location'/>
		<s:submit value="edit"/>
	</s:form>
		
				<a type='button'
					onclick="return confirm('Are you sure, you want to delete it?'); "
					href="delete?deptno=<s:property value="deptno"/>">
						<button class="button-delete">Delete</button>
				</a>
		</td>	
</tr>
</s:iterator>


</table>
</body>
</html>