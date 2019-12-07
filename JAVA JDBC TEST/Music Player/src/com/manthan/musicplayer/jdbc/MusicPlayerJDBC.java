package com.manthan.musicplayer.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MusicPlayerJDBC {

	public void allSongs(){

		Connection connection=null;
		PreparedStatement preparedStatement=null;
		Statement statement=null;
		ResultSet resultSet= null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/musicplayer";
			connection=DriverManager.getConnection(dburl,"root","root");

			String query="select * from musicfiles";
			statement=connection.createStatement();
			resultSet=statement.executeQuery(query);

			while(resultSet.next()) {
				System.out.println("ID: "+resultSet.getInt("song_id")
				+"\n"+ "Song title: "+resultSet.getString("song_title")+
				"\n"+ "Artist name: "+resultSet.getString("artist_name"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(resultSet!=null)
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(preparedStatement!=null)
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(connection!=null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}

	public void randomSongs() {

		Connection connection=null;
		PreparedStatement preparedStatement=null;
		Statement statement=null;
		ResultSet resultSet= null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/musicplayer";
			connection=DriverManager.getConnection(dburl,"root","root");

			String query="select * from musicfiles order by rand()";
			statement=connection.createStatement();
			resultSet=statement.executeQuery(query);
			
			while(resultSet.next()) {

				System.out.println("ID: "+resultSet.getInt("song_id")
				+"\n"+ "Song title: "+resultSet.getString("song_title")+
				"\n"+ "Artist name: "+resultSet.getString("artist_name"));

				System.out.println("Song is playing");

				Thread.sleep(2000);

				System.out.println("Next Song");
			}
			System.out.println("All songs played");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(resultSet!=null)
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(preparedStatement!=null)
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(connection!=null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}

	public void searchSongs() {

		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet= null;

		System.out.println("Enter the song name");

		Scanner sc = new Scanner(System.in);
		int song_id = sc.nextInt();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/musicplayer";
			connection=DriverManager.getConnection(dburl,"root","root");

			String query="select * from musicfiles where song_id= ?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, song_id);
			resultSet=preparedStatement.executeQuery();

			if(resultSet.next()) {
				System.out.println("ID: "+resultSet.getInt("song_id")
						+"\n"+ "Song title: "+resultSet.getString("song_title")+
						"\n"+ "Artist name: "+resultSet.getString("artist_name"));
			}
			else {
				System.out.println("Record not found");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if(resultSet!=null)
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(preparedStatement!=null)
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(connection!=null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	public void addSongs() {

		Connection con=null;
		Statement stmt=null; 
		PreparedStatement pstmt=null;
		ResultSet rs= null;

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter song name to add\n");

		System.out.print("\n Enter song id: ");

		int song_id = sc.nextInt();
		sc.nextLine();

		System.out.print("\n Enter song Name: ");
		String song_name = sc.nextLine();

		System.out.print("\n Enter artist name: ");
		String artist = sc.nextLine();
		
		System.out.print("\n Enter Album name: ");
		String album=sc.nextLine();

		System.out.print("\n Enter song location: ");
		String location=sc.nextLine();
		
		System.out.println("\n Enter the song description: ");
		String description= sc.nextLine();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/musicplayer";
			con=DriverManager.getConnection(dburl,"root","root");

			String query="insert into musicfiles values(?,?,?,?,?,?)";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, song_id);
			pstmt.setString(2, song_name);
			pstmt.setString(3, artist);
			pstmt.setString(4, album);
			pstmt.setString(5, location);
			pstmt.setString(6, description);

			int n=pstmt.executeUpdate();

			if(n>0) {
				System.out.println("Song has been added");
			}
			else {
				System.out.println("Failed to add");
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

	public void deleteSong() {
		Connection con=null;
		Statement stmt=null; 
		PreparedStatement pstmt=null;
		ResultSet rs= null;

		System.out.println("Enter song name to delete:\n");
		Scanner sc=new Scanner(System.in);
		String name=sc.nextLine();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/musicplayer";
			con=DriverManager.getConnection(dburl,"root","root");

			String query="delete from musicfiles where song_title=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, name);
			int n=pstmt.executeUpdate();
			if(n>0) {
				System.out.println("Song has been deleted");
			}
			else {
				System.out.println("Failed to delete");
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

	public void updateSong(String artist, String song_name) {

		Connection con=null;
		Statement stmt=null; 
		PreparedStatement pstmt=null;
		ResultSet rs= null;


		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/musicplayer";
			con=DriverManager.getConnection(dburl,"root","root");

			String query="update musicfiles set artist_name=? where song_title=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, artist);
			pstmt.setString(2, song_name);
			int n=pstmt.executeUpdate();
			if(n>0) {
				System.out.println("Song has been updated");
			}
			else {
				System.out.println("Failed to update");
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

}
