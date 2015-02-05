package com.epoint.webapp.dao;

import java.util.List;

import com.epoint.webapp.entity.Member;
import com.epoint.webapp.entity.PayMoney;

public interface PayMoneyDAO {
	public void addPayMoney(PayMoney paymoney);
	public void modiPayMoney(PayMoney paymoney);
	public void delPayMoney(PayMoney paymoney);
	public void delPayMoneyByDate(String account, String startDate, String endDate);
	public int getPayRecord(String account, int itemID);
	public List<PayMoney> getPayMoneyByItemID(String account, int itemID);
	public List<PayMoney> getPayMoneyBySubClassStatus(String account, int subClass, int status);
	public PayMoney getSinglePayMoneyByItemID(String account, int itemID);
	public int getMonthlyCostByAccount(String account);
	public List<PayMoney> getMonthTotalMoneyByAccount(String account);
	public List<PayMoney> getMonthTotalMoneyBySubClassID(String account,String date);
	public double getVentureCapitalPercent(Member member); 
	public int getVentureCapitalYearExpenditure(Member member);
}
