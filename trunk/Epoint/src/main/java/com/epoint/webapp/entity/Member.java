package com.epoint.webapp.entity;
import java.sql.Date;

public class Member {
	private String account;
	private String password;
	private String name;
	private String phone;
	private int status;
	private Date date;
	private boolean login;
	private String memberNO;
	private String registerNO;
	private String resetNO;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isLogin() {
		return login;
	}
	public void setLogin(boolean login) {
		this.login = login;
	}
	public String getMemberNO() {
		return memberNO;
	}
	public void setMemberNO(String memberNO) {
		this.memberNO = memberNO;
	}
	public String getRegisterNO() {
		return registerNO;
	}
	public void setRegisterNO(String registerNO) {
		this.registerNO = registerNO;
	}
	public String getResetNO() {
		return resetNO;
	}
	public void setResetNO(String resetNO) {
		this.resetNO = resetNO;
	}
}
