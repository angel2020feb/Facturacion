<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Página de Error</title>
	</head>
	<body>
		<h1>Error</h1>
		<%= (String)request.getAttribute("mensajeError")%>	
		<br><br>
		<a href="index.jsp">Volver al index</a>
	</body>
</html>