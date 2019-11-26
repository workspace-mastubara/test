package com.internousdev.login.action;

import java.sql.SQLException;

import com.internousdev.login.dao.LoginDAO;
import com.internousdev.login.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String name;
	private String password;

	public String execute() throws SQLException {
		String ret = ERROR ;

		LordingDAO dao = new LoginDAO();
		LordingDTO dto = new LoginDTO();

		dto = dao.select(name, password);

		if(name == dto.getName()) {
			if(password == dto.getPassword()) {
				ret = SUCCESS ;
			}
		}

		return ret;
	}

	public void getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}