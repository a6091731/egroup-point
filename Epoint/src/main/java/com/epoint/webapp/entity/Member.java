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
	private int lack;
	private Date capitalDate;
	
	//程式變數
	private int classID;
	//紀錄完成度變數-----------
	private double percent11;
	private double percent12;
	private double percent13;
	private double percent14;
	private double percent15;
	private double percent16;
	private double percent17;
	
	private double percent211;
	private double percent212;
	private double percent213;
	private double percent214;
	private double percent215;
	private double percent216;
	private double percent217;
	private double percent218;
	private double percent219;
	//取得哪個變數------------
	private String setPercent;
	private double getPercent;
	
	//一年總支出、總收入
	private int expenditure;
	private int income;
	
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
	public int getClassID() {
		return classID;
	}
	public void setClassID(int classID) {
		this.classID = classID;
	}
	public int getLack() {
		return lack;
	}
	public void setLack(int lack) {
		this.lack = lack;
	}			
	public Date getCapitalDate() {
		return capitalDate;
	}
	public void setCapitalDate(Date capitalDate) {
		this.capitalDate = capitalDate;
	}
	public double getPercent11() {
		return percent11;
	}
	public void setPercent11(double percent11) {
		this.percent11 = percent11;
	}
	public double getPercent12() {
		return percent12;
	}
	public void setPercent12(double percent12) {
		this.percent12 = percent12;
	}
	public double getPercent13() {
		return percent13;
	}
	public void setPercent13(double percent13) {
		this.percent13 = percent13;
	}
	public double getPercent14() {
		return percent14;
	}
	public void setPercent14(double percent14) {
		this.percent14 = percent14;
	}
	public double getPercent15() {
		return percent15;
	}
	public void setPercent15(double percent15) {
		this.percent15 = percent15;
	}
	public double getPercent16() {
		return percent16;
	}
	public void setPercent16(double percent16) {
		this.percent16 = percent16;
	}
	public double getPercent17() {
		return percent17;
	}
	public void setPercent17(double percent17) {
		this.percent17 = percent17;
	}
	public double getPercent211() {
		return percent211;
	}
	public void setPercent211(double percent211) {
		this.percent211 = percent211;
	}
	public double getPercent212() {
		return percent212;
	}
	public void setPercent212(double percent212) {
		this.percent212 = percent212;
	}
	public double getPercent213() {
		return percent213;
	}
	public void setPercent213(double percent213) {
		this.percent213 = percent213;
	}
	public double getPercent214() {
		return percent214;
	}
	public void setPercent214(double percent214) {
		this.percent214 = percent214;
	}
	public double getPercent215() {
		return percent215;
	}
	public void setPercent215(double percent215) {
		this.percent215 = percent215;
	}
	public double getPercent216() {
		return percent216;
	}
	public void setPercent216(double percent216) {
		this.percent216 = percent216;
	}
	public double getPercent217() {
		return percent217;
	}
	public void setPercent217(double percent217) {
		this.percent217 = percent217;
	}
	public double getPercent218() {
		return percent218;
	}
	public void setPercent218(double percent218) {
		this.percent218 = percent218;
	}
	public double getPercent219() {
		return percent219;
	}
	public void setPercent219(double percent219) {
		this.percent219 = percent219;
	}
	public String getSetPercent() {
		return setPercent;
	}
	public void setSetPercent(String setPercent) {
		this.setPercent = setPercent;
	}
	public double getGetPercent() {
		return getPercent;
	}
	public void setGetPercent(double getPercent) {
		this.getPercent = getPercent;
	}
	public int getExpenditure() {
		return expenditure;
	}
	public void setExpenditure(int expenditure) {
		this.expenditure = expenditure;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}		
}
