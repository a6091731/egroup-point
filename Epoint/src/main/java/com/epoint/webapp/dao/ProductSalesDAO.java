package com.epoint.webapp.dao;

import java.util.List;

import com.epoint.webapp.entity.Member;
import com.epoint.webapp.entity.PayMoney;
import com.epoint.webapp.entity.ProductSales;

public interface ProductSalesDAO {
	public void insertProductSales(ProductSales productSales);
	public List<ProductSales> getProductSalesListByMemberID(ProductSales productSales);
	public boolean checkProductSalesByMember(ProductSales productSales);
	public void updateProductSales(ProductSales productSales);
	public void delProductSalesByMember(ProductSales productSales);
	public int getVentureCapitalYearIncome(Member member);
	public List<ProductSales> getMonTotalIncomeByAccoun(String account);
	public List<ProductSales> getMonthTotalIncomeBySubClassID(String account,String date);
}
