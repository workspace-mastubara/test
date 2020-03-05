package com.practice.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.practice.dao.DestinationInfoDAO;
import com.practice.dto.DestinationInfoDTO;

public class SettlementConfirmAction extends ActionSupport implements SessionAware {

	private List<DestinationInfoDTO> destinationInfoDTOList = new ArrayList<DestinationInfoDTO>();
	private String userId;
	private Map<String, Object> session;

	public String execute() throws SQLException{

		String tempLogined = String.valueOf(session.get("logined"));
		int logined = "null".equals(tempLogined)? 0 : Integer.parseInt(tempLogined);
		if(logined != 1) {
			return "loginError";
		}

		//userIdを元に宛先情報を取得
		DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
		destinationInfoDTOList  = destinationInfoDAO.getDestinationInfo(userId);

		return SUCCESS;

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<DestinationInfoDTO> getDestinationInfoDTOList() {
		return destinationInfoDTOList;
	}

	public void setDestinationInfoDTOList(List<DestinationInfoDTO> destinationInfoDTOList) {
		this.destinationInfoDTOList = destinationInfoDTOList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
