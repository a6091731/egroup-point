package com.epoint.webapp.entity;

public class HumanResourceContent {
	int periodID;
	int itemID;
	String account;
	int content;
	
	public int getPeriodID(){
		return periodID;
	}
	
	public void setPeriodID(int periodID){
		this.periodID = periodID;
	}
	
	public int getItemID(){
		return itemID;
	}
	
	public void setItemID(int itemID){
		this.itemID = itemID;
	}
	
	public String getAccount(){
		return account;
	}
	
	public void setAccount(String account){
		this.account = account;
	}
	
	public int getContent(){
		return content;
	}
	
	public void setContent(int content){
		this.content = content;
	}
}
