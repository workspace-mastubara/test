package com.internousdev.Test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.internousdev.Test.dto.CartInfoDTO;
import com.internousdev.Test.util.DBConnector;

public class LoginFunctionCartInfoDAO {
	private List<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();

	//大平さんへ
	//カート機能で仮ユーザーIDと個数をsessionに詰めてもらうことを前提に組みました


	/**
	 * 更新日時を取得するためのメソッド
	 * @return 登録日時
	 */
	public String getDate(){
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		return simpleDateFormat.format(date);
	}



	/**
	 * 【A】
	 * 仮ユーザーIDに紐づくカート情報を取得するメソッド
	 * 引数：仮ユーザーID
	 * @return dtoList  (dto:ユーザーID、商品ID)
	 *
	 *
	 * 仮ユーザーIDはsessionに詰まっている予定
	 * (最初からそういう仕様？  やすさんにお願いするかも)
	 *
	 */
	public List<CartInfoDTO> getCartInfoLinkTemporaryUser(String temporaryUserId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "SELECT * FROM cart_info WHERE user_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, temporaryUserId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				CartInfoDTO cartInfoDTO = new CartInfoDTO();

				cartInfoDTO.setUserId(rs.getString("user_id"));
				cartInfoDTO.setProductId(rs.getInt("product_id"));

				cartInfoDTOList.add(cartInfoDTO);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return cartInfoDTOList;
	}



	/**
	【B】
	 * ユーザーIDに紐づくカート情報を取得するメソッド
	 * 引数：ユーザーID
	 * @return B__dtoList  (dto:仮ユーザーID、、商品ID、個数)
	 *
	 */
	public List<CartInfoDTO> getCartInfoLinkUser(String userId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "SELECT * FROM cart_info WHERE user_id = ? ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				CartInfoDTO cartInfoDTO = new CartInfoDTO();

				cartInfoDTO.setUserId(rs.getString("user_id"));
				cartInfoDTO.setProductId(rs.getInt("product_id"));
				cartInfoDTO.setProductCount(rs.getInt("product_count"));

				cartInfoDTOList.add(cartInfoDTO);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return cartInfoDTOList;
	}



	/**
	 * 【C】
	 * 仮ユーザーIDに紐づく商品IDが
	 * ユーザーIDの商品IDと一致しなかった場合に
	 * 仮ユーザーIDをユーザーIDに更新するメソッド
	 * 引数：仮ユーザーID, ユーザーID
	 * @return updateCount(更新件数)
	 *
	 *
	 *
	 * actionでif elseの分岐の時分岐じゃなくてCとB両方呼び出さないとだめな気がする
	 * ID　　ユーザーID　　商品ID　　個数　　登録日時
	 * 1     taro          1         1       2020/01/12
	 * 2     k3ji24        2         3       2020/01/13
	 * 3     k3ji24        1         2       2020/01/13
	 *
	 * みたいなときはCとDのupdateメソッド両方使いたい
	 * actionの書き方気を付ける
	 *
	 */
	public int updateUserId(String temporaryUserId, String userId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int updateCountC = 0;

		String sql = "UPDATE cart_info SET user_id ? ? WHERE user_id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, temporaryUserId);
			ps.setString(2, userId);
			ps.setString(3, temporaryUserId);
			updateCountC = ps.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		} try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return updateCountC;
	}



	/**
	 * 【D】
	 * 仮ユーザーIDに紐づく商品IDが
	 * ユーザーIDの商品IDと一致した場合に
	 * 個数を更新するメソッド
	 * 引数：仮ユーザでぽちった個数, ユーザーID
	 * @return updateCount(更新件数)
	 */
	public int updateCount(int temporaryUserProductCount, String userId) {						//やすさんに仮ユーザーの購入個数もsessionに入れてもらうこと前提
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int updateCountD = 0;

		String sql = "UPDATE cart_info SET count = count + ? WHERE = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, temporaryUserProductCount);
			ps.setString(2, userId);
			updateCountD = ps.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		} try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return updateCountD;
	}



	/**
	 * 【E】
	 * 仮ユーザーIDに紐づく情報を
	 * 削除するメソッド
	 * 引数：仮ユーザID
	 * @return deleteCount(削除件数)
	 */
	public int deleteTemporaryUserInfo(String temporaryUserId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int deleteCount = 0;

		String sql = "DELETE FROM cart_info WHERE user_id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, temporaryUserId);
			deleteCount = ps.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		} try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return deleteCount;
	}




	/* カート情報の取得 カート画面用の表示が目的だったがほかでもどんどん使われるかも
	 * 入力：ナシじゃまずい可能性がある　出力：*/
	public List<CartInfoDTO> getCartInfoDTO(String userId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<CartInfoDTO> cartInfoDTO = new ArrayList<CartInfoDTO>();

		/* テーブル結合：カート情報を軸にして商品情報を内部結合 */
		String sql = "SELECT ci.user_id, ci.product_id, pi.product_name, pi.product_name_kana,"
		+ " pi.price, pi.image_file_name, pi.image_file_path, pi.release_date, pi.release_company, ci.product_count,"
		+ " (ci.product_count * pi.price) as total_price ,"
		+ " ci.regist_date, ci.update_date"
		+ " FROM cart_info ci"
		+ " INNER JOIN product_info pi"
		+ " ON ci.product_id = pi.product_id"
		+ " ORDER BY ci.update_date DESC, ci.regist_date DESC";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				CartInfoDTO dto = new CartInfoDTO();
				dto.setUserId(rs.getString("user_id"));
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductNameKana(rs.getString("product_name_kana"));
				dto.setPrice(rs.getString("price"));
				dto.setImageFileName(rs.getString("image_file_name"));
				dto.setImageFilePath(rs.getString("image_file_path"));
				dto.setReleaseDate(rs.getDate("release_date"));
				dto.setReleaseCompany(rs.getString("release_company"));
				dto.setProductCount(rs.getInt("product_count"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setRegistDate(rs.getDate("regist_date"));
				dto.setUpdatedDate(rs.getDate("update_date"));
				cartInfoDTO.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// デバッグコンソール
		//for (int i=0; i<cartInfoDTO.size(); i++) {
			//System.out.println(cartInfoDTO.get(i).getUserId()+"は"+cartInfoDTO.get(i).getProductName());
		//}

		return cartInfoDTO;
	}


}
