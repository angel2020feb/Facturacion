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
		<a href="index.jsp">Volver al index</a>
	</body>
</html>