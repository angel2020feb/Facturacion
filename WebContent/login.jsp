<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
		<h1>Login</h1>
		
		<form action="servletlogin?op=2" method="post">
			User: <input type="text" name="user"/>
			<br><br>
			Password: <input type="text" name="password"/>
			<br><br>
			<input type="submit" value="Login"/>
		</form>
		<br><br>
		
		
	</body>
</html>