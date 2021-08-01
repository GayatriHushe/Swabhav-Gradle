<%@page import="com.techlab.model.BankTransaction"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
		<%
			List<BankTransaction> transactions = (List<BankTransaction>) request.getAttribute("Transactions");
		int count = transactions.size();
		%>

		<h2>Bank Statements</h2>

		<h3>
			Total no of Transactions :
			<%=count%></h3>

		<table class="table table-condensed">
			<thead>
				<tr>
					<th>Name</th>
					<th>Amount</th>
					<th>Type</th>
				</tr>
			</thead>

			<tbody>
				<%
					for (BankTransaction transaction : transactions) {
				%>
				<tr>
					<td><%=transaction.getName()%></td>
					<td><%=transaction.getAmount()%></td>
					<td><%=transaction.getType()%></td>
				</tr>
				<%
					}
				%>
			</tbody>

		</table>
		<a href = 'export'><button  class="btn btn-info">Export to Csv File</button></a>
	</div>

	<script>
	
		function downloadCSV(csv, filename) {
			var csvFile;
			var downloadLink;
			
			csvFile = new Blob([ csv ], { type : "text/csv" });
			downloadLink = document.createElement("a");
			downloadLink.download = filename;
			downloadLink.href = window.URL.createObjectURL(csvFile);
			downloadLink.style.display = "none";
			document.body.appendChild(downloadLink);
			downloadLink.click();
		}
		function exportTableToCSV(filename) {
			var csv = [];
			var rows = document.querySelectorAll("table tr");

			for (var i = 0; i < rows.length; i++) {
				var row = [], cols = rows[i].querySelectorAll("td, th");

				for (var j = 0; j < cols.length; j++)
					row.push(cols[j].innerText);

				csv.push(row.join(","));
			}

			downloadCSV(csv.join("\n"), filename);
		}
	</script>
</body>
</html>