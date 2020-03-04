<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Buscar</title>
	</head>
	<body>
	<h1>Página de Búsqueda</h1>
		<!-- Usando JavaBeans 
		Requisitos:
		1. Clase encapsulada.
		2. Implementa Serializable.
		3. Constructor vacío.
		-->
		
		<% if(request.getParameter("id_pedido") != null){%>
		<jsp:useBean id="pedido" scope="request" class="com.vipper.modelo.Pedido"/>
		<jsp:setProperty name="pedido" property="*"/>
		<jsp:forward page="servletfacturacion?op=2"/>
		<%}%>
	
		<% if(request.getParameter("id") != null){%>
		<jsp:useBean id="clienteproveedor" scope="request" class="com.vipper.modelo.ClienteProveedor"/>
		<jsp:setProperty name="clienteproveedor" property="*"/>
		<jsp:forward page="servletfacturacion?op=4"/>
		<%}%>
		
		<% if(request.getParameter("id_servicio") != null){%>
		<jsp:useBean id="servicioproducto" scope="request" class="com.vipper.modelo.ServicioProducto"/>
		<jsp:setProperty name="servicioproducto" property="*"/>
		<jsp:forward page="servletfacturacion?op=6"/>
		<%}%>
		
		<% if(request.getParameter("id_factura") != null){%>
		<jsp:useBean id="factura" scope="request" class="com.vipper.modelo.Factura"/>
		<jsp:setProperty name="factura" property="*"/>
		<jsp:forward page="servletfacturacion?op=8"/>
		<%}%>
		
		<form action="buscar.jsp" method="post">
			Buscar Pedido : <input type="text" name="id_pedido"/>
			<input type="submit" value="Buscar Pedido"/>
		</form>
		<br><br>
		
		<form action="buscar.jsp" method="post">
			Buscar Cliente/Proveedor : <input type="text" name="id"/>
			<input type="submit" value="Buscar Cliente/Proveedor"/>
		</form>
		<br><br>
		
		<form action="buscar.jsp" method="post">
			Buscar Servicio/Producto : <input type="text" name="id_servicio"/>
			<input type="submit" value="Buscar Servicio/Producto"/>
		</form>
		<br><br>
		
		<form action="buscar.jsp" method="post">
			Buscar Factura : <input type="text" name="id_factura"/>
			<input type="submit" value="Buscar Factura"/>
		</form>
		<br><br>
		
		<br><br>
		<a href="servletlogin?op=1">Volver al menú</a>
	</body>
</html>