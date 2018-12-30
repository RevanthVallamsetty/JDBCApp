package com.mtc.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registerprocess")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//request object holds the request information required for the servlet to process the clients request and 
	//response object helps the servlet to construct the response and send it to the client.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		
		String firstname = request.getParameter("firstname");
		
		String lastname = request.getParameter("lastname");
		
		String email = request.getParameter("email");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		
		out.println("<h2 align=center> U R Registered Successfully</h2>");
		
		out.println("<p>");
		
		out.println("Username : "+username);
		
		out.println("</p>");
		
		out.println("<p>");
		
		out.println("Email   : "+email);
		
		out.println("</p>");
		
		out.println("</body></html>");
		
	}

}
