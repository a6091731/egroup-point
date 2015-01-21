package com.epoint.webapp.controller;

import java.io.InputStream;
import java.util.List;

import javax.mail.Flags.Flag;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epoint.webapp.dao.VentureChecklistDAO;
import com.epoint.webapp.entity.HumanResourceContent;
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
	
	@RequestMapping(value = "/businessMarket", method = RequestMethod.GET)
	public ModelAndView marketPromote (HttpServletRequest request, HttpSession session){
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");
		if(memberLogin==null)
			model.setViewName("memberLogin");
		else{
			model.setViewName("businessMarket");
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
	
	@RequestMapping(value = "/humanResourcePlan", method = RequestMethod.GET)
	public ModelAndView humanResoucePlan (HttpServletRequest request, HttpSession session){
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");
		if(memberLogin==null)
			model.setViewName("memberLogin");
		else{
			model.setViewName("humanResourcePlan");			
			VentureChecklistDAO ventureChecklistDAO = (VentureChecklistDAO)context.getBean("ventureChecklistDAO");
			MapClass mapClass = new MapClass();
			mapClass.setId(1);
			mapClass.setAccount(memberLogin.getAccount());
			List<MapClass> getVentureCheckMenuList = ventureChecklistDAO.getMapClassList(mapClass);
		
			memberLogin.setClassID(17);
			List<MapSubclass> getVentureCheckListByMember= ventureChecklistDAO.getVentureCheckListByMember(memberLogin);
			
			HumanResourceContent getHumanResourceContentByMember = ventureChecklistDAO.getHumanResourceContentByMember(memberLogin);			
			if(getHumanResourceContentByMember!=null){
				getHumanResourceContentByMember.setMQ0(getHumanResourceContentByMember.getMQ0()==0?0:getHumanResourceContentByMember.getMQ0());
				getHumanResourceContentByMember.setMQ1(getHumanResourceContentByMember.getMQ1()==0?0:getHumanResourceContentByMember.getMQ1());
				getHumanResourceContentByMember.setMQ2(getHumanResourceContentByMember.getMQ2()==0?0:getHumanResourceContentByMember.getMQ2());
				getHumanResourceContentByMember.setMQ3(getHumanResourceContentByMember.getMQ3()==0?0:getHumanResourceContentByMember.getMQ3());
				getHumanResourceContentByMember.setMQ4(getHumanResourceContentByMember.getMQ4()==0?0:getHumanResourceContentByMember.getMQ4());
				getHumanResourceContentByMember.setRQ0(getHumanResourceContentByMember.getRQ0()==0?0:getHumanResourceContentByMember.getRQ0());
				getHumanResourceContentByMember.setRQ1(getHumanResourceContentByMember.getRQ1()==0?0:getHumanResourceContentByMember.getRQ1());
				getHumanResourceContentByMember.setRQ2(getHumanResourceContentByMember.getRQ2()==0?0:getHumanResourceContentByMember.getRQ2());
				getHumanResourceContentByMember.setRQ3(getHumanResourceContentByMember.getRQ3()==0?0:getHumanResourceContentByMember.getRQ3());
				getHumanResourceContentByMember.setRQ4(getHumanResourceContentByMember.getRQ4()==0?0:getHumanResourceContentByMember.getRQ4());
				getHumanResourceContentByMember.setSQ0(getHumanResourceContentByMember.getSQ0()==0?0:getHumanResourceContentByMember.getSQ0());
				getHumanResourceContentByMember.setSQ1(getHumanResourceContentByMember.getSQ1()==0?0:getHumanResourceContentByMember.getSQ1());
				getHumanResourceContentByMember.setSQ2(getHumanResourceContentByMember.getSQ2()==0?0:getHumanResourceContentByMember.getSQ2());
				getHumanResourceContentByMember.setSQ3(getHumanResourceContentByMember.getSQ3()==0?0:getHumanResourceContentByMember.getSQ3());
				getHumanResourceContentByMember.setSQ4(getHumanResourceContentByMember.getSQ4()==0?0:getHumanResourceContentByMember.getSQ4());
				getHumanResourceContentByMember.setOQ0(getHumanResourceContentByMember.getOQ0()==0?0:getHumanResourceContentByMember.getOQ0());
				getHumanResourceContentByMember.setOQ1(getHumanResourceContentByMember.getOQ1()==0?0:getHumanResourceContentByMember.getOQ1());
				getHumanResourceContentByMember.setOQ2(getHumanResourceContentByMember.getOQ2()==0?0:getHumanResourceContentByMember.getOQ2());
				getHumanResourceContentByMember.setOQ3(getHumanResourceContentByMember.getOQ3()==0?0:getHumanResourceContentByMember.getOQ3());
				getHumanResourceContentByMember.setOQ4(getHumanResourceContentByMember.getOQ4()==0?0:getHumanResourceContentByMember.getOQ4());
				getHumanResourceContentByMember.setTotalQ0(getHumanResourceContentByMember.getTotalQ0()==0?0:getHumanResourceContentByMember.getTotalQ0());
				getHumanResourceContentByMember.setTotalQ1(getHumanResourceContentByMember.getTotalQ1()==0?0:getHumanResourceContentByMember.getTotalQ1());
				getHumanResourceContentByMember.setTotalQ2(getHumanResourceContentByMember.getTotalQ2()==0?0:getHumanResourceContentByMember.getTotalQ2());
				getHumanResourceContentByMember.setTotalQ3(getHumanResourceContentByMember.getTotalQ3()==0?0:getHumanResourceContentByMember.getTotalQ3());
				getHumanResourceContentByMember.setTotalQ4(getHumanResourceContentByMember.getTotalQ4()==0?0:getHumanResourceContentByMember.getTotalQ4());
			}
			else {
				getHumanResourceContentByMember.setMQ0(0);
				getHumanResourceContentByMember.setMQ1(0);
				getHumanResourceContentByMember.setMQ2(0);
				getHumanResourceContentByMember.setMQ3(0);
				getHumanResourceContentByMember.setMQ4(0);
				getHumanResourceContentByMember.setRQ0(0);
				getHumanResourceContentByMember.setRQ1(0);
				getHumanResourceContentByMember.setRQ2(0);
				getHumanResourceContentByMember.setRQ3(0);
				getHumanResourceContentByMember.setRQ4(0);
				getHumanResourceContentByMember.setSQ0(0);
				getHumanResourceContentByMember.setSQ1(0);
				getHumanResourceContentByMember.setSQ2(0);
				getHumanResourceContentByMember.setSQ3(0);
				getHumanResourceContentByMember.setSQ4(0);
				getHumanResourceContentByMember.setOQ0(0);
				getHumanResourceContentByMember.setOQ1(0);
				getHumanResourceContentByMember.setOQ2(0);
				getHumanResourceContentByMember.setOQ3(0);
				getHumanResourceContentByMember.setOQ4(0);
				getHumanResourceContentByMember.setTotalQ0(0);
				getHumanResourceContentByMember.setTotalQ1(0);
				getHumanResourceContentByMember.setTotalQ2(0);
				getHumanResourceContentByMember.setTotalQ3(0);
				getHumanResourceContentByMember.setTotalQ4(0);
			}
			model.addObject("getVentureCheckMenuList",getVentureCheckMenuList);
			model.addObject("getVentureCheckListByMember", getVentureCheckListByMember);
			model.addObject("getVentureCheckMenuListNow",getVentureCheckMenuList.get(0).getNow());
			model.addObject("getHumanResourceContentByMember",getHumanResourceContentByMember);
		}
		
		return model;
	}
	
	@RequestMapping(value = "/addVentureTypeCont", method = RequestMethod.POST)
	public ModelAndView addVentureTypeCont (String content111, String content112, String content113, HttpSession session){
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");		
		if(memberLogin!=null){			
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
			addVentureCheckList(memberLogin.getAccount(),14,141,content141);
			addVentureCheckList(memberLogin.getAccount(),14,142,content142);
			model.setViewName("redirect:/businessMarket");
		}
		else
			model.setViewName("memberLogin");
		return model;
	}	
	
	@RequestMapping(value = "/addBusinessMarket", method = RequestMethod.POST)
	public ModelAndView addMarketPromote (String content151, String content152, String content153, HttpSession session){
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");		
		if(memberLogin!=null){		
			addVentureCheckList(memberLogin.getAccount(),15,151,content151);
			addVentureCheckList(memberLogin.getAccount(),15,152,content152);
			addVentureCheckList(memberLogin.getAccount(),15,153,content153);
			//model.setViewName("redirect:/memberLogin");
		}
		else
			model.setViewName("memberLogin");
		return model;
	}	
	
	@RequestMapping(value = "/addHumanResourcePlan", method = RequestMethod.POST)
	public ModelAndView addHumanResourcePlan (String content171, String content172, String content173, 
			HumanResourceContent humanResourceContent, HttpSession session){
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");		
		if(memberLogin!=null){	
			System.out.println("***addHumanResourcePlan1!!!");
			model.setViewName("redirect:/humanResourcePlan");
			addVentureCheckList(memberLogin.getAccount(),17,171,content171);
			addVentureCheckList(memberLogin.getAccount(),17,172,content172);
			addVentureCheckList(memberLogin.getAccount(),17,173,content173);
			VentureChecklistDAO ventureChecklistDAO = (VentureChecklistDAO)context.getBean("ventureChecklistDAO");
			humanResourceContent.setAccount(memberLogin.getAccount());
			boolean flag = ventureChecklistDAO.checkHumanResourceContentByMember(memberLogin);
			if(flag==false)
				ventureChecklistDAO.insertHumanResourceContent(humanResourceContent);
			else
				ventureChecklistDAO.updateHumanResourceContentByMember(humanResourceContent);
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
