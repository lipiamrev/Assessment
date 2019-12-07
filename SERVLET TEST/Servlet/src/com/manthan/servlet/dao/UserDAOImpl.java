package com.manthan.servlet.dao;
import com.manthan.servlet.bean.UserBean;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserDAOImpl implements UserDAO {

	@Override
	public UserBean authenticate(String username, String password) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		UserBean userBean = new UserBean();

		try
		{

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_test", "root", "root");

			String query = "select * from user where username = ? and password = ?" ;
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();

			if(rs.next()) {


				userBean.setUsername(rs.getString("username"));
				userBean.setPassword(rs.getString("password"));
			}
		}

		catch(Exception e){
			e.printStackTrace();
		}

		finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}


		}
		return userBean;
	}

	public boolean register(UserBean userBean) {

		Connection con= null;
		PreparedStatement pstmt = null;

		boolean isAdded = false;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_test", "root", "root");

			String query = "insert into employee_info value(?, ?, ?, ?);";

			pstmt = con.prepareStatement(query);

			pstmt.setString(1, userBean.getUsername());
			pstmt.setString(2, userBean.getPassword());
			pstmt.setInt(3, userBean.getAge());
			pstmt.setString(4, userBean.getGender());
			//pstmt.setString(7, "qwerty");

			int n =pstmt.executeUpdate();

			if(n>0) {
				isAdded = true;
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}


		}
		return isAdded;
	}


	@Override
	public boolean forgot(UserBean userBean) {

		Connection con= null;
		PreparedStatement pstmt = null;

		boolean isUpdated = false;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_test", "root", "root");

			String query = "update user set password = ? where username = ?";

			pstmt = con.prepareStatement(query);

			pstmt.setString(1, userBean.getPassword());
			pstmt.setString(2, userBean.getUsername());

			int n = pstmt.executeUpdate();

			if(n>0) {
				isUpdated = true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return isUpdated;
	}


}//End of class