package com.epoint.webapp.entity;

public class MapSubclass {
	private int classID;
	private int subclassID;
	String name;
	
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
}
