package com.epoint.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.swing.event.HyperlinkEvent;

import com.epoint.webapp.dao.VentureChecklistDAO;
import com.epoint.webapp.entity.HumanResourceContent;
import com.epoint.webapp.entity.MapClass;
import com.epoint.webapp.entity.MapSubclass;
import com.epoint.webapp.entity.Member;
import com.epoint.webapp.entity.VentureChecklist;

public class VentureChecklistDAOImpl implements VentureChecklistDAO{
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
			rs1 = smt.executeQuery();
			while(rs1.next()){
				MapClass mapClass2 = new MapClass();
				mapClass2.setId(rs1.getInt("mapID"));
				mapClass2.setClassID(rs1.getInt("mapClassID"));
				mapClass2.setName(rs1.getString("mapClassName"));
				mapClass2.setUrl(rs1.getString("mapClassUrl"));
				mapClass2.setCss(rs1.getString("mapClassCss"));
				if(now == false){
					now = true;
					smt = conn.prepareStatement(sql2);
					smt.setString(1, mapClass.getAccount());
					rs2 = smt.executeQuery();
					while(rs2.next()){
						mapClass2.setNow(rs2.getInt("now"));	
						if(mapClass2.getNow()<13){
							String sql3 = "SELECT * FROM product WHERE memberAccount = ?";
							smt = conn.prepareStatement(sql3);
							smt.setString(1, mapClass.getAccount());
							ResultSet rs3 = smt.executeQuery();
							if(rs3.next()){
								mapClass2.setNow(13);
							}
						}
					}					
				}
				mapClassList.add(mapClass2);
			}			
			rs1.close();
			rs2.close();
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
			rs1 = smt.executeQuery();
			while(rs1.next()){				
				MapSubclass mapSubclass = new MapSubclass();				
				mapSubclass.setClassID(rs1.getInt("mapClassID"));
				mapSubclass.setSubclassID(rs1.getInt("mapSubClassID"));
				mapSubclass.setName(rs1.getString("mapSubClassName"));				
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
			rs1.close();
			rs2.close();
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

	public void insertHumanResourceContent(HumanResourceContent humanResourceContent) {
		// TODO Auto-generated method stub
		sql = "INSERT INTO human_resource_content (memberAccount, MQ0, MQ1, MQ2, MQ3, MQ4, "
				+ "RQ0, RQ1, RQ2, RQ3, RQ4, SQ0, SQ1, SQ2, SQ3, SQ4, OQ0, OQ1, OQ2, OQ3, OQ4, "
				+ "totalQ0, totalQ1, totalQ2, totalQ3, totalQ4) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			System.out.println("123456");
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, humanResourceContent.getAccount());
			smt.setInt(2, humanResourceContent.getMQ0());
			smt.setInt(3, humanResourceContent.getMQ1());
			smt.setInt(4, humanResourceContent.getMQ2());
			smt.setInt(5, humanResourceContent.getMQ3());
			smt.setInt(6, humanResourceContent.getMQ4());
			smt.setInt(7, humanResourceContent.getRQ0());
			smt.setInt(8, humanResourceContent.getRQ1());
			smt.setInt(9, humanResourceContent.getRQ2());
			smt.setInt(10, humanResourceContent.getRQ3());
			smt.setInt(11, humanResourceContent.getRQ4());
			smt.setInt(12, humanResourceContent.getSQ0());
			smt.setInt(13, humanResourceContent.getSQ1());
			smt.setInt(14, humanResourceContent.getSQ2());
			smt.setInt(15, humanResourceContent.getSQ3());
			smt.setInt(16, humanResourceContent.getSQ4());
			smt.setInt(17, humanResourceContent.getOQ0());
			smt.setInt(18, humanResourceContent.getOQ1());
			smt.setInt(19, humanResourceContent.getOQ2());
			smt.setInt(20, humanResourceContent.getOQ3());
			smt.setInt(21, humanResourceContent.getOQ4());
			smt.setInt(22, humanResourceContent.getTotalQ0());
			smt.setInt(23, humanResourceContent.getTotalQ1());
			smt.setInt(24, humanResourceContent.getTotalQ2());
			smt.setInt(25, humanResourceContent.getTotalQ3());
			smt.setInt(26, humanResourceContent.getTotalQ4());
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

	public HumanResourceContent getHumanResourceContentByMember(Member member) {
		// TODO Auto-generated method stub
		sql = "SELECT * FROM human_resource_content WHERE memberAccount = ?";
		HumanResourceContent humanResourceContent = new HumanResourceContent();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, member.getAccount());
			rs = smt.executeQuery();
			if(rs.next()){				
				humanResourceContent.setMQ0(rs.getInt("MQ0"));
				humanResourceContent.setMQ1(rs.getInt("MQ1"));
				humanResourceContent.setMQ2(rs.getInt("MQ2"));
				humanResourceContent.setMQ3(rs.getInt("MQ3"));
				humanResourceContent.setMQ4(rs.getInt("MQ4"));
				humanResourceContent.setRQ0(rs.getInt("RQ0"));
				humanResourceContent.setRQ1(rs.getInt("RQ1"));
				humanResourceContent.setRQ2(rs.getInt("RQ2"));
				humanResourceContent.setRQ3(rs.getInt("RQ3"));
				humanResourceContent.setRQ4(rs.getInt("RQ4"));
				humanResourceContent.setSQ0(rs.getInt("SQ0"));
				humanResourceContent.setSQ1(rs.getInt("SQ1"));
				humanResourceContent.setSQ2(rs.getInt("SQ2"));
				humanResourceContent.setSQ3(rs.getInt("SQ3"));
				humanResourceContent.setSQ4(rs.getInt("SQ4"));
				humanResourceContent.setOQ0(rs.getInt("OQ0"));
				humanResourceContent.setOQ1(rs.getInt("OQ1"));
				humanResourceContent.setOQ2(rs.getInt("OQ2"));
				humanResourceContent.setOQ3(rs.getInt("OQ3"));
				humanResourceContent.setOQ4(rs.getInt("OQ4"));
				humanResourceContent.setTotalQ0(rs.getInt("totalQ0"));
				humanResourceContent.setTotalQ1(rs.getInt("totalQ1"));
				humanResourceContent.setTotalQ2(rs.getInt("totalQ2"));
				humanResourceContent.setTotalQ3(rs.getInt("totalQ3"));
				humanResourceContent.setTotalQ4(rs.getInt("totalQ4"));				
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
		return humanResourceContent;
	}

	public boolean checkHumanResourceContentByMember(Member member) {
		// TODO Auto-generated method stub
		sql = "SELECT * FROM human_resource_content WHERE memberAccount=?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, member.getAccount());
			rs = smt.executeQuery();
			if(rs.next()){				
				smt.setString(1, member.getAccount());
				return true;
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
		return false;
	}

	public void updateHumanResourceContentByMember(
			HumanResourceContent humanResourceContent) {		
		// TODO Auto-generated method stub
		String sql = "UPDATE human_resource_content SET memberAccount=?, MQ0=?, MQ1=?, MQ2=?, MQ3=?, MQ4=?, "
				+ "RQ0=?, RQ1=?, RQ2=?, RQ3=?, RQ4=?, SQ0=?, SQ1=?, SQ2=?, SQ3=?, SQ4=?, OQ0=?, "
				+ "OQ1=?, OQ2=?, OQ3=?, OQ4=?, totalQ0=?, totalQ1=?, totalQ2=?, totalQ3=?, totalQ4=? "
				+ "WHERE memberAccount = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1,humanResourceContent.getAccount());
			smt.setInt(2,humanResourceContent.getMQ0());
			smt.setInt(3, humanResourceContent.getMQ1());
			smt.setInt(4, humanResourceContent.getMQ2());
			smt.setInt(5, humanResourceContent.getMQ3());
			smt.setInt(6, humanResourceContent.getMQ4());
			
			smt.setInt(7, humanResourceContent.getRQ0());
			smt.setInt(8, humanResourceContent.getRQ1());
			smt.setInt(9, humanResourceContent.getRQ2());
			smt.setInt(10, humanResourceContent.getRQ3());
			smt.setInt(11, humanResourceContent.getRQ4());
			
			smt.setInt(12, humanResourceContent.getSQ0());
			smt.setInt(13, humanResourceContent.getSQ1());
			smt.setInt(14, humanResourceContent.getSQ2());
			smt.setInt(15, humanResourceContent.getSQ3());
			smt.setInt(16, humanResourceContent.getSQ4());
			
			smt.setInt(17, humanResourceContent.getOQ0());
			smt.setInt(18, humanResourceContent.getOQ1());
			smt.setInt(19, humanResourceContent.getOQ2());
			smt.setInt(20, humanResourceContent.getOQ3());
			smt.setInt(21, humanResourceContent.getOQ4());
			
			smt.setInt(22, humanResourceContent.getTotalQ0());
			smt.setInt(23, humanResourceContent.getTotalQ1());
			smt.setInt(24, humanResourceContent.getTotalQ2());
			smt.setInt(25, humanResourceContent.getTotalQ3());
			smt.setInt(26, humanResourceContent.getTotalQ4());
			smt.setString(27,humanResourceContent.getAccount());
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

	public double getVentureChecklistPercent(Member member1) {
		// TODO Auto-generated method stub
		double mapSubclassCount;
		double mySubclassCount;
		double percentCount;
		sql1 = "SELECT COUNT(*) AS count FROM map_subclass WHERE mapClassID=?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql1);
			smt.setString(1, member1.getSetPercent());
			System.out.println("getSetPercent()="+member1.getSetPercent());
			rs1 = smt.executeQuery();
			if(rs1.next()){	
				mapSubclassCount=rs1.getInt("count");
				System.out.println("mapSubclassCount="+mapSubclassCount);				
				sql2 = "SELECT COUNT(*) AS count FROM venture_checklist WHERE mapClassID=? AND memberAccount =? ";
				smt = conn.prepareStatement(sql2);
				smt.setString(1, member1.getSetPercent());
				smt.setString(2, member1.getAccount());
				rs2 = smt.executeQuery();
				if(rs2.next()){	
					mySubclassCount=rs2.getInt("count");
					//System.out.println("mySubclassCount="+mySubclassCount);	
					percentCount = mySubclassCount/mapSubclassCount;
					//System.out.println("percentCount="+(mySubclassCount/mapSubclassCount));
					return percentCount;
				}
			}
			smt.executeQuery();
			rs1.close();
			rs2.close();
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
}
