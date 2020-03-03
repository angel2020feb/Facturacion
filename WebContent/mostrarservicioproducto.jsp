<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Mostrar Servicio/Producto</title>
	</head>
	<body>
		<jsp:useBean id="servicioproducto" class="com.vipper.modelo.ServicioProducto" scope="request"/>
		<h1>Datos del Servicio/Producto</h1>
		<ul>
			<li>ID Servicio: <%=servicioproducto.getId_servicio() %></li>
			<li>Descripcion: <%=servicioproducto.getDescrip()%></li>
			<li>Coste: <%=servicioproducto.getCoste()%></li>
			<li>ID Cliente/Proveedor: <%=servicioproducto.getId()%></li>
			<li>IVA: <%=servicioproducto.getIva()%></li>
		</ul>	
		<br><br>
		<a href="servletlogin?op=1">Volver al menú</a>			
	</body>
</html>