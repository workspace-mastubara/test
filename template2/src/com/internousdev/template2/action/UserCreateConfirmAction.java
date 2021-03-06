package com.internousdev.template2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware{
	private String loginId;
	private String loginPass;
	private String userName;
	private Map<String, Object> session;
	private String errorMessage;

	public String execute(){
		String result = SUCCESS;

		if(!(loginId.equals(""))
				&& !(loginPass.equals(""))
				&& !(userName.equals(""))){
			session.put("loginId", loginId);
			session.put("loginPass", loginPass);
			session.put("userName", userName);
		} else {
			setErrorMessage("未入力の項目があります。");
			result = ERROR;
		}
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

	public String getErrorMessage(){
		return this.errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}



}
