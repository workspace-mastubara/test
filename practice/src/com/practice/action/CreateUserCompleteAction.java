package com.practice.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.practice.dao.UserInfoDAO;

public class CreateUserCompleteAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;
		String sex = null;
		if ("女性".equals(String.valueOf(session.get("sex")))) {
			sex = "1";
		} else {
			sex = "0";
		}

		UserInfoDAO userInfoDAO = new UserInfoDAO();
		int count = userInfoDAO.createUser(
				session.get("userIdForCreateUser").toString(),//詰まっているのはuserId
				session.get("password").toString(),
				session.get("familyName").toString(),
				session.get("firstName").toString(),
				session.get("familyNameKana").toString(),
				session.get("firstNameKana").toString(),
				sex,
				session.get("email").toString());

		if (count > 0) {
			result = SUCCESS;
			session.put("createUserFlg", 1);
		}

		session.remove("familyName");
		session.remove("firstName");
		session.remove("familyNameKana");
		session.remove("firstNameKana");
		session.remove("sex");
		session.remove("sexList");
		session.remove("email");
		session.remove("password");
		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}