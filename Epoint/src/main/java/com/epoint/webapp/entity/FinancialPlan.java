package com.epoint.webapp.entity;

public class FinancialPlan {
	private String account;
	private int needs;
	private String payItem;
	private int pay;
	private String incomeItem;
	private int income;
	
	public String getAccount(){
		return account;
	}
	
	public void setAccount(String account){
		this.account = account;
	}
	
	public int getNeeds(){
		return needs;
	}
	
	public void setNeeds(int needs){
		this.needs = needs;
	}
	
	public String getPayItem(){
		return payItem ;
	}
	
	public void setPayItem(String payItem){
		this.payItem = payItem;
	}
	
	public int getPay(){
		return pay;
	}
	
	public void setPay(int pay){
		this.pay = pay;
	}
	
	public String getIncomeItem(){
		return incomeItem;
	}
	
	public void setIncomeItem(String incomeItem){
		this.incomeItem = incomeItem;
	}
	
	public int getIncome(){
		return income;
	}
	
	public void setIncome(int income){
		this.income = income;
	}
	
}
