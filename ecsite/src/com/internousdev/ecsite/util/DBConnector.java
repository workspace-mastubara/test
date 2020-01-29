package com.internousdev.ecsite.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/matsubara";
	private static String user = "root";
	private static String pass = "mysql";

	public Connection getConnect(){
		Connection con = null;

		try {
			Class.forName(driverName);
			con = (Connection)DriverManager.getConnection(url, user, pass);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e){
			e.printStackTrace();
		}

		return con;
	}

}
