package com.epoint.webapp.dao;

import java.util.List;

import com.epoint.webapp.entity.Member;
import com.epoint.webapp.entity.PayMoney;

public interface PayMoneyDAO {
	//insert
	public void addPayMoney(PayMoney paymoney);
	//modi
	public void modiPayMoney(PayMoney paymoney);
	//del
	public void delPayMoney(PayMoney paymoney);
	public void delPayMoneyByDate(String account, String startDate, String endDate);
	//get
	public int getPayRecord(String account, int itemID);
	public List<PayMoney> getPayMoneyByItemID(String account, int itemID);
	public List<PayMoney> getPayMoneyBySubClassStatus(String account, int subClass, int status);
	public PayMoney getSinglePayMoneyByItemID(String account, int itemID);
	public int getMonthlyCostByAccount(String account);
	public List<PayMoney> getTotalExpenditureByAccount(String account);
	public List<PayMoney> getMonthTotalMoneyBySubclassID(String account,String date);
	public double getVentureCapitalPercent(Member member); 
	public int getVentureCapitalYearExpenditure(Member member);
	//check
	public boolean checkPayMoneyByMember(Member member);
}
