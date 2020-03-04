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
		<title>Realizar un nuevo pedido</title>
	</head>
	<body>
		<p>Seleccione un Servicio/Producto:</p>
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
				<th>----------</th>	
			</tr>
		<% for(ServicioProducto e : jServiciosProductos){%>
			<tr>
				<td><%=e.getId_servicio()%></td>	
				<td><%=e.getDescrip()%></td>	
				<td><%=e.getCoste()%></td>	
				<td><%=e.getId()%></td>	
				<td><%=e.getIva()%></td>
				<td>
					<a href="servletpedidos?op=2&id_servicio=<%=e.getId_servicio()%>"> 
					Seleccionar</a>
				</td>	

			</tr>		
		<%}%>
		
		</table>
		
		<br><br>
		<a href="servletlogin?op=1">Volver al menú</a>
	</body>
</html>