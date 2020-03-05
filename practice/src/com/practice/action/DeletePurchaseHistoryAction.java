package com.practice.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.practice.dao.PurchaseHistoryInfoDAO;
import com.practice.dto.PurchaseHistoryInfoDTO;

public class DeletePurchaseHistoryAction extends ActionSupport implements SessionAware{
	private String userId;
	private String message;
	private Map<String, Object>session;
	private List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList = new ArrayList<PurchaseHistoryInfoDTO>();

	public String execute() {
		String res = SUCCESS;

		String userId = String.valueOf(session.get("userId"));
		String temporaryUserId = String.valueOf(session.get("randomId"));

		String tempLogined = String.valueOf(session.get("logined"));
		int logined = "null".equals(tempLogined)? 0 : Integer.parseInt(tempLogined);
		if(logined != 1) {
			res =  "loginError";
		}

		PurchaseHistoryInfoDAO purchaseHistoryInfoDAO = new PurchaseHistoryInfoDAO();

		int tempDeleteCount = purchaseHistoryInfoDAO.deletePurchaseHistoryList(temporaryUserId);
		int userDeleteCount = purchaseHistoryInfoDAO.deletePurchaseHistoryList(userId);

		if(tempDeleteCount > 0 || userDeleteCount > 0) {
			purchaseHistoryInfoDTOList.clear();
			setMessage("商品購入履歴情報はありません。");



			res = SUCCESS;
		}

		return res;
	}

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String,Object> getSession() {
		return session;
	}
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

	public List<PurchaseHistoryInfoDTO> getPurchaseHistoryInfoDTOList() {
		return this.purchaseHistoryInfoDTOList;
	}
	public void setPurchaseHistoryInfoDTOList(List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList) {
		this.purchaseHistoryInfoDTOList = purchaseHistoryInfoDTOList;
	}
}