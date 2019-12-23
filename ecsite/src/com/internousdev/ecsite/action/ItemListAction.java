package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport{
	private ItemListDAO dao = new ItemListDAO();
	private List<ItemInfoDTO> dtoList = new ArrayList<ItemInfoDTO>();

	public String execute(){
		dtoList = dao.getItemInfo();

		return SUCCESS;
	}

	public List<ItemInfoDTO> getDtoList(){
		return this.dtoList;
	}
	public void setDtoList(List<ItemInfoDTO> dtoList){
		this.dtoList = dtoList;
	}



}
