package com.internousdev.login2.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector3 {
	private String driverName = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/logindb3_m";
	private String user = "root";
	private String password = "mysql";

	public Connection getConnection() {
		Connection con = null;

		try {
			Class.forName(driverName);
			con = (Connection) DriverManager.getConnection(url,user,password);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
