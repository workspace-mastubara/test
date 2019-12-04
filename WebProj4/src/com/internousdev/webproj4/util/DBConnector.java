package com.internousdev.webproj4.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private String driverName = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/abcdb";
	private String user = "root";
	private String password = "mysql";


	public Connection getConnect(){
		Connection con = null;
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url,user,password);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

}
