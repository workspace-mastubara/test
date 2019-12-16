package com.internousdev.template2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template2.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware{
	private String loginId;
	private String loginPass;
	private String userName;
	private Map<String, Object>session;

	public String execute(){
		UserCreateCompleteDAO dao = new UserCreateCompleteDAO();
		dao.createUser(session.get("loginId").toString(),
				session.get("loginPass").toString(),
				session.get("userName").toString());
		String result = SUCCESS;

		return result;
	}

	public String getLoginId(){
		return this.loginId;
	}
	public void setLoginId(String loginId){
		this.loginId = loginId;
	}

	public String getLoginPass(){
		return this.loginPass;
	}
	public void setLoginPass(String loginPass){
		this.loginPass = loginPass;
	}

	public String getUserName(){
		return this.userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}

	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
