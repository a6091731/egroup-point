package com.epoint.webapp.dao;

import java.util.List;

import com.epoint.webapp.entity.ProductSales;

public interface ProductSalesDAO {
	public void insertProductSales(ProductSales productSales);
	public List<ProductSales> getProductSalesListByMemberID(ProductSales productSales);
	public boolean checkProductSalesByMember(ProductSales productSales);
	public void updateProductSales(ProductSales productSales);
}
