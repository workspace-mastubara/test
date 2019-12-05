package com.internousdev.webproj4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj4.dto.InquiryDTO;
import com.internousdev.webproj4.util.DBConnector;


public class InquiryCompleteDAO {
	private List<InquiryDTO> InquiryDTOList = new ArrayList<InquiryDTO>();

	public List<InquiryDTO> select(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnect();

		String sql = "select * from inquiry";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				InquiryDTO dto = new InquiryDTO();
				dto.setName(rs.getString("name"));
				dto.setQtype(rs.getString("qtype"));
				dto.setBody(rs.getString("body"));
				InquiryDTOList.add(dto);
			}

			}catch(SQLException e) {
				e.printStackTrace();
			} try {
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return InquiryDTOList;
	}

	public int insert(String name, String qtype, String body){
		int ret = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnect();

		String sql = "insert into inquiry values(?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, qtype);
			ps.setString(3, body);
			int i = ps.executeUpdate();

			if(i > 0){
				System.out.println(i + "件更新されました。");
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
