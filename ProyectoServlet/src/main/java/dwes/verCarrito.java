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
	
	/**
	 * recoge los datos de usuario y la lista por sesion y muestra informacion sobre el pedido
	 * pinta una tabla con los datos seleccionados anteriormente y guarda los datos de los pedidos realizados en sesion.
	 * por ultimo nos pinta un pequeÒo formulario para seleccionar la opcion de envio.
	 * 
	 * @param request
	 * @param response
	 */

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><link rel='stylesheet' href='/ProyectoServlet/HTML/style.css'><body>");
		
		//recuperamos la lista de la sesion
		HttpSession sesion = request.getSession();
		List<Producto> listado = (List<Producto>) sesion.getAttribute("carrito");

		//si no tiene sesion iniciada se le lleva al login
		
		if (sesion.isNew() || sesion.getAttribute("usuario") == null) {
			response.sendRedirect("/ProyectoServlet/HTML/Login.jsp");
		}

		else {
			//se pinta el html
			out.println("<p id=\"welcome\">Sr./a " + sesion.getAttribute("usuario") + ". Este es el resumen de su pedido</p>");
			out.println("<br/>Si des√©a modificar su pedido o no ha seleccionado ning√∫n producto, puedes.");
			out.println("<a href=\"servletCatalogo\">Volver a la tienda</a></br>");

			out.println("<br/><table border='1' id='tablaCarrito'>");
			out.println("<tr><th>Producto</th><th>Cantidad</th><th>Precio</th></tr>");

			
			//creamos los productos
			
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
			
			//aÒadimos los productos a la lista
			
			listado.add(p);
			listado.add(p2);
			listado.add(p3);

			
			//si la cantidad que hemos elegido es mayor de 0, se pinta nuestro producto en la tabla.
			//guardamos en sesion la informacion del producto.
			
			if (cantidad > 0) {
				out.println("<tr><td>" + producto + "</td>");
				out.println("<td>" + cantidad + "</td>");
				out.println("<td>" + precio + "$</td></tr>");

				sesion.setAttribute("producto", producto);
				sesion.setAttribute("cantidad", cantidad);
				sesion.setAttribute("precio", precio);
				double total1 = precio * cantidad;
				sesion.setAttribute("total1", total1);
			}

			if (cantidad2 > 0) {
				out.println("<tr><td>" + producto2 + "</td>");
				out.println("<td>" + cantidad2 + "</td>");
				out.println("<td>" + precio2 + "$</td></tr>");
				sesion.setAttribute("producto2", producto2);
				sesion.setAttribute("cantidad2", cantidad2);
				sesion.setAttribute("precio2", precio2);
				double total2 = precio2 * cantidad2;
				sesion.setAttribute("total2", total2);

			}

			if (cantidad3 > 0) {
				out.println("<tr><td>" + producto3 + "</td>");
				out.println("<td>" + cantidad3 + "</td>");
				out.println("<td>" + precio3 + "$</td></tr>");
				sesion.setAttribute("producto3", producto3);
				sesion.setAttribute("cantidad3", cantidad3);
				sesion.setAttribute("precio3", precio3);
				double total3 = precio3 * cantidad3;
				sesion.setAttribute("total3", total3);
			}

			out.println(" </table> ");
			//pintamos precio total
			double total = (precio * cantidad) + (precio2 * cantidad2) + (precio3 * cantidad3);
			sesion.setAttribute("total", total);
			if (total > 0) {
				out.println("</br>Total <b>sin IVA:</b> " + total + "$");
			}

			
			//form final con opciones de envio. cada una tiene un value de accion al hacer el submit
			if (cantidad >0 || cantidad2 >0 || cantidad3 > 0) {
				
				out.println("<form action=\"/ProyectoServlet/servletFactura\"> ");
				out.println(" <table border=\"0\"> ");
				out.println("<header><br/>Elige una opcion de envio.</header>");
				out.println(
						" <br/><tr><td><input type=\"radio\" name=\"accion\" value=\"domicilio\" checked>Envio a su domicilio. (2,50$)</td></tr> ");
				out.println(
						" <tr><td><input type=\"radio\" name=\"accion\" value=\"correo\">Envio a su oficina de correos mas cercana. (1,25$)</td></tr> ");
				out.println(
						" <tr><td><input type=\"radio\" name=\"accion\" value=\"tienda\">Recogida en una de nuestras tiendas. (Gratuito)</td></tr> ");
				out.println(" </table> ");
				out.println(" <input type=\"submit\" id=\"btnResumen\" value=\"Tramitar\"> ");
				out.println(" </form> ");
			}

			

		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}