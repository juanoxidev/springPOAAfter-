<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix=form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/estilos.css" />
</head>
<body>

	<form:form action="insertarCliente" modelAttribute="cliente"
		method="POST">
		<!-- Cuando queremos hacer una modificacion el capo id se llena pero no se muestra, solo lo hace para cumpliir con la instruccion sql UPDATE.... WHERE ID =X -->
		<form:hidden path="id"/>

		<label name="nombre"> Nombre: </label>
		<form:input path="nombre" name="nombre" />

		<label name="apellido"> Apellido: </label>
		<form:input path="apellido" name="apellido" />

		<label name="email"> Email: </label>
		<form:input path="email" name="email" />

		<form:button type="submit" value="Cargar Cliente"></form:button>
	</form:form>

</body>

</html>