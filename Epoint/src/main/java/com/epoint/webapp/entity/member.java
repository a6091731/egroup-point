package com.epoint.webapp.entity;

import java.sql.Date;


public class member {
	private String account;
	private String password;
	private String name;
	private String phone;
	private boolean status;
	private Date date;
	
	public String getAccount(){
		return account;
	}
	
	public void setAccount (String account){
		this.account = account;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getName(String name){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	public boolean isStatus(){
		return status;
	}
	
	public void setStatus(boolean status){
		this.status = status;
	}
	
	public Date getDate(){
		return date;
	}
	
	public void setDate(Date date){
		this.date = date;
	}
	
}
