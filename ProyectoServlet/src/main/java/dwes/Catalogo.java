package dwes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "catalogo", urlPatterns = "/servletCatalogo")
public class Catalogo extends HttpServlet {
	// Metodo para GET

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();

		List<Producto> listado;
		listado = new ArrayList<>();
		
		String producto = request.getParameter("producto");
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		int precio = Integer.parseInt(request.getParameter("precio"));

		Producto p = new Producto(producto,cantidad,precio);

		listado.add(p);

		// recuperar carrito si existe y si no lo creamos y lo guardamos en la sesion
		if (sesion.getAttribute("carrito") != null) {
			listado = (List<Producto>) sesion.getAttribute("carrito");
		} else {

			sesion.setAttribute("carrito", listado);

		}

		response.sendRedirect("/ProyectoServlet/servletCarrito");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
