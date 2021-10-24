<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ page import="java.text.*,java.util.*"%>

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

	<p><strong>
		Nota media:
		<jsp:getProperty name="matricula" property="media" />
		</strong>
	</p>
	
	
	<form action="beca.jsp" method="POST">
		<button type="submit" value="Becas">Informacion sobre beca</button>
		</form>
		
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
