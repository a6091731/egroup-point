package com.epoint.webapp.controller;

import java.io.InputStream;
import java.util.ArrayList;
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
import com.epoint.webapp.entity.MapSubclass;
import com.epoint.webapp.entity.Member;
import com.epoint.webapp.entity.VentureChecklist;
import com.epoint.webapp.util.PropertyConstants;

@Controller
public class VentureChecklistController {
	ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	PropertyConstants PC = new PropertyConstants();
	String absolutePath;
	InputStream is = null;
	
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
			
			model.addObject("getVentureCheckMenuList",getVentureCheckMenuList);
			model.addObject("getVentureCheckListByMember", getVentureCheckListByMember);
			model.addObject("getVentureCheckMenuListNow",getVentureCheckMenuList.get(0).getNow());
			
			/*absolutePath="test.properties";	
			is =  VentureChecklistController.class.getResourceAsStream(absolutePath); 
			PC.loadProperties(is);
			String dbName=PC.getConfig("dbName");
			String serverip=PC.getConfig("serverip");
			System.out.println("dbName="+dbName+",serverip"+serverip);*/
		
		}			
		return model;
	}
	
	@RequestMapping(value = "/targetMarketDescribe", method = RequestMethod.GET)
	public ModelAndView targetMarketDescribe (HttpServletRequest request, HttpSession session){
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");
		if(memberLogin==null)
			model.setViewName("memberLogin");
		else{
			model.setViewName("targetMarketDescribe");
			VentureChecklistDAO ventureChecklistDAO = (VentureChecklistDAO)context.getBean("ventureChecklistDAO");
			MapClass mapClass = new MapClass();
			mapClass.setId(1);
			mapClass.setAccount(memberLogin.getAccount());
			List<MapClass> getVentureCheckMenuList = ventureChecklistDAO.getMapClassList(mapClass);
			
			memberLogin.setClassID(12);
			List<MapSubclass> getVentureCheckListByMember= ventureChecklistDAO.getVentureCheckListByMember(memberLogin);
			
			model.addObject("getVentureCheckMenuList",getVentureCheckMenuList);
			model.addObject("getVentureCheckListByMember", getVentureCheckListByMember);
			model.addObject("getVentureCheckMenuListNow",getVentureCheckMenuList.get(0).getNow());
		}
		
		return model;
	}
	
	@RequestMapping(value = "/businessSales", method = RequestMethod.GET)
	public ModelAndView businessSales (HttpServletRequest request, HttpSession session){
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");
		if(memberLogin==null)
			model.setViewName("memberLogin");
		else{
			model.setViewName("businessSales");
			VentureChecklistDAO ventureChecklistDAO = (VentureChecklistDAO)context.getBean("ventureChecklistDAO");
			MapClass mapClass = new MapClass();
			mapClass.setId(1);
			mapClass.setAccount(memberLogin.getAccount());
			List<MapClass> getVentureCheckMenuList = ventureChecklistDAO.getMapClassList(mapClass);
			
			memberLogin.setClassID(14);
			List<MapSubclass> getVentureCheckListByMember= ventureChecklistDAO.getVentureCheckListByMember(memberLogin);
			
			model.addObject("getVentureCheckMenuList",getVentureCheckMenuList);
			model.addObject("getVentureCheckListByMember", getVentureCheckListByMember);
			model.addObject("getVentureCheckMenuListNow",getVentureCheckMenuList.get(0).getNow());
		}
		
		return model;
	}
	
	@RequestMapping(value = "/marketPromote", method = RequestMethod.GET)
	public ModelAndView marketPromote (HttpServletRequest request, HttpSession session){
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");
		if(memberLogin==null)
			model.setViewName("memberLogin");
		else{
			model.setViewName("marketPromote");
			VentureChecklistDAO ventureChecklistDAO = (VentureChecklistDAO)context.getBean("ventureChecklistDAO");
			MapClass mapClass = new MapClass();
			mapClass.setId(1);
			mapClass.setAccount(memberLogin.getAccount());
			List<MapClass> getVentureCheckMenuList = ventureChecklistDAO.getMapClassList(mapClass);
			
			memberLogin.setClassID(15);
			List<MapSubclass> getVentureCheckListByMember= ventureChecklistDAO.getVentureCheckListByMember(memberLogin);
			
			model.addObject("getVentureCheckMenuList",getVentureCheckMenuList);
			model.addObject("getVentureCheckListByMember", getVentureCheckListByMember);
			model.addObject("getVentureCheckMenuListNow",getVentureCheckMenuList.get(0).getNow());
		}
		
		return model;
	}
	
	@RequestMapping(value = "/showAllProductDescribe", method = RequestMethod.GET)
	public ModelAndView showAllProductDescribe (HttpServletRequest request, HttpSession session){
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");
		if(memberLogin==null)
			model.setViewName("memberLogin");
		else{
			model.setViewName("showAllProductDescribe");
			VentureChecklistDAO ventureChecklistDAO = (VentureChecklistDAO)context.getBean("ventureChecklistDAO");
			MapClass mapClass = new MapClass();
			mapClass.setId(1);
			mapClass.setAccount(memberLogin.getAccount());
			List<MapClass> getVentureCheckMenuList = ventureChecklistDAO.getMapClassList(mapClass);
			
			memberLogin.setClassID(15);
			List<MapSubclass> getVentureCheckListByMember= ventureChecklistDAO.getVentureCheckListByMember(memberLogin);
			
			model.addObject("getVentureCheckMenuList",getVentureCheckMenuList);
			model.addObject("getVentureCheckListByMember", getVentureCheckListByMember);
			model.addObject("getVentureCheckMenuListNow",getVentureCheckMenuList.get(0).getNow());
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
			model.setViewName("redirect:/targetMarketDescribe");
		}
		else
			model.setViewName("memberLogin");
		return model;
	}	
	
	@RequestMapping(value = "/addTargetMarketDescribeCont", method = RequestMethod.POST)
	public ModelAndView addTargetMarketDescribeCont (String content121, String content122, String content123, HttpSession session){
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");		
		if(memberLogin!=null){			
			System.out.println("content121="+content121+",content122"+content122+",content123="+content123);
			addVentureCheckList(memberLogin.getAccount(),12,121,content121);
			addVentureCheckList(memberLogin.getAccount(),12,122,content122);
			addVentureCheckList(memberLogin.getAccount(),12,123,content123);
			//model.setViewName("redirect:/memberLogin");
		}
		else
			model.setViewName("memberLogin");
		return model;
	}	
	
	@RequestMapping(value = "/addBusinessSales", method = RequestMethod.POST)
	public ModelAndView addBusinessSales (String content141, String content142, HttpSession session){
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");		
		if(memberLogin!=null){			
			System.out.println("content141="+content141+",content142"+content142);
			addVentureCheckList(memberLogin.getAccount(),14,141,content141);
			addVentureCheckList(memberLogin.getAccount(),14,142,content142);
			model.setViewName("redirect:/marketPromote");
		}
		else
			model.setViewName("memberLogin");
		return model;
	}	
	
	@RequestMapping(value = "/addMarketPromote", method = RequestMethod.POST)
	public ModelAndView addMarketPromote (String content151, String content152, String content153, HttpSession session){
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");		
		if(memberLogin!=null){			
			System.out.println("content151="+content151+",content152"+content152+",content153="+content153);
			addVentureCheckList(memberLogin.getAccount(),15,151,content151);
			addVentureCheckList(memberLogin.getAccount(),15,152,content152);
			addVentureCheckList(memberLogin.getAccount(),15,153,content153);
			//model.setViewName("redirect:/memberLogin");
		}
		else
			model.setViewName("memberLogin");
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
			System.out.println("flag1");
			ventureChecklistDAO.insertVentureCheckList(ventureChecklist);			
		}
		else{
			System.out.println("flag2");
			ventureChecklistDAO.updateVentureCheckList(ventureChecklist);			
		}
	}	
}
