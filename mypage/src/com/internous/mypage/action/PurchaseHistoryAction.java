package com.internous.mypage.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.internous.mypage.dao.PurchaseHistoryInfoDAO;
import com.internous.mypage.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PurchaseHistoryAction extends ActionSupport {
	private String userId;
	private String message;
	private Map<String, Object>session;
	private List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList = new ArrayList<PurchaseHistoryInfoDTO>();


	public String execute() {

		String res = SUCCESS;

		/*String temporaryUserId = String.valueOf(session.get("randomId"));*/
		/*loginFlg = Integer.parseInt(session.get("loginFrg").toString());
*/

		/*if("null".equals(temporaryUserId)  &&  loginFlg == 0) {
			res = "loginError";
		}*/

		PurchaseHistoryInfoDAO purchaseHistoryInfoDAO = new PurchaseHistoryInfoDAO();
		purchaseHistoryInfoDTOList = purchaseHistoryInfoDAO.getPurchaseHistoryInfoList(userId);

		System.out.println(purchaseHistoryInfoDTOList.size());


		if(purchaseHistoryInfoDTOList.size() == 0){
			setMessage("商品購入履歴情報はありません。");
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
		return this.message;
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


	public List<PurchaseHistoryInfoDTO> getPurchaseHistoryInfoDTOList(){
		return this.purchaseHistoryInfoDTOList;
	}
	public void setPurchaseHistoryInfoDTOList(List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList){
		this.purchaseHistoryInfoDTOList = purchaseHistoryInfoDTOList;
	}
}
