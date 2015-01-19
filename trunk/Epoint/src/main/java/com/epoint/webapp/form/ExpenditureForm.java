package com.epoint.webapp.form;

import java.util.List;

import com.epoint.webapp.entity.PayMoney;

public class ExpenditureForm {
	private String subClass;
	private List<PayMoney> fixedPayMoney;
	private String[] dynamicTypeCount;
	private List<PayMoney> dynamicPayMoney;
	private List<PayMoney> deletedPayMoney;
	
	public String getSubClass() {
		return subClass;
	}
	public void setSubClass(String subClass) {
		this.subClass = subClass;
	}
	public List<PayMoney> getFixedPayMoney() {
		return fixedPayMoney;
	}
	public void setFixedPayMoney(List<PayMoney> fixedPayMoney) {
		this.fixedPayMoney = fixedPayMoney;
	}
	public String[] getDynamicTypeCount() {
		return dynamicTypeCount;
	}
	public void setDynamicTypeCount(String[] dynamicTypeCount) {
		this.dynamicTypeCount = dynamicTypeCount;
	}
	public List<PayMoney> getDynamicPayMoney() {
		return dynamicPayMoney;
	}
	public void setDynamicPayMoney(List<PayMoney> dynamicPayMoney) {
		this.dynamicPayMoney = dynamicPayMoney;
	}
	public List<PayMoney> getDeletedPayMoney() {
		return deletedPayMoney;
	}
	public void setDeletedPayMoney(List<PayMoney> deletedPayMoney) {
		this.deletedPayMoney = deletedPayMoney;
	}
}
