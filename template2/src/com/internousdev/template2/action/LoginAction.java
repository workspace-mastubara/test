package com.internousdev.template2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template2.dao.BuyItemDAO;
import com.internousdev.template2.dao.LoginDAO;
import com.internousdev.template2.dto.BuyItemDTO;
import com.internousdev.template2.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private String loginId;
	private String loginPass;
	private String result;
	private Map<String, Object>session;


	public String execute(){
		result = ERROR;
		LoginDAO lDao = new LoginDAO();
		LoginDTO lDto = new LoginDTO();
		BuyItemDAO bDao = new BuyItemDAO();

		lDto = lDao.getLoginUserInfo(loginId, loginPass);
		session.put("loginUser", lDto);

		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
			result = SUCCESS;
			BuyItemDTO bDto = bDao.getBuyItemInfo();

			session.put("login_user_id", lDto.getLoginId());
			session.put("id", bDto.getId());
			session.put("buyItem_name", bDto.getItemName());
			session.put("buyItem_price", bDto.getItemPrice());
		}
		return result;
	}


	public String getLoginId(){
		return this.loginId;
	}
	public void setLoginId(String loginId){
		this.loginId = loginId;
	}

	public String getLoginPass(){
		return this.loginPass;
	}
	public void setLoginPass(String loginPass){
		this.loginPass = loginPass;
	}

	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}



}
