package com.internousdev.sample.action;

import com.internousdev.sample.dao.PurchaseHistoryDAO;

public class DletePurchasehistoryAction extends ActionSuuport {
	private String userId;
	private PurchaseHistoryDAO purchaseHistoryDAO = new PurchaseHistoryDAO();

	public String execute() {
		String res = ERROR;
		int count = purchaseHistoryDAO.deletePurchaseHistoryList();

		if(count > 0) {
			purchaseHistoryDAO.deletePurchaseHistoryList();
			res = SUCCESS;
		}

		return res;
	}


}
