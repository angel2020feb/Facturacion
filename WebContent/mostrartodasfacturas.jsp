<%@page import="com.vipper.modelo.Factura"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="estilos/estilos.css">
		<title>Mostrar Todas facturas</title>
	</head>
	<body>
		<p>Todos los facturas son:</p>
		<!-- Usar un scriplet para recoger todos los productos del ámbito request -->
		<!-- En este caso request es una palabra reservada -->
		<% ArrayList<Factura> jFacturas = (ArrayList<Factura>)request.getAttribute("requestTodasFacturas"); %>
		
		<table>
			<tr>
				<th>ID Factura</th>
				<th>Fecha</th>
				<th>Concepto</th>
				<th>ID Contrato</th>				
				<th>ID Forma de pago</th>
				<th>Importe</th>
				<th>IVA</th>	
			</tr>
		<% for(Factura f : jFacturas){%>
			<tr>
				<td><%=f.getId()%></td>
				<td><%=f.getFecha()%></td>
				<td><%=f.getConcepto()%></td>
				<td><%=f.getId_contrato()%></td>
				<td><%=f.getId_forma_pago()%></td>
				<td><%=f.getImporte()%></td>
				<td><%=f.getIva()%></td>
			</tr>		
		<%}%>
		
		</table>
		
		<br><br>
		<a href="servletlogin?op=1">Volver al menú</a>			
	</body>
</html>