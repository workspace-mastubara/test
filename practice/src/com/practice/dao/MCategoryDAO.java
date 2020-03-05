package com.practice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.practice.dto.MCategoryDTO;
import com.practice.util.DBConnector;


public class MCategoryDAO{
	/**
	 * カテゴリーを取得するメソッド
	 * @return カテゴリーリスト(idとカテゴリー名)
	 */
	public List<MCategoryDTO> setCategoryInfo(){
		List<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql="SELECT * FROM m_category";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				MCategoryDTO dto = new MCategoryDTO();
				dto.setCategoryId(rs.getInt("category_id"));
				dto.setCategoryName(rs.getString("category_name"));

				mCategoryDTOList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return mCategoryDTOList;
	}
}
