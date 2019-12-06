package com.internousdev.webproj4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj4.dto.LoginDTO;
import com.internousdev.webproj4.util.DBConnector;

public class TestDAO {
	public List<LoginDTO> LoginDTOList = new ArrayList<LoginDTO>();

	public List<LoginDTO> select(String username, String password){
		DBConnector db = new DBConnector();
		Connection con = db.getConnect();

		String sql = "select * from users where user_name=? and password=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				LoginDTO dto = new LoginDTO();
				dto.setUsername(username);
				dto.setPassword(password);
				LoginDTOList.add(dto);
			}

			if(LoginDTOList.size() <= 0){
				LoginDTO dto = new LoginDTO();
				dto.setUsername("該当なし");
				dto.setPassword("該当なし");
				LoginDTOList.add(dto);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return LoginDTOList;
	}


	public int insert(String username, String password) {
		int ret = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnect();

		String sql = "insert into users(user_name,password) values (?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			int i = ps.executeUpdate();

			if(i > 0){
				System.out.println(i + "件登録されました");
				ret = i;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

}
