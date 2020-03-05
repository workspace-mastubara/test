package com.practice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.practice.dto.AskQuestionDTO;
import com.practice.util.DBConnector;

public class AskQuestionDAO {
	/**
	 * 質問と答えを取得するメソッド
	 * @return よくある質問リスト(質問と答え)
	 */
	public List<AskQuestionDTO> setAskQuestionList(){
		List<AskQuestionDTO> askQuestionDTOList = new ArrayList<AskQuestionDTO>();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql="SELECT * FROM askd_questions";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				AskQuestionDTO dto = new AskQuestionDTO();
				dto.setQuestion(rs.getString("question"));
				dto.setAnswer(rs.getString("answer"));

				askQuestionDTOList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return askQuestionDTOList;
	}
}
