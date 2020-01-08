package com.internousdev.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PurchaseHistoryDAO {
	private List<PurchaseHistoryDTO> purchaseHistoryDTOList = new ArrayList<PurchaseHistoryDTO>();

	public List<PurchaseHistoryDTO> getPurchaseHistoryList(int userId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "SELECT pi.product_name, pi.product_name_kana, pi.image_file_path, pi.release_company, pi.release_date, pi.price "
				+ "phi.product_count, di.first_name, di.family_name, di.user_address "
				+ "FROM purchase_history_info AS phi "
				+ "LEFT JOIN destination_info AS di "
				+ "ON phi.user_id = di.user_id "
				+ "LEFT JOIN product_info AS pi "
				+ "ON phi.product_id = pi.product_id "
				+ "WHERE phi.user_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				PurchaseHistoryDTO purchaseHistoryDTO = new PurchaseHistoryDTO();
				purchaseHistoryDTO.setProductName(rs.getString("product_name"));
				purchaseHistoryDTO.setProductNameKana(rs.getString("product_name_kana"));
				purchaseHistoryDTO.setImageFilePath(rs.getString("image_file_path"));
				purchaseHistoryDTO.setReleaseCompany(rs.getString("release_company"));
				purchaseHistoryDTO.setReleaseDate(rs.getString("release_date"));
				purchaseHistoryDTO.setPrice(rs.getString("price"));
				purchaseHistoryDTO.setProductCount(rs.getString("product_count"));
				purchaseHistoryDTO.setFirstName(rs.getString("first_name"));
				purchaseHistoryDTO.setFamilyName(rs.getString("family_name"));
				purchaseHistoryDTO.setUserAddress(rs.getString("user_address"));

				getPurchaseHistoryList.add(purchaseHistoryDTO);
			}
		} catch(SQLException e){
			e.printStackTrace();
		} try {
			con.close();
		} catch(SQLException e){
			e.printStackTrace();
		}

		return getPurchaseHistoryList;
	}



	public int deletePurchaseHistoryList(){
		int deleteHistoryCount = 0;
	}
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "DELETE FROM purchase_history_info";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			deleteHistoryCount = ps.executeUpdate();

		} catch(SQLException e){
			e.printStackTrace();
		} try {
			con.close();
		} catch(SQLException e){
			e.printStackTrace();
		}

		return deleteHistoryCount;
	}
}
