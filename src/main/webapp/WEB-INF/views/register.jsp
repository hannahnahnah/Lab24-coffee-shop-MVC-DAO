<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
<h3>Register here:</h3>
<form method="post" action="/register">
	<label><input type="text" name="name" required/>Enter your name:</label>
	<label><input type=email name="email" required/>Enter your email for user name:</label>
	<label><input type=password name="pw" required/> Create your password: </label>
	
	<label><button type=submit >Submit</button></label>
</form>

<a href="/" >Go Home.</a>
</body>
</html>