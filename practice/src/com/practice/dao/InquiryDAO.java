package com.practice.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.practice.dto.InquiryDTO;
import com.practice.util.DBConnector;

public class InquiryDAO {
	/**
	 * 質問タイプリストを取得するメソッド
	 * @return 質問タイプリスト(質問タイプ)
	 */
	public List<InquiryDTO> setQTypeList(){
		List<InquiryDTO> inquiryDTOList = new ArrayList<InquiryDTO>();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql="SELECT * FROM asked_question";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				InquiryDTO dto = new InquiryDTO();
				dto.setqType(rs.getString("q_type"));

				inquiryDTOList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return inquiryDTOList;
	}
}