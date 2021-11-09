package dwes;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "login", urlPatterns = "/servletLogin")
public class Login extends HttpServlet {
	// Metodo para GET

	/**
	 * Creamos un hashMap y guardamos dentro 2 usuarios y sus respectivas contraseñas
	 * Comprobamos que el usuario y clave introducido coincide con uno de los que hemos puesto.
	 * Si escorrecto te envia al catalogo y guardamos en sesion el usuario
	 * y si es incorrecto te manda al login de nuevo con un error.
	 * @param request
	 * @param response
	 */
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// creamos hashMap para guardar los usuarios

		HashMap<String, String> userPass = new HashMap<String, String>();

		// añadimos clave valor
		userPass.put("user1", "Admin");
		userPass.put("claveuser1", "1234");
		userPass.put("user2", "Joaquin");
		userPass.put("claveuser2", "abcjoaquin123");

		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("passwd");
		// creamo una sesion
		HttpSession sesion = request.getSession();

		// si el usuario y clave coincide con user 1 o user 2

		if (usuario.equals(userPass.get("user1")) && clave.equals(userPass.get("claveuser1"))
				|| usuario.equals(userPass.get("user2")) && clave.equals(userPass.get("claveuser2"))) {

			sesion.setAttribute("usuario", request.getParameter("usuario"));
			response.sendRedirect("/ProyectoServlet/servletCatalogo");

		} else {
			sesion.setAttribute("errorLogin", "true");
			response.sendRedirect("/ProyectoServlet/HTML/Login.jsp");

		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}