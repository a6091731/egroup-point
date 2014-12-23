package com.epoint.webapp.entity;

public class PayItem {
	private int subclassID;
	private int itemID;
	private String name;
	private int status;
	
	public int getSubclassID(){
		return subclassID;
	}
	
	public void setSubclassID(int subclassID){
		this.subclassID = subclassID;
	}
	
	public int getItemID(){
		return itemID;
	}
	
	public void setItemID(int itemID){
		this.itemID = itemID;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getStatus(){
		return status;
	}
	
	public void setStatus(int status){
		this.status = status;
	}
}
