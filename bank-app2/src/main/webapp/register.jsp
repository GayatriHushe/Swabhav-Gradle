<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body style="background-color: pink">
	<div class="container">
		<h2>Register Page</h2>
		<form method="post">
			<div class="form-group">
				<label for="name">Name:</label> <input type="text"
					class="form-control" id="name" name="name">
			</div>
			<div class="form-group">
				<label for="balance">Balance:</label> <input type="text"
					class="form-control" id="balance" name="balance">
			</div>
			<div class="form-group">
				<label for="password1">Password:</label> <input
					type="password" class="form-control" id="password1" name="password1">
			</div>
			<div class="form-group">
				<label for="password2">Retype Password:</label> <input
					type="password" class="form-control" id="password2" name="password2">
			</div>
			<div class="form-group">

				<input type="submit" class="btn btn-info" value="Submit" id="submit">
			</div>
		</form>
	</div>
</body>
</html>