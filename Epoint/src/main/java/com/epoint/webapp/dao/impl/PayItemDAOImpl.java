package com.epoint.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.epoint.webapp.dao.PayItemDAO;
import com.epoint.webapp.entity.PayItem;


public class PayItemDAOImpl implements PayItemDAO {
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<PayItem> getAllPayItemBySubClassID(int classID){
		String sql = "SELECT * FROM pay_item WHERE mapSubClassID = ? ORDER BY payItemID ASC";
		List<PayItem> allPayItem = new ArrayList<PayItem>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, classID);
			rs = smt.executeQuery();
			while(rs.next()){
				PayItem payItem = new PayItem();
				payItem.setItemID(rs.getInt("payItemID"));
				payItem.setName(rs.getString("payItemName"));
				payItem.setStatus(rs.getInt("payItemStatus"));
				allPayItem.add(payItem);
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
		return allPayItem;
	}
}
