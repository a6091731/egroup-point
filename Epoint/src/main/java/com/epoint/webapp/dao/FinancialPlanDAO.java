package com.epoint.webapp.dao;

import java.util.List;

import com.epoint.webapp.entity.FinancialPlan;

public interface FinancialPlanDAO {
	public void addFinancialPlan(FinancialPlan financialPlan);
	public void modiFinancialPlan(FinancialPlan financialPlan);
	public void delFinancialPlan(FinancialPlan financialPlan);
	public int getRecordByProperty(String account, int itemProperty);
	public List<FinancialPlan> getFinancialPlansByItemID(String account, int itemProperty);
}
