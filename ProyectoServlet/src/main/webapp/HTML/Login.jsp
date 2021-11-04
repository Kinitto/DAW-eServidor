<!DOCTYPE html>
<html>
<body>
	<form action="/ProyectoServlet/servletLogin" method="post">
		<p>
			Usuario <input type="text" name="usuario">
		</p>
		<p>
			Contraseña <input type="password" name="passwd">
		</p>
		<input type="submit" value="Login" />
	</form>
	<%
			if (session.getAttribute("errorLogin") == "true" ){
			%>
			<p>Error al logearse, intentelo de nuevo.</p>
			<%
			}
			%>
</body>
</html>