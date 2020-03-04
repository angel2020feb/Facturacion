<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Mostrar Usuario</title>
	</head>
	<body>
		<jsp:useBean id="Usuario" class="com.vipper.modelo.Usuario" scope="request"/>
		<h1>Datos del Usuario</h1>
		<ul>
			<li>Id: <%=Usuario.getIdUsuario() %></li>
			<li>Nombre: <%=Usuario.getNomUsuario()%></li>
			<li>Password: <%=Usuario.getPassword()%></li>
			<li>Tipo usuario: <%=Usuario.getTipoUsuario()%></li>					
		</ul>
		<br><br>
		<a href="servletlogin?op=1">Volver al menú</a>		
	</body>
</html>