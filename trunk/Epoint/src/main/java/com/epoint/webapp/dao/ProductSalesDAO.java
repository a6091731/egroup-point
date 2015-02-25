package com.epoint.webapp.dao;

import java.util.List;

import com.epoint.webapp.entity.Member;
import com.epoint.webapp.entity.PayMoney;
import com.epoint.webapp.entity.ProductSales;

public interface ProductSalesDAO {
	//insert
	public void insertProductSales(ProductSales productSales);
	//del
	public void delProductSalesByMember(ProductSales productSales);
	public void delProductSalesByMemberDate(String account, String startDate, String endDate);
	//get
	public List<ProductSales> getProductSalesListByMemberID(ProductSales productSales);
	public long getVentureCapitalYearIncome(Member member);
	public List<ProductSales> getMonTotalIncomeByAccoun(String account);
	public List<ProductSales> getMonthTotalIncomeByMemberDate(String account,String date);
	//update
	public void updateProductSales(ProductSales productSales);
	//check	
	public boolean checkProductSalesByMember(ProductSales productSales);
	public boolean checkProductSalesByMember(Member member);	
}
