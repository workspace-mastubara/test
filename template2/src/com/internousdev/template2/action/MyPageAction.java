package com.internousdev.template2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template2.dao.MyPageDAO;
import com.internousdev.template2.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{
	private Map<String, Object>session;
	private String deleteFlg;
	private String result;

	public String execute(){
		MyPageDAO dao = new MyPageDAO();
		MyPageDTO dto = new MyPageDTO();

		if(deleteFlg == null){
			String itemId = session.get("id").toString();
			String masterId = session.get("login_user_id").toString();

			dto = dao.getMyPageUserInfo(itemId, masterId);

			session.put("buyItem_name", dto.getItemName());
			session.put("total_price", dto.getTotalPrice());
			session.put("total_count", dto.getTotalCount());
			session.put("total_payment", dto.getPayment());
			session.put("message", "");
		} else if(deleteFlg.equals("1")) {
			delete();
		}
		result = SUCCESS;
		return result;
	}


	public void delete(){
		MyPageDAO dao = new MyPageDAO();

		String itemId = session.get("id").toString();
		String masterId = session.get("login_user_id").toString();

		int res = dao.buyItemHistoryDelete(itemId, masterId);

		if(res > 0){
			session.put("message", "商品情報を正しく削除しました。");
		} else if(res == 0) {
			session.put("message", "商品情報の削除に失敗しました。");
		}
	}


	public String getDeleteFlg(){
		return deleteFlg;
	}
	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg = deleteFlg;
	}

	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
