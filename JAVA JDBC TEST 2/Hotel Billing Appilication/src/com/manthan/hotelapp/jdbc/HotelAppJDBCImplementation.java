package com.manthan.hotelapp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HotelAppJDBCImplementation implements HotelAppJDBC {

	public void allFood() {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/hotel_db";
			con = DriverManager.getConnection(dburl,"root","root");

			String query = "select * from hotel_bill";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			while(rs.next()) {
				System.out.println("Item Code: "+rs.getInt("item_code")
				+"\n"+ "Food Name: "+rs.getString("food_name")+
				"\n"+ "Price: "+rs.getString("price"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}

	public void takeOrder() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		double sum = 0;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter no. of Item Codes:");
			int values = sc.nextInt();

			int[] items = new int[values];
			//double add=0;
			int i;

			for(i = 0; i < values; i++) {
				System.out.println("Enter item code");
				items[i] = sc.nextInt();
			}

			for(int j = 0; j < values; j++) {

				Class.forName("com.mysql.jdbc.Driver");
				String dburl = "jdbc:mysql://localhost:3306/hotel_db";
				con = DriverManager.getConnection(dburl,"root","root");
				String query = "select Price from hotel_bill where Item_Code = ?";
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, items[j]);
				rs = pstmt.executeQuery();

				while(rs.next()) {
					sum+=rs.getDouble("Price");

				}

			}			
			System.out.println("Your Total bill is:" + sum);


		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		//System.out.println("Your Total bill is:" + sum);
	}



	public void addFood() {

		Connection con = null;
		PreparedStatement pstmt = null;

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Item Code:");
		int item_Code = sc.nextInt();

		sc.nextLine();

		System.out.println("Enter Food Name:");
		String food_Name = sc.nextLine();

		System.out.println("Enter Price:");
		double price = sc.nextDouble();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/hotel_db";
			con = DriverManager.getConnection(dburl,"root","root");

			String query="insert into hotel_bill value(?, ?, ?)";

			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, item_Code);
			pstmt.setString(2, food_Name);
			pstmt.setDouble(3, price);

			int n = pstmt.executeUpdate();

			if(n>0) {
				System.out.println("Food Item has been added");
			}
			else {
				System.out.println("Error in adding food item");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	public void deleteFood() {

		Connection con = null;
		PreparedStatement pstmt = null;

		System.out.println("Enter Item Code:");

		Scanner sc = new Scanner(System.in);
		int item_Code = sc.nextInt();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/hotel_db";
			con = DriverManager.getConnection(dburl,"root","root");

			String query = "delete from hotel_bill where item_code = ?";

			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, item_Code);

			int n = pstmt.executeUpdate();

			if(n>0) {
				System.out.println("Food Item has been deleted");
			}
			else {
				System.out.println("Error in deleting food item");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	public void modifyFood(int item_Code, String food_Name, double price) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/hotel_db";
			con = DriverManager.getConnection(dburl,"root","root");

			String query = "update hotel_bill set food_name = ? and price = ? where item_code = ?";

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, food_Name);
			pstmt.setDouble(2, price);
			pstmt.setInt(3, item_Code);

			int n = pstmt.executeUpdate();

			if(n>0) {
				System.out.println("Food Item has been updated");
			}
			else {
				System.out.println("Error in updating food item");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	public void totalHotelBill() {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/hotel_db";
			con = DriverManager.getConnection(dburl,"root","root");

			String query = "select sum(Price) from hotel_bill";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			while(rs.next()) {
				System.out.println("Your Total bill is:" + rs.getDouble("sum(Price)"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}


