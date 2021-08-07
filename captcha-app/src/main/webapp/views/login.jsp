<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Login Form</h1>
<s:form method="POST" action="login">
	<s:textfield name="userId" label="Id"></s:textfield>
	<s:textfield name="pass" label="Password"></s:textfield>
	
	<s:textfield name="check" label="Captcha Code"></s:textfield>
	<img id="capImg" src="loadCaptcha" /> <button type="button"	onclick="generateNewCaptcha();">Refresh</button>
	<s:submit action="login" value="Login"></s:submit>
</s:form>
<p>	<s:property value="msg" /> </p>
<script type="text/javascript">
	function generateNewCaptcha() {		
		document.getElementById("capImg").setAttribute("src", "");
		document.getElementById("capImg").setAttribute("src", "loadCaptcha?date="+new Date());
	}
</script>
</body>
</html>