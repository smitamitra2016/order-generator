package com.menu.beans;

public class FoodItem {

	private String itemName;
	private String itemType;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public FoodItem(String itemName, String itemType) {
		super();
		this.itemName = itemName;
		this.itemType = itemType;
	}

}
