package com.epoint.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.epoint.webapp.dao.FinancialPlanDAO;
import com.epoint.webapp.entity.FinancialPlan;
import com.epoint.webapp.entity.Member;

public class FinancialPlanDAOImpl implements FinancialPlanDAO {
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void addFinancialPlan(FinancialPlan financialPlan){
		String sql = "INSERT INTO financial_plan (memberAccount,itemName,money,record,itemProperty) VALUES (?,?,?,?,?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, financialPlan.getAccount());
			smt.setString(2, financialPlan.getName());
			smt.setInt(3, financialPlan.getMoney());
			smt.setInt(4, financialPlan.getRecord());
			smt.setInt(5, financialPlan.getProperty());
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
	
	public void modiFinancialPlan(FinancialPlan financialPlan){
		String sql = "UPDATE financial_plan SET itemName = ?,money = ? WHERE memberAccount = ? AND record = ? AND itemProperty = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, financialPlan.getName());
			smt.setInt(2, financialPlan.getMoney());
			smt.setString(3, financialPlan.getAccount());
			smt.setInt(4, financialPlan.getRecord());
			smt.setInt(5, financialPlan.getProperty());
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
	
	public void delFinancialPlan(FinancialPlan financialPlan){
		String sql = "DELETE FROM financial_plan WHERE memberAccount = ? AND record = ? AND itemProperty = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, financialPlan.getAccount());
			smt.setInt(2, financialPlan.getRecord());
			smt.setInt(3, financialPlan.getProperty());
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
	
	public int getRecordByProperty(String account, int itemProperty){
		String sql = "SELECT IFNULL(MAX(record),0)+1 AS Number FROM financial_plan WHERE memberAccount = ? AND itemProperty = ?";
		int Number = 0;
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, account);
			smt.setInt(2, itemProperty);
			rs = smt.executeQuery();
			if(rs.next()){
				Number = rs.getInt("Number");
			}
			rs.close();
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
	
	public List<FinancialPlan> getFinancialPlansByItemID(String account, int itemProperty){
		String sql = "SELECT * FROM financial_plan WHERE memberAccount = ? AND itemProperty = ? ORDER BY record ASC";
		List<FinancialPlan> allFinancialPlans = new ArrayList<FinancialPlan>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, account);
			smt.setInt(2, itemProperty);
			rs = smt.executeQuery();
			while(rs.next()){
				FinancialPlan financialPlan = new FinancialPlan();
				financialPlan.setMoney(rs.getInt("money"));
				financialPlan.setName(rs.getString("itemName"));
				financialPlan.setRecord(rs.getInt("record"));
				financialPlan.setProperty(rs.getInt("itemProperty"));
				allFinancialPlans.add(financialPlan);
			}
			rs.close();
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
		return allFinancialPlans;
	}

	public boolean checkFinancialPlanByMember(Member member) {
		// TODO Auto-generated method stub
				boolean flag = false;
				String sql = "SELECT * FROM financial_plan WHERE memberAccount = ?";
				try {
					conn = dataSource.getConnection();
					smt = conn.prepareStatement(sql);
					smt.setString(1, member.getAccount());
					rs = smt.executeQuery();
					if(rs.next()){
						flag = false;
					}
					rs.close();
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
				return flag;
	}
}
