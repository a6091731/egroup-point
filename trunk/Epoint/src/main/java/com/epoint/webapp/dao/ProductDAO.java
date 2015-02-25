package com.epoint.webapp.dao;

import java.util.List;

import com.epoint.webapp.entity.Member;
import com.epoint.webapp.entity.Product;

public interface ProductDAO {
	//insert
	public void insertProduct1(Product product);
	public String insertProduct2(Product product);
	//get
	public List<Product> getProductList (Member member,int start, int size);
	public List<Product> getProductListSum (Member member,int start, int size);
	public int countProductByMember(Member member);
	public List<Product> getAllProductList(Member member);
	//update
	public void updateProduct(Product product);
	//del
	public void delProduct(Product product);
	//check
	public boolean checkProductByMember(Member member);
	
	
	
	
	
	
	
	
}
