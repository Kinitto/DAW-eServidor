<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="style.css">
<body>
	  <div class="login">
	<form action="/ProyectoServlet/servletLogin" method="post">
        <header>Inicio de sesion</header>
		<p>
			 <input type="text" name="usuario" id="username" placeholder="Usuario">
		</p>
		<p>
			 <input type="password" name="passwd" placeholder="Contraseņa">
		</p>
		<input type="submit" value="Login" />
	</form>
</div>
	<%
			if (session.getAttribute("errorLogin") == "true" ){
			%>
			<p>Error al logearse, intentelo de nuevo.</p>
			<%
			}
			%>
</body>
</html>