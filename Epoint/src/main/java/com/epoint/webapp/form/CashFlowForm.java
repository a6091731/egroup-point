package com.epoint.webapp.form;

import java.util.List;

import com.epoint.webapp.entity.PayItem;
import com.epoint.webapp.entity.PayMoney;

public class CashFlowForm {
	private int[] listCount;
	private List<PayItem> payItemList;
	private List<PayMoney> payMoneyList;
	
	public int[] getListCount() {
		return listCount;
	}
	public void setListCount(int[] listCount) {
		this.listCount = listCount;
	}
	public List<PayItem> getPayItemList() {
		return payItemList;
	}
	public void setPayItemList(List<PayItem> payItemList) {
		this.payItemList = payItemList;
	}
	public List<PayMoney> getPayMoneyList() {
		return payMoneyList;
	}
	public void setPayMoneyList(List<PayMoney> payMoneyList) {
		this.payMoneyList = payMoneyList;
	}
}
