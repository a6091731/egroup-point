package com.epoint.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.epoint.webapp.dao.VentureChecklistDAO;
import com.epoint.webapp.entity.MapClass;
import com.epoint.webapp.entity.Member;
import com.epoint.webapp.entity.VentureChecklist;

public class VentureChecklistDAOImpl implements VentureChecklistDAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void insertVentureCheckList(VentureChecklist ventureChecklist){
		String sql = "INSERT INTO venture_checklist (memberAccount, mapClassID, mapSubClassID, ventureChecklistContent) "
				+ "VALUES (?, ?, ?, ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, ventureChecklist.getAccount());
			smt.setInt(2, ventureChecklist.getId());
			smt.setInt(3, ventureChecklist.getClassID());
			smt.setString(3, ventureChecklist.getContent());
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
	
	public boolean checkVentureCheckList(VentureChecklist ventureChecklist){
		boolean flag = true;
		String sql = "SELECT * FROM venture_checklist WHERE memberAccount = ? AND mapSubClassID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, ventureChecklist.getAccount());
			smt.setInt(2, ventureChecklist.getId());
			rs = smt.executeQuery();
			if(rs.next()){
				flag = false;
			}
			smt.executeQuery();	
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

	public void updateVentureCheckList(VentureChecklist ventureChecklist) {
		// TODO Auto-generated method stub
		String sql = "UPDATE venture_checklist SET ventureChecklistContent = ? WHERE memberAccount= ? AND mapSubClassID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, ventureChecklist.getContent());
			smt.setString(2, ventureChecklist.getAccount());
			smt.setInt(3, ventureChecklist.getId());
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

	public List<MapClass> getMapClassList(MapClass mapClass) {
		// TODO Auto-generated method stub
		List<MapClass> mapClassList = new ArrayList<MapClass>();
		//String sql = "SELECT * FROM map_class LEFT JOIN venture_checklist ON map_class.mapClassID = venture_checklist.mapClassID WHERE mapID = ?";
		String sql = "SELECT * FROM map_class WHERE mapID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, mapClass.getId());
			rs = smt.executeQuery();
			while(rs.next()){
				MapClass mapclass = new MapClass();
				mapclass.setId(rs.getInt("mapID"));
				mapclass.setClassID(rs.getInt("mapClassID"));
				mapclass.setName(rs.getString("mapClassName"));
				mapClass.setUrl(rs.getString("mapClassUrl"));
				mapClassList.add(mapclass);
				System.out.println("url="+mapClass.getUrl());
			}
			smt.executeQuery();	
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
		return mapClassList;
	}
	
	public int getVentrueCheckListByMember(Member member1){
		int checkListNow = 0;
		String sql = "SELECT MAX(mapClassID) AS Now FROM venture_checklist WHERE memberAccount = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, member1.getAccount());
			rs = smt.executeQuery();			
			if(rs.next()){
				checkListNow = rs.getInt("Now");
			}
			smt.executeQuery();	
			rs.close();
			smt.close();
			return checkListNow;
 
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
