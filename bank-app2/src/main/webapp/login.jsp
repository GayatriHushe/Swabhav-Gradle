<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body style="background-color: pink">
	<div class="container">
  <h2>Login Page</h2>
  <form method="post">
    <div class="form-group">
      <label for="customerName">Name:</label>
      <input type="text" class="form-control" id="customerName" name="customerName">
    </div>
    <div class="form-group">
      <label for="customerPassword">Password:</label>
      <input type="password" class="form-control" id="customerPassword" name="customerPassword">
    </div>
        <div class="form-group">
      
      <input type="submit" class="btn btn-info" value="Submit" id="submit">
    </div>
  </form>
</div>
</body>
</html>