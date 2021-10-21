<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<title>Principal</title>
</head>

<body>

	<h1>Matrícula:</h1>

	<%
                String nombre = request.getParameter("nombre");
                if(nombre!=null && nombre.length()>0){
                    out.println("Nombre del alumno: " + nombre);
                }else{
                    out.println("campo nombre inválido o vacío");
                }
                
        %>

	<ul>
		<li><p>
				<b>Matemáticas:</b>
				<%= request.getParameter("matematicas")%>
			</p></li>
		<li><p>
				<b>Física</b>
				<%= request.getParameter("fisica")%>
			</p></li>
		<li><p>
				<b>Literatura</b>
				<%= request.getParameter("literatura")%>
			</p></li>
	</ul>
	<%
   java.util.Date date = new java.util.Date();
   String fecha = date.toString();
	out.println("Registrado el "+fecha);
	
%>

</body>
</html>