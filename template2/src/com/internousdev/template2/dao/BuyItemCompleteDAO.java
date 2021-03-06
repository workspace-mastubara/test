package com.internousdev.template2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.template2.util.DBConnector;
import com.internousdev.template2.util.DateUtil;

public class BuyItemCompleteDAO {

	public void buyItemInfo(String itemId, String masterId, String totalPrice, String totalCount, String pay){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil date = new DateUtil();

		String sql = "INSERT INTO userbit(item_transaction_id, total_price, total_count, user_master_id, pay, insert_date) VALUES(?,?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, itemId);
			ps.setString(2, totalPrice);
			ps.setString(3, totalCount);
			ps.setString(4, masterId);
			ps.setString(5, pay);
			ps.setString(6, date.getDate());

			ps.execute();
		} catch(SQLException e){
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

}
