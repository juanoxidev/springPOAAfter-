<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- linkeo de css al .jsp -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/estilos.css" />
</head>
<body>
	<table>
		<tr>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Email</th>
			<th>Acciones</th>

		</tr>

		<c:forEach var="clienteTemp" items="${clientes}">

			<!-- El valor de linkActualizar esta compuesto por la url + el parametro que corresponde al clienteID a la hora de clickear sobre el boton -->
			<c:url var="linkActualizar"
				value="/cliente/muestraFormularioActualizar">
				<!-- Al pulsar en modificar le tenemos que pasar el id del cliente que queremos modificar-->
				<c:param name="clienteId" value="${clienteTemp.id}" />
			</c:url>

			<!-- Link para eliminar -->
			<c:url var="linkEliminar"
				value="/cliente/eliminar">
				<!-- Al pulsar en eliminar le tenemos que pasar el id del cliente-->
				<c:param name="clienteId" value="${clienteTemp.id}" />
			</c:url>
			<tr>
				<td>${clienteTemp.nombre}</td>
				<td>${clienteTemp.apellido}</td>
				<td>${clienteTemp.email}</td>
				<td><a href="${linkActualizar}"><input type="button"
						value="Modificar" /></a> <a href="${linkEliminar}"><input
						type="button" value="Eliminar" onclick="if(!(confirm('Vas a eliminar un registro. Estas seguro?'))) return false" /></a></td>

			</tr>
		</c:forEach>

	</table>
	<br />
	<input type="button" value="Agregar Cliente"
		onclick="window.location.href='muestraFormularioAgregar'; return false;">
</body>
</html>