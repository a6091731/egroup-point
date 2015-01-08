package com.epoint.webapp.entity;

public class MapClass {
	//Table欄位
	private int id;
	private int classID;
	private String name;
	private String url;
	
	//程式變數
	private String account;
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public int getClassID(){
		return classID;
	}
	
	public void setClassID(int classID){
		this.classID = classID;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
	
}
