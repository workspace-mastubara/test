package com.internousdev.latte.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.latte.dao.PurchaseHistoryInfoDAO;
import com.internousdev.latte.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeletePurchaseHistroyAction extends ActionSupport {
	private String userId;
	private PurchaseHistoryInfoDAO purchaseHistoryInfoDAO = new PurchaseHistoryInfoDAO();
	private List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList = new ArrayList<PurchaseHistoryInfoDTO>();

	public String execute() {
		String res = ERROR;
		int count = purchaseHistoryInfoDAO.deletePurchaseHistoryList(userId);

		if(count > 0) {
			purchaseHistoryInfoDTOList = null;
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


	public List<PurchaseHistoryInfoDTO> getPurchaseHistoryInfoDTOList() {
		return this.purchaseHistoryInfoDTOList;
	}
	public void setPurchaseHistoryInfoDTOList(List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList) {
		this.purchaseHistoryInfoDTOList = purchaseHistoryInfoDTOList;
	}





}