package com.internousdev.webproj52.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj52.dto.TestDTO;
import com.internousdev.webproj52.util.DBConnector;

public class TestDAO {
	private List<TestDTO> testDTOList = new ArrayList<TestDTO>();

	public int insert(String name, String password){
		int ret = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnect();

		String sql = "insert into users(user_name,password) values(?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
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


	public List<TestDTO> select(String name, String password){
		DBConnector db = new DBConnector();
		Connection con = db.getConnect();

		String sql = "select * from users where user_name=? and password=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				TestDTO dto = new TestDTO();
				dto.setName(rs.getString("user_name"));
				dto.setPassword(rs.getString("password"));
				testDTOList.add(dto);
			}

			if(testDTOList.size() <= 0){
				TestDTO dto = new TestDTO();
				dto.setName("該当者なし");
				dto.setPassword("該当者なし");
				testDTOList.add(dto);
			}

		} catch(SQLException e) {
			e.printStackTrace();
		} try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return testDTOList;
 	}




}
