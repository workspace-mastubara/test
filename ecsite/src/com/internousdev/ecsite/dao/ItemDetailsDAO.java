package com.internousdev.ecsite.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Connection;
import com.internousdev.ecsite.util.DBConnector;


public class ItemDetailsDAO {

	public void itemDetail(String id){
		DBConnector db = new DBConnector();
		Connection con = db.getConnect();

		String sql = "SELECT * FROM item_info_transaction WHERE id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.set
		}


	}


}
