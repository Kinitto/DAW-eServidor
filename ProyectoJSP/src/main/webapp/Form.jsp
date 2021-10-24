<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	
<!DOCTYPE html>
<head>
  <link rel="stylesheet" href="style.css">
<title>Formulario</title>
</head>
<body>
	<form action="result.jsp" method="POST" id="datosAlumno">
		Nombre del Alumno: <input type="text" name="nombre" />
		<p>
			Matemáticas: <input type="number" name="matematicas" />
		</p>
		<p>
			Ingles: <input type="number" name="ingles" />
		</p>
		<p>
			Ciencias: <input type="number" name="ciencias" />
		</p>

		<p>
			<button type="submit" value="Enviar" id="EnviarDatos">Enviar</button>
		</p>
	</form>
	
	<p id="contador"><%! private int Contador = 0; %>
        Número de accesos al formulario: <%= ++Contador %><p>
</body>
</html>