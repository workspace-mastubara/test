package com.internousdev.template2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.template2.dto.MyPageDTO;
import com.internousdev.template2.util.DBConnector;


public class MyPageDAO {

	public MyPageDTO getMyPageUserInfo(String itemId, String masterId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		MyPageDTO dto = new MyPageDTO();

		String sql = "SELECT itemit.item_name, userbit.total_price, userbit.total_count, userbit.pay FROM userbit Left JOIN itemit ON userbit.item_transaction_id = itemit.id WHERE userbit.item_transaction_id = ? AND userbit.user_master_id = ? ORDER BY userbit.insert_date DESC";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, itemId);
			ps.setString(2, masterId);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				dto.setItemName(rs.getString("item_name"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setTotalCount(rs.getString("total_count"));
				dto.setPayment(rs.getString("pay"));
			}
		} catch(SQLException e){
			e.printStackTrace();
		} finally {
			try{
				con.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}

		return dto;
	}


	public int buyItemHistoryDelete(String itemId, String masterId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "DELETE FROM userbit WHERE item_transaction_id = ? AND user_master_id = ?";

		PreparedStatement ps;
		int result = 0;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, itemId);
			ps.setString(2, masterId);
			result = ps.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		} finally {
			try{
				con.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}

		return result;
	}

}
