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

		List<Producto> listado;
		HttpSession sesion = request.getSession();

		// recuperar carrito si existe y si no lo creamos y lo guardamos en la sesion
		if (sesion.getAttribute("carrito") != null) {
			listado = (List<Producto>) sesion.getAttribute("carrito");
		} else {
			listado = new ArrayList<>();
			sesion.setAttribute("carrito", listado);

		}

		String producto = "Camiseta";
		String cantidad = request.getParameter("cantidad");
		int precio = 15;
		
		String producto2 = "Pantalon";
		String cantidad2 = request.getParameter("cantidadp2");
		int precio2 = 25;
		
		String producto3 = "Abrigo";
		String cantidad3 = request.getParameter("cantidadp3");
		int precio3 = 65;
		
		
		Producto p = new Producto(producto, cantidad, precio);
		Producto p2 = new Producto(producto2, cantidad2, precio2);
		Producto p3 = new Producto(producto3, cantidad3, precio3);

		listado.add(p);
		listado.add(p2);
		listado.add(p3);



		response.sendRedirect("/ProyectoServlet/servletCarrito");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}