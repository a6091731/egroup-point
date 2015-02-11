package com.epoint.webapp.dao;

import com.epoint.webapp.entity.Member;

public interface MemberDAO {
	//check
	public Member checkLogin(Member member);
	public boolean checkAccount(String account);
	public Member checkMember(String account);
	public boolean checkMemberPassword(String account,String password);
	//add
	public void addMember(Member member);
	//update
	public void updateResetNO(Member member);
	public void updatePassword(Member member);
	//add
	public Member getByResetNO(Member member);
	public int getFundLackByAccount(String account);
	
	//modi
	public void modiFundLackBy(String account,int lack);		
	public void modiVentureCapitalDateByAccount(String account,String startDate);
	public void modieMember(Member member);
}
