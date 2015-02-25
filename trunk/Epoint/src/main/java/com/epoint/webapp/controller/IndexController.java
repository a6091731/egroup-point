package com.epoint.webapp.controller;

import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epoint.webapp.dao.FinancialPlanDAO;
import com.epoint.webapp.dao.PayMoneyDAO;
import com.epoint.webapp.dao.ProductDAO;
import com.epoint.webapp.dao.ProductSalesDAO;
import com.epoint.webapp.dao.VentureChecklistDAO;
import com.epoint.webapp.entity.FinancialPlan;
import com.epoint.webapp.entity.Member;

@Controller
public class IndexController {
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	
	@RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
	public ModelAndView index (HttpServletRequest request, HttpSession session){
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}
	
	
	@RequestMapping(value = "/venturePlanMap", method = RequestMethod.GET)
	public ModelAndView ventureChecklistMap (HttpServletRequest request, HttpSession session){
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");
		if(memberLogin==null)
			model.setViewName("memberLogin");
		else{
			model.setViewName("venturePlanMap");			
			VentureChecklistDAO ventureChecklistDAO = (VentureChecklistDAO)context.getBean("ventureChecklistDAO");
			ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
			DecimalFormat df = new DecimalFormat("0.00");
			memberLogin.setSetPercent("11");			
			memberLogin.setPercent11(Double.parseDouble(df.format(ventureChecklistDAO.getVentureChecklistPercent(memberLogin)))*100);
			memberLogin.setSetPercent("12");
			memberLogin.setPercent12(Double.parseDouble(df.format(ventureChecklistDAO.getVentureChecklistPercent(memberLogin)))*100);
			/*
			memberLogin.setSetPercent("13");
			memberLogin.setPercent13(Double.parseDouble(df.format(ventureChecklistDAO.getVentureChecklistPercent(memberLogin)))*100);
			*/
			memberLogin.setProductCount(productDAO.countProductByMember(memberLogin));
			int productPercent = productDAO.countProductByMember(memberLogin)>0?100:0;
			memberLogin.setSetPercent("14");
			memberLogin.setPercent14(Double.parseDouble(df.format(ventureChecklistDAO.getVentureChecklistPercent(memberLogin)))*100);
			memberLogin.setSetPercent("15");
			memberLogin.setPercent15(Double.parseDouble(df.format(ventureChecklistDAO.getVentureChecklistPercent(memberLogin)))*100);
			memberLogin.setSetPercent("16");
			memberLogin.setPercent16(Double.parseDouble(df.format(ventureChecklistDAO.getVentureChecklistPercent(memberLogin)))*100);
			memberLogin.setSetPercent("17");
			memberLogin.setPercent17(Double.parseDouble(df.format(ventureChecklistDAO.getVentureChecklistPercent(memberLogin)))*100);
			double checkListPercent = (memberLogin.getPercent11()+ memberLogin.getPercent12()+ productPercent+ memberLogin.getPercent14()
					+ memberLogin.getPercent15()+ memberLogin.getPercent16()+ memberLogin.getPercent17())/7.0;
			
			FinancialPlanDAO financialPlanDAO = (FinancialPlanDAO)context.getBean("financialPlanDAO");
			boolean flag1 = financialPlanDAO.checkFinancialPlanByMember(memberLogin);
			PayMoneyDAO payMoneyDAO = (PayMoneyDAO)context.getBean("payMoneyDAO");
			ProductSalesDAO productSalesDAO = (ProductSalesDAO)context.getBean("productSalesDAO");
			boolean flag2 = payMoneyDAO.checkPayMoneyByMember(memberLogin);
			if(flag2==false)
				flag2=productSalesDAO.checkProductSalesByMember(memberLogin);
			System.out.println("FinancialPlanFlag="+flag1);
			model.addObject("FinancialPlanFlag",flag1);
			model.addObject("capitalPlanFlag",flag2);
			model.addObject("checkListPercent",checkListPercent);
		}			
		return model;
	}
}
