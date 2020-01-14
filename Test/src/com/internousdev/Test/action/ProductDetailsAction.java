package com.internousdev.Test.action;

import com.internousdev.Test.dao.ProductInfoDAO;
import com.internousdev.Test.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;



public class ProductDetailsAction extends ActionSupport{
	private int productId;
	private ProductInfoDTO productInfoDTO = new ProductInfoDTO();
	private String message;

	public String execute() {
		String result= SUCCESS;

		if(productInfoDTO != null) {
			ProductInfoDAO productInfoDAO = new ProductInfoDAO();

			productInfoDTO = productInfoDAO.getProductDetails(productId);

		} else {
			setMessage("商品情報なし");

		}
		//DBから商品情報を取得

		//商品情報がある場合は情報を表示

		//関連情報を表示し
		//クリックした場合　商品IDを保持し詳細画面へ

		return result;
	}

	public String getMessage() {
		return message;

	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public ProductInfoDTO getProductInfoDTO() {
		return productInfoDTO;

	}

	public void setProductInfoDTO(ProductInfoDTO productInfoDTO) {
		this.productInfoDTO = productInfoDTO;
	}


}
