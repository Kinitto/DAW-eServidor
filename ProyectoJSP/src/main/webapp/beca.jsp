<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ page import="java.text.*,java.util.*"%>

<!DOCTYPE html>

<html>
<head>
  <link rel="stylesheet" href="style.css">

<title>Beca</title>
</head>

<body>
	<jsp:useBean id="matricula"
		class="es.jacaranda.proyectoJSP.MatriculaBean" scope="session" />
	<jsp:setProperty name="matricula" property="*" />

<div>
	<p>
	<strong>
		Alumno:
		<jsp:getProperty name="matricula" property="nombre" />
		</strong>
	</p>
	<p>
		
		<jsp:getProperty name="matricula" property="beca" />
	</p>
	<p>
	<a href="result.jsp">Volver a Informe</a>
	</p>


		<%DateFormat fmtdia = new SimpleDateFormat("dd/MM/yyyy");
	String dia = fmtdia.format(new Date());
	DateFormat fmthora = new SimpleDateFormat("hh:mm:ss");
	String hora = fmthora.format(new Date());%>
		<p class="hora">
			Registrado el <%=dia%> a las
			<%=hora%>
		</p>
		</div>
</body>
</html>