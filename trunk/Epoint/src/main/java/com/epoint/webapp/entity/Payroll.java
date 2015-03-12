package com.epoint.webapp.entity;

public class Payroll {
	private String account;
	private int itemID;
	private int periodID;
	private int payroll;
	private int trainingFee;
	private int employeeRecord;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public int getPeriodID() {
		return periodID;
	}
	public void setPeriodID(int periodID) {
		this.periodID = periodID;
	}
	public int getPayroll() {
		return payroll;
	}
	public void setPayroll(int payroll) {
		this.payroll = payroll;
	}
	public int getTrainingFee() {
		return trainingFee;
	}
	public void setTrainingFee(int trainingFee) {
		this.trainingFee = trainingFee;
	}
	public int getEmployeeRecord() {
		return employeeRecord;
	}
	public void setEmployeeRecord(int employeeRecord) {
		this.employeeRecord = employeeRecord;
	}
	
	
}
