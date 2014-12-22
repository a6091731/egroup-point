package com.epoint.webapp.entity;

public class MapClass {
	private int id;
	private int classID;
	String name;
	
	public int getID(){
		return id;
	}
	
	public void setID(int id){
		this.id=id;
	}
	
	public int getClassID(){
		return classID;
	}
	
	public void setClassID(int classID){
		this.classID = classID;
	}
	
	public String getname(){
		return name;
	}
	
	public void setname(String name){
		this.name = name;
	}
}
