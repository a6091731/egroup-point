package com.epoint.webapp.dao;

import java.util.List;

import com.epoint.webapp.entity.Member;
import com.epoint.webapp.entity.Product;

public interface ProductDAO {
	public void insetProduct(Product product);
	public List<Product> getProductList (Member member,int start, int size);
	public List<Product> getProductListSum (Member member,int start, int size);
	public void updateProduct(Product product);
	public int countProductByMember(Member member);
}
