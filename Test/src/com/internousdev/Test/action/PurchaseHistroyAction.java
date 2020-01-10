package com.internousdev.latte.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.latte.dao.PurchaseHistoryInfoDAO;
import com.internousdev.latte.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PurchaseHistroyAction extends ActionSupport {
	private String userId;
	private String message;
	private int totalPrice;
	private PurchaseHistoryInfoDAO purchaseHistoryInfoDAO = new PurchaseHistoryInfoDAO();
	private PurchaseHistoryInfoDTO purchaseHistoryInfoDTO = new PurchaseHistoryInfoDTO();
	private List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList = new ArrayList<PurchaseHistoryInfoDTO>();


	public String execute() {

		if(userId.equals(purchaseHistoryInfoDTO.getUserId())) {
			purchaseHistoryInfoDTOList = purchaseHistoryInfoDAO.getPurchaseHistoryInfoList(userId);
			totalPrice = purchaseHistoryInfoDTO.getPrice() + purchaseHistoryInfoDTO.getProductCount();

		} else {
			setMessage("商品購入履歴情報はありません。");
		}

		return SUCCESS;
	}


	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getMessaege() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}


	public int getTotalPrice() {
		return this.totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


	public List<PurchaseHistoryInfoDTO> getPurchaseHistoryInfoDTOList(){
		return this.purchaseHistoryInfoDTOList;
	}
	public void setPurchaseHistoryInfoDTOList(List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList){
		this.purchaseHistoryInfoDTOList = purchaseHistoryInfoDTOList;
	}

}
