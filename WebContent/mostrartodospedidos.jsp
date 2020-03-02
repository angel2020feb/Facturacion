<%@page import="com.vipper.modelo.Pedido"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="estilos/estilos.css">
		<title>Mostrar Todos Pedidos</title>
	</head>
	<body>
		<p>Todos los pedidos son:</p>
		<!-- Usar un scriplet para recoger todos los productos del ámbito request -->
		<!-- En este caso request es una palabra reservada -->
		<% ArrayList<Pedido> jPedidos = (ArrayList<Pedido>)request.getAttribute("requestTodosPedidos"); %>
		
		<table>
			<tr>
				<th>ID Pedido</th>
				<th>Descripcion</th>
				<th>ID (Cliente/Proveedor)</th>
				<th>ID Forma de pago</th>
				<th>Total</th>
				<th>Fecha</th>	
				<th>ID Servicio</th>	
				<th>ID Contrato</th>	
				<th>Importe Facturado</th>			
			</tr>
		<% for(Pedido p : jPedidos){%>
			<tr>
				<td><%=p.getId_pedido()%></td>
				<td><%=p.getDescrip()%></td>
				<td><%=p.getId()%></td>
				<td><%=p.getId_forma_pago()%></td>
				<td><%=p.getTotal()%></td>
				<td><%=p.getFecha()%></td>
				<td><%=p.getId_servicio()%></td>
				<td><%=p.getId_contrato()%></td>
				<td><%=p.getImporte_facturado()%></td>			
			</tr>		
		<%}%>
		
		</table>
		
		<br><br>
		<a href="index.jsp">Volver al index</a>
	</body>
</html>