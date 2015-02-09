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
import com.epoint.webapp.entity.Member;
import com.epoint.webapp.entity.PayMoney;
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
			smt.setString(3, productSales.getDate_string()+" 00:00:00");
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

	public void delProductSalesByMember(ProductSales productSales) {
		// TODO Auto-generated method stub
		sql = "DELETE FROM product_sales WHERE memberAccount = ? AND productID = ? ";
		try {			
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1,productSales.getAccount());
			smt.setString(2,productSales.getId());
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

	public long getVentureCapitalYearIncome(Member member) {
		// TODO Auto-generated method stub
		long yearIncome = 0;
		sql = "SELECT SUM((p.productSalesPrice-p.productCost)*IFNULL(s.productSalesQuantity,0)) AS yearIncome "
				+ "FROM product p LEFT JOIN product_sales s ON p.productID=s.productID WHERE p.memberAccount = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);			
			smt.setString(1, member.getAccount());
			rs = smt.executeQuery();
			while(rs.next()){
				yearIncome = rs.getLong("yearIncome");
				return yearIncome;
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
		return 0;
	}

	public List<ProductSales> getMonTotalIncomeByAccoun(String account) {
		// TODO Auto-generated method stub
		String sql = "SELECT SUM((p.productSalesPrice-p.productCost)*IFNULL(s.productSalesQuantity,0)) "
				+ "AS monthIncome,s.productSalesDate FROM  product_sales s LEFT JOIN product p ON "
				+ "p.memberAccount = s.memberAccount AND p.productID = s.productID WHERE s.memberAccount = ? "
				+ "GROUP BY productSalesDate";
		List<ProductSales> productSalesList = new ArrayList<ProductSales>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, account);
			rs = smt.executeQuery();
			while(rs.next()){
				ProductSales productSales = new ProductSales();
				productSales.setDate(rs.getDate("productSalesDate"));
				productSales.setMonthIncome(rs.getInt("monthIncome"));
				productSalesList.add(productSales);
			}
			rs.close();
			smt.close();
			return productSalesList;			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return null;
	}

	public List<ProductSales> getMonthTotalIncomeByMemberDate(String account,
			String date) {
		// TODO Auto-generated method stub
		String sql = "SELECT SUM((p.productSalesPrice-p.productCost)*IFNULL(s.productSalesQuantity,0)) "
				+ "AS monthIncome,s.productSalesDate ,p.productID ,p.productName FROM product p LEFT JOIN "
				+ "product_sales s ON p.memberAccount = s.memberAccount AND p.productID = s.productID "
				+ "WHERE s.memberAccount = ? AND s.productSalesDate LIKE ? "
				+ "GROUP BY s.productID";
		List<ProductSales> productSalesList = new ArrayList<ProductSales>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, account);
			smt.setString(2, "%"+date+"%");
			rs = smt.executeQuery();
			while(rs.next()){
				ProductSales productSales = new ProductSales();
				productSales.setAccount(account);
				productSales.setDate(rs.getDate("productSalesDate"));
				productSales.setId(rs.getString("productID"));
				productSales.setName(rs.getString("productName"));
				productSales.setMonthIncome(rs.getInt("monthIncome"));
				productSalesList.add(productSales);
			}
			rs.close();
			smt.close();
			return productSalesList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return null;
	}

	public void delProductSalesByMemberDate(String account, String startDate,
			String endDate) {
		// TODO Auto-generated method stub
		sql = "DELETE FROM product_sales WHERE memberAccount = ? AND productSalesDate < ? OR productSalesDate > ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, account);
			smt.setString(2, startDate);
			smt.setString(3, endDate);
			smt.executeUpdate();			
			smt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
}
