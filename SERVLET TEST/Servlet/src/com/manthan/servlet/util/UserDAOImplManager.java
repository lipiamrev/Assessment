package com.manthan.servlet.util;

import com.manthan.servlet.dao.UserDAO;
import com.manthan.servlet.dao.UserDAOImpl;

public class UserDAOImplManager {
	
	private UserDAOImplManager() {
	}
	
	public static UserDAOImpl getDAOInstance() {
		return new UserDAOImpl();
	}


}
