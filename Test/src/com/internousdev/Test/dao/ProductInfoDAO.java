package com.internousdev.latte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.latte.dto.ProductInfoDTO;
import com.internousdev.latte.util.DBConnector;


public class ProductInfoDAO {
	public ProductInfoDTO getProductDetails(int productId) {
		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();

		String sql = "select * from product_info where Product_id = ?";

	try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,productId);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {

				productInfoDTO.setProductName(rs.getString("product_name"));
				productInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				productInfoDTO.setPrice(rs.getString("price"));
				productInfoDTO.setReleaseCompany(rs.getString("release_company"));
				productInfoDTO.setReleaseDate(rs.getString("release_date"));
				productInfoDTO.setProductDescription(rs.getString("product_descripdtion"));


			}

	} catch(SQLException e){
		e.printStackTrace();
	} try {
		con.close();
	} catch(SQLException e){
		e.printStackTrace();
	}

	return productInfoDTO;
	}




}
