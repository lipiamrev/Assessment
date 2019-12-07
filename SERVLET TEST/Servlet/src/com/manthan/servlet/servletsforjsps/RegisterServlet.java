package com.manthan.servlet.servletsforjsps;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manthan.servlet.bean.UserBean;
import com.manthan.servlet.dao.UserDAO;
import com.manthan.servlet.dao.UserDAOImpl;

@WebServlet("/register")

public class RegisterServlet extends HttpServlet {

		private UserDAO dao = new UserDAOImpl();

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			HttpSession session = req.getSession(false);
			
			if(session != null) {
				
				String username = req.getParameter("username");
				String password = req.getParameter("password");
				int age = Integer.parseInt(req.getParameter("age"));
				String gender = req.getParameter("gender");
				
				UserBean userBean = new UserBean();
				
				userBean.setUsername(username);
				userBean.setPassword(password);
				userBean.setAge(age);
				userBean.setGender(gender);
				
				if(dao.register(userBean)) {
					req.setAttribute("msg", "New User added");
				}
				else {
					req.setAttribute("msg", "Fail to add New User");
				}
				req.getRequestDispatcher("/login").forward(req, resp);
				
			}
			else {
				req.setAttribute("msg", "Please login first");
				req.getRequestDispatcher("/loginPage").forward(req, resp);
			}
		}
	}//end of class

