package com.internousdev.template2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.template2.dto.BuyItemDTO;
import com.internousdev.template2.util.DBConnector;


public class BuyItemDAO {

	public BuyItemDTO getBuyItemInfo(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		BuyItemDTO dto = new BuyItemDTO();

		String sql = "select id,item_name,item_price from itemit";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return dto;
	}


}
