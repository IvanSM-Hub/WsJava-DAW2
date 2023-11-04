<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		@import url('https://fonts.googleapis.com/css2?family=Poppins&display=swap');
		*{font-family:Poppins;}
		th{padding:5px;}
	</style>
	</head>
	<body>
		<h1>App de Clientes</h1>
		<h3>mensajes: ${mensaje}</h3>
		<p><a href="cliente?opcion=altaCliente">Cliente Nuevo</a></p>
		<table border="2">
			<tr>
				<th>ID Cliente</th>
				<th>Nombre</th>
				<th>Ver Detalle</th>
				<th>Eliminar</th>
			</tr>
			<c:forEach items="${clientes}" var="cliente">
			<tr>
				<th>${cliente.idCliente}</th>
				<th>${cliente.nombre}</th>
				<th><a href="cliente?opcion=ver&idCliente=${cliente.idCliente}">Ver detalle</a></th>
				<th><a href="cliente?opcion=eliminar&idCliente=${cliente.idCliente}">Eliminar</a></th>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>