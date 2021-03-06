package com.internousdev.webproj5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj5.dto.HelloDTO;
import com.internousdev.webproj5.util.DBConnector;


public class HelloDAO {
	private List<HelloDTO> HelloDTOList = new ArrayList<HelloDTO>();

	public List<HelloDTO> select(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnect();

		String sql = "select * from users";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				HelloDTO dto = new HelloDTO();
				dto.setUserId(rs.getInt("user_id"));
				dto.setUsername(rs.getString("user_name"));
				dto.setPassword(rs.getString("password"));
				dto.setResult("Mysqlに接続できます。");
				HelloDTOList.add(dto);
			}
		} catch(SQLException e){
			e.printStackTrace();
		} try {
			con.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
		return HelloDTOList;
	}


}
