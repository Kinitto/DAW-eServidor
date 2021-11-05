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

@WebServlet(name = "verCarrito", urlPatterns = "/servletCarrito")
public class verCarrito extends HttpServlet {
	// Metodo para GET

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		HttpSession sesion = request.getSession();
		List<Producto> listado = (List<Producto>) sesion.getAttribute("carrito");
		out.println("Sr./a " + sesion.getAttribute("usuario"));
		if (listado == null) {
			out.println("<br/>Usted no ha añadido ningun producto!!!");

		} else {

			out.println("<br/><table border='1'>");
			out.println("<tr><th>Producto</th><th>Cantidad</th><th>Precio</th></tr>");
			for (int i = 0; i < listado.size(); i++) {
				out.println("<tr><td>" + listado.get(i).getProducto() + "</td>");
				out.println("<td>" + listado.get(i).getCantidad() + "</td>");
				out.println("<td>" + listado.get(i).getPrecio() + "</td></tr>");
				System.out.println(listado.size());
			}
			
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}