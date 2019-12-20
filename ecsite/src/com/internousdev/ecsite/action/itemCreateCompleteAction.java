package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.itemCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class itemCreateCompleteAction extends ActionSupport implements SessionAware{

	private int count = 0;
	private Map<String, Object> session;

	public String execute(){
		String res = ERROR;

		itemCreateCompleteDAO itemCreateDAO = new itemCreateCompleteDAO();
		count = itemCreateDAO.itemCreate(session.get("itemName").toString(),
				Integer.parseInt(session.get("itemPrice").toString()),
				Integer.parseInt(session.get("itemStock").toString()));

		if(count > 0){
			res = SUCCESS;
		}
		return res;
	}




	public Map<String, Object> getSession(){
		return this.session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}


}
