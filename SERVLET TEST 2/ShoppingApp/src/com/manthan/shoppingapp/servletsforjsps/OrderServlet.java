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


@WebServlet("/orderproduct")
public class OrderServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		
		if(session != null) {
			
			int product_id = Integer.parseInt(request.getParameter("product_id"));
			ShoppingAppDAO dao = new ShoppingAppDAOImplementation();

			ShoppingAppBean shoppingappbean = dao.orderProduct(product_id);

			if(shoppingappbean != null) {
				request.setAttribute("orderproduct", shoppingappbean);
			}
			else {
				request.setAttribute("msg", "Order not placed");
			}

			request.getRequestDispatcher("./orderproduct").forward(request, response);
		}
		else {
			request.setAttribute("msg", "Please login first");
			request.getRequestDispatcher("./userlogin").forward(request, response);
		}
	}

}

