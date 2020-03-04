<%@page import="com.vipper.modelo.Usuario"%>
<%@page import="com.vipper.modelo.Pedido"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="estilos/estilos.css">
		<title>Mostrar Todos Usuarios</title>
	</head>
	<body>
		<p>Todos los Usuarios son:</p>
		<!-- Usar un scriplet para recoger todos los productos del ámbito request -->
		<!-- En este caso request es una palabra reservada -->
		<% ArrayList<Usuario> jUsuarios = (ArrayList<Usuario>)request.getAttribute("requestTodosUsuarios"); %>
		
		<table>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Password</th>
				<th>Tipo de usuario</th>
			</tr>
		<% for(Usuario u : jUsuarios){%>
			<tr>
				<td><%=u.getIdUsuario()%></td>	
				<td><%=u.getNomUsuario()%></td>	
				<td><%=u.getPassword()%></td>	
				<td><%=u.getTipoUsuario()%></td>	
			</tr>		
		<%}%>
		
		</table>
		
		<br><br>
		<a href="servletlogin?op=1">Volver al menú</a>
	</body>
</html>