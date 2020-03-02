<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar Pedido</title>
</head>
<body>
<jsp:useBean id="pedido" class="com.vipper.modelo.Pedido" scope="request"/>
<h1>Datos del Pedido</h1>
<ul>
	<li>Id: <%=pedido.getId_pedido() %></li>
	<li>Descripcion: <%=pedido.getDescrip()%></li>
</ul>

</body>
</html>