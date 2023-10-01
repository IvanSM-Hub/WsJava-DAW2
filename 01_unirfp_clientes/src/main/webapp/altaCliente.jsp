<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<h1>Aplicación Cliente: ALta Cliente</h1>
	<form action="cliente?opcion=altaCliente" method="post">
		<p>Nombre: <input type="text" name="nombre"/></p>
		<p>Numero Empleados: <input type="text" name="cantidadEmpleados"/></p>
		<p>Facturación Anual: <input type="text" name="facturacionAnual"/></p>
		<p><input type="submit" value="Enviar"/></p>
	</form>
</body>
</html>