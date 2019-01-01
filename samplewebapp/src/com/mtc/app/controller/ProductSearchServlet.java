package com.mtc.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtc.app.dao.IProductDAO;
import com.mtc.app.dao.ProductDAO;
import com.mtc.app.vo.Product;

/**
 * Servlet implementation class ProductSearchServlet
 */
@WebServlet("/ProductSearch")
public class ProductSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IProductDAO productDAO; 
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductSearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

		productDAO = new ProductDAO();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid= Integer.parseInt(request.getParameter("pid"));
	
		Product product= productDAO.findById(pid);
		
		request.setAttribute("product", product);
		
		RequestDispatcher view = request.getRequestDispatcher("search.jsp");
		view.forward(request, response);
	}

	//	/**
	//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	//	 */
	//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//		// TODO Auto-generated method stub
	//		doGet(request, response);
	//	}

}
