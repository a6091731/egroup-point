package com.epoint.webapp.entity;

import java.sql.Date;

public class PayMoney {
	private String account;
	private int id;
	private Date date;
	private int money;
	private int record;
	
	public String getAccount(){
		return account;
	}
	
	public void setAccount(String account){
		this.account = account;
	}
	
	public int getID(){
		return id;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public Date getDate(){
		return date;
	}
	
	public void setDate(Date date){
		this.date = date;
	}
	
	public int getMoney(){
		return money;
	}
	
	public void setMoney(int money){
		this.money = money;
	}
	
	public int getRecord(){
		return record;
	}
	
	public void setRecord(int record){
		this.record = record;
	}
}
