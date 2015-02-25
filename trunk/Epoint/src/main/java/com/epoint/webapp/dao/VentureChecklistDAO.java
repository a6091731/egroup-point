package com.epoint.webapp.dao;

import java.util.List;

import com.epoint.webapp.entity.HumanResourceContent;
import com.epoint.webapp.entity.MapClass;
import com.epoint.webapp.entity.MapSubclass;
import com.epoint.webapp.entity.Member;
import com.epoint.webapp.entity.VentureChecklist;

public interface VentureChecklistDAO {
	//insert
	public void insertVentureCheckList(VentureChecklist ventureChecklist);
	public void insertHumanResourceContent(HumanResourceContent humanResourceContent);
	//update
	public void updateVentureCheckList(VentureChecklist ventureChecklist);
	public void updateHumanResourceContentByMember(HumanResourceContent humanResourceContent);
	//get
	public List<MapClass> getMapClassList(MapClass mapClass);
	public List<MapSubclass> getVentureCheckListByMember(Member member);
	public HumanResourceContent getHumanResourceContentByMember(Member member);
	public double getVentureChecklistPercent(Member Member);
	//check
	public boolean checkVentureCheckList(VentureChecklist ventureChecklist);
	public boolean checkHumanResourceContentByMember(Member member);
	public boolean checkVentureCheckListByMemberSubID(String account,int id);
	
	
	
	
	
	
	
	
	
}
