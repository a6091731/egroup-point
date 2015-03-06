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
	//如果method裡面有一句以上的Sl，請使用Sl1,Sl2分開
	private String Sl;
	private String Sl1;
	private String Sl2;
	//flag用來判斷回傳的true or false
	private boolean flag;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void insertVentureCheckList(VentureChecklist ventureChecklist){
		Sl = "INSERT INTO venture_checklist (memberAccount, mapClassID, mapSubClassID, ventureChecklistContent) "
				+ "VALUES (?, ?, ?, ?)";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(Sl);
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
		Sl = "SELECT * FROM venture_checklist WHERE memberAccount = ? AND mapSubClassID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(Sl);
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
		Sl = "UPDATE venture_checklist SET ventureChecklistContent = ? WHERE memberAccount= ? AND mapSubClassID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(Sl);
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
		//String Sl = "SELECT * FROM map_class LEFT JOIN venture_checklist ON map_class.mapClassID = venture_checklist.mapClassID WHERE mapID = ?";
		Sl1 = "SELECT * FROM map_class WHERE mapID = ?";
		Sl2 = "SELECT MAX(mapClassID) AS now FROM venture_checklist WHERE memberAccount = ? "
				+ "GROUP BY memberAccount";
		boolean now = false;
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(Sl1);
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
					smt = conn.prepareStatement(Sl2);
					smt.setString(1, mapClass.getAccount());
					rs2 = smt.executeQuery();
					while(rs2.next()){
						mapClass2.setNow(rs2.getInt("now"));	
						if(mapClass2.getNow()<13){
							String Sl3 = "SELECT * FROM product WHERE memberAccount = ?";
							smt = conn.prepareStatement(Sl3);
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
		Sl1 = "SELECT * FROM map_subclass WHERE mapClassID = ?";
		Sl2 = "SELECT MAX(mapClassID) AS now ,ventureChecklistContent FROM venture_checklist "
				+ "WHERE memberAccount = ? AND mapSubClassID = ? GROUP BY mapClassID";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(Sl1);
			smt.setInt(1, member.getClassID());
			rs1 = smt.executeQuery();
			while(rs1.next()){				
				MapSubclass mapSubclass = new MapSubclass();				
				mapSubclass.setClassID(rs1.getInt("mapClassID"));
				mapSubclass.setSubclassID(rs1.getInt("mapSubClassID"));
				mapSubclass.setName(rs1.getString("mapSubClassName"));				
				smt = conn.prepareStatement(Sl2);
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
		Sl = "INSERT INTO human_resource_content (memberAccount, M0, M1, M2, M3, M4, M5, M6, M7, M8, M9,"
				+ "M10, M11, M12, R0, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12,"
				+ "S0, S1, S2, S3, S4, S5, S6, S7, S8, S9, S10, S11, S12, O0, O1, O2, O3, O4, O5, O6, O7, O8, O9,"
				+ "O10, O11, O12, total0, total1, total2, total3, total4, total5, total6, total7, " 
				+ "total8, total9, total10, total11, total12) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
				+ " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			System.out.println("123456");
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(Sl);
			smt.setString(1, humanResourceContent.getAccount());
			smt.setInt(2, humanResourceContent.getM0());
			smt.setInt(3, humanResourceContent.getM1());
			smt.setInt(4, humanResourceContent.getM2());
			smt.setInt(5, humanResourceContent.getM3());
			smt.setInt(6, humanResourceContent.getM4());
			smt.setInt(7, humanResourceContent.getM5());
			smt.setInt(8, humanResourceContent.getM6());
			smt.setInt(9, humanResourceContent.getM7());
			smt.setInt(10, humanResourceContent.getM8());
			smt.setInt(11, humanResourceContent.getM9());
			smt.setInt(12, humanResourceContent.getM10());
			smt.setInt(13, humanResourceContent.getM11());
			smt.setInt(14, humanResourceContent.getM12());
			
			smt.setInt(15, humanResourceContent.getR0());
			smt.setInt(16, humanResourceContent.getR1());
			smt.setInt(17, humanResourceContent.getR2());
			smt.setInt(18, humanResourceContent.getR3());
			smt.setInt(19, humanResourceContent.getR4());
			smt.setInt(20, humanResourceContent.getR5());
			smt.setInt(21, humanResourceContent.getR6());
			smt.setInt(22, humanResourceContent.getR7());
			smt.setInt(23, humanResourceContent.getR8());
			smt.setInt(24, humanResourceContent.getR9());
			smt.setInt(25, humanResourceContent.getR10());
			smt.setInt(26, humanResourceContent.getR11());
			smt.setInt(27, humanResourceContent.getR12());
			
			smt.setInt(28, humanResourceContent.getS0());
			smt.setInt(29, humanResourceContent.getS1());
			smt.setInt(30, humanResourceContent.getS2());
			smt.setInt(31, humanResourceContent.getS3());
			smt.setInt(32, humanResourceContent.getS4());
			smt.setInt(33, humanResourceContent.getS5());
			smt.setInt(34, humanResourceContent.getS6());
			smt.setInt(35, humanResourceContent.getS7());
			smt.setInt(36, humanResourceContent.getS8());
			smt.setInt(37, humanResourceContent.getS9());
			smt.setInt(38, humanResourceContent.getS10());
			smt.setInt(39, humanResourceContent.getS11());
			smt.setInt(40, humanResourceContent.getS12());
			
			smt.setInt(41, humanResourceContent.getO0());
			smt.setInt(42, humanResourceContent.getO1());
			smt.setInt(43, humanResourceContent.getO2());
			smt.setInt(44, humanResourceContent.getO3());
			smt.setInt(45, humanResourceContent.getO4());
			smt.setInt(46, humanResourceContent.getO5());
			smt.setInt(47, humanResourceContent.getO6());
			smt.setInt(48, humanResourceContent.getO7());
			smt.setInt(49, humanResourceContent.getO8());
			smt.setInt(50, humanResourceContent.getO9());
			smt.setInt(51, humanResourceContent.getO10());
			smt.setInt(52, humanResourceContent.getO11());
			smt.setInt(53, humanResourceContent.getO12());
			
			smt.setInt(54, humanResourceContent.getTotal0());
			smt.setInt(55, humanResourceContent.getTotal1());
			smt.setInt(56, humanResourceContent.getTotal2());
			smt.setInt(57, humanResourceContent.getTotal3());
			smt.setInt(58, humanResourceContent.getTotal4());
			smt.setInt(59, humanResourceContent.getTotal5());
			smt.setInt(60, humanResourceContent.getTotal6());
			smt.setInt(61, humanResourceContent.getTotal7());
			smt.setInt(62, humanResourceContent.getTotal8());
			smt.setInt(63, humanResourceContent.getTotal9());
			smt.setInt(64, humanResourceContent.getTotal10());
			smt.setInt(65, humanResourceContent.getTotal11());
			smt.setInt(66, humanResourceContent.getTotal12());
			
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
		Sl = "SELECT * FROM human_resource_content WHERE memberAccount = ?";
		HumanResourceContent humanResourceContent = new HumanResourceContent();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(Sl);
			smt.setString(1, member.getAccount());
			rs = smt.executeQuery();
			if(rs.next()){				
				humanResourceContent.setM0(rs.getInt("M0"));
				humanResourceContent.setM1(rs.getInt("M1"));
				humanResourceContent.setM2(rs.getInt("M2"));
				humanResourceContent.setM3(rs.getInt("M3"));
				humanResourceContent.setM4(rs.getInt("M4"));
				humanResourceContent.setM5(rs.getInt("M5"));
				humanResourceContent.setM6(rs.getInt("M6"));
				humanResourceContent.setM7(rs.getInt("M7"));
				humanResourceContent.setM8(rs.getInt("M8"));
				humanResourceContent.setM9(rs.getInt("M9"));
				humanResourceContent.setM10(rs.getInt("M10"));
				humanResourceContent.setM11(rs.getInt("M11"));
				humanResourceContent.setM12(rs.getInt("M12"));
				
				humanResourceContent.setR0(rs.getInt("R0"));
				humanResourceContent.setR1(rs.getInt("R1"));
				humanResourceContent.setR2(rs.getInt("R2"));
				humanResourceContent.setR3(rs.getInt("R3"));
				humanResourceContent.setR4(rs.getInt("R4"));
				humanResourceContent.setR5(rs.getInt("R5"));
				humanResourceContent.setR6(rs.getInt("R6"));
				humanResourceContent.setR7(rs.getInt("R7"));
				humanResourceContent.setR8(rs.getInt("R8"));
				humanResourceContent.setR9(rs.getInt("R9"));
				humanResourceContent.setR10(rs.getInt("R10"));
				humanResourceContent.setR11(rs.getInt("R11"));
				humanResourceContent.setR12(rs.getInt("R12"));
				
				humanResourceContent.setS0(rs.getInt("S0"));
				humanResourceContent.setS1(rs.getInt("S1"));
				humanResourceContent.setS2(rs.getInt("S2"));
				humanResourceContent.setS3(rs.getInt("S3"));
				humanResourceContent.setS4(rs.getInt("S4"));
				humanResourceContent.setS5(rs.getInt("S5"));
				humanResourceContent.setS6(rs.getInt("S6"));
				humanResourceContent.setS7(rs.getInt("S7"));
				humanResourceContent.setS8(rs.getInt("S8"));
				humanResourceContent.setS9(rs.getInt("S9"));
				humanResourceContent.setS10(rs.getInt("S10"));
				humanResourceContent.setS11(rs.getInt("S11"));
				humanResourceContent.setS12(rs.getInt("S12"));
				
				humanResourceContent.setO0(rs.getInt("O0"));
				humanResourceContent.setO1(rs.getInt("O1"));
				humanResourceContent.setO2(rs.getInt("O2"));
				humanResourceContent.setO3(rs.getInt("O3"));
				humanResourceContent.setO4(rs.getInt("O4"));
				humanResourceContent.setO5(rs.getInt("O5"));
				humanResourceContent.setO6(rs.getInt("O6"));
				humanResourceContent.setO7(rs.getInt("O7"));
				humanResourceContent.setO8(rs.getInt("O8"));
				humanResourceContent.setO9(rs.getInt("O9"));
				humanResourceContent.setO10(rs.getInt("O10"));
				humanResourceContent.setO11(rs.getInt("O11"));
				humanResourceContent.setO12(rs.getInt("O12"));
				
				humanResourceContent.setTotal0(rs.getInt("total0"));
				humanResourceContent.setTotal1(rs.getInt("total1"));
				humanResourceContent.setTotal2(rs.getInt("total2"));
				humanResourceContent.setTotal3(rs.getInt("total3"));
				humanResourceContent.setTotal4(rs.getInt("total4"));
				humanResourceContent.setTotal5(rs.getInt("total5"));
				humanResourceContent.setTotal6(rs.getInt("total6"));
				humanResourceContent.setTotal7(rs.getInt("total7"));
				humanResourceContent.setTotal8(rs.getInt("total8"));
				humanResourceContent.setTotal9(rs.getInt("total9"));
				humanResourceContent.setTotal10(rs.getInt("total10"));
				humanResourceContent.setTotal11(rs.getInt("total11"));
				humanResourceContent.setTotal12(rs.getInt("total12"));
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
		Sl = "SELECT * FROM human_resource_content WHERE memberAccount=?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(Sl);
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
		String Sl = "UPDATE human_resource_content SET memberAccount=?, M0=?, M1=?, M2=?, M3=?, M4=?, "
				+ "M5=?, M6=?, M7=?, M8=?, M9=?, M10=?, M11=?, M12=?, R0=?, R1=?, R2=?, R3=?, R4=?, "
				+ "R5=?, R6=?, R7=?, R8=?, R9=?, R10=?, R11=?, R12=?, S0=?, S1=?, S2=?, S3=?, S4=?, "
				+ "S5=?, S6=?, S7=?, S8=?, S9=?, S10=?, S11=?, S12=?, O0=?, O1=?, O2=?, O3=?, O4=?, "
				+ "O5=?, O6=?, O7=?, O8=?, O9=?, O10=?, O11=?, O12=?, total0=?, total1=?, total2=?, total3=?, total4=?, "
				+ "total5=?, total6=?, total7=?, total8=?, total9=?, total10=?, total11=?, total12=? "
				+ "WHERE memberAccount = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(Sl);
			smt.setString(1,humanResourceContent.getAccount());
			smt.setInt(2,humanResourceContent.getM0());
			smt.setInt(3, humanResourceContent.getM1());
			smt.setInt(4, humanResourceContent.getM2());
			smt.setInt(5, humanResourceContent.getM3());
			smt.setInt(6, humanResourceContent.getM4());
			smt.setInt(7, humanResourceContent.getM5());
			smt.setInt(8, humanResourceContent.getM6());
			smt.setInt(9, humanResourceContent.getM7());
			smt.setInt(10, humanResourceContent.getM8());
			smt.setInt(11, humanResourceContent.getM9());
			smt.setInt(12, humanResourceContent.getM10());
			smt.setInt(13, humanResourceContent.getM11());
			smt.setInt(14, humanResourceContent.getM12());
			
			smt.setInt(15, humanResourceContent.getR0());
			smt.setInt(16, humanResourceContent.getR1());
			smt.setInt(17, humanResourceContent.getR2());
			smt.setInt(18, humanResourceContent.getR3());
			smt.setInt(19, humanResourceContent.getR4());
			smt.setInt(20, humanResourceContent.getR5());
			smt.setInt(21, humanResourceContent.getR6());
			smt.setInt(22, humanResourceContent.getR7());
			smt.setInt(23, humanResourceContent.getR8());
			smt.setInt(24, humanResourceContent.getR9());
			smt.setInt(25, humanResourceContent.getR10());
			smt.setInt(26, humanResourceContent.getR11());
			smt.setInt(27, humanResourceContent.getR12());
			
			smt.setInt(28, humanResourceContent.getS0());
			smt.setInt(29, humanResourceContent.getS1());
			smt.setInt(30, humanResourceContent.getS2());
			smt.setInt(31, humanResourceContent.getS3());
			smt.setInt(32, humanResourceContent.getS4());
			smt.setInt(33, humanResourceContent.getS5());
			smt.setInt(34, humanResourceContent.getS6());
			smt.setInt(35, humanResourceContent.getS7());
			smt.setInt(36, humanResourceContent.getS8());
			smt.setInt(37, humanResourceContent.getS9());
			smt.setInt(38, humanResourceContent.getS10());
			smt.setInt(39, humanResourceContent.getS11());
			smt.setInt(40, humanResourceContent.getS12());
			
			smt.setInt(41, humanResourceContent.getO0());
			smt.setInt(42, humanResourceContent.getO1());
			smt.setInt(43, humanResourceContent.getO2());
			smt.setInt(44, humanResourceContent.getO3());
			smt.setInt(45, humanResourceContent.getO4());
			smt.setInt(46, humanResourceContent.getO5());
			smt.setInt(47, humanResourceContent.getO6());
			smt.setInt(48, humanResourceContent.getO7());
			smt.setInt(49, humanResourceContent.getO8());
			smt.setInt(50, humanResourceContent.getO9());
			smt.setInt(51, humanResourceContent.getO10());
			smt.setInt(52, humanResourceContent.getO11());
			smt.setInt(53, humanResourceContent.getO12());
			
			smt.setInt(54, humanResourceContent.getTotal0());
			smt.setInt(55, humanResourceContent.getTotal1());
			smt.setInt(56, humanResourceContent.getTotal2());
			smt.setInt(57, humanResourceContent.getTotal3());
			smt.setInt(58, humanResourceContent.getTotal4());
			smt.setInt(59, humanResourceContent.getTotal5());
			smt.setInt(60, humanResourceContent.getTotal6());
			smt.setInt(61, humanResourceContent.getTotal7());
			smt.setInt(62, humanResourceContent.getTotal8());
			smt.setInt(63, humanResourceContent.getTotal9());
			smt.setInt(64, humanResourceContent.getTotal10());
			smt.setInt(65, humanResourceContent.getTotal11());
			smt.setInt(66, humanResourceContent.getTotal12());
			
			smt.setString(67,humanResourceContent.getAccount());
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
		Sl1 = "SELECT COUNT(*) AS count FROM map_subclass WHERE mapClassID=?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(Sl1);
			smt.setString(1, member1.getSetPercent());
			System.out.println("getSetPercent()="+member1.getSetPercent());
			rs1 = smt.executeQuery();
			if(rs1.next()){	
				mapSubclassCount=rs1.getInt("count");
				System.out.println("mapSubclassCount="+mapSubclassCount);				
				Sl2 = "SELECT COUNT(*) AS count FROM venture_checklist WHERE mapClassID=? AND memberAccount =? ";
				smt = conn.prepareStatement(Sl2);
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

	public boolean checkVentureCheckListByMemberSubID(String account, int id) {
		// TODO Auto-generated method stub
		Sl = "SELECT * FROM venture_checklist WHERE memberAccount=? AND mapSubClassID=?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(Sl);
			smt.setString(1, account);
			smt.setInt(2, id);
			rs = smt.executeQuery();
			if(rs.next()){				
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
}
