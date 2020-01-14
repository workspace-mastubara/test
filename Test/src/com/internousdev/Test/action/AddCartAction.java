package com.internousdev.Test.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Test.dao.ProductDetailsFunctionCartInfoDAO;
import com.internousdev.Test.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AddCartAction extends ActionSupport implements SessionAware {

	private int productId;
	private int productCount;
	private int price;
	private Map<String, Object>session;
	private CartInfoDTO cartInfoDTO = new CartInfoDTO();


	public String execute() {
		String res = "sessionError";
		int insertCount = 0;
		int addCount = 0;
		ProductDetailsFunctionCartInfoDAO productDetailsFunctionCartInfoDAO = new ProductDetailsFunctionCartInfoDAO();

		cartInfoDTO = productDetailsFunctionCartInfoDAO.getCartInfoTiedUserId
				(session.get("userId").toString(), productId);

		if(cartInfoDTO == null) {
			insertCount = productDetailsFunctionCartInfoDAO.insertCartInfo(session.get("userId").toString(), productId);

				if(insertCount > 0) {
					// やすさんのメソッド名に合わせる
					// cartInfoDTO = productDetailsFunctionCartInfoDAO.getCartAndProductInfo(productId);
					res = SUCCESS;
				} else {
					res = ERROR;
				}

		} else {
			addCount = productDetailsFunctionCartInfoDAO.addProductCountOfCartInfo(productCount, session.get("userId").toString(), productId);

				if(addCount > 0) {
					// やすさんのメソッド名に合わせる
					// cartInfoDTO = productDetailsFunctionCartInfoDAO.getCartAndProductInfo(productId);
					res = SUCCESS;
				} else {
					res = ERROR;
				}
		}

		return res;
	}


	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}


	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}


	public int getProductCount() {
		return productId;
	}
	public void setProductCount(int productId) {
		this.productId = productId;
	}


	public Map<String, Object> getSession() {
		return this.session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public CartInfoDTO getCartInfoDTO() {
		return this.cartInfoDTO;
	}
	public void setCartInfoDTO(CartInfoDTO cartInfoDTO) {
		this.cartInfoDTO = cartInfoDTO;
	}

}
