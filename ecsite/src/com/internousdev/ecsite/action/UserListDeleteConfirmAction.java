package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteConfirmAction extends ActionSupport implements SessionAware{
	private String deleteFlg;
	private String message;
	private Map<String, Object> session;

	public String execute(){

		if(deleteFlg.equals("1")){
			setMessage("管理者以外のユーザーを削除します。よろしいですか？");
			session.put("deleteFlg", deleteFlg);
		}

		return SUCCESS;
	}

	public String getDeleteFlg(){
		return this.deleteFlg;
	}
	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg = deleteFlg;
	}

	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message = message;
	}

	public Map<String, Object> getSession(){
		return this.session;
 	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
