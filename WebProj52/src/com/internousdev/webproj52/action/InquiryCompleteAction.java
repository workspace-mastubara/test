package com.internousdev.webproj52.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webproj52.dao.InquiryDAO;
import com.internousdev.webproj52.dto.InquiryDTO;
import com.opensymphony.xwork2.ActionSupport;


public class InquiryCompleteAction extends ActionSupport implements SessionAware{
	private String name;
	private String qtype;
	private String body;
	private List<InquiryDTO> inquiryDTOList = new ArrayList<InquiryDTO>();
	private Map<String, Object> session;

	public String execute(){
		String ret = ERROR;

		InquiryDAO dao = new InquiryDAO();
		int count = dao.insert(name,qtype,body);

		if(count > 0){
			inquiryDTOList = dao.select();
			session.put("inquiryDTOList", inquiryDTOList);
			ret = SUCCESS;
		}
		return ret;
	}

	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}

	public String getQtype(){
		return this.qtype;
	}
	public void setQtype(String qtype){
		this.qtype = qtype;
	}

	public String getBody(){
		return this.body;
	}
	public void setBody(String body){
		this.body = body;
	}

	public Map<String, Object> getSession(){
		return this.session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}