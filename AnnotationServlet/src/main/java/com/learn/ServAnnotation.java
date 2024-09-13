package com.learn;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ServAnnotation
 */
@WebServlet("/annotation")
public class ServAnnotation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String var1 = request.getParameter("var1");
		String var2 = request.getParameter("var2");
		String var3 = request.getParameter("var3");
		
		response.setContentType("text/html");
		
		String welcomeMessage = "Welcome " + (var1 != null ? var1 : "APEX1") + " <br> Welcome " + (var2 != null ? var2 : "APEX2") + " <br> Welcome " + (var3 != null ? var3 : "APEX3") ;
        response.getWriter().append(welcomeMessage).close();
	}

}
