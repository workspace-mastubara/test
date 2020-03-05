package com.practice.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.practice.dao.UserInfoDAO;
import com.practice.util.CommonUtility;
import com.practice.util.InputChecker;

public class CreateUserConfirmAction extends ActionSupport implements SessionAware {
	private List<String> errorFamilyName;
	private List<String> errorFirstName;
	private List<String> errorFamilyNameKana;
	private List<String> errorFirstNameKana;
	private List<String> errorEmail;
	private List<String> errorUserId;
	private List<String> errorPassword;

	//データ持ち運ぶ用
	private Map<String, Object> session;

	//コンファーム画面に出力する用
	private String userId;
	private String password;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private String email;
	private String registError;

	public String execute() {
		InputChecker ic = new InputChecker();
		String result = ERROR;
		session.put("familyName", familyName);
		session.put("firstName", firstName);
		session.put("familyNameKana", familyNameKana);
		session.put("firstNameKana", firstNameKana);
		session.put("sex", sex);
		session.put("email", email);
		session.put("userIdForCreateUser", userId);
		session.put("password", password);

		//List型
		errorFamilyName = ic.doCheck("姓", familyName, 1, 16, true, true, true, false, true, false);
		errorFirstName = ic.doCheck("名", firstName, 1, 16, true, true, true, false, true, false);
		errorFamilyNameKana = ic.doCheck("姓ふりがな", familyNameKana, 1, 16, false, false, true, false, false, false);
		errorFirstNameKana = ic.doCheck("名ふりがな", firstNameKana, 1, 16, false, false, true, false, false, false);
		errorEmail = ic.doCheckForEmail(email);
		errorUserId = ic.doCheck("ユーザーID", userId, 1, 8, true, false, false, true, false, false);
		errorPassword = ic.doCheck("パスワード", password, 1, 16, true, false, false, true, false, false);

		if (errorFamilyName.size() > 0
				|| errorFirstName.size() > 0
				|| errorFamilyNameKana.size() > 0
				|| errorFirstNameKana.size() > 0
				|| errorEmail.size() > 0
				|| errorUserId.size() > 0
				|| errorPassword.size() > 0) {
			return result;
		}

		UserInfoDAO userInfoDAO = new UserInfoDAO();
		if (userInfoDAO.countUserId(userId)) {
			registError = "使用できないユーザーIDです。";

		} else {
			CommonUtility commonUtility = new CommonUtility();
			//コンプリート画面に出力の際、2～16文字目を＊＊＊表示にする
			password = commonUtility.concealPassword(password);

			result = SUCCESS;

		}

		return result;

	}

	public String getRegistError() {
		return registError;
	}

	public void setRegistError(String registError) {
		this.registError = registError;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyNameKana() {
		return familyNameKana;
	}

	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}

	public String getFirstNameKana() {
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setErrorFamilyName(List<String> errorFamilyName) {
		this.errorFamilyName = errorFamilyName;
	}

	public List<String> getErrorFamilyName() {
		return this.errorFamilyName;
	}

	public void setErrorFirstName(List<String> errorFirstName) {
		this.errorFirstName = errorFirstName;
	}

	public List<String> getErrorFirstName() {
		return this.errorFirstName;
	}

	public void setErrorFamilyNameKana(List<String> errorFamilyNameKana) {
		this.errorFamilyNameKana = errorFamilyNameKana;
	}

	public List<String> getErrorFamilyNameKana() {
		return this.errorFamilyNameKana;
	}

	public void setErrorFirstNameKana(List<String> errorFirstNameKana) {
		this.errorFirstName = errorFirstNameKana;
	}

	public List<String> getErrorFirstNameKana() {
		return this.errorFirstNameKana;
	}

	public void setErrorEmail(List<String> errorEmail) {
		this.errorEmail = errorEmail;
	}

	public List<String> getErrorEmail() {
		return this.errorEmail;
	}

	public void setErrorUserId(List<String> errorUserId) {
		this.errorUserId = errorUserId;
	}

	public List<String> getErrorUserId() {
		return this.errorUserId;
	}

	public void setErrorPassword(List<String> errorPassword) {
		this.errorPassword = errorPassword;
	}

	public List<String> getErrorPassword() {
		return this.errorPassword;
	}

}