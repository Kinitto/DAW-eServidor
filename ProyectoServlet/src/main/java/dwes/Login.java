package dwes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="login", urlPatterns="/servletLogin")
public class Login extends HttpServlet {
 
    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) 
                   throws ServletException, IOException {
    	 HashMap<String, String> userPass = new HashMap<String, String>();

    	    // Add keys and values (Country, City)
    	    userPass.put("Admin", "1234");
    	    userPass.put("Joaquin", "claveJoaquin");
    	    
    	    System.out.println(userPass.get("Admin"));
    }
}