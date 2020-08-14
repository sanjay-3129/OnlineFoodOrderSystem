package com.foodorder.models;

public class Menu {
	
	private String itemId;
	private String itemName;
	private double itemPrice;
	private String itemType;
	private String itemImgPath;

	public Menu() {
		super();
	}

	public Menu(String itemId, String itemName, double itemPrice, String itemType, String itemImgPath) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemType = itemType;
		this.itemImgPath = itemImgPath;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemImgPath() {
		return itemImgPath;
	}

	public void setItemImgPath(String itemImgPath) {
		this.itemImgPath = itemImgPath;
	}

}
