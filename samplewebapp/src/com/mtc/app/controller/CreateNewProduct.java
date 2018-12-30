package com.mtc.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class CreateNewProduct
 */
@WebServlet("/CreateNewProduct")
public class CreateNewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IProductDAO productDAO;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateNewProduct() {
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
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("/CreateNewProduct.html");
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Product newProduct = new Product();
		newProduct.setId(Integer.parseInt(request.getParameter("id")));
		newProduct.setName(request.getParameter("name"));
		newProduct.setPrice(Float.parseFloat(request.getParameter("price")));
		newProduct.setDescription(request.getParameter("description"));
		newProduct.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		Boolean status = productDAO.add(newProduct);
		PrintWriter out = response.getWriter();
		
		if(status) {
			out.print("Product inserted successfully");
		}
		else
		{
			out.print("Product not inserted");
		}
		
		
	}

}
