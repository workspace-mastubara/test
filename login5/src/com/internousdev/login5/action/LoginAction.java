package com.internousdev.login5.action;

import java.sql.SQLException;

import com.internousdev.login5.dao.LoginDAO;
import com.internousdev.login5.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private String name;
	private String password;

	public String execute() throws SQLException{
		String res = ERROR;

		LoginDAO dao = new LoginDAO();
		LoginDTO dto = new LoginDTO();

		dto = dao.select(name, password);

		if(name.equals(dto.getName()) &&
				password.equals(dto.getPassword())){
			res = SUCCESS;
		}

		return res;
	}


	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password){
		this.password = password;
	}


}
