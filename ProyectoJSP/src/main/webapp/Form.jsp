<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<title>Formulario</title>
</head>
<body>
	<form action=result.jsp method=POST>
		Nombre del Alumno<input type="text" name="nombre"/>
		<p>
			Matemáticas: <input type="number" name="matematicas"/>
		</p>
		<p>
			Ingles<input type="number" name="ingles"/>
		</p>
		<p>
			Ciencias<input type="number" name="ciencias"/>
		<p>
			¿Solicitó beca?<input type="checkbox" name="beca"></input>
		</p>
		<p>
			<button type="submit" value="Enviar">Enviar</button>
		</p>
	</form>
</body>
</html>