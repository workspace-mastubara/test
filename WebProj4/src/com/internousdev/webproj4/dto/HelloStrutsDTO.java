package com.internousdev.webproj4.dto;

public class HelloStrutsDTO {
	private int userId;
	private String userName;
	private String password;
	private String result;

	public int getUserId(){
		return this.userId;
	}
	public void setUserId(int userId){
		this.userId = userId;
	}

	public String getUserName(){
		return this.userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password){
		this.password = password;
	}

	public String getResult(){
		return this.result;
	}
	public void setResult(String result){
		this.result = result;
	}
}
