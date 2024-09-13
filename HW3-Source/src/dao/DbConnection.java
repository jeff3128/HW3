package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.DbConnection;

public class DbConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DbConnection.getdb());
	}
	       public static Connection getdb() {
			Connection conn=null;
			
			String URL="jdbc:mysql://localhost:3306/gjun";
			String user="root";
			String password="1234";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn=DriverManager.getConnection(URL, user, password);
				
			} catch (ClassNotFoundException e) {
				System.out.println("no Driver");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("no connection");
				e.printStackTrace();
			
			}
			return conn;
			
			
		}

}
