package com.internousdev.webproj52.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webproj52.dao.HelloStrutsDAO;
import com.internousdev.webproj52.dto.HelloStrutsDTO;
import com.opensymphony.xwork2.ActionSupport;


public class HelloStrutsAction extends ActionSupport implements SessionAware{
	private List<HelloStrutsDTO> helloDTOList = new ArrayList<HelloStrutsDTO>();
	private Map<String, Object> session;


	public String execute(){
		String ret = ERROR;

		HelloStrutsDAO dao = new HelloStrutsDAO();
		helloDTOList = dao.select();

		if(helloDTOList.size() > 0){
			session.put("helloDTOList", helloDTOList);
			ret = SUCCESS;
		} else {
			ret = ERROR;
		}
		return ret;
	}


	public Map<String, Object> getSession(){
		return this.session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
