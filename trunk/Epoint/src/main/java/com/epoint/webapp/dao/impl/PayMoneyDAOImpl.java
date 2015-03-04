package com.epoint.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.epoint.webapp.dao.PayMoneyDAO;
import com.epoint.webapp.entity.Member;
import com.epoint.webapp.entity.PayMoney;
import com.epoint.webapp.util.DateConversion;

public class PayMoneyDAOImpl implements PayMoneyDAO {
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private ResultSet rs1 = null ;
	private ResultSet rs2 = null ;
	private PreparedStatement smt = null ;
	//如果method裡面有一句以上的sql，請使用sql1,sql2分開
	private String sql;
	private String sql1;
	private String sql2;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void addPayMoney(PayMoney paymoney){
		sql = "INSERT INTO pay_money (memberAccount,payItemID,payDate,payMoney,payRecord) VALUES (?,?,?,?,?)";
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
		sql = "UPDATE pay_money SET payDate = ?,payMoney = ? WHERE memberAccount = ? AND payItemID = ? AND payRecord = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, paymoney.getDate_string());
			smt.setInt(2, paymoney.getMoney());
			smt.setString(3, paymoney.getAccount());
			smt.setInt(4, paymoney.getID());
			smt.setInt(5, paymoney.getRecord());
			System.out.println("------------------------------------");
			System.out.println("Date="+paymoney.getDate_string());
			System.out.println("Money="+paymoney.getMoney());
			System.out.println("Account="+paymoney.getAccount());
			System.out.println("ID="+paymoney.getID());
			System.out.println("Record()="+paymoney.getRecord());
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
		sql = "DELETE FROM pay_money WHERE memberAccount = ? AND payItemID = ? AND payRecord = ?";
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
	
	public void delPayMoneyByDate(String account, String startDate, String endDate){
		sql = "DELETE FROM pay_money WHERE memberAccount = ? AND payDate < ? OR payDate > ?";
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

	public int getPayRecord(String account, int itemID) {
		sql = "SELECT IFNULL(MAX(payRecord),0)+1 AS Number FROM pay_money WHERE memberAccount = ? AND payItemID = ?";
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
	
	public List<PayMoney> getPayMoneyByItemID(String account, int itemID){
		sql = "SELECT * FROM pay_money WHERE memberAccount = ? AND payItemID = ? ORDER BY payDate ASC";
		List<PayMoney> allPayMoney = new ArrayList<PayMoney>();
		/*DateConversion dateConversion = new DateConversion();
		String year;
		String mon;*/
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, account);
			smt.setInt(2, itemID);
			rs = smt.executeQuery();
			while(rs.next()){
				PayMoney payMoney = new PayMoney();
				/*String dateString = dateConversion.ConversionYMD(rs.getDate("payDate"));
            	year = dateString.substring(0,4);
            	mon = dateString.substring(5,7);
            	payMoney.setDate_string(year+"-"+mon);  */          	
				payMoney.setDate(rs.getDate("payDate"));
				payMoney.setMoney(rs.getInt("payMoney"));
				payMoney.setRecord(rs.getInt("payRecord"));
				payMoney.setID(rs.getInt("payItemID"));
				allPayMoney.add(payMoney);
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
		return allPayMoney;
	}
	
	public PayMoney getSinglePayMoneyByItemID(String account, int itemID){
		String sql = "SELECT * FROM pay_money WHERE memberAccount = ? AND payItemID = ? ORDER BY payDate ASC";
		PayMoney payMoney = new PayMoney();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, account);
			smt.setInt(2, itemID);
			rs = smt.executeQuery();
			/*DateConversion dateConversion = new DateConversion();
			String year;
			String mon;*/
			if(rs.next()){	
				/*String dateString = dateConversion.ConversionYMD(rs.getDate("payDate"));
            	year = dateString.substring(0,4);
            	mon = dateString.substring(5,7);
            	payMoney.setDate_string(year+"-"+mon)*/
				payMoney.setDate(rs.getDate("payDate"));
				payMoney.setMoney(rs.getInt("payMoney"));
				payMoney.setRecord(rs.getInt("payRecord"));
				payMoney.setID(rs.getInt("payItemID"));
				System.out.println("payMone="+payMoney.getDate_string());
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
		return payMoney;
	}
	
	public List<PayMoney> getPayMoneyBySubClassStatus(String account, int subClass, int status){
		String sql = "SELECT m.* FROM pay_money m INNER JOIN pay_item i ON i.payItemID = m.payItemID AND i.payItemStatus = ? AND i.mapSubClassID = ? WHERE m.memberAccount = ? ORDER BY m.payItemID ASC";
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
		return allPayMoney;
	}
	
	public int getMonthlyCostByAccount(String account) {
		String sql = "SELECT IFNULL(SUM(payMoney),0) AS Number FROM pay_money WHERE memberAccount = ?";
		int Number = 0;
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, account);
			rs = smt.executeQuery();
			if(rs.next()){
				int result = rs.getInt("Number");
				if(result % 12 != 0)
					Number =  result / 12 +1;
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
	
	public List<PayMoney> getTotalExpenditureByAccount(String account){
		String sql = "SELECT SUM(payMoney) AS Total , payDate FROM pay_money WHERE memberAccount = ? GROUP BY payDate";
		List<PayMoney> allPayMoney = new ArrayList<PayMoney>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, account);
			rs = smt.executeQuery();
			while(rs.next()){
				PayMoney payMoney = new PayMoney();
				payMoney.setDate(rs.getDate("payDate"));
				payMoney.setMonthTotal(rs.getInt("Total"));
				allPayMoney.add(payMoney);
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
		return allPayMoney;
	}
	
	public List<PayMoney> getMonthTotalMoneyBySubclassID(String account,String date){
		/*String sql = "SELECT SUM(m.payMoney) AS Total,m.*,i.mapSubClassID,s.mapSubClassName FROM pay_money m "
				+ "INNER JOIN pay_item i ON m.payItemID = i.payItemID LEFT JOIN map_subclass s ON "
				+ "i.mapSubClassID = s.mapSubClassID WHERE m.memberAccount = ? AND m.payDate LIKE ? "
				+ "GROUP BY i.mapSubClassID";*/
		sql = "SELECT i.mapSubClassID, s.mapSubClassName ,m.payDate , m.payItemID,SUM(IFNULL(m.payMoney,0)) AS Total "
				+ "FROM pay_item i LEFT JOIN map_subclass s ON i.mapSubClassID = s.mapSubClassID "
				+ "LEFT JOIN pay_money m ON i.payItemID = m.payItemID AND m.memberAccount= ? AND m.payDate LIKE ? "
				+ "GROUP BY s.mapSubClassID";
		List<PayMoney> payMoneyList = new ArrayList<PayMoney>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, account);
			smt.setString(2, "%"+date+"%");
			rs = smt.executeQuery();
			while(rs.next()){
				PayMoney payMoney = new PayMoney();
				payMoney.setDate(rs.getDate("payDate"));
				payMoney.setID(rs.getInt("payItemID"));
				payMoney.setMonthTotal(rs.getInt("Total"));
				payMoney.setSubClassName(rs.getString("mapSubClassName"));
				payMoney.setSubClassID(rs.getInt("mapSubClassID"));
				payMoneyList.add(payMoney);
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
		return payMoneyList;
	}

	public double getVentureCapitalPercent(Member member) {
		// TODO Auto-generated method stub
		double mapSubclassCount = 0;
		double mySubclassCount = 0;
		double percentCount;
		sql1 = "SELECT payItemID FROM pay_item WHERE mapSubClassID=? GROUP BY payItemID";
		sql2 = "SELECT * FROM pay_money WHERE payItemID=? AND memberAccount=? GROUP BY payItemID";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql1);
			smt.setString(1, member.getSetPercent());
			rs1 = smt.executeQuery();
			while(rs1.next()){
				mapSubclassCount = mapSubclassCount+1;	
				/*System.out.println("payItemID="+rs1.getString("payItemID"));
				System.out.println("mapSubclassCount="+mapSubclassCount);*/
				
				smt = conn.prepareStatement(sql2);
				smt.setString(1, rs1.getString("payItemID"));
				smt.setString(2,member.getAccount());
				rs2 = smt.executeQuery();
				if(rs2.next()){					
					mySubclassCount = mySubclassCount+1;
					//System.out.println("mySubclassCount"+mySubclassCount);
				}
			}
			percentCount = mySubclassCount/mapSubclassCount;
			System.out.println("percentCount="+percentCount);
			rs1.close();
			rs2.close();
			smt.close();
			return percentCount;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return 0.0;
	}

	public int getVentureCapitalYearExpenditure(Member member) {
		// TODO Auto-generated method stub
		int yearExpenditure = 0;
		sql = "SELECT SUM(payMoney) AS yearExpenditure FROM pay_money WHERE memberAccount = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, member.getAccount());
			rs = smt.executeQuery();
			if(rs.next()){
				yearExpenditure = rs.getInt("yearExpenditure");
			}
			rs.close();
			smt.close();
			return yearExpenditure;			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return yearExpenditure;
	}

	public boolean checkPayMoneyByMember(Member member) {
		// TODO Auto-generated method stub
		boolean flag = false;
		sql = "SELECT * FROM pay_money WHERE memberAccount = ?";
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
