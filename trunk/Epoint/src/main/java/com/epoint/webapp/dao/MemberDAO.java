package com.epoint.webapp.dao;

import com.epoint.webapp.entity.Member;

public interface MemberDAO {
	public Member checkLogin(Member member);
	public void addMember(Member member);
	public boolean checkAccount(String account);
	public Member checkMember(String account);
	public void updateResetNO(Member member);
	public void updatePassword(Member member);
	public Member getByResetNO(Member member);
	public void modiFundLackBy(String account,int lack);
	public int getFundLackByAccount(String account);
	public void modiVentureCapitalDateByAccount(String account,String startDate);
}
