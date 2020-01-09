package com.internousdev.sample.action;


public class PurchaseHistoryInfoAction {
	private int totalPrice;

	/*public String execute() {*/

	/*	if(userId.equals(purchaseHistoryInfoDTO.getUserId())) {
			purchaseHistoryInfoDTOList = purchaseHistoryInfoDAO.getPurchaseHistoryInfoList(userId);*/

			totalPrice = purchaseHistoryInfoDTO.getPrice() + purchaseHistoryInfoDTO.getProductCount();

/*		} else {
			setMessage("商品購入履歴情報はありません。");
		}

		return SUCCESS;
	}*/

	public int getTotalPrice() {
		return this.totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

}

//合計金額を追加
