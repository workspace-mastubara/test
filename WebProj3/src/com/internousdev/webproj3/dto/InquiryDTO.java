package com.internousdev.webproj3.dto;

public class InquiryDTO {
	private String name;
	private String qtype;
	private String body;


	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}

	public String getQtype(){
		return this.qtype;
	}
	public void setQtype(String qtype){
		this.qtype = qtype;
	}

	public String getBody(){
		return this.body;
	}
	public void setBody(String body){
		this.body = body;
	}

}
