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
import com.epoint.webapp.entity.MapSubclass;
import com.epoint.webapp.entity.Member;
import com.epoint.webapp.entity.VentureChecklist;

public class VentureChecklistDAOImpl implements VentureChecklistDAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private ResultSet rs2 = null ;
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
			smt.setString(4, ventureChecklist.getContent());
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
			System.out.println("ventureChecklist.getClassID()="+ventureChecklist.getClassID());
			smt.setInt(3, ventureChecklist.getClassID());
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
	
	public List<MapSubclass> getVentureCheckListByMember(Member member){
		List<MapSubclass> mapSubclassesList = new ArrayList<MapSubclass>();
		String sql1 = "SELECT * FROM map_subclass WHERE mapClassID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql1);
			System.out.println("member.getClassID()="+member.getClassID());
			smt.setInt(1, member.getClassID());
			rs = smt.executeQuery();
			while(rs.next()){				
				MapSubclass mapSubclass = new MapSubclass();				
				mapSubclass.setClassID(rs.getInt("mapClassID"));
				mapSubclass.setSubclassID(rs.getInt("mapSubClassID"));
				mapSubclass.setName(rs.getString("mapSubClassName"));
				System.out.println("mapClassID="+mapSubclass.getClassID()+",mapSubClassID="+mapSubclass.getSubclassID()+",mapSubClassName="+mapSubclass.getName());
				String sql2 = "SELECT ventureChecklistContent FROM venture_checklist "
						+ "WHERE memberAccount = ? AND mapSubClassID = ?";
				smt = conn.prepareStatement(sql2);
				smt.setString(1, member.getAccount());
				smt.setInt(2, mapSubclass.getSubclassID());
				System.out.println("mapSubclass.getSubclassID="+mapSubclass.getSubclassID());
				rs2 = smt.executeQuery();
				while (rs2.next()) {
					mapSubclass.setContent(rs2.getString("ventureChecklistContent"));
					System.out.println("ventureChecklistContent="+mapSubclass.getContent());
				}				
				mapSubclassesList.add(mapSubclass);
			}
			smt.executeQuery();	
			rs.close();
			smt.close();
			return mapSubclassesList;
 
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
