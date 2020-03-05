package com.practice.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.practice.dao.UserInfoDAO;
import com.practice.dto.UserInfoDTO;

public class MyPageAction extends ActionSupport implements SessionAware{
	private UserInfoDTO userInfoDTO = new UserInfoDTO();
	private Map<String, Object>session;

	public String execute(){
		String res = SUCCESS;

		String userId = String.valueOf(session.get("userId"));
		String tempLogined = String.valueOf(session.get("logined"));
		int logined = "null".equals(tempLogined)? 0 : Integer.parseInt(tempLogined);
		if(logined == 0) {
			res =  "loginError";
		}

		//ログインしなくても仮IDが配られるので条件(if)なし

		UserInfoDAO userInfoDAO = new UserInfoDAO();
		userInfoDTO = userInfoDAO.getUserInfo(userId);

		return res;
	}

	public UserInfoDTO getUserInfoDTO() {
		return this.userInfoDTO;
	}

	public void setUserInfoDTO(UserInfoDTO userInfoDTO) {
		this.userInfoDTO = userInfoDTO;
	}

	public Map<String,Object> getSession(){
		return this.session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
