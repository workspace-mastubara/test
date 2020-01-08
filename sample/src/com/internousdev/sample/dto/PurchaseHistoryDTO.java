package com.internousdev.sample.dto;

public class PurchaseHistoryDTO {
	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String releaseCompany;
	private String releaseDate;
	private int price;
	private int totalCount;
	private String firstName;
	private String familyName;
	private String userAddress;


	public String getProductName() {
		return this.productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductNameKana() {
		return this.productNameKana;
	}
	public void setProductNameKana(String productNameKana) {
		this.productNameKana = productNameKana;
	}


	public String getImageFilePath() {
		return this.imageFilePath;
	}
	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}


	public String getReleaseCompany() {
		return this.releaseCompany;
	}
	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
	}


	public String getReleaseDate() {
		return this.releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}


	public int getPrice() {
		return this.price;
	}
	public void setPrice(int price) {
		this.price = price;
	}


	public int getTotalCount() {
		return this.totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getFamilyName() {
		return this.familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}


	public String getUserAddress() {
		return this.userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

}
