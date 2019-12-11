package com.internousdev.webproj52.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj52.dto.HelloStrutsDTO;
import com.internousdev.webproj52.util.DBConnector;


public class HelloStrutsDAO {
	private List<HelloStrutsDTO> helloDTOList = new ArrayList<HelloStrutsDTO>();

	public List<HelloStrutsDTO> select(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnect();

		String sql = "select * from users";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				HelloStrutsDTO dto = new HelloStrutsDTO();
				dto.setUserId(rs.getInt("user_id"));
				dto.setUserName(rs.getString("user_name"));
				dto.setPassword(rs.getString("password"));
				dto.setResult("Mysqlと接続できます");
				helloDTOList.add(dto);
			}
		} catch(SQLException e){
			e.printStackTrace();
		} try {
			con.close();
		} catch(SQLException e){
			e.printStackTrace();
		}

		return helloDTOList;
	}


}
