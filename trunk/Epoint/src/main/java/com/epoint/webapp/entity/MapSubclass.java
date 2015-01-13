package com.epoint.webapp.entity;


public class MapSubclass {
	private int classID;
	private int subclassID;
	private String name;
	
	//程式變數
	private String content;
	private int now;
	
	public int getClassID(){
		return classID;
	}
	
	public void setClassID(int classID){
		this.classID = classID;
	}
	
	public int getSubclassID(){
		return subclassID;
	}
	
	public void setSubclassID(int subclassID){
		this.subclassID = subclassID;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public int getNow() {
		return now;
	}

	public void setNow(int now) {
		this.now = now;
	}
}
