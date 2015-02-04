package com.epoint.webapp.dao;

import java.util.List;

import com.epoint.webapp.entity.HumanResourceContent;
import com.epoint.webapp.entity.MapClass;
import com.epoint.webapp.entity.MapSubclass;
import com.epoint.webapp.entity.Member;
import com.epoint.webapp.entity.VentureChecklist;

public interface VentureChecklistDAO {
	public void insertVentureCheckList(VentureChecklist ventureChecklist);
	public void updateVentureCheckList(VentureChecklist ventureChecklist);
	public boolean checkVentureCheckList(VentureChecklist ventureChecklist);
	public List<MapClass> getMapClassList(MapClass mapClass);
	public List<MapSubclass> getVentureCheckListByMember(Member member);
	public void insertHumanResourceContent(HumanResourceContent humanResourceContent);
	public HumanResourceContent getHumanResourceContentByMember(Member member);
	public boolean checkHumanResourceContentByMember(Member member);
	public void updateHumanResourceContentByMember(HumanResourceContent humanResourceContent);
	public double getVentureChecklistPercent(Member Member);
}
