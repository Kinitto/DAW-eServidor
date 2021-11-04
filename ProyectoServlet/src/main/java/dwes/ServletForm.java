package dwes;

import java.io.*;
import java.util.HashMap;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/servletform")
public class ServletForm extends HttpServlet
{
    // Metodo para GET
 
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                   throws ServletException, IOException {
    	
    	 HashMap<String, String> userPass = new HashMap<String, String>();

 	    // Add keys and values (Country, City)
 	    userPass.put("Admin", "1234");
 	    userPass.put("Joaquin", "claveJoaquin");
 	    
 	    System.out.println(userPass.get("Admin"));
    	
        response.setContentType("text/html");
 
        PrintWriter out = response.getWriter();
 
        // Mostramos los datos del formulario
 
        out.println ("<HTML>");
        out.println ("<BODY>");
        out.println ("<H1>Datos del formulario</H1>");
        out.println ("<BR>");
 
        String valor1 =
            request.getParameter("texto1");
        String valor2 =
            request.getParameter("lista");
        String[] valor3 =
            request.getParameterValues("texto2");
 
        out.println ("Valor 1:" + valor1);
        out.println ("<BR>");
        out.println ("Valor 2:" + valor2);
        out.println ("<BR>");
        out.println ("Valor 3:");
        out.println ("<BR>");
        if (valor3 != null)
            for (int i = 0; i < valor3.length; i++)
            {
                out.println (valor3[i]);
                out.println ("<BR>");
            }
 
        out.println ("</BODY>");
        out.println ("</HTML>");
    }
 
    // Metodo para POST
 
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
                    throws ServletException, IOException {
        doGet(request, response);
    }
}