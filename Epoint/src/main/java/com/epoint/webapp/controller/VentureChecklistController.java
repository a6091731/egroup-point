package com.epoint.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.AbstractDocument.Content;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epoint.webapp.dao.MapSubclassDAO;
import com.epoint.webapp.dao.VentureChecklistDAO;
import com.epoint.webapp.entity.MapClass;
import com.epoint.webapp.entity.MapSubclass;
import com.epoint.webapp.entity.Member;
import com.epoint.webapp.entity.VentureChecklist;

@Controller
public class VentureChecklistController {
	ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	
	@RequestMapping(value = "/ventureTypes", method = RequestMethod.GET)
	public ModelAndView ventureTypes (HttpServletRequest request, HttpSession session){
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");
		if(memberLogin==null)
			model.setViewName("memberLogin");
		else{
			model.setViewName("ventureTypes");
			VentureChecklistDAO ventureChecklistDAO = (VentureChecklistDAO)context.getBean("ventureChecklistDAO");
			MapClass mapClass = new MapClass();
			mapClass.setId(1);
			mapClass.setAccount(memberLogin.getAccount());
			List<MapClass> getVentureCheckMenuList = ventureChecklistDAO.getMapClassList(mapClass);
			
			memberLogin.setClassID(11);
			List<MapSubclass> getVentureCheckListByMember= ventureChecklistDAO.getVentureCheckListByMember(memberLogin);
			System.out.println("size = "+ getVentureCheckListByMember.size());
			
			model.addObject("getVentureCheckMenuList",getVentureCheckMenuList);
			model.addObject("getVentureCheckListByMember", getVentureCheckListByMember);
		}			
		return model;
	}
	
	@RequestMapping(value = "/addVentureTypeCont", method = RequestMethod.POST)
	public ModelAndView addVentureTypeCont (String content111, String content112, String content113, HttpSession session){
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");		
		if(memberLogin!=null){			
			System.out.println("content111="+content111+",content112"+content112+",content113="+content113);
			addVentureCheckList(memberLogin.getAccount(),11,111,content111);
			addVentureCheckList(memberLogin.getAccount(),11,112,content112);
			addVentureCheckList(memberLogin.getAccount(),11,113,content113);
			//model.setViewName("memberLogin");
		}
		else
			model.setViewName("ventureTypes");
		return model;
	}	
	
	public void addVentureCheckList(String account, int id, int classID, String content){
		VentureChecklistDAO ventureChecklistDAO = (VentureChecklistDAO)context.getBean("ventureChecklistDAO");
		VentureChecklist ventureChecklist = new VentureChecklist();
		ventureChecklist.setAccount(account);
		ventureChecklist.setId(id);
		ventureChecklist.setClassID(classID);
		ventureChecklist.setContent(content);
		boolean flag = ventureChecklistDAO.checkVentureCheckList(ventureChecklist);
		if(flag == false){	
			System.out.println("flag");
			ventureChecklistDAO.insertVentureCheckList(ventureChecklist);			
		}
		else
			ventureChecklistDAO.updateVentureCheckList(ventureChecklist);
	}	
}
