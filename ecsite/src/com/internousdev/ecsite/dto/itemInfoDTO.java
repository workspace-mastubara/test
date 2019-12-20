package com.internousdev.ecsite.dto;

public class itemInfoDTO {
	private String itemName;
	private int itemPrice;
	private int itemStock;


	public String getItemName(){
		return this.itemName;
	}
	public void setItemName(String itemName){
		this.itemName = itemName;
	}

	public int getItemPrice(){
		return this.itemPrice;
	}
	public void setItemPrice(int itemPrice){
		this.itemPrice = itemPrice;
	}

	public int getItemStock(){
		return this.itemStock;
	}
	public void setItemStock(int itemStock){
		this.itemStock = itemStock;
	}



}
