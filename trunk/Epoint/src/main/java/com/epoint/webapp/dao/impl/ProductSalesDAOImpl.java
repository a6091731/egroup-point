package com.epoint.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.epoint.webapp.dao.ProductSalesDAO;
import com.epoint.webapp.entity.Member;
import com.epoint.webapp.entity.Product;
import com.epoint.webapp.entity.ProductSales;

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
		sql = "INSERT INTO product_sales(memberAccount,productID,productSalesDate, "
				+ "productSalesQuantity) SELECT ?,?,?,? FROM member";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1,productSales.getAccount());
			smt.setString(2,productSales.getId());
			smt.setDate(3,productSales.getDate());
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
}
