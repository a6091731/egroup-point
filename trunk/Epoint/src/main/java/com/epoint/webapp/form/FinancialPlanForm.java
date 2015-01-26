package com.epoint.webapp.form;

import java.util.List;

import com.epoint.webapp.entity.FinancialPlan;

public class FinancialPlanForm {
	private int lackMoney;
	private List<FinancialPlan> dynamicPlans;
	private List<FinancialPlan> usesPlans;
	private List<FinancialPlan> sourcePlans;
	private List<FinancialPlan> deletedPlans;
	
	public int getLackMoney() {
		return lackMoney;
	}
	public void setLackMoney(int lackMoney) {
		this.lackMoney = lackMoney;
	}
	public List<FinancialPlan> getDynamicPlans() {
		return dynamicPlans;
	}
	public void setDynamicPlans(List<FinancialPlan> dynamicPlans) {
		this.dynamicPlans = dynamicPlans;
	}
	public List<FinancialPlan> getUsesPlans() {
		return usesPlans;
	}
	public void setUsesPlans(List<FinancialPlan> usesPlans) {
		this.usesPlans = usesPlans;
	}
	public List<FinancialPlan> getSourcePlans() {
		return sourcePlans;
	}
	public void setSourcePlans(List<FinancialPlan> sourcePlans) {
		this.sourcePlans = sourcePlans;
	}
	public List<FinancialPlan> getDeletedPlans() {
		return deletedPlans;
	}
	public void setDeletedPlans(List<FinancialPlan> deletedPlans) {
		this.deletedPlans = deletedPlans;
	}
}
