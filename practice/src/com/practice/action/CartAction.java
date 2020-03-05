package com.practice.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.practice.dao.CartInfoDAO;
import com.practice.dto.CartInfoDTO;

public class CartAction extends ActionSupport implements SessionAware {
	private int totalPrice;
	private Map<String, Object> session;
	private List<CartInfoDTO> cartInfoDTO = new ArrayList<CartInfoDTO>();

	public String execute() {

		if(!session.containsKey("tempUserId") && !session.containsKey("userId")) {
			return "sessionTimeout";
		}

		CartInfoDAO dao = new CartInfoDAO();
		String userId;

		// tempLogined: セッションから受け取るために一時的に保存する変数
		// cartLogined: ログインフラグが立っているかどうか判定するための変数
		String tempLogined = String.valueOf(session.get("logined"));
		int cartLogined;
		// loginFlgがnullなのかそうでないのか
		// 結果をcartLoginedに代入
		if (tempLogined == null) {
			cartLogined = 0;
		} else {
			cartLogined = Integer.parseInt(tempLogined);
		}

		if (cartLogined == 1) {
			userId = session.get("userId").toString();
		} else {
			userId = String.valueOf(session.get("tempUserId"));
		}

		//カート画面に出したい項目をcartInfoDTOに代入
		//カート情報すべての金額をsumしたものをtotalPriceに代入
		cartInfoDTO = dao.getCartInfoDTO(userId);
		totalPrice = dao.getTotalPrice(userId);

		return SUCCESS;
	}

	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<CartInfoDTO> getCartInfoDTO() {
		return cartInfoDTO;
	}
	public void setCartInfoDTO(List<CartInfoDTO> cartInfoDTO) {
		this.cartInfoDTO = cartInfoDTO;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
