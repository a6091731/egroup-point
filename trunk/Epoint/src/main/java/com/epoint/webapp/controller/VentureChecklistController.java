package com.epoint.webapp.controller;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epoint.webapp.dao.ProductDAO;
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
	
	@RequestMapping(value = "/ventureChecklistMap", method = RequestMethod.GET)
	public ModelAndView ventureChecklistMap (HttpServletRequest request, HttpSession session){
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");
		if(memberLogin==null)
			model.setViewName("memberLogin");
		else{			
			model.setViewName("ventureChecklistMap");	
			VentureChecklistDAO ventureChecklistDAO = (VentureChecklistDAO)context.getBean("ventureChecklistDAO");
			ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
			DecimalFormat df = new DecimalFormat("0.00");
			memberLogin.setSetPercent("11");			
			memberLogin.setPercent11(Double.parseDouble(df.format(ventureChecklistDAO.getVentureChecklistPercent(memberLogin)))*100);
			memberLogin.setSetPercent("12");
			memberLogin.setPercent12(Double.parseDouble(df.format(ventureChecklistDAO.getVentureChecklistPercent(memberLogin)))*100);
			//************************
			//Product 紀錄比數，但不記錄完成度
			memberLogin.setProductCount(productDAO.countProductByMember(memberLogin));
			//************************
			memberLogin.setSetPercent("14");
			memberLogin.setPercent14(Double.parseDouble(df.format(ventureChecklistDAO.getVentureChecklistPercent(memberLogin)))*100);
			memberLogin.setSetPercent("15");
			memberLogin.setPercent15(Double.parseDouble(df.format(ventureChecklistDAO.getVentureChecklistPercent(memberLogin)))*100);
			memberLogin.setSetPercent("16");
			memberLogin.setPercent16(Double.parseDouble(df.format(ventureChecklistDAO.getVentureChecklistPercent(memberLogin)))*100);
			memberLogin.setSetPercent("17");
			memberLogin.setPercent17(Double.parseDouble(df.format(ventureChecklistDAO.getVentureChecklistPercent(memberLogin)))*100);
			
			model.addObject("getPercent",memberLogin);
			model.addObject("getMember",memberLogin);
		}			
		return model;
	}
	
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
			
			
			/* 載入設定檔案
			absolutePath="test.properties";	
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
			VentureChecklistDAO ventureChecklistDAO = (VentureChecklistDAO)context.getBean("ventureChecklistDAO");
			MapClass mapClass = new MapClass();
			mapClass.setId(1);
			mapClass.setAccount(memberLogin.getAccount());
			List<MapClass> getVentureCheckMenuList = ventureChecklistDAO.getMapClassList(mapClass);
			
			memberLogin.setClassID(12);
			List<MapSubclass> getVentureCheckListByMember= ventureChecklistDAO.getVentureCheckListByMember(memberLogin);
			boolean flag = ventureChecklistDAO.checkVentureCheckListByMemberSubID(memberLogin.getAccount(),113);
			if(getVentureCheckMenuList.get(0).getNow()>=12 || flag==true){
				//System.out.println("1");
				model.setViewName("targetMarketDescribe");
				model.addObject("getVentureCheckMenuList",getVentureCheckMenuList);
				model.addObject("getVentureCheckListByMember", getVentureCheckListByMember);
				model.addObject("getVentureCheckMenuListNow",getVentureCheckMenuList.get(0).getNow());
			}else{
				//System.out.println("2");
				model.setViewName("redirect:/ventureTypes");
			}			
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
			VentureChecklistDAO ventureChecklistDAO = (VentureChecklistDAO)context.getBean("ventureChecklistDAO");
			ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
			MapClass mapClass = new MapClass();
			mapClass.setId(1);
			mapClass.setAccount(memberLogin.getAccount());
			List<MapClass> getVentureCheckMenuList = ventureChecklistDAO.getMapClassList(mapClass);
			
			memberLogin.setClassID(14);
			List<MapSubclass> getVentureCheckListByMember= ventureChecklistDAO.getVentureCheckListByMember(memberLogin);
			boolean flag = productDAO.checkProductByMember(memberLogin);
			if(flag==true){
				model.setViewName("businessSales");
				model.addObject("getVentureCheckMenuList",getVentureCheckMenuList);
				model.addObject("getVentureCheckListByMember", getVentureCheckListByMember);
				model.addObject("getVentureCheckMenuListNow",getVentureCheckMenuList.get(0).getNow());
			}else{
				model.setViewName("redirect:/showAllProductDescribe");
			}
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
			VentureChecklistDAO ventureChecklistDAO = (VentureChecklistDAO)context.getBean("ventureChecklistDAO");
			ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
			MapClass mapClass = new MapClass();
			mapClass.setId(1);
			mapClass.setAccount(memberLogin.getAccount());
			List<MapClass> getVentureCheckMenuList = ventureChecklistDAO.getMapClassList(mapClass);
			
			memberLogin.setClassID(15);
			List<MapSubclass> getVentureCheckListByMember= ventureChecklistDAO.getVentureCheckListByMember(memberLogin);
			boolean productFlag = productDAO.checkProductByMember(memberLogin);
			boolean flag = ventureChecklistDAO.checkVentureCheckListByMemberSubID(memberLogin.getAccount(),142);
			if(getVentureCheckMenuList.get(0).getNow()>=15 || flag==true){
				model.setViewName("businessMarket");
				model.addObject("productFlag",productFlag);
				model.addObject("getVentureCheckMenuList",getVentureCheckMenuList);
				model.addObject("getVentureCheckListByMember", getVentureCheckListByMember);
				model.addObject("getVentureCheckMenuListNow",getVentureCheckMenuList.get(0).getNow());
			}else{
				model.setViewName("redirect:/businessSales");
			}
		}
		
		return model;
	}
	
	@RequestMapping(value = "/businessOrientation", method = RequestMethod.GET)
	public ModelAndView businessOrientation (HttpServletRequest request, HttpSession session){
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");
		if(memberLogin==null)
			model.setViewName("memberLogin");
		else{
			VentureChecklistDAO ventureChecklistDAO = (VentureChecklistDAO)context.getBean("ventureChecklistDAO");
			MapClass mapClass = new MapClass();
			mapClass.setId(1);
			mapClass.setAccount(memberLogin.getAccount());
			List<MapClass> getVentureCheckMenuList = ventureChecklistDAO.getMapClassList(mapClass);
			memberLogin.setClassID(16);
			List<MapSubclass> getVentureCheckListByMember= ventureChecklistDAO.getVentureCheckListByMember(memberLogin);
			boolean flag = ventureChecklistDAO.checkVentureCheckListByMemberSubID(memberLogin.getAccount(),153);
			if(getVentureCheckMenuList.get(0).getNow()>=16 || flag==true){
				model.setViewName("businessOrientation");
				model.addObject("getVentureCheckMenuList",getVentureCheckMenuList);
				model.addObject("getVentureCheckListByMember", getVentureCheckListByMember);
				model.addObject("getVentureCheckMenuListNow",getVentureCheckMenuList.get(0).getNow());
			}else{
				model.setViewName("redirect:/businessMarket");
			}
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
			VentureChecklistDAO ventureChecklistDAO = (VentureChecklistDAO)context.getBean("ventureChecklistDAO");
			MapClass mapClass = new MapClass();
			mapClass.setId(1);
			mapClass.setAccount(memberLogin.getAccount());
			List<MapClass> getVentureCheckMenuList = ventureChecklistDAO.getMapClassList(mapClass);
		
			memberLogin.setClassID(17);
			List<MapSubclass> getVentureCheckListByMember= ventureChecklistDAO.getVentureCheckListByMember(memberLogin);
			boolean flag = ventureChecklistDAO.checkVentureCheckListByMemberSubID(memberLogin.getAccount(),1613);
			if(getVentureCheckMenuList.size()!=0 && getVentureCheckMenuList.get(0).getNow()>=16 || flag==true){
				model.setViewName("humanResourcePlan");
				HumanResourceContent getHumanResourceContentByMember = ventureChecklistDAO.getHumanResourceContentByMember(memberLogin);			
				if(getHumanResourceContentByMember!=null){
					
					getHumanResourceContentByMember.setM0(getHumanResourceContentByMember.getM0()==0?0:getHumanResourceContentByMember.getM0());
					getHumanResourceContentByMember.setM1(getHumanResourceContentByMember.getM1()==0?0:getHumanResourceContentByMember.getM1());
					getHumanResourceContentByMember.setM2(getHumanResourceContentByMember.getM2()==0?0:getHumanResourceContentByMember.getM2());
					getHumanResourceContentByMember.setM3(getHumanResourceContentByMember.getM3()==0?0:getHumanResourceContentByMember.getM3());
					getHumanResourceContentByMember.setM4(getHumanResourceContentByMember.getM4()==0?0:getHumanResourceContentByMember.getM4());
					getHumanResourceContentByMember.setM5(getHumanResourceContentByMember.getM5()==0?0:getHumanResourceContentByMember.getM5());
					getHumanResourceContentByMember.setM6(getHumanResourceContentByMember.getM6()==0?0:getHumanResourceContentByMember.getM6());
					getHumanResourceContentByMember.setM7(getHumanResourceContentByMember.getM7()==0?0:getHumanResourceContentByMember.getM7());
					getHumanResourceContentByMember.setM8(getHumanResourceContentByMember.getM8()==0?0:getHumanResourceContentByMember.getM8());
					getHumanResourceContentByMember.setM9(getHumanResourceContentByMember.getM9()==0?0:getHumanResourceContentByMember.getM9());
					getHumanResourceContentByMember.setM10(getHumanResourceContentByMember.getM10()==0?0:getHumanResourceContentByMember.getM10());
					getHumanResourceContentByMember.setM11(getHumanResourceContentByMember.getM11()==0?0:getHumanResourceContentByMember.getM11());
					getHumanResourceContentByMember.setM12(getHumanResourceContentByMember.getM12()==0?0:getHumanResourceContentByMember.getM12());
					
					getHumanResourceContentByMember.setR0(getHumanResourceContentByMember.getR0()==0?0:getHumanResourceContentByMember.getR0());
					getHumanResourceContentByMember.setR1(getHumanResourceContentByMember.getR1()==0?0:getHumanResourceContentByMember.getR1());
					getHumanResourceContentByMember.setR2(getHumanResourceContentByMember.getR2()==0?0:getHumanResourceContentByMember.getR2());
					getHumanResourceContentByMember.setR3(getHumanResourceContentByMember.getR3()==0?0:getHumanResourceContentByMember.getR3());
					getHumanResourceContentByMember.setR4(getHumanResourceContentByMember.getR4()==0?0:getHumanResourceContentByMember.getR4());
					getHumanResourceContentByMember.setR5(getHumanResourceContentByMember.getR5()==0?0:getHumanResourceContentByMember.getR5());
					getHumanResourceContentByMember.setR6(getHumanResourceContentByMember.getR6()==0?0:getHumanResourceContentByMember.getR6());
					getHumanResourceContentByMember.setR7(getHumanResourceContentByMember.getR7()==0?0:getHumanResourceContentByMember.getR7());
					getHumanResourceContentByMember.setR8(getHumanResourceContentByMember.getR8()==0?0:getHumanResourceContentByMember.getR8());
					getHumanResourceContentByMember.setR9(getHumanResourceContentByMember.getR9()==0?0:getHumanResourceContentByMember.getR9());
					getHumanResourceContentByMember.setR10(getHumanResourceContentByMember.getR10()==0?0:getHumanResourceContentByMember.getR10());
					getHumanResourceContentByMember.setR11(getHumanResourceContentByMember.getR11()==0?0:getHumanResourceContentByMember.getR11());
					getHumanResourceContentByMember.setR12(getHumanResourceContentByMember.getR12()==0?0:getHumanResourceContentByMember.getR12());
					
					getHumanResourceContentByMember.setS0(getHumanResourceContentByMember.getS0()==0?0:getHumanResourceContentByMember.getS0());
					getHumanResourceContentByMember.setS1(getHumanResourceContentByMember.getS1()==0?0:getHumanResourceContentByMember.getS1());
					getHumanResourceContentByMember.setS2(getHumanResourceContentByMember.getS2()==0?0:getHumanResourceContentByMember.getS2());
					getHumanResourceContentByMember.setS3(getHumanResourceContentByMember.getS3()==0?0:getHumanResourceContentByMember.getS3());
					getHumanResourceContentByMember.setS4(getHumanResourceContentByMember.getS4()==0?0:getHumanResourceContentByMember.getS4());
					getHumanResourceContentByMember.setS5(getHumanResourceContentByMember.getS5()==0?0:getHumanResourceContentByMember.getS5());
					getHumanResourceContentByMember.setS6(getHumanResourceContentByMember.getS6()==0?0:getHumanResourceContentByMember.getS6());
					getHumanResourceContentByMember.setS7(getHumanResourceContentByMember.getS7()==0?0:getHumanResourceContentByMember.getS7());
					getHumanResourceContentByMember.setS8(getHumanResourceContentByMember.getS8()==0?0:getHumanResourceContentByMember.getS8());
					getHumanResourceContentByMember.setS9(getHumanResourceContentByMember.getS9()==0?0:getHumanResourceContentByMember.getS9());
					getHumanResourceContentByMember.setS10(getHumanResourceContentByMember.getS10()==0?0:getHumanResourceContentByMember.getS10());
					getHumanResourceContentByMember.setS11(getHumanResourceContentByMember.getS11()==0?0:getHumanResourceContentByMember.getS11());
					getHumanResourceContentByMember.setS12(getHumanResourceContentByMember.getS12()==0?0:getHumanResourceContentByMember.getS12());
					
					getHumanResourceContentByMember.setO0(getHumanResourceContentByMember.getO0()==0?0:getHumanResourceContentByMember.getO0());
					getHumanResourceContentByMember.setO1(getHumanResourceContentByMember.getO1()==0?0:getHumanResourceContentByMember.getO1());
					getHumanResourceContentByMember.setO2(getHumanResourceContentByMember.getO2()==0?0:getHumanResourceContentByMember.getO2());
					getHumanResourceContentByMember.setO3(getHumanResourceContentByMember.getO3()==0?0:getHumanResourceContentByMember.getO3());
					getHumanResourceContentByMember.setO4(getHumanResourceContentByMember.getO4()==0?0:getHumanResourceContentByMember.getO4());
					getHumanResourceContentByMember.setO5(getHumanResourceContentByMember.getO5()==0?0:getHumanResourceContentByMember.getO5());
					getHumanResourceContentByMember.setO6(getHumanResourceContentByMember.getO6()==0?0:getHumanResourceContentByMember.getO6());
					getHumanResourceContentByMember.setO7(getHumanResourceContentByMember.getO7()==0?0:getHumanResourceContentByMember.getO7());
					getHumanResourceContentByMember.setO8(getHumanResourceContentByMember.getO8()==0?0:getHumanResourceContentByMember.getO8());
					getHumanResourceContentByMember.setO9(getHumanResourceContentByMember.getO9()==0?0:getHumanResourceContentByMember.getO9());
					getHumanResourceContentByMember.setO10(getHumanResourceContentByMember.getO10()==0?0:getHumanResourceContentByMember.getO10());
					getHumanResourceContentByMember.setO11(getHumanResourceContentByMember.getO11()==0?0:getHumanResourceContentByMember.getO11());
					getHumanResourceContentByMember.setO12(getHumanResourceContentByMember.getO12()==0?0:getHumanResourceContentByMember.getO12());
					
					getHumanResourceContentByMember.setTotal0(getHumanResourceContentByMember.getTotal0()==0?0:getHumanResourceContentByMember.getTotal0());
					getHumanResourceContentByMember.setTotal1(getHumanResourceContentByMember.getTotal1()==0?0:getHumanResourceContentByMember.getTotal1());
					getHumanResourceContentByMember.setTotal2(getHumanResourceContentByMember.getTotal2()==0?0:getHumanResourceContentByMember.getTotal2());
					getHumanResourceContentByMember.setTotal3(getHumanResourceContentByMember.getTotal3()==0?0:getHumanResourceContentByMember.getTotal3());
					getHumanResourceContentByMember.setTotal4(getHumanResourceContentByMember.getTotal4()==0?0:getHumanResourceContentByMember.getTotal4());
					getHumanResourceContentByMember.setTotal5(getHumanResourceContentByMember.getTotal5()==0?0:getHumanResourceContentByMember.getTotal5());
					getHumanResourceContentByMember.setTotal6(getHumanResourceContentByMember.getTotal6()==0?0:getHumanResourceContentByMember.getTotal6());
					getHumanResourceContentByMember.setTotal7(getHumanResourceContentByMember.getTotal7()==0?0:getHumanResourceContentByMember.getTotal7());
					getHumanResourceContentByMember.setTotal8(getHumanResourceContentByMember.getTotal8()==0?0:getHumanResourceContentByMember.getTotal8());
					getHumanResourceContentByMember.setTotal9(getHumanResourceContentByMember.getTotal9()==0?0:getHumanResourceContentByMember.getTotal9());
					getHumanResourceContentByMember.setTotal10(getHumanResourceContentByMember.getTotal10()==0?0:getHumanResourceContentByMember.getTotal10());
					getHumanResourceContentByMember.setTotal11(getHumanResourceContentByMember.getTotal11()==0?0:getHumanResourceContentByMember.getTotal11());
					getHumanResourceContentByMember.setTotal12(getHumanResourceContentByMember.getTotal12()==0?0:getHumanResourceContentByMember.getTotal12());
				
				}
				else { // The default value of the textfield is zero
					
					getHumanResourceContentByMember.setM0(0);
					getHumanResourceContentByMember.setM1(0);
					getHumanResourceContentByMember.setM2(0);
					getHumanResourceContentByMember.setM3(0);
					getHumanResourceContentByMember.setM4(0);
					getHumanResourceContentByMember.setM5(0);
					getHumanResourceContentByMember.setM6(0);
					getHumanResourceContentByMember.setM7(0);
					getHumanResourceContentByMember.setM8(0);
					getHumanResourceContentByMember.setM9(0);
					getHumanResourceContentByMember.setM10(0);
					getHumanResourceContentByMember.setM11(0);
					getHumanResourceContentByMember.setM12(0);
					
					getHumanResourceContentByMember.setR0(0);
					getHumanResourceContentByMember.setR1(0);
					getHumanResourceContentByMember.setR2(0);
					getHumanResourceContentByMember.setR3(0);
					getHumanResourceContentByMember.setR4(0);
					getHumanResourceContentByMember.setR5(0);
					getHumanResourceContentByMember.setR6(0);
					getHumanResourceContentByMember.setR7(0);
					getHumanResourceContentByMember.setR8(0);
					getHumanResourceContentByMember.setR9(0);
					getHumanResourceContentByMember.setR10(0);
					getHumanResourceContentByMember.setR11(0);
					getHumanResourceContentByMember.setR12(0);
					
					getHumanResourceContentByMember.setS0(0);
					getHumanResourceContentByMember.setS1(0);
					getHumanResourceContentByMember.setS2(0);
					getHumanResourceContentByMember.setS3(0);
					getHumanResourceContentByMember.setS4(0);
					getHumanResourceContentByMember.setS5(0);
					getHumanResourceContentByMember.setS6(0);
					getHumanResourceContentByMember.setS7(0);
					getHumanResourceContentByMember.setS8(0);
					getHumanResourceContentByMember.setS9(0);
					getHumanResourceContentByMember.setS10(0);
					getHumanResourceContentByMember.setS11(0);
					getHumanResourceContentByMember.setS12(0);
					
					getHumanResourceContentByMember.setO0(0);
					getHumanResourceContentByMember.setO1(0);
					getHumanResourceContentByMember.setO2(0);
					getHumanResourceContentByMember.setO3(0);
					getHumanResourceContentByMember.setO4(0);
					getHumanResourceContentByMember.setO5(0);
					getHumanResourceContentByMember.setO6(0);
					getHumanResourceContentByMember.setO7(0);
					getHumanResourceContentByMember.setO8(0);
					getHumanResourceContentByMember.setO9(0);
					getHumanResourceContentByMember.setO10(0);
					getHumanResourceContentByMember.setO11(0);
					getHumanResourceContentByMember.setO12(0);
					
					getHumanResourceContentByMember.setTotal0(0);
					getHumanResourceContentByMember.setTotal1(0);
					getHumanResourceContentByMember.setTotal2(0);
					getHumanResourceContentByMember.setTotal3(0);
					getHumanResourceContentByMember.setTotal4(0);
					getHumanResourceContentByMember.setTotal5(0);
					getHumanResourceContentByMember.setTotal6(0);
					getHumanResourceContentByMember.setTotal7(0);
					getHumanResourceContentByMember.setTotal8(0);
					getHumanResourceContentByMember.setTotal9(0);
					getHumanResourceContentByMember.setTotal10(0);
					getHumanResourceContentByMember.setTotal11(0);
					getHumanResourceContentByMember.setTotal12(0);
				}
				model.addObject("getVentureCheckMenuList",getVentureCheckMenuList);
				model.addObject("getVentureCheckListByMember", getVentureCheckListByMember);
				model.addObject("getVentureCheckMenuListNow",getVentureCheckMenuList.get(0).getNow());
				model.addObject("getHumanResourceContentByMember",getHumanResourceContentByMember);
			}else{
				model.setViewName("redirect:/businessOrientation");
			}
			
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
			model.setViewName("redirect:/memberLogin");
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
			model.setViewName("redirect:/showAllProductDescribe");
		}
		else
			model.setViewName("redirect:/memberLogin");
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
			model.setViewName("redirect:/memberLogin");
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
			model.setViewName("redirect:/businessOrientation");
		}
		else
			model.setViewName("redirect:/memberLogin");
		return model;
	}
	
	@RequestMapping(value = "/addBusinessOrientationCont", method = RequestMethod.POST)
	public ModelAndView addBusinessOrientationCont (String content161, String content162, String content163, String content164, String content165, String content166, String content167, String content168, String content169, String content1610, String content1611, String content1612, String content1613,HttpSession session){
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");		
		if(memberLogin!=null){			
			addVentureCheckList(memberLogin.getAccount(),16,161,content161);
			addVentureCheckList(memberLogin.getAccount(),16,162,content162);
			addVentureCheckList(memberLogin.getAccount(),16,163,content163);
			addVentureCheckList(memberLogin.getAccount(),16,164,content164);
			addVentureCheckList(memberLogin.getAccount(),16,165,content165);
			addVentureCheckList(memberLogin.getAccount(),16,166,content166);
			/*addVentureCheckList(memberLogin.getAccount(),16,167,content167);
			addVentureCheckList(memberLogin.getAccount(),16,168,content168);
			addVentureCheckList(memberLogin.getAccount(),16,169,content169);
			addVentureCheckList(memberLogin.getAccount(),16,1610,content1610);
			addVentureCheckList(memberLogin.getAccount(),16,1611,content1611);
			addVentureCheckList(memberLogin.getAccount(),16,1612,content1612);
			addVentureCheckList(memberLogin.getAccount(),16,1613,content1613);*/
			model.setViewName("redirect:/humanResourcePlan");
		}
		else
			model.setViewName("redirect:/memberLogin");
		return model;
	}	
	
	@RequestMapping(value = "/addHumanResourcePlan", method = RequestMethod.POST)
	public ModelAndView addHumanResourcePlan (String content171, String content172, String content173, 
			HumanResourceContent humanResourceContent, HttpSession session){
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");		
		if(memberLogin!=null){	
			model.setViewName("redirect:/venturePlanMap");
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
			model.setViewName("redirect:/memberLogin");
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
			ventureChecklistDAO.insertVentureCheckList(ventureChecklist);			
		}
		else{
			ventureChecklistDAO.updateVentureCheckList(ventureChecklist);			
		}
	}	
}
