package com.epoint.webapp.entity;

import java.sql.Date;

public class PayMoney {
	private String account;
	private int id;
	private Date date;
	private String date_string;
	private int money;
	private int record;
	private int monthTotal;
	private String subClassName;
	private int subClassID;
	
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

	public String getDate_string() {
		return date_string;
	}

	public void setDate_string(String date_string) {
		this.date_string = date_string;
	}

	public int getMonthTotal() {
		return monthTotal;
	}

	public void setMonthTotal(int monthTotal) {
		this.monthTotal = monthTotal;
	}

	public String getSubClassName() {
		return subClassName;
	}

	public void setSubClassName(String subClassName) {
		this.subClassName = subClassName;
	}

	public int getSubClassID() {
		return subClassID;
	}

	public void setSubClassID(int subClassID) {
		this.subClassID = subClassID;
	}
}
