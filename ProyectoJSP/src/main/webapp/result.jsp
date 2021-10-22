<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.*,java.util.*" session="false"%>

<!DOCTYPE html>

<html>
<head>
<title>Principal</title>
</head>

<body>
	<jsp:useBean id="matricula" class="es.jacaranda.proyectoJSP.MatriculaBean"/>
	<jsp:setProperty name="matricula" property="*" />

	<p>
		Nombre del alumno:
		<jsp:getProperty name="matricula" property="nombre" />
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




	<%!DateFormat fmtdia = new SimpleDateFormat("dd/MM/yyyy");
	String dia = fmtdia.format(new Date());
	DateFormat fmthora = new SimpleDateFormat("hh:mm:ss");
	String hora = fmthora.format(new Date());%>
	<p>
		Registrado el
		<%=dia%>
		a las
		<%=hora%>
	</p>


</body>
</html>
