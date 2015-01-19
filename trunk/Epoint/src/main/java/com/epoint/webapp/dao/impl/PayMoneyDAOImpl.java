package com.epoint.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.epoint.webapp.dao.PayMoneyDAO;
import com.epoint.webapp.entity.PayMoney;

public class PayMoneyDAOImpl implements PayMoneyDAO {
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void addPayMoney(PayMoney paymoney){
		String sql = "INSERT INTO pay_money (memberAccount,payItemID,payDate,payMoney,payRecord) VALUES (?,?,?,?,?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, paymoney.getAccount());
			smt.setInt(2, paymoney.getID());
			smt.setString(3, paymoney.getDate_string());
			smt.setInt(4, paymoney.getMoney());
			smt.setInt(5, paymoney.getRecord());
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
	
	public void modiPayMoney(PayMoney paymoney){
		String sql = "UPDATE pay_money SET payDate = ?,payMoney = ? WHERE memberAccount = ? AND payItemID = ? AND payRecord = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, paymoney.getDate_string());
			smt.setInt(2, paymoney.getMoney());
			smt.setString(3, paymoney.getAccount());
			smt.setInt(4, paymoney.getID());
			smt.setInt(5, paymoney.getRecord());
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
	
	public void delPayMoney(PayMoney paymoney){
		String sql = "DELETE FROM pay_money WHERE memberAccount = ? AND payItemID = ? AND payRecord = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, paymoney.getAccount());
			smt.setInt(2, paymoney.getID());
			smt.setInt(3, paymoney.getRecord());
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

	public int getPayRecord(String account, int itemID) {
		String sql = "SELECT IFNULL(MAX(payRecord),0)+1 AS Number FROM pay_money WHERE memberAccount = ? AND payItemID = ?";
		int Number = 0;
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, account);
			smt.setInt(2, itemID);
			rs = smt.executeQuery();
			if(rs.next()){
				Number = rs.getInt("Number");
			}
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
		return Number;
	}
	
	public List<PayMoney> getPayMoneyByItemID(String account, int itemID){
		String sql = "SELECT * FROM pay_money WHERE memberAccount = ? AND payItemID = ? ORDER BY payRecord ASC";
		List<PayMoney> allPayMoney = new ArrayList<PayMoney>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, account);
			smt.setInt(2, itemID);
			rs = smt.executeQuery();
			while(rs.next()){
				PayMoney payMoney = new PayMoney();
				payMoney.setDate(rs.getDate("payDate"));
				payMoney.setMoney(rs.getInt("payMoney"));
				payMoney.setRecord(rs.getInt("payRecord"));
				payMoney.setID(rs.getInt("payItemID"));
				allPayMoney.add(payMoney);
			}
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
		return allPayMoney;
	}
	
	public PayMoney getSinglePayMoneyByItemID(String account, int itemID){
		String sql = "SELECT * FROM pay_money WHERE memberAccount = ? AND payItemID = ? ORDER BY payRecord ASC";
		PayMoney payMoney = new PayMoney();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, account);
			smt.setInt(2, itemID);
			rs = smt.executeQuery();
			if(rs.next()){
				payMoney.setDate(rs.getDate("payDate"));
				payMoney.setMoney(rs.getInt("payMoney"));
				payMoney.setRecord(rs.getInt("payRecord"));
				payMoney.setID(rs.getInt("payItemID"));
			}
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
		return payMoney;
	}
	
	public List<PayMoney> getPayMoneyBySubClassStatus(String account, int subClass, int status){
		String sql = "SELECT * FROM pay_money m INNER JOIN pay_item i ON i.payItemID = m.payItemID AND i.payItemStatus = ? AND i.mapSubClassID = ? WHERE m.memberAccount = ? ORDER BY m.payItemID ASC";
		List<PayMoney> allPayMoney = new ArrayList<PayMoney>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, status);
			smt.setInt(2, subClass);
			smt.setString(3, account);
			rs = smt.executeQuery();
			while(rs.next()){
				PayMoney payMoney = new PayMoney();
				payMoney.setDate(rs.getDate("payDate"));
				payMoney.setMoney(rs.getInt("payMoney"));
				payMoney.setRecord(rs.getInt("payRecord"));
				payMoney.setID(rs.getInt("payItemID"));
				allPayMoney.add(payMoney);
			}
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
		return allPayMoney;
	}
}
