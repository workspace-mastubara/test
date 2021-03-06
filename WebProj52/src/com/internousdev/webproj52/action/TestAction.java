package com.internousdev.webproj52.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webproj52.dao.TestDAO;
import com.internousdev.webproj52.dto.TestDTO;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport implements SessionAware {
	private String name;
	private String password;
	private List<TestDTO> testDTOList = new ArrayList<TestDTO>();
	private Map<String, Object> session;

	public String execute(){
		String ret = ERROR;

		TestDAO dao = new TestDAO();
		int count = dao.insert(name, password);

		if(count > 0){
			ret = SUCCESS;
		} else {
			ret = ERROR;
		}

		testDTOList = dao.select(name, password);
		session.put("testDTOList", testDTOList);

		return ret;
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

	public Map<String, Object> getSession(){
		return this.session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
