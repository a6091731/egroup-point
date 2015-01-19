package com.epoint.webapp.dao;

import java.util.List;

import com.epoint.webapp.entity.PayMoney;

public interface PayMoneyDAO {
	public void addPayMoney(PayMoney paymoney);
	public void modiPayMoney(PayMoney paymoney);
	public void delPayMoney(PayMoney paymoney);
	public int getPayRecord(String account, int itemID);
	public List<PayMoney> getPayMoneyByItemID(String account, int itemID);
	public List<PayMoney> getPayMoneyBySubClassStatus(String account, int subClass, int status);
	public PayMoney getSinglePayMoneyByItemID(String account, int itemID);
}
