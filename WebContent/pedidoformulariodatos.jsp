<%@page import="com.vipper.modelo.Pedido"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Formulario de datos</title>
	</head>
	<body>
		<h1>Rellene el siguiente formulario para realizar el pedido</h1>
		
		<% Pedido jPedido = (Pedido)session.getAttribute("miPedido"); %>
		
		<form action = "servletpedidos?op=3" method = "post">
            Descripcion pedido: <input type = "text" name = "descripcion"/>
            <br>
            Forma de pago: <input type = "text" name = "formapago"/>
            <br>
            <input type = "submit" value = "Enviar informacion"/>
        </form>
		
	</body>
</html>