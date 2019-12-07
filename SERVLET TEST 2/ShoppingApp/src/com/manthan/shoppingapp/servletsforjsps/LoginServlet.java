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
import com.manthan.shoppingapp.dao.ShoppingAppDAOImplManager;
import com.manthan.shoppingapp.dao.ShoppingAppDAOImplementation;

@WebServlet("/userloginn")
public class LoginServlet extends HttpServlet {

	ShoppingAppDAO dao = ShoppingAppDAOImplManager.getDAOInstance();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		ShoppingAppBean shoppingappbean = dao.authenticate(email, password);

		if(shoppingappbean != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("shoppingappbean", shoppingappbean);
			request.getRequestDispatcher("/searchproduct").forward(request, response);

		}else {
			request.setAttribute("msg", "Invalid credentials");
			request.getRequestDispatcher("/userlogin").forward(request, response);
		}
	}
}
