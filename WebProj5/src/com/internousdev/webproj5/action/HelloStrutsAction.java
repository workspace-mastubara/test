package com.internousdev.webproj5.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webproj5.dao.HelloDAO;
import com.internousdev.webproj5.dto.HelloDTO;
import com.opensymphony.xwork2.ActionSupport;


public class HelloStrutsAction extends ActionSupport implements SessionAware{
	private List<HelloDTO> HelloDTOList = new ArrayList<HelloDTO>();
	private Map<String, Object> session;

	public String execute(){
		String ret = ERROR;
		HelloDAO dao = new HelloDAO();

		HelloDTOList = dao.select();

		if(HelloDTOList.size() > 0){
			session.put("HelloDTOList", HelloDTOList);
			ret = SUCCESS;
		} else {
			ret = ERROR;
		}
		return ret;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
