<%@page import="com.vipper.modelo.ServicioProducto"%>
<%@page import="com.vipper.modelo.Pedido"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="estilos/estilos.css">
		<title>Mostrar Todos Servicios/Productos</title>
	</head>
	<body>
		<p>Todos los Servicios/Productos son:</p>
		<!-- Usar un scriplet para recoger todos los productos del ámbito request -->
		<!-- En este caso request es una palabra reservada -->
		<% ArrayList<ServicioProducto> jServiciosProductos = (ArrayList<ServicioProducto>)request.getAttribute("requestTodosServiciosProductos"); %>
		
		<table>
			<tr>
				<th>ID Servicio</th>
				<th>Descripcion</th>
				<th>Coste</th>
				<th>ID Proveedor</th>	
				<th>IVA</th>		
			</tr>
		<% for(ServicioProducto e : jServiciosProductos){%>
			<tr>
				<td><%=e.getId_servicio()%></td>	
				<td><%=e.getDescrip()%></td>	
				<td><%=e.getCoste()%></td>	
				<td><%=e.getId()%></td>	
				<td><%=e.getIva()%></td>	
			</tr>		
		<%}%>
		
		</table>
		
		<br><br>
		<a href="servletlogin?op=1">Volver al menú</a>
	</body>
</html>