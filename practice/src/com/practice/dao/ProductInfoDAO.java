package com.practice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.practice.dto.ProductInfoDTO;
import com.practice.util.DBConnector;

//商品詳細情報を取り出す:
public class ProductInfoDAO {

	/*商品IDを条件として商品情報を取り出す
	 * @param: productId
	 *@return: productInfoDTO */

	public ProductInfoDTO getProductDetails(int productId) {
		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();

		String sql = "select * from product_info where product_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				productInfoDTO.setCategoryId(rs.getInt("category_id"));
				productInfoDTO.setProductId(rs.getInt("product_id"));
				productInfoDTO.setProductName(rs.getString("product_name"));
				productInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				productInfoDTO.setImageFileName(rs.getString("image_file_name"));
				productInfoDTO.setPrice(rs.getInt("price"));
				productInfoDTO.setReleaseCompany(rs.getString("release_company"));
				productInfoDTO.setReleaseDate(rs.getString("release_date"));
				productInfoDTO.setProductDescription(rs.getString("product_description"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productInfoDTO;
	}

	//全てのカテゴリーとキーワード未入力時に情報を取り出す
	public List<ProductInfoDTO> allSelect() {

		List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();

		String sql = "select * from product_info";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				ProductInfoDTO productInfoDTO = new ProductInfoDTO();

				productInfoDTO.setId(rs.getInt("id"));
				productInfoDTO.setProductId(rs.getInt("product_id"));
				productInfoDTO.setProductName(rs.getString("product_name"));
				productInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				productInfoDTO.setProductDescription(rs.getString("product_description"));
				productInfoDTO.setCategoryId(rs.getInt("category_id"));
				productInfoDTO.setPrice(rs.getInt("price"));
				productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				productInfoDTO.setImageFileName(rs.getString("image_file_name"));
				productInfoDTO.setReleaseDate(rs.getString("release_date"));
				productInfoDTO.setReleaseCompany(rs.getString("release_company"));

				productInfoDTOList.add(productInfoDTO);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productInfoDTOList;

	}

	/*カテゴリーIDとキーワードを条件に商品情報を取り出す
	 * @param: categoryId
	 * @param: stringList
	 * @return: productInfoDTOList */
	public List<ProductInfoDTO> getProductInfoListByCategoryIdAndKeyword(int categoryId, String[] stringList) {

		List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();

		String sql = "select * from product_info where category_id=?";

		if (!"".equals(stringList[0])) {

			for (int i = 0; i < stringList.length; i++) {
				if (i == 0) {
					sql += " and ((product_name like '%" + stringList[i] + "%' or product_name_kana like '%"
							+ stringList[i] + "%')";
				} else {
					sql += "or (product_name like '%" + stringList[i] + "%' or product_name_kana like '%"
							+ stringList[i] + "%')";
				}
			}
			sql += ")";
		}
		sql += "order by product_id asc";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				ProductInfoDTO productInfoDTO = new ProductInfoDTO();

				productInfoDTO.setId(rs.getInt("id"));
				productInfoDTO.setProductId(rs.getInt("product_id"));
				productInfoDTO.setProductName(rs.getString("product_name"));
				productInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				productInfoDTO.setProductDescription(rs.getString("product_description"));
				productInfoDTO.setCategoryId(rs.getInt("category_id"));
				productInfoDTO.setPrice(rs.getInt("price"));
				productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				productInfoDTO.setImageFileName(rs.getString("image_file_name"));
				productInfoDTO.setReleaseDate(rs.getString("release_date"));
				productInfoDTO.setReleaseCompany(rs.getString("release_company"));

				productInfoDTOList.add(productInfoDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productInfoDTOList;
	}

	/*カテゴリーIDを条件に商品詳細を取り出す
	 *@param: categoryId
	 *@return: productInfoDTOList */
	public List<ProductInfoDTO> serchItemInfoBaseOnCategory(int categoryId) {

		List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();

		String sql = "select * from product_info where category_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				ProductInfoDTO productInfoDTO = new ProductInfoDTO();

				productInfoDTO.setProductId(rs.getInt("product_id"));
				productInfoDTO.setProductName(rs.getString("product_name"));
				productInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				productInfoDTO.setImageFileName(rs.getString("image_file_name"));
				productInfoDTO.setPrice(rs.getInt("price"));

				productInfoDTOList.add(productInfoDTO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productInfoDTOList;
	}

	/*キーワードを条件に商品詳細を取り出す
	 * @param: serchWordList
	 * @return: productInfoDTOList*/
	public List<ProductInfoDTO> serchItemInfoBaseOnWord(String[] serchWordList) {

		List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();

		String sql = "select * from product_info";

		if (!"".equals(serchWordList[0])) {

			for (int i = 0; i < serchWordList.length; i++) {
				if (i == 0) {
					sql += " where ((product_name like '%" + serchWordList[i] + "%' or product_name_kana like '%"
							+ serchWordList[i] + "%')";
				} else {
					sql += "or (product_name like '%" + serchWordList[i] + "%' or product_name_kana like '%"
							+ serchWordList[i] + "%')";
				}
			}
			sql += ")";
		}
		sql += "order by product_id asc";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				ProductInfoDTO productInfoDTO = new ProductInfoDTO();

				productInfoDTO.setProductId(rs.getInt("product_id"));
				productInfoDTO.setProductName(rs.getString("product_name"));
				productInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				productInfoDTO.setImageFileName(rs.getString("image_file_name"));
				productInfoDTO.setPrice(rs.getInt("price"));

				productInfoDTOList.add(productInfoDTO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productInfoDTOList;

	}

	/* 関連商品情報取得（自身を除く同じカテゴリーの商品を3件表示）
	 * @param: categoryId
	 * @param: productId
	 * @return: 関連商品情報リスト(3件) */
	public List<ProductInfoDTO> getReleatedProductInfo(int categoryId, int productId) {
		List<ProductInfoDTO> relatedProductInfoList = new ArrayList<ProductInfoDTO>();

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "SELECT * FROM product_info WHERE category_id = ? AND product_id != ? ORDER BY RAND() LIMIT 0, 3";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ps.setInt(2, productId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ProductInfoDTO dto = new ProductInfoDTO();
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductNameKana(rs.getString("product_name_kana"));
				dto.setProductDescription(rs.getString("product_description"));
				dto.setPrice(rs.getInt("price"));
				dto.setCategoryId(rs.getInt("category_id"));
				dto.setImageFileName(rs.getString("image_file_name"));
				dto.setImageFilePath(rs.getString("image_file_path"));
				dto.setReleaseDate(rs.getString("release_date"));
				dto.setReleaseCompany(rs.getString("release_company"));
				relatedProductInfoList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return relatedProductInfoList;
	}
}
