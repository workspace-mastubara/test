package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteCompleteAction extends ActionSupport implements SessionAware{
	private int deleteFlg;
	private Map<String, Object>session;
	private UserListDeleteCompleteDAO dao = new UserListDeleteCompleteDAO();


	public String execute(){
		if(deleteFlg == 1){
			dao.userListDelete();
			session.put("deleteFlg", deleteFlg);
		}

		return SUCCESS;
	}

	public int getDeleteFlg(){
		return this.deleteFlg;
	}
	public void setDeleteFlg(int deleteFlg){
		this.deleteFlg = deleteFlg;
	}

	public Map<String, Object> getSession(){
		return this.session;
 	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
