package com.internous.mypage.action;

import java.util.Map;

import com.internous.mypage.dao.UserInfoDAO;
import com.internous.mypage.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport {
	private String userId;
	private int loginFlg;
	private UserInfoDTO userInfoDTO = new UserInfoDTO();
	private Map<String, Object>session;

	public String execute(){


		String res = null;
		/*String temporaryUserId = String.valueOf(session.get("randomId"));*/
		/*loginFlg = Integer.parseInt(session.get("loginFrg").toString());
*/

		/*if("null".equals(temporaryUserId)  &&  loginFlg == 0) {
			res = "loginError";
		}*/


		//ログインしなくても仮IDが配られるので条件(if)なし

		UserInfoDAO userInfoDAO = new UserInfoDAO();
		userInfoDTO = userInfoDAO.getUserInfo(userId);

		res = SUCCESS;

		return res;
	}


	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}


	public int getLoginFlg(){
		return this.loginFlg;
	}
	public void setLoginFlg(int loginFlg){
		this.loginFlg = loginFlg;
	}


	public UserInfoDTO getUserInfoDTO() {
		return this.userInfoDTO;
	}
	public void setUserInfoDTO(UserInfoDTO userInfoDTO) {
		this.userInfoDTO = userInfoDTO;
	}


	public Map<String,Object> getSession() {
		return session;
	}
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}


}
