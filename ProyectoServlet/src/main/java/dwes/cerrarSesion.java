package dwes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "cerrarSesion", urlPatterns = "/cerrarSesion")
public class cerrarSesion extends HttpServlet {
	// Metodo para GET

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession sesion = request.getSession();
		
		if(sesion.isNew() || sesion.getAttribute("usuario") == null) {
			response.sendRedirect("/ProyectoServlet/HTML/Login.jsp");
		}

		else {
			sesion.invalidate();
			response.sendRedirect("/ProyectoServlet/HTML/Login.jsp");

		}


	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
