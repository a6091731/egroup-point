package com.epoint.webapp.entity;

import java.util.Date;


public class ProductSales {
	private String account;
	private String id;
	private Date date;
	private int quantity;
	
	//程式控制
	private String date_string;
		
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDate_string() {
		return date_string;
	}
	public void setDate_string(String date_string) {
		this.date_string = date_string;
	}
	
}
