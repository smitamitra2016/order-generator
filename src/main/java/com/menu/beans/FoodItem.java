package com.menu.beans;

public class FoodItem {

	private String itemName;
	private String itemType;
	private String timeToPrepare;

	public String getTimeToPrepare() {
		return timeToPrepare;
	}

	public void setTimeToPrepare(String timeToPrepare) {
		this.timeToPrepare = timeToPrepare;
	}

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

	public FoodItem(String itemName, String itemType, String timeToPrepare) {
		super();
		this.itemName = itemName;
		this.itemType = itemType;
		this.timeToPrepare = timeToPrepare;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(itemName).append(":").append(itemType).append(":").append(timeToPrepare);
		return str.toString();
	}

}
