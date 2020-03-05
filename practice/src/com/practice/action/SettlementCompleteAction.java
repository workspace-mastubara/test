package com.practice.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.practice.dao.CartInfoDAO;
import com.practice.dao.PurchaseHistoryInfoDAO;
import com.practice.dto.CartInfoDTO;

public class SettlementCompleteAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private int id;

	public String execute() throws SQLException{
		String tempLogined = String.valueOf(session.get("logined"));
		int logined = "null".equals(tempLogined)? 0 : Integer.parseInt(tempLogined);
		if(logined != 1) {
			return "loginError";
		}

		String result = ERROR;

		String userId = session.get("userId").toString();

		//userIdを元にカート情報を取得
		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		List<CartInfoDTO> cartInfoDTOList = cartInfoDAO.getCartInfoDTO(userId);

		//カート情報を商品購入履歴テーブルにインサート(カート情報のrow分)
		PurchaseHistoryInfoDAO purchaseHistoryInfoDAO = new PurchaseHistoryInfoDAO();
		int insertCount = 0;

		for (CartInfoDTO dto : cartInfoDTOList) {
			insertCount += purchaseHistoryInfoDAO.insertSettlementComplete(
				userId,
				dto.getProductId(),
				dto.getProductCount(),
				dto.getPrice(),
				id
				);
		}

		//商品購入履歴にインサートしたデータがあるなら
		//カートテーブルのデータは全件削除
		if(insertCount > 0) {
			int count = cartInfoDAO.deleteAll(String.valueOf(session.get("userId")));
			if(count > 0) {
				result = SUCCESS;
			}
		}

		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
