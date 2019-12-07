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

@WebServlet("/userregisterr")
public class RegisterServlet extends HttpServlet {
	
	private ShoppingAppDAO dao = new ShoppingAppDAOImplementation();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			
			int user_id = Integer.parseInt(request.getParameter("user_id"));
			String user_name = request.getParameter("user_name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			ShoppingAppBean shoppingappbean = new ShoppingAppBean();
			
			shoppingappbean.setUser_id(user_id);
			shoppingappbean.setUser_name(user_name);
			shoppingappbean.setEmail(email);
			shoppingappbean.setPassword(password);
			
			
			if(dao.register(shoppingappbean)) {
				request.setAttribute("msg", "New User added");
			}
			else {
				request.setAttribute("msg", "Fail to add New User");
			}
			request.getRequestDispatcher("/userregister").forward(request, response);
			
		}
		else {
			request.setAttribute("msg", "Please login first");
			request.getRequestDispatcher("/userlogin").forward(request, response);
		}
	}

}
