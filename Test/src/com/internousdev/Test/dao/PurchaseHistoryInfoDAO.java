package com.internousdev.Test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.internousdev.Test.dto.PurchaseHistoryInfoDTO;
import com.internousdev.Test.util.DBConnector;


public class PurchaseHistoryInfoDAO {
	private List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList = new ArrayList<PurchaseHistoryInfoDTO>();


	/**
	 * 登録日時を取得するためのメソッド
	 * @return 登録日時
	 */
	public String getDate(){
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		return simpleDateFormat.format(date);
	}

	/**
	 * 購入履歴情報テーブルに決済情報を挿入するためのメソッド
	 * @return 決済情報登録件数
	 */
	public int insertSettlementComplete(String userId, int productId, int productCount, int price, int destinationId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int  settle = 0;

		String sql = "INSERT INTO purchase_history_info "
				+ "(user_id, product_id, product_count, price, destination_id, regist_date) "
				+ "VALUES(?,?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setInt(2, productId);
			ps.setInt(3, productCount);
			ps.setInt(4, price);
			ps.setInt(5, destinationId);
			ps.setString(6, getDate());

			settle = ps.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		} try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return settle;
	}





	/**
	 * 商品購入履歴テーブルのユーザIDを元に、
	 * 宛先情報テーブル、商品情報テーブルを紐づけして
	 * 購入履歴リストをDTOListに格納するメソッド
	 * @return 購入履歴リスト
	 */
	public List<PurchaseHistoryInfoDTO> getPurchaseHistoryInfoList(String userId){
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
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				PurchaseHistoryInfoDTO purchaseHistoryInfoDTO = new PurchaseHistoryInfoDTO();
				purchaseHistoryInfoDTO.setProductName(rs.getString("product_name"));
				purchaseHistoryInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				purchaseHistoryInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				purchaseHistoryInfoDTO.setReleaseCompany(rs.getString("release_company"));
				purchaseHistoryInfoDTO.setReleaseDate(rs.getString("release_date"));
				purchaseHistoryInfoDTO.setPrice(rs.getInt("price"));
				purchaseHistoryInfoDTO.setProductCount(rs.getInt("product_count"));
				purchaseHistoryInfoDTO.setFirstName(rs.getString("first_name"));
				purchaseHistoryInfoDTO.setFamilyName(rs.getString("family_name"));
				purchaseHistoryInfoDTO.setUserAddress(rs.getString("user_address"));

				purchaseHistoryInfoDTOList.add(purchaseHistoryInfoDTO);
			}
		} catch(SQLException e){
			e.printStackTrace();
		} try {
			con.close();
		} catch(SQLException e){
			e.printStackTrace();
		}

		return purchaseHistoryInfoDTOList;
	}





	/**
	 * 購入履歴リストを全件削除するメソッド
	 * @return 削除件数(全消去で1件)
	 */
	public int deletePurchaseHistoryList(String userId){
		int deleteHistoryCount = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
//		WHEREのあとがuserIdになっていたのでuser_idになおしました　黒川
		String sql = "DELETE FROM purchase_history_info WHERE user_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
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
