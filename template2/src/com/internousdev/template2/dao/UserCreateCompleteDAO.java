package com.internousdev.template2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.template2.util.DBConnector;
import com.internousdev.template2.util.DateUtil;

public class UserCreateCompleteDAO {

	public void createUser(String loginId, String loginPass, String userName){
		DateUtil util = new DateUtil();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "INSERT INTO loginut(login_id, login_pass, user_name, insert_date) VALUES(?,?,?,?)";


		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, loginPass);
			ps.setString(3, userName);
			ps.setString(4, util.getDate());

			ps.execute();
		} catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}
