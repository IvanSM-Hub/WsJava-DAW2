<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<ul>
			<li>ID Cliente: ${cliente.idCliente}</li>
			<li>Nombre: ${cliente.nombre}</li>
			<li>Empleados: ${cliente.cantidadEmpleados}</li>
			<li>Facturación: ${cliente.facturacionAnual}</li>
		</ul>
		<a href="cliente?opcion=todos">Volver</a>
	</body>
</html>