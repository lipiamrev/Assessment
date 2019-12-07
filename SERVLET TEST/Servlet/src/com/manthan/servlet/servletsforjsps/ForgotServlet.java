package com.manthan.servlet.servletsforjsps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manthan.servlet.bean.UserBean;
import com.manthan.servlet.dao.UserDAO;
import com.manthan.servlet.util.UserDAOImplManager;

@WebServlet("/forgot")

public class ForgotServlet extends HttpServlet {

	UserDAO dao = UserDAOImplManager.getDAOInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);

		if(session != null) {

			String username = req.getParameter("username");
			String password = req.getParameter("password");
			//String  = req.getParameter("password");

			UserBean userBean = new UserBean();

			userBean.setUsername(username);
			userBean.setPassword(password);
			//userBean.setPassword();

			if(dao.forgot(userBean)) {
				req.setAttribute("msg", "password set");
			}
			else {
				req.setAttribute("msg", "Fail to set password");
			}
			req.getRequestDispatcher("/login").forward(req, resp);

		}
		else {
			req.setAttribute("msg", "Please login first");
			req.getRequestDispatcher("/loginPage").forward(req, resp);
		}
	}


}

