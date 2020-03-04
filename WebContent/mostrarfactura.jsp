<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Mostrar Factura</title>
	</head>
	<body>
	<jsp:useBean id="factura" class="com.vipper.modelo.Factura" scope="request"/>
	<h1>Datos de la factura</h1>
	<ul>
		<li>Id: <%=factura.getId() %></li>
		<li>Fecha: <%=factura.getFecha() %></li>
		<li>Concepto: <%=factura.getConcepto() %></li>
		<li>Id. Contrato: <%=factura.getId_contrato() %></li>
		<li>Id. Forma pago: <%=factura.getId_forma_pago() %></li>
		<li>Importe: <%=factura.getImporte() %></li>
	    <li>IVA: <%=factura.getIva() %></li>						
	</ul>
	
	<br><br>
		<a href="servletlogin?op=1">Volver al menú</a>
	</body>
</html>