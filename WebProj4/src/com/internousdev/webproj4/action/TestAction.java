package com.internousdev.webproj4.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj4.dao.TestDAO;
import com.internousdev.webproj4.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;



public class TestAction extends ActionSupport{
	private String username;
	private String password;
	private List<LoginDTO> LoginDTOList = new ArrayList<LoginDTO>();

	public String execute(){
		String ret = ERROR;

		TestDAO dao = new TestDAO();
		int count = dao.insert(username, password);

		if(count > 0){
			ret = SUCCESS;
		} else {
			ret = ERROR;
		}

		LoginDTOList = dao.select(username, password);

		return ret;
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

	public List<LoginDTO> getLoginDTOList() {
		return this.LoginDTOList;
	}
	public void setLoginDTOList(List<LoginDTO> LoginDTOList) {
		this.LoginDTOList = LoginDTOList;
	}



}
