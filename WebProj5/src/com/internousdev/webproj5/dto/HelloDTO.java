package com.internousdev.webproj5.dto;

public class HelloDTO {
	private int userId;
	private String username;
	private String password;
	private String result;

	public int getUserId(){
		return userId;
	}
	public void setUserId(int userId){
		this.userId = userId;
	}
	public String getUsername(){
		return this.username;
	}
	public void setUsername(String username){
		this.username = username;
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
