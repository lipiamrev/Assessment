package com.manthan.shoppingapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.manthan.shoppingapp.bean.ShoppingAppBean;

public class ShoppingAppDAOImplementation implements ShoppingAppDAO {

	ShoppingAppBean shoppingappbean = new ShoppingAppBean();

	@Override
	public ShoppingAppBean authenticate(String email, String password) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try
		{

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "root");

			String query = "select * from user where email = ? and password = ?" ;
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();

			if(rs.next()) {


				shoppingappbean.setEmail(rs.getString("username"));
				shoppingappbean.setPassword(rs.getString("password"));
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
		return shoppingappbean;
	}

	@Override
	public boolean register(Object setUser_id) {

		Connection con= null;
		PreparedStatement pstmt = null;

		boolean isAdded = false;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "root");

			String query = "insert into user_info value(?, ?, ?, ?);";

			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, shoppingappbean.getUser_id());
			pstmt.setString(2, shoppingappbean.getUser_name());
			pstmt.setString(3, shoppingappbean.getEmail());
			pstmt.setString(4, shoppingappbean.getPassword());

			int n = pstmt.executeUpdate();

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
	public ShoppingAppBean searchProduct(String product_name) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ShoppingAppBean shoppingappbean = null;
		try
		{

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "root");

			String query = "select * from product_info where ProductName = ?" ;
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, product_name);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				shoppingappbean = new ShoppingAppBean();

				shoppingappbean.setProduct_id(rs.getInt("product_id"));
				shoppingappbean.setProduct_name(rs.getString("product_name"));
				shoppingappbean.setProduct_color(rs.getString("product_color"));
				shoppingappbean.setDescription(rs.getString("description"));
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
		return shoppingappbean;
	}

	@Override
	public ShoppingAppBean orderProduct(int product_id) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ShoppingAppBean shoppingappbean = null;
		try
		{

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "root");
			String query = "select ProductCost, NoOfProducts from product_info where ProductID = ?" ;
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, product_id);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				shoppingappbean = new ShoppingAppBean();

				shoppingappbean.setNo_of_products(rs.getInt("no_of_products"));
				shoppingappbean.setProduct_cost(rs.getInt("product_cost"));
				shoppingappbean.orderSum();

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
		return shoppingappbean;
	}


	@Override
	public double ordersum(double product_cost, int no_of_products) {

		double sum = 0;

		sum = product_cost * no_of_products;

		return sum;

	}
}

