package com.epoint.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epoint.webapp.dao.VentureChecklistDAO;
import com.epoint.webapp.entity.MapClass;
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
			List<MapClass> ventureCheckMenuList = ventureChecklistDAO.getMapClassList(mapClass);
			int ventureCheckListNow = ventureChecklistDAO.getVentrueCheckListByMember(memberLogin);
			model.addObject("ventureCheckMenuList",ventureCheckMenuList);
			model.addObject("ventureCheckListNow", ventureCheckListNow);
		}			
		return model;
	}
	
	@RequestMapping(value = "/addVentureTypeCont", method = RequestMethod.POST)
	public ModelAndView addVentureTypeCont (String content1, String content2, String content3, HttpSession session){
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");		
		if(memberLogin!=null){			
			addVentureCheckList(memberLogin.getAccount(),11,111,content1);
			addVentureCheckList(memberLogin.getAccount(),11,112,content2);
			addVentureCheckList(memberLogin.getAccount(),11,113,content3);
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
		if(flag == true){
			ventureChecklistDAO.insertVentureCheckList(ventureChecklist);
			System.out.println("flag");
		}
		else
			ventureChecklistDAO.updateVentureCheckList(ventureChecklist);
	}	
}
