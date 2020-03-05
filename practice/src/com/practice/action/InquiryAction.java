package com.practice.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.practice.dao.AskQuestionDAO;
import com.practice.dao.InquiryDAO;
import com.practice.dto.AskQuestionDTO;
import com.practice.dto.InquiryDTO;

public class InquiryAction extends ActionSupport implements SessionAware{
	private int inquiryFlg;
	private Map<String, Object>session;
	private List<InquiryDTO> inquiryDTOList = new ArrayList<InquiryDTO>();
	private List<AskQuestionDTO> askQuestionDTOList = new ArrayList<AskQuestionDTO>();

	public String execute() {
		//よくある質問リスト
		AskQuestionDAO askQuestionDAO = new AskQuestionDAO();
		askQuestionDTOList = askQuestionDAO.setAskQuestionList();

		//質問タイプリスト
		InquiryDAO inquiryDAO = new InquiryDAO();
		inquiryDTOList = inquiryDAO.setQTypeList();

		return SUCCESS;
	}

	public int getInquiryFlg() {
		return inquiryFlg;
	}

	public void setInquiryFlg(int inquiryFlg) {
		this.inquiryFlg = inquiryFlg;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<InquiryDTO> getInquiryDTOList() {
		return inquiryDTOList;
	}

	public void setInquiryDTOList(List<InquiryDTO> inquiryDTOList) {
		this.inquiryDTOList = inquiryDTOList;
	}

	public List<AskQuestionDTO> getAskQuestionDTOList() {
		return askQuestionDTOList;
	}

	public void setAskQuestionDTOList(List<AskQuestionDTO> askQuestionDTOList) {
		this.askQuestionDTOList = askQuestionDTOList;
	}
}
