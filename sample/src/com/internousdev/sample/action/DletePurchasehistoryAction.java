package com.internousdev.sample.action;

/*import com.internousdev.sample.dao.PurchaseHistoryDAO;*/
import com.internousdev.sample.dto.PurchaseHistorInfoDTO;
import java.util.List;
import java.util.ArrayList;

/*public class DletePurchasehistoryAction extends ActionSuuport {
	private String userId;*/
	private PurchaseHistoryDAO purchaseHistoryDAO = new PurchaseHistoryDAO();
	private List<PurchaseHistorInfoDTO> PurchaseHistoryInfoList = new ArrayList<PurchaseHistorInfoDTO>();

/*	public String execute() {
		String res = ERROR;
		int count = purchaseHistoryDAO.deletePurchaseHistoryList(userId);

		if(count > 0) {*/
			PurchaseHistoryInfoList = null;
/*			res = SUCCESS;
		}

		return res;*/
	}


}


//データベースからdeleteされたらListもnullに更新