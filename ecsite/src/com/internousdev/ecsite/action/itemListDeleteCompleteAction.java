package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.itemListDAO;
import com.opensymphony.xwork2.ActionSupport;

public class itemListDeleteCompleteAction extends ActionSupport implements SessionAware{
	private Map<String, Object>session;
	private itemListDAO dao = new itemListDAO();
	private String deleteFlg;

	public String execute(){
		if(session.get("deleteFlg").toString().equals("1")){
			dao.itemListDelete();
		}

		return SUCCESS;
	}


	public Map<String, Object> getSession(){
		return this.session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

	public String getDeleteFlg(){
		return this.deleteFlg;
	}
	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg = deleteFlg;
	}



}
