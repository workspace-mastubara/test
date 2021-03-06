package com.internousdev.webproj4.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj4.dao.InquiryCompleteDAO;
import com.internousdev.webproj4.dto.InquiryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class InquiryCompleteAction extends ActionSupport{
	private String name;
	private String qtype;
	private String body;
	private List<InquiryDTO> InquiryDTOList = new ArrayList<InquiryDTO>();

	public String execute(){
		String ret = ERROR;

		InquiryCompleteDAO dao = new InquiryCompleteDAO();
		int count = dao.insert(name, qtype, body);

		if(count > 0){
			InquiryDTOList = dao.select();
			ret = SUCCESS;
		} else {
			ret = ERROR;
		}
		return ret;
	}

	public String getName(){
		return this.name;
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

	public List<InquiryDTO> getInquiryDTOList(){
		return this.InquiryDTOList;
	}
	public void setInquiryDTOList(List<InquiryDTO> InquiryDTOList){
		this.InquiryDTOList = InquiryDTOList;
	}


}
