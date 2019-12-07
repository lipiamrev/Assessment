package com.manthan.shoppingapp.servletsforjsps;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manthan.shoppingapp.bean.ShoppingAppBean;
import com.manthan.shoppingapp.dao.ShoppingAppDAO;
import com.manthan.shoppingapp.dao.ShoppingAppDAOImplementation;

@WebServlet("/productsearch")
public class SearchServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session != null) {
			String product_name = request.getParameter("product_name");
			ShoppingAppDAO dao = new ShoppingAppDAOImplementation();
			ShoppingAppBean shoppingappbean = dao.searchProduct(product_name);
			
			if(shoppingappbean != null) {
				request.setAttribute("searchproduct", shoppingappbean);
			}
			else {
				request.setAttribute("msg", "Product not found");
			}
			
			request.getRequestDispatcher("./searchproduct").forward(request, response);
		}
		else {
			request.setAttribute("msg", "Please login first");
			request.getRequestDispatcher("./userlogin").forward(request, response);
		}
	}


}
