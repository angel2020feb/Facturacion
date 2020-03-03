<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Mostrar Cliente/Proveedor</title>
	</head>
	<body>
		<jsp:useBean id="clienteproveedor" class="com.vipper.modelo.ClienteProveedor" scope="request"/>
		<h1>Datos del Cliente/Proveedor</h1>
		<ul>
			<li>Id: <%=clienteproveedor.getId() %></li>
			<li>NIF: <%=clienteproveedor.getNIF()%></li>
		</ul>
		<br><br>
		<a href="servletlogin?op=1">Volver al menú</a>		
	</body>
</html>