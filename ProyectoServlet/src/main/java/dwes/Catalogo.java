package dwes;

import java.io.IOException;
import java.io.PrintWriter;
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
	/**
	 * Comprueba que hay una sesion creada y crea el arraylist de objetos
	 * muestra por pantalla el html del catalogo.
	 * @param request
	 * @param response
	 */

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		List<Producto> listado;
		HttpSession sesion = request.getSession();
		
		if(sesion.isNew() || sesion.getAttribute("usuario") == null) {
			response.sendRedirect("/ProyectoServlet/HTML/Login.jsp");
		}

		// recuperar carrito si existe y si no lo creamos y lo guardamos en la sesion
		if (sesion.getAttribute("carrito") != null) {
			listado = (List<Producto>) sesion.getAttribute("carrito");
		} else {
			listado = new ArrayList<>();
			sesion.setAttribute("carrito", listado);

		}
		
		out.println("<!DOCTYPE html><html>"
				+ "<link rel=\"stylesheet\" href=\"/ProyectoServlet/HTML/style.css\">\n"
				+ "<body>\n"
				+ "<form action=\"/ProyectoServlet/servletCarrito\" method=\"post\">\n"
				+ "	<div class=\"section\">\n"
				+ "		<div class=\"cards\">\n"
				+ "			<div class=\"new-producto\">\n"
				+ "				<h1>Hooders.</h1>\n"
				+ "			</div>\n"
				+ "			<div class=\"card\">\n"
				+ "				<div class=\"image-section\">\n"
				+ "					<img src=\"/ProyectoServlet/HTML/camiseta.jpg\">\n"
				+ "				</div>\n"
				+ "				<div class=\"description\">\n"
				+ "					<h1>Camiseta</h1>\n"
				+ "					<p><b>Precio-</b><span>15$</span></p>\n"
				+ "				</div>\n"
				+ "				<div class=\"button-group\">\n"
				+ "					Cantidad: <input type=\"number\" name=\"cantidad\" class=\"cantidad\" value=\"0\">\n"
				+ "				</div>\n"
				+ "			</div>\n"
				+ "			<div class=\"card\">\n"
				+ "				<div class=\"image-section\">\n"
				+ "					<img src=\"/ProyectoServlet/HTML/pantalon.jpg\">\n"
				+ "				</div>\n"
				+ "				<div class=\"description\">\n"
				+ "					<h1>Pantalon</h1>\n"
				+ "					<p><b>Precio</b><span>25$</span></p>\n"
				+ "				</div>\n"
				+ "				<div class=\"button-group\">\n"
				+ "					Cantidad: <input type=\"number\" name=\"cantidadp2\" class=\"cantidad\" value=\"0\">\n"
				+ "				</div>\n"
				+ "			</div>\n"
				+ "			<div class=\"card\">\n"
				+ "				<div class=\"image-section\">\n"
				+ "					<img src=\"/ProyectoServlet/HTML/abrigo.jpg\">\n"
				+ "				</div>\n"
				+ "				<div class=\"description\">\n"
				+ "					<h1>Abrigo</h1>\n"
				+ "					<p><b>Precio</b><span>65$</span></p>\n"
				+ "				</div>\n"
				+ "				<div class=\"button-group\">\n"
				+ "					Cantidad: <input type=\"number\" name=\"cantidadp3\" class=\"cantidad\" value=\"0\">\n"
				+ "				</div>\n"
				+ "			</div>\n"
				+ "			\n"
				+ "		</div>\n"
				+ "		\n"
				+ "		\n"
				+ "		<input type=\"submit\" value=\"Ver pedido\" class=\"boton\">\n"
				+ "		\n"
				+ "	</div>\n"
				+ "	\n"
				+ "	</form>\n"
				+ "\n"
				+ "</body></html>");

		// declaramos los nombres de cada producto, precio y su request

		
		
		


	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}