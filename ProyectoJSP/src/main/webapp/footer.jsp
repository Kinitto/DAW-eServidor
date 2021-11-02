<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.*,java.util.*"%>

<!DOCTYPE html>
<html>
<body>
	<form action="beca.jsp" method="POST">
		<button type="submit" value="Becas">Informacion sobre beca</button>
	</form>
	<%DateFormat fmtdia = new SimpleDateFormat("dd/MM/yyyy");
	String dia = fmtdia.format(new Date());
	DateFormat fmthora = new SimpleDateFormat("hh:mm:ss");
	String hora = fmthora.format(new Date());%>
	<p class="hora">
		Registrado el
		<%=dia%>
		a las
		<%=hora%>

		<a id="volver" href="Form.jsp">Volver a Formulario</a>
	</p>
</body>
</html>