package com.internousdev.webproj52.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj52.dto.LoginDTO;
import com.internousdev.webproj52.util.DBConnector;

public class LoginDAO {
	private List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();

	public List<LoginDTO> select(String username, String password){
		DBConnector db = new DBConnector();
		Connection con = db.getConnect();

		String sql = "select * from users where user_name=? and password=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				LoginDTO dto = new LoginDTO();
				dto.setUsername(rs.getString("user_name"));
				dto.setPassword(rs.getString("password"));
				loginDTOList.add(dto);
			}

			if(loginDTOList.size() <= 0){
				LoginDTO dto = new LoginDTO();
				dto.setUsername("該当者なし");
				dto.setPassword("該当者なし");
				loginDTOList.add(dto);
			}

		} catch(SQLException e){
			e.printStackTrace();
		} try {
			con.close();
		} catch(SQLException e){
			e.printStackTrace();
		}

		return loginDTOList;
	}



}
