package dwes;

import java.io.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/servletFactura")
public class Factura extends HttpServlet implements Runnable {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><link rel='stylesheet' href='/ProyectoServlet/HTML/style.css'><body>");
		HttpSession sesion = request.getSession();
		List<Producto> listado = (List<Producto>) sesion.getAttribute("carrito");

		if (sesion.isNew() || sesion.getAttribute("usuario") == null) {
			response.sendRedirect("/ProyectoServlet/HTML/Login.jsp");
		}

		else {
			String accion = request.getParameter("accion");

			if (accion.equals("domicilio")) {
			
				// Buscar el ultimo numero primo y enviarlo

				double iva = 0.21;
				double envio = 2.50;
				double total = (double) sesion.getAttribute("total");
				
				out.println ("<!DOCTYPE HTML><html>"
						+ "<head>\r\n"
						+ "    <link rel=\"stylesheet\" href=\"/ProyectoServlet/HTML/style.css\">\r\n"
						+ "    <meta charset=\"UTF-8\">\r\n"
						+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
						+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
						+ "    <title>Document</title>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "    <span class=\"titulo\">Factura Hooders</span>\r\n"
						+ "<p></p>\r\n"
						+ "<table>\r\n"
						+ "  <tr>\r\n"
						+ "    <th>Concepto</th>\r\n"
						+ "    <th>Cantidad</th>\r\n"
						+ "    <th>Valor unitario</th>\r\n"
						+ "    <th>Valor total</th>\r\n"
						);
			
				
			if(sesion.getAttribute("producto") != null) {
				
				out.println ("  </tr>\r\n"
						+ "  <tr>\r\n"
						+ "    <td>\r\n"
						+ "      "+sesion.getAttribute("producto")+"\r\n"
						+ "    </td>\r\n"
						+ "    <td>\r\n"
						+ "        "+sesion.getAttribute("cantidad")+"\r\n"
						+ "    </td>\r\n"
						+ "    <td>\r\n"
						+ "      "+sesion.getAttribute("precio")+"\r\n"
						+ "    </td>\r\n"
						+ "    <td>\r\n"
						+ "      "+sesion.getAttribute("total1")+"\r\n"
						+ "    </td>\r\n"
						+ "  </tr>\r\n"
						);
			}
			if(sesion.getAttribute("producto2") != null) {
				out.println ( "  <tr>\r\n"
						+ "    <td>\r\n"
						+ "      "+sesion.getAttribute("producto2")+"\r\n"
						+ "    </td>\r\n"
						+ "    <td>\r\n"
						+ "     "+sesion.getAttribute("cantidad2")+"\r\n"
						+ "    </td>\r\n"
						+ "    <td>\r\n"
						+ "      "+sesion.getAttribute("precio2")+"\r\n"
						+ "    </td>\r\n"
						+ "    <td>\r\n"
						+ "      "+sesion.getAttribute("total2")+"\r\n"
						+ "    </td>\r\n"
						+ "  </tr>\r\n"
						);
			}
			if(sesion.getAttribute("producto3") != null) {
				out.println ( "  <tr>\r\n"
						+ "    <td>\r\n"
						+ "     "+sesion.getAttribute("producto3")+"\r\n"
						+ "    </td>\r\n"
						+ "    <td>\r\n"
						+ "     "+sesion.getAttribute("cantidad3")+"\r\n"
						+ "    </td>\r\n"
						+ "    <td>\r\n"
						+ "     "+sesion.getAttribute("precio3")+"\r\n"
						+ "    </td>\r\n"
						+ "    <td>\r\n"
						+ "    "+sesion.getAttribute("total3")+"\r\n"
						+ "    </td>\r\n"
						+ "  </tr>\r\n"
						);
			}
				out.println ( "</table>\r\n"
						+ "</br>\r\n"
						+ "<table>\r\n"
						+ "  <tr>\r\n"
						+ "    <th>IVA 21%</th>\r\n"
						+ "    <td>\r\n"
						+ "      "+(total) * (iva) +"\r\n"
						+ "    </td>\r\n"
						+ "  </tr>\r\n"
						+ "   <tr>\r\n"
						+ "    <th>Envio</th>\r\n"
						+ "    <td>\r\n"
						+ "      "+envio+"\r\n"
						+ "    </td>\r\n"
						+ "  </tr>\r\n"
						+ "   <tr>\r\n"
						+ "    <th>Total importe</th>\r\n"
						+ "    <td>\r\n"
						+ "      "+(total+envio+(total) * (iva)) +"\r\n"
						+ "    </td>\r\n"
						+ "  </tr>\r\n"
						+ "</table>\r\n"
						+ "</br>\r\n"
						+ "<hr width=\"98%\"/>\r\n"
						+ "</body></html>");

			}
			
			if (accion.equals("correo")) {
				
				// Buscar el ultimo numero primo y enviarlo

				double iva = 0.21;
				double envio = 1.25;
				double total = (double) sesion.getAttribute("total");
				
				out.println ("<!DOCTYPE HTML><html>"
						+ "<head>\r\n"
						+ "    <link rel=\"stylesheet\" href=\"/ProyectoServlet/HTML/style.css\">\r\n"
						+ "    <meta charset=\"UTF-8\">\r\n"
						+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
						+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
						+ "    <title>Document</title>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "    <span class=\"titulo\">Factura Hooders</span>\r\n"
						+ "<p></p>\r\n"
						+ "<table>\r\n"
						+ "  <tr>\r\n"
						+ "    <th>Concepto</th>\r\n"
						+ "    <th>Cantidad</th>\r\n"
						+ "    <th>Valor unitario</th>\r\n"
						+ "    <th>Valor total</th>\r\n"
						);
			
				
			if(sesion.getAttribute("producto") != null) {
				
				out.println ("  </tr>\r\n"
						+ "  <tr>\r\n"
						+ "    <td>\r\n"
						+ "      "+sesion.getAttribute("producto")+"\r\n"
						+ "    </td>\r\n"
						+ "    <td>\r\n"
						+ "        "+sesion.getAttribute("cantidad")+"\r\n"
						+ "    </td>\r\n"
						+ "    <td>\r\n"
						+ "      "+sesion.getAttribute("precio")+"\r\n"
						+ "    </td>\r\n"
						+ "    <td>\r\n"
						+ "      "+sesion.getAttribute("total1")+"\r\n"
						+ "    </td>\r\n"
						+ "  </tr>\r\n"
						);
			}
			if(sesion.getAttribute("producto2") != null) {
				out.println ( "  <tr>\r\n"
						+ "    <td>\r\n"
						+ "      "+sesion.getAttribute("producto2")+"\r\n"
						+ "    </td>\r\n"
						+ "    <td>\r\n"
						+ "     "+sesion.getAttribute("cantidad2")+"\r\n"
						+ "    </td>\r\n"
						+ "    <td>\r\n"
						+ "      "+sesion.getAttribute("precio2")+"\r\n"
						+ "    </td>\r\n"
						+ "    <td>\r\n"
						+ "      "+sesion.getAttribute("total2")+"\r\n"
						+ "    </td>\r\n"
						+ "  </tr>\r\n"
						);
			}
			if(sesion.getAttribute("producto3") != null) {
				out.println ( "  <tr>\r\n"
						+ "    <td>\r\n"
						+ "     "+sesion.getAttribute("producto3")+"\r\n"
						+ "    </td>\r\n"
						+ "    <td>\r\n"
						+ "     "+sesion.getAttribute("cantidad3")+"\r\n"
						+ "    </td>\r\n"
						+ "    <td>\r\n"
						+ "     "+sesion.getAttribute("precio3")+"\r\n"
						+ "    </td>\r\n"
						+ "    <td>\r\n"
						+ "    "+sesion.getAttribute("total3")+"\r\n"
						+ "    </td>\r\n"
						+ "  </tr>\r\n"
						);
			}
				out.println ( "</table>\r\n"
						+ "</br>\r\n"
						+ "<table>\r\n"
						+ "  <tr>\r\n"
						+ "    <th>IVA 21%</th>\r\n"
						+ "    <td>\r\n"
						+ "      "+(total) * (iva) +"\r\n"
						+ "    </td>\r\n"
						+ "  </tr>\r\n"
						+ "   <tr>\r\n"
						+ "    <th>Envio</th>\r\n"
						+ "    <td>\r\n"
						+ "      "+envio+"\r\n"
						+ "    </td>\r\n"
						+ "  </tr>\r\n"
						+ "   <tr>\r\n"
						+ "    <th>Total importe</th>\r\n"
						+ "    <td>\r\n"
						+ "      "+(total+envio+(total) * (iva)) +"\r\n"
						+ "    </td>\r\n"
						+ "  </tr>\r\n"
						+ "</table>\r\n"
						+ "</br>\r\n"
						+ "<hr width=\"98%\"/>\r\n"
						+ "</body></html>");

			}
			
				if (accion.equals("tienda")) {
				
				// Buscar el ultimo numero primo y enviarlo
				
				
				double iva = 0.21;
				double envio = 0;
				double total = (double) sesion.getAttribute("total");
				
				out.println ("<!DOCTYPE HTML><html>"
						+ "<head>\r\n"
						+ "    <link rel=\"stylesheet\" href=\"/ProyectoServlet/HTML/style.css\">\r\n"
						+ "    <meta charset=\"UTF-8\">\r\n"
						+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
						+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
						+ "    <title>Document</title>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "    <span class=\"titulo\">Factura Hooders</span>\r\n"
						+ "<p></p>\r\n"
						+ "<table>\r\n"
						+ "  <tr>\r\n"
						+ "    <th>Concepto</th>\r\n"
						+ "    <th>Cantidad</th>\r\n"
						+ "    <th>Valor unitario</th>\r\n"
						+ "    <th>Valor total</th>\r\n"
						);
			
				
			if(sesion.getAttribute("producto") != null) {
				
				out.println ("  </tr>\r\n"
						+ "  <tr>\r\n"
						+ "    <td>\r\n"
						+ "      "+sesion.getAttribute("producto")+"\r\n"
						+ "    </td>\r\n"
						+ "    <td>\r\n"
						+ "        "+sesion.getAttribute("cantidad")+"\r\n"
						+ "    </td>\r\n"
						+ "    <td>\r\n"
						+ "      "+sesion.getAttribute("precio")+"\r\n"
						+ "    </td>\r\n"
						+ "    <td>\r\n"
						+ "      "+sesion.getAttribute("total1")+"\r\n"
						+ "    </td>\r\n"
						+ "  </tr>\r\n"
						);
			}
			if(sesion.getAttribute("producto2") != null) {
				out.println ( "  <tr>\r\n"
						+ "    <td>\r\n"
						+ "      "+sesion.getAttribute("producto2")+"\r\n"
						+ "    </td>\r\n"
						+ "    <td>\r\n"
						+ "     "+sesion.getAttribute("cantidad2")+"\r\n"
						+ "    </td>\r\n"
						+ "    <td>\r\n"
						+ "      "+sesion.getAttribute("precio2")+"\r\n"
						+ "    </td>\r\n"
						+ "    <td>\r\n"
						+ "      "+sesion.getAttribute("total2")+"\r\n"
						+ "    </td>\r\n"
						+ "  </tr>\r\n"
						);
			}
			if(sesion.getAttribute("producto3") != null) {
				out.println ( "  <tr>\r\n"
						+ "    <td>\r\n"
						+ "     "+sesion.getAttribute("producto3")+"\r\n"
						+ "    </td>\r\n"
						+ "    <td>\r\n"
						+ "     "+sesion.getAttribute("cantidad3")+"\r\n"
						+ "    </td>\r\n"
						+ "    <td>\r\n"
						+ "     "+sesion.getAttribute("precio3")+"\r\n"
						+ "    </td>\r\n"
						+ "    <td>\r\n"
						+ "    "+sesion.getAttribute("total3")+"\r\n"
						+ "    </td>\r\n"
						+ "  </tr>\r\n"
						);
			}
				out.println ( "</table>\r\n"
						+ "</br>\r\n"
						+ "<table>\r\n"
						+ "  <tr>\r\n"
						+ "    <th>IVA 21%</th>\r\n"
						+ "    <td>\r\n"
						+ "      "+(total) * (iva) +"\r\n"
						+ "    </td>\r\n"
						+ "  </tr>\r\n"
						+ "   <tr>\r\n"
						+ "    <th>Envio</th>\r\n"
						+ "    <td>\r\n"
						+ "      "+envio+"\r\n"
						+ "    </td>\r\n"
						+ "  </tr>\r\n"
						+ "   <tr>\r\n"
						+ "    <th>Total importe</th>\r\n"
						+ "    <td>\r\n"
						+ "      "+(total+envio+(total) * (iva)) +"\r\n"
						+ "    </td>\r\n"
						+ "  </tr>\r\n"
						+ "</table>\r\n"
						+ "</br>\r\n"
						+ "<hr width=\"98%\"/>\r\n"
						+ "</body></html>");

			}
				
			
			

		}

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
