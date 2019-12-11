package com.internousdev.webproj52.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webproj52.dao.LoginDAO;
import com.internousdev.webproj52.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport implements SessionAware{
	private List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();
	private Map<String, Object> session;
	private String username;
	private String password;

	public String execute(){
		String ret = ERROR;
		System.out.println(username);
		System.out.println(password);

		LoginDAO dao = new LoginDAO();
		loginDTOList = dao.select(username, password);

		if(this.username.equals(loginDTOList.get(0).getUsername()) &&
				this.password.equals(loginDTOList.get(0).getPassword())){

			session.put("loginDTOList", loginDTOList);
			ret = SUCCESS;
		} else {
			session.put("loginDTOList", loginDTOList);
			ret = ERROR;
		}

		return ret;
	}



	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username = username;
	}

	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}

	public Map<String, Object> getSession(){
		return this.session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
