<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display</title>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
<h1>Display Page</h1>
<a href="form"><button>Add</button></a>
<table>
<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Cgpa</th>
	<th>Option</th>
</tr>

<s:iterator value="students">
<tr>
        <td><s:property value="id" /></td>
        <td><s:property value="name" /></td>
        <td><s:property value="cgpa" /></td>
        <td>
		<s:form action = 'edit'>
		<s:hidden name = 'id'  label = 'id'/>
		<s:hidden name = 'name' label = 'name'/>
		<s:hidden name = 'cgpa' label = 'cgpa'/>
		<s:submit value="edit"/>
		</s:form>
		</td>
		<td>
		<s:form action = 'delete'>
		<s:hidden name = 'id'  label = 'id'/>
		<s:hidden name = 'name' label = 'name'/>
		<s:hidden name = 'cgpa' label = 'cgpa'/>
		<a type='button'
					onclick="return confirm('Are you sure, you want to delete it?'); "
					>
						<button type='submit' action='delete' class="button-delete">Delete</button>
				</a>
			
		</s:form>	
		</td>	
</tr>
</s:iterator>

</table>
<s:property value="studentList"/>
</body>
</html>