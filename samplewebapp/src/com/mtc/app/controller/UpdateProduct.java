package com.mtc.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IProductDAO productDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		productDAO = new ProductDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId=Integer.parseInt(request.getParameter("id"));
		Product updatedProduct=productDAO.findById(productId);
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2 align=center>Update Record</h2>");
		out.println("<form action=\"UpdateProduct\" method=\"post\">");
		out.println("<table align=\"center\">\r\n" + 
				"			\r\n" + 
				"			<tr>\r\n" + 
				"				<td><label>ID</label></td><td><input type=\"text\" name=\"id\" value="+String.valueOf(productId)+" readonly></td>			\r\n" + 
				"			</tr>\r\n" + 
				"			\r\n" + 
				"			<tr>\r\n" + 
				"				<td><label>Name</label></td><td><input type=\"text\" name=\"name\" value="+updatedProduct.getName()+"></td>			\r\n" + 
				"			</tr>\r\n" + 
				"			\r\n" + 
				"			<tr>\r\n" + 
				"				<td><label>Price</label></td><td><input type=\"text\" name=\"price\" value="+String.valueOf(updatedProduct.getPrice())+"></td>			\r\n" + 
				"			</tr>\r\n" + 
				"			\r\n" + 
				"			<tr>\r\n" + 
				"				<td><label>Description</label></td><td><input type=\"text\" name=\"description\" value="+updatedProduct.getDescription()+"></td>			\r\n" + 
				"			</tr>\r\n" + 
				"			\r\n" + 
				"			<tr>\r\n" + 
				"				<td><label>Quantity</label></td><td><input type=\"text\" name=\"quantity\" value="+String.valueOf(updatedProduct.getQuantity())+"></td>			\r\n" + 
				"			</tr>\r\n" + 
				"			\r\n" + 
				"			<tr>\r\n" + 
				"				<td><input type=\"submit\" value=\"Update\"> </td>\r\n" + 
				"			</tr>\r\n" + 
				"			\r\n" + 
				"		</table>");
		
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Product updatedProduct = new Product();
		updatedProduct.setId(Integer.parseInt(request.getParameter("id")));
		updatedProduct.setName(request.getParameter("name"));
		updatedProduct.setPrice(Float.parseFloat(request.getParameter("price")));
		updatedProduct.setDescription(request.getParameter("description"));
		updatedProduct.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		Boolean status = productDAO.update(updatedProduct);
		PrintWriter out = response.getWriter();
		
		if(status) {
			out.print("Product updated successfully");
			
		}
		else
		{
			out.print("Product not updated");
		}
		
	}

}
