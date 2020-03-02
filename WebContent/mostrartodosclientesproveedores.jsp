<%@page import="com.vipper.modelo.ClienteProveedor"%>
<%@page import="com.vipper.modelo.Pedido"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="estilos/estilos.css">
		<title>Mostrar Todos Clientes/Proveedores</title>
	</head>
	<body>
		<p>Todos los Clientes/Proveedores son:</p>
		<!-- Usar un scriplet para recoger todos los productos del ámbito request -->
		<!-- En este caso request es una palabra reservada -->
		<% ArrayList<ClienteProveedor> jClientesProveedores = (ArrayList<ClienteProveedor>)request.getAttribute("requestTodosClientesProveedores"); %>
		
		<table>
			<tr>
				<th>ID</th>
				<th>NIF</th>
				<th>Nombre</th>
				<th>Dirección</th>
				<th>Tipo</th>
				<th>Email</th>	
				<th>Telefono</th>		
			</tr>
		<% for(ClienteProveedor e : jClientesProveedores){%>
			<tr>
				<td><%=e.getId()%></td>	
				<td><%=e.getNIF()%></td>	
				<td><%=e.getNombre()%></td>	
				<td><%=e.getDireccion()%></td>	
				<td><%=e.getId()%></td>	
				<td><%=e.getEmail()%></td>	
				<td><%=e.getTelefono()%></td>	
			</tr>		
		<%}%>
		
		</table>
		
		<br><br>
		<a href="index.jsp">Volver al index</a>
	</body>
</html>