package com.manthan.servlet.dao;

import com.manthan.servlet.bean.UserBean;

public interface UserDAO {

		public  UserBean authenticate (String username, String password);

		public boolean forgot(UserBean userBean);

		public boolean register(UserBean userBean);

		//public boolean deleteEmployee (int empId);
		
		
	}// end of DAO
