<!DOCTYPE html>
<html lang="es">
<link rel="stylesheet" href="style.css">
<title>Login</title>
<body>
	<div class="login">
		<form action="/ProyectoServlet/servletLogin" method="post">
			<header class="errorLogin">Inicio de sesion</header>
			<p>
				<input type="text" name="usuario" id="username"
					placeholder="Usuario">
			</p>
			<p>
				<input type="password" name="passwd" placeholder="Contrase�a">
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