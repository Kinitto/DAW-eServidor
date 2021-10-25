<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ page import="java.text.*,java.util.*"%>
<%@ page errorPage="error.jsp"%>

<!DOCTYPE html>

<html>
<head>
<link rel="stylesheet" href="style.css">

<title>Resultado</title>
</head>

<body>
	<jsp:useBean id="matricula"
		class="es.jacaranda.proyectoJSP.MatriculaBean" scope="session" />
	<jsp:setProperty name="matricula" property="*" />
	<h2>Informe de Alumnado</h2>
	<div>

		<p>
			Nombre del alumno:
			<jsp:getProperty name="matricula" property="nombre" />

			<%
			if (request.getParameter("nombre") == "") {
			%>
			<strong>No se ha enviado ningun nombre de alumno, revisa el
				formulario.</strong>
			<%
			}
			%>

		</p>

		<p>
			Nota final de matematicas:
			<jsp:getProperty name="matricula" property="matematicas" />
		</p>
		<p>
			Nota final de ingles:
			<jsp:getProperty name="matricula" property="ingles" />
		</p>
		<p>
			Nota final de ciencias:
			<jsp:getProperty name="matricula" property="ciencias" />
		</p>

		<p>
			<strong> Nota media: <jsp:getProperty name="matricula"
					property="media" />
			</strong>
		</p>

		<%@ include file="footer.jsp"%>

	</div>



</body>
</html>
