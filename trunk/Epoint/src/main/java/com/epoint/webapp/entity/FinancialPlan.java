package com.epoint.webapp.entity;

public class FinancialPlan {
	private String account;
	private int name;
	private String money;
	private String record;
	private int property;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	public int getProperty() {
		return property;
	}
	public void setProperty(int property) {
		this.property = property;
	}
}