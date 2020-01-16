package com.internous.mypage.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.internous.mypage.dao.PurchaseHistoryInfoDAO;
import com.internous.mypage.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeletePurchaseHistoryAction extends ActionSupport {
	private String userId;
	private Map<String, Object>session;
	private List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList = new ArrayList<PurchaseHistoryInfoDTO>();

	public String execute() {
		PurchaseHistoryInfoDAO purchaseHistoryInfoDAO = new PurchaseHistoryInfoDAO();
		String res = ERROR;
		/*String temporaryUserId = String.valueOf(session.get("randomId"));*/
		/*loginFlg = Integer.parseInt(session.get("loginFrg").toString());
*/

		/*if("null".equals(temporaryUserId)  &&  loginFlg == 0) {
			res = "loginError";
		}*/

		int deleteCount = purchaseHistoryInfoDAO.deletePurchaseHistoryList(userId);
		if(deleteCount > 0) {
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