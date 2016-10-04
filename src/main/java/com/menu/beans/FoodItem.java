package com.menu.beans;

import org.apache.commons.lang.StringUtils;

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
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(itemName).append(":").append(itemType);
		return str.toString();
	}
	
}
