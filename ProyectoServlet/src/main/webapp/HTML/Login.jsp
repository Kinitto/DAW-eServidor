<!DOCTYPE html>
<html>
<link rel="stylesheet" href="style.css">
<body>
	<div class="login">
		<form action="/ProyectoServlet/servletLogin" method="post">
			<header class="errorLogin">Inicio de sesion</header>
			<p>
				<input type="text" name="usuario" id="username"
					placeholder="Usuario">
			</p>
			<p>
				<input type="password" name="passwd" placeholder="Contraseña">
			</p>
			<input type="submit" value="Login" />
		</form>
	</div>
	<div class="error">
		<%
		if (session.getAttribute("errorLogin") == "true") {
		%>
		<p>Error al logearse, intentelo de nuevo.</p>
		<%
		}
		%>
	</div>
</body>
</html>