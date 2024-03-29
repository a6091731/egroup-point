package com.epoint.webapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.epoint.webapp.dao.ProductDAO;
import com.epoint.webapp.entity.Member;
import com.epoint.webapp.entity.Product;
import com.epoint.webapp.util.DateConversion;
import com.mysql.jdbc.Statement;

public class ProductDAOImpl implements ProductDAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	private String sql;
	private String sql1;
	private String sql2;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/*public boolean productCheck(Product product) {
		// TODO Auto-generated method stub
		boolean falg=false;
		sql="SELECT * FROM product WHERE memberAccount = ?, productID=?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, product.getAccount());
			smt.setString(2, product.getId());
			rs = smt.executeQuery();
			if(rs.next()){
				
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
	}*/

	public List<Product> getProductAndSalesListByMemberID(Product prodcut1) {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<Product>();
		sql = "SELECT p.*, s.productSalesDate, s.productSalesQuantity FROM product_sales s LEFT JOIN product p "
				+ "ON p.productID = s.productID WHERE s.memberAccount = ? AND s.productID = ?";		
		try {
			DateConversion dateConversion = new DateConversion();
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);			
			smt.setString(1, prodcut1.getAccount());
			smt.setString(2, prodcut1.getId());
			rs = smt.executeQuery();
			while(rs.next()){
				Product product2 = new Product();
				product2.setId(rs.getString("productID"));
				product2.setTime(rs.getDate("productNewTime"));
				product2.setName(rs.getString("productName"));
				product2.setSpecification(rs.getString("productSpecifications"));
				product2.setPack(rs.getString("productPack"));
				product2.setEndPrice(rs.getInt("productEndPrice"));
				product2.setSalesPrice(rs.getInt("productSalesPrice"));
				product2.setCost(rs.getInt("productCost"));
				product2.setQuantity(rs.getInt("productSalesQuantity"));
				try {					
					product2.setDate_string(dateConversion.ConversionYM(rs.getDate("productSalesDate")));	
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				product2.setQuantity(rs.getInt("productSalesQuantity"));				
				productList.add(product2);
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
		return productList;
	}
	
	public void insertProduct1(Product product) {
		// TODO Auto-generated method stub		
		sql = "INSERT INTO product (memberAccount,productID, productNewTime,productName, "
				+ "productSpecifications, productPack,productEndPrice, productSalesPrice, productCost) "
				+ "VALUES (?,CONCAT(?,NOW()),NOW(),?,?,?,?,?,?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1,product.getAccount());
			smt.setString(2,product.getAccount());
			smt.setString(3,product.getName());
			smt.setString(4,product.getSpecification());
			smt.setString(5, product.getPack());
			smt.setInt(6,product.getEndPrice());
			smt.setInt(7,product.getSalesPrice());
			smt.setInt(8,product.getCost());
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
	
	public String insertProduct2(Product product) {
		// TODO Auto-generated method stub
		sql1 = "INSERT INTO product (memberAccount,productID, productNewTime,productName, "
				+ "productSpecifications, productPack,productEndPrice, productSalesPrice, productCost) "
				+ "VALUES (?,CONCAT(?,NOW()),NOW(),?,?,?,?,?,?) ";
		
		sql2 = "SELECT productID FROM product WHERE productID = CONCAT(?,NOW())";		
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql1);
			smt.setString(1,product.getAccount());
			smt.setString(2,product.getAccount());
			smt.setString(3,product.getName());
			smt.setString(4,product.getSpecification());
			smt.setString(5, product.getPack());
			smt.setInt(6,product.getEndPrice());
			smt.setInt(7,product.getSalesPrice());
			smt.setInt(8,product.getCost());
			smt.executeUpdate();
			
			smt = conn.prepareStatement(sql2);
			smt.setString(1,product.getAccount());
			rs = smt.executeQuery();
			if(rs.next()){
				String productID = rs.getString("productID");
				return productID;
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
		return null;
	}

	public List<Product> getProductList(Member member, int start, int size) {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<Product>();
		sql = "SELECT * FROM product WHERE memberAccount = ? ORDER BY productNewTime ASC LIMIT ?,?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, member.getAccount());
			smt.setInt(2, start);
			smt.setInt(3, size);
			rs = smt.executeQuery();
			while(rs.next()){
				Product product = new Product();
				product.setAccount(member.getAccount());
				product.setId(rs.getString("productID"));
				product.setTime(rs.getDate("productNewTime"));
				product.setName(rs.getString("productName"));
				product.setSpecification(rs.getString("productSpecifications").replaceAll("(\r\n|\n)", "<br />"));
				product.setPack(rs.getString("productPack").replaceAll("(\r\n|\n)", "<br />"));
				product.setEndPrice(rs.getInt("productEndPrice"));
				product.setSalesPrice(rs.getInt("productSalesPrice"));
				product.setCost(rs.getInt("productCost"));
				productList.add(product);
				/*System.out.println(member.getAccount());
				System.out.println(rs.getString("productID"));
				System.out.println(rs.getDate("productNewTime"));
				System.out.println(rs.getString("productName"));
				System.out.println(rs.getString("productSpecifications"));
				System.out.println(rs.getString("productPack"));
				System.out.println(rs.getInt("productEndPrice"));
				System.out.println(rs.getInt("productSalesPrice"));
				System.out.println(rs.getInt("productCost"));
				System.out.println("************************");*/
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
		return productList;
	}

	public List<Product> getProductListSum(Member member, int start, int size) {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<Product>();
		sql = "SELECT SUM(DISTINCT s.productSalesQuantity) AS sumQuantity, p.productID ,p.productNewTime , "
				+ "p.productName, p.productSpecifications, p.productPack, p.productEndPrice, p.productSalesPrice, "
				+ "p.productCost FROM product p LEFT JOIN product_sales s ON p.memberAccount = s.memberAccount "
				+ "AND p.productID = s.productID WHERE p.memberAccount = ? GROUP BY "
				+ "p.productID ORDER BY p.productNewTime ASC LIMIT ?,?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, member.getAccount());
			smt.setInt(2, start);
			smt.setInt(3, size);
			rs = smt.executeQuery();
			while(rs.next()){
				Product product = new Product();
				product.setAccount(member.getAccount());
				product.setId(rs.getString("productID"));
				product.setTime(rs.getDate("productNewTime"));
				product.setName(rs.getString("productName"));
				product.setSpecification(rs.getString("productSpecifications"));
				product.setPack(rs.getString("productPack"));
				product.setEndPrice(rs.getInt("productEndPrice"));
				product.setSalesPrice(rs.getInt("productSalesPrice"));
				product.setCost(rs.getInt("productCost"));
				product.setProfit(product.getSalesPrice()-product.getCost());
				product.setSum(rs.getInt("sumQuantity"));
				product.setTotalProfit(product.getProfit()*product.getSum());
				productList.add(product);
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
		return productList;
	}
	
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		String sql = "UPDATE product SET productName = ?, productSpecifications = ?, productPack = ?, "
				+ "productEndPrice = ?, productSalesPrice = ?, productCost = ?, productUpdateTime = NOW() "
				+ "WHERE memberAccount = ? AND productID = ? ";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1,product.getName());
			smt.setString(2,product.getSpecification());
			smt.setString(3,product.getPack());
			smt.setInt(4,product.getEndPrice());
			smt.setInt(5,product.getSalesPrice());
			smt.setInt(6,product.getCost());
			smt.setString(7,product.getAccount());
			smt.setString(8,product.getId());
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

	public int countProductByMember(Member member) {
		// TODO Auto-generated method stub
		sql = "SELECT COUNT(*) AS count FROM product WHERE memberAccount = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, member.getAccount());
			rs = smt.executeQuery();
			while(rs.next()){
				return rs.getInt("count");
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
	
	public List<Product> getAllProductList(Member member) {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<Product>();
		sql = "SELECT * FROM product WHERE memberAccount = ? ORDER BY productNewTime ASC";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, member.getAccount());
			rs = smt.executeQuery();
			while(rs.next()){
				Product product = new Product();
				product.setAccount(member.getAccount());
				product.setId(rs.getString("productID"));
				product.setTime(rs.getDate("productNewTime"));
				product.setName(rs.getString("productName"));
				product.setSpecification(rs.getString("productSpecifications"));
				product.setPack(rs.getString("productPack"));
				product.setEndPrice(rs.getInt("productEndPrice"));
				product.setSalesPrice(rs.getInt("productSalesPrice"));
				product.setCost(rs.getInt("productCost"));
				productList.add(product);
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
		return productList;
	}

	public void delProduct(Product product) {
		// TODO Auto-generated method stub
		sql = "DELETE FROM product WHERE memberAccount = ? AND productID = ? ";
		try {			
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1,product.getAccount());
			smt.setString(2,product.getId());
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

	public boolean checkProductByMember(Member member) {
		// TODO Auto-generated method stub
		boolean flag = false;
		sql = "SELECT * FROM product WHERE memberAccount = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, member.getAccount());
			rs = smt.executeQuery();
			if(rs.next()){
				flag = true;
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
		return flag;
	}

	
}
