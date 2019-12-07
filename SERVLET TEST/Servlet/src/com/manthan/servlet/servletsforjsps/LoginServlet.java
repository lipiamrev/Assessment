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
import com.manthan.servlet.util.UserDAOImplManager;

@WebServlet("/login")

public class LoginServlet extends HttpServlet {

	UserDAO dao = UserDAOImplManager.getDAOInstance();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		UserBean userBean = dao.authenticate(username, password);

		if(userBean != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("userBean", userBean);
			req.getRequestDispatcher("./homePage").forward(req, resp);

		}else {
			req.setAttribute("msg", "Invalid credentials");
			req.getRequestDispatcher("./loginPage").forward(req, resp);
		}
	}

}

