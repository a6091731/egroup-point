package com.epoint.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.epoint.webapp.dao.ProductSalesDAO;
import com.epoint.webapp.entity.ProductSales;
import com.epoint.webapp.util.DateConversion;

public class ProductSalesDAOImpl implements ProductSalesDAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	private String sql;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insertProductSales(ProductSales productSales) {
		// TODO Auto-generated method stub
		sql = "INSERT INTO product_sales (memberAccount, productID, productSalesDate, productSalesQuantity) "
				+ "VALUES (?, ?, ?, ?)";
		try {			
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1,productSales.getAccount());
			smt.setString(2,productSales.getId());
			smt.setString(3,productSales.getDate_string());
			smt.setInt(4,productSales.getQuantity());
			smt.executeUpdate();			
			smt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	public List<ProductSales> getProductSalesListByMemberID(ProductSales productSales1) {
		// TODO Auto-generated method stub
		List<ProductSales> productSalesList = new ArrayList<ProductSales>();
		sql = "SELECT * FROM product_sales WHERE memberAccount = ? AND productID = ?";		
		try {
			DateConversion dateConversion = new DateConversion();
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);			
			smt.setString(1, productSales1.getAccount());
			smt.setString(2, productSales1.getId());
			rs = smt.executeQuery();
			while(rs.next()){
				ProductSales productSales2 = new ProductSales();
				productSales2.setAccount(productSales1.getAccount());
				productSales2.setId(productSales1.getId());
				try {					
					productSales2.setDate_string(dateConversion.ConversionYM(rs.getDate("productSalesDate")));	
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				productSales2.setQuantity(rs.getInt("productSalesQuantity"));				
				productSalesList.add(productSales2);
			}			
			rs.close();
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return productSalesList;
	}

	public void updateProductSales(ProductSales productSales) {
		// TODO Auto-generated method stub
		sql = "UPDATE product_sales SET memberAccount = ?, productID = ?, productSalesDate = ?, productSalesQuantity = ? "
				+ "WHERE memberAccount= ? AND productID = ? AND productSalesDate = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, productSales.getAccount());
			smt.setString(2, productSales.getId());
			smt.setString(3,productSales.getDate_string());
			smt.setInt(4,productSales.getQuantity());
			smt.setString(5,productSales.getAccount());
			smt.setString(6,productSales.getId());
			smt.setString(7,productSales.getDate_string());
			smt.executeUpdate();	
			rs.close();
			smt.close(); 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	public boolean checkProductSalesByMember(ProductSales productSales) {
		// TODO Auto-generated method stub
		sql = "SELECT * FROM product_sales WHERE memberAccount = ? AND productID = ? AND productSalesDate = ?";		
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);			
			smt.setString(1, productSales.getAccount());
			smt.setString(2, productSales.getId());
			smt.setString(2, productSales.getDate_string());
			rs = smt.executeQuery();
			while(rs.next()){
				return true;
			}			
			rs.close();
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return false;
	}
}
