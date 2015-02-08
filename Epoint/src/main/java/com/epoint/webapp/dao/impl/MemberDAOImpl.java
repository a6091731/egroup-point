package com.epoint.webapp.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import com.epoint.webapp.dao.MemberDAO;
import com.epoint.webapp.entity.Member;

public class MemberDAOImpl implements MemberDAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
		
	public Member checkLogin(Member member) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM member WHERE memberAccount=? AND memberPassword=? "
				+ "AND memberStatus=1";
		member.setLogin(false);
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, member.getAccount());
			smt.setString(2, member.getPassword());
			rs = smt.executeQuery();
			if(rs.next()){
				member.setPassword("");
				member.setName(rs.getString("memberName"));
				member.setPhone(rs.getString("memberPhone"));
				member.setDate(rs.getDate("registerDate"));
				member.setCapitalDate(rs.getDate("ventureCapitalDate"));
				member.setLogin(true);
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
		return member;
	}

	public void addMember(Member member) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO member(memberAccount,memberPassword,memberName,"
				+ "memberStatus,memberNO,registerDate) SELECT ?,?,?,?,MAX(memberNO)+1,"
				+ "NOW() FROM member";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1,member.getAccount());
			smt.setString(2,member.getPassword());
			smt.setString(3,member.getName());
			smt.setString(4,"0");
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

	public boolean checkAccount(String account) {
		// TODO Auto-generated method stub
		boolean flag = true;
		String sql = "SELECT * FROM member WHERE memberAccount = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, account);
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

	public Member checkMember(String account) {
		// TODO Auto-generated method stub
		Member member = new Member();
		String sql = "SELECT * FROM member WHERE memberAccount=?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, account);
			rs = smt.executeQuery();
			if(rs.next()){
				member.setAccount(account);
				member.setName(rs.getString("memberName"));
				member.setDate(rs.getDate("registerDate"));
				member.setPhone(rs.getString("memberPhone"));
				member.setRegisterNO(rs.getString("registerNO"));
				member.setMemberNO(rs.getString("memberNO"));
				member.setResetNO(rs.getString("resetNO"));
				member.setStatus(rs.getInt("memberStatus"));
				member.setCapitalDate(rs.getDate("ventureCapitalDate"));
			}
			rs.close();
			smt.close();
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){}
			}
		
		} 
		return member;
	}

	public void updateResetNO(Member member) {
		// TODO Auto-generated method stub
		String sql = "UPDATE member SET resetNO = ?, resetDate = NOW() WHERE memberAccount = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1,member.getResetNO());
			smt.setString(2,member.getAccount());
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

	public void updatePassword(Member member) {
		// TODO Auto-generated method stub
		String sql = "UPDATE member SET memberPassword=?, resetNO='', resetDate=NULL "
				+ "WHERE memberAccount=?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1,member.getPassword());
			smt.setString(2,member.getAccount());			
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
	
	//根據重設代碼取得資料
	public Member getByResetNO(Member member) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM member WHERE resetNO=?";
		member.setLogin(false);
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, member.getResetNO());
			rs = smt.executeQuery();
			if(rs.next()){
				member.setAccount(rs.getString("memberAccount"));
				member.setName(rs.getString("memberName"));			
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
		return member;
	}
	
	public void modiFundLackBy(String account,int lack) {
		String sql = "UPDATE member SET fundLack = ? WHERE memberAccount = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1,lack);
			smt.setString(2,account);
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
	
	public int getFundLackByAccount(String account) {
		// TODO Auto-generated method stub
		String sql = "SELECT fundLack FROM member WHERE memberAccount = ?";
		int lack = 0;
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, account);
			rs = smt.executeQuery();
			if(rs.next()){
				lack = rs.getInt("fundLack");
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
		return lack;
	}
	
	public void modiVentureCapitalDateByAccount(String account,String startDate) {
		String sql = "UPDATE member SET ventureCapitalDate = ? WHERE memberAccount = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1,startDate);
			smt.setString(2,account);
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
}
