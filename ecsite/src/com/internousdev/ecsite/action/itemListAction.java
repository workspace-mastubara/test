package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dao.itemListDAO;
import com.internousdev.ecsite.dto.itemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class itemListAction extends ActionSupport{
	private itemListDAO dao = new itemListDAO();
	private List<itemInfoDTO> dtoList = new ArrayList<itemInfoDTO>();

	public String execute(){
		dtoList = dao.getItemInfo();

		return SUCCESS;
	}

	public List<itemInfoDTO> getDtoList(){
		return this.dtoList;
	}
	public void setDtoList(List<itemInfoDTO> dtoList){
		this.dtoList = dtoList;
	}



}
