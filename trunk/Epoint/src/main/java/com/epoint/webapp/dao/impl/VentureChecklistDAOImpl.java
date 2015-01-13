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
	//如果method裡面有一句以上的sql，請使用sql1,sql2分開
	private String sql;
	private String sql1;
	private String sql2;
	//flag用來判斷回傳的true or false
	private boolean flag;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void insertVentureCheckList(VentureChecklist ventureChecklist){
		sql = "INSERT INTO venture_checklist (memberAccount, mapClassID, mapSubClassID, ventureChecklistContent) "
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
		flag = false;
		sql = "SELECT * FROM venture_checklist WHERE memberAccount = ? AND mapSubClassID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, ventureChecklist.getAccount());
			smt.setInt(2, ventureChecklist.getClassID());
			rs = smt.executeQuery();
			if(rs.next()){
				flag = true;
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
		sql = "UPDATE venture_checklist SET ventureChecklistContent = ? WHERE memberAccount= ? AND mapSubClassID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, ventureChecklist.getContent());
			smt.setString(2, ventureChecklist.getAccount());
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
		sql1 = "SELECT * FROM map_class WHERE mapID = ?";
		sql2 = "SELECT MAX(mapClassID) AS now FROM venture_checklist WHERE memberAccount = ? "
				+ "GROUP BY memberAccount";
		boolean now = false;
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql1);
			smt.setInt(1, mapClass.getId());
			rs = smt.executeQuery();
			while(rs.next()){
				MapClass mapClass2 = new MapClass();
				mapClass2.setId(rs.getInt("mapID"));
				mapClass2.setClassID(rs.getInt("mapClassID"));
				mapClass2.setName(rs.getString("mapClassName"));
				mapClass2.setUrl(rs.getString("mapClassUrl"));					
				if(now == false){
					now = true;
					smt = conn.prepareStatement(sql2);
					smt.setString(1, mapClass.getAccount());
					rs2 = smt.executeQuery();
					while(rs2.next()){
						mapClass2.setNow(rs2.getInt("now"));						
					}					
				}
				System.out.println("getNow()"+mapClass2.getNow());
				mapClassList.add(mapClass2);
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
		return mapClassList;
	}
	
	public List<MapSubclass> getVentureCheckListByMember(Member member){
		List<MapSubclass> mapSubclassesList = new ArrayList<MapSubclass>();
		sql1 = "SELECT * FROM map_subclass WHERE mapClassID = ?";
		sql2 = "SELECT MAX(mapClassID) AS now ,ventureChecklistContent FROM venture_checklist "
				+ "WHERE memberAccount = ? AND mapSubClassID = ? GROUP BY mapClassID";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql1);
			smt.setInt(1, member.getClassID());
			rs = smt.executeQuery();
			while(rs.next()){				
				MapSubclass mapSubclass = new MapSubclass();				
				mapSubclass.setClassID(rs.getInt("mapClassID"));
				mapSubclass.setSubclassID(rs.getInt("mapSubClassID"));
				mapSubclass.setName(rs.getString("mapSubClassName"));				
				smt = conn.prepareStatement(sql2);
				smt.setString(1, member.getAccount());
				smt.setInt(2, mapSubclass.getSubclassID());
				rs2 = smt.executeQuery();
				while (rs2.next()) {
					mapSubclass.setNow(rs2.getInt("now"));
					mapSubclass.setContent(rs2.getString("ventureChecklistContent"));
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
