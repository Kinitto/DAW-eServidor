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
		out.println("<html><link rel='stylesheet' href='/ProyectoServlet/HTML/style.css'><body>");
		HttpSession sesion = request.getSession();
		List<Producto> listado = (List<Producto>) sesion.getAttribute("carrito");

		if (sesion.getAttribute("usuario") == null) {
			out.println("<br/>No puede llegar hasta aqui sin iciar sesion.");
			out.println("<a href=\"/ProyectoServlet/HTML/Login.jsp\">Iniciar Sesi�n</a>");

		}

		else {

			out.println("Sr./a " + sesion.getAttribute("usuario") + ". Este es el resumen de su pedido");
			out.println("<br/><table border='1' id='tablaCarrito'>");
			out.println("<tr><th>Producto</th><th>Cantidad</th><th>Precio</th></tr>");
			out.println("<br/>Si desea añadir mas productos o no seleccionaste ninguno, puedes.");
			out.println("<a href=\"servletCatalogo\">Volver a la tienda</a>");

			String producto = "Camiseta";
			int cantidad = Integer.parseInt(request.getParameter("cantidad"));
			int precio = 15;

			String producto2 = "Pantalon";
			int cantidad2 = Integer.parseInt(request.getParameter("cantidadp2"));
			int precio2 = 25;

			String producto3 = "Abrigo";
			int cantidad3 = Integer.parseInt(request.getParameter("cantidadp3"));
			int precio3 = 65;

			Producto p = new Producto(producto, cantidad, precio);
			Producto p2 = new Producto(producto2, cantidad2, precio2);
			Producto p3 = new Producto(producto3, cantidad3, precio3);

			listado.add(p);
			listado.add(p2);
			listado.add(p3);

			for (int i = 0; i < listado.size(); i++) {

				if (listado.get(i).getCantidad() != 0) {
					out.println("<tr><td>" + listado.get(i).getProducto() + "</td>");
					out.println("<td>" + listado.get(i).getCantidad() + "</td>");
					out.println("<td>" + listado.get(i).getPrecio() + "</td></tr>");
					
					
				}
				
			}
			

			out.println("<form action=\"/ProyectoServlet/servletrespuesta\"> ");

			out.println(" <table border=\"0\"> ");
			out.println("<header><br/>Elige una opcion de envio.</header>");
			out.println(
					" <br/><tr><td><input type=\"radio\" name=\"accion\" value=\"primo\" selected>Envio a su domicilio.</td></tr> ");
			out.println(
					" <tr><td><input type=\"radio\" name=\"accion\" value=\"redirect\">Envio a su oficina de correos mas cercana.</td></tr> ");
			out.println(
					" <tr><td><input type=\"radio\" name=\"accion\" value=\"error\">Recogida en una de nuestras tiendas.</td></tr> ");
			out.println(" </table> ");
			out.println(" <input type=\"submit\" value=\"Enviar Datos\"> ");
			out.println(" </form> ");

		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}