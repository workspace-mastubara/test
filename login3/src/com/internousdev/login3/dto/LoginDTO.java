package com.internousdev.login3.dto;

public class LoginDTO {
	private int id;
	private String name;
	private String password;

	public int getId() {
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password){
		this.password = password;
	}

}
