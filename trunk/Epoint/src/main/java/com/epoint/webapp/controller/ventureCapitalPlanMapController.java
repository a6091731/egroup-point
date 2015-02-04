package com.epoint.webapp.controller;

import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epoint.webapp.dao.PayMoneyDAO;
import com.epoint.webapp.dao.VentureChecklistDAO;
import com.epoint.webapp.entity.Member;

@Controller
public class ventureCapitalPlanMapController {
	ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	@RequestMapping(value = "/ventureCapitalPlanMap", method = RequestMethod.GET)
	public ModelAndView ventureCapitalPlanMap (HttpServletRequest request, HttpSession session){
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");
		if(memberLogin==null)
			model.setViewName("memberLogin");					
		else{
			model.setViewName("ventureCapitalPlanMap");		
			PayMoneyDAO payMoneyDAO = (PayMoneyDAO)context.getBean("payMoneyDAO");
			DecimalFormat df = new DecimalFormat("0.00");
			memberLogin.setSetPercent("211");			
			memberLogin.setPercent211(Double.parseDouble(df.format(payMoneyDAO.getVentureCapitalPercent(memberLogin)))*100);
			memberLogin.setSetPercent("212");			
			memberLogin.setPercent212(Double.parseDouble(df.format(payMoneyDAO.getVentureCapitalPercent(memberLogin)))*100);
			memberLogin.setSetPercent("213");			
			memberLogin.setPercent213(Double.parseDouble(df.format(payMoneyDAO.getVentureCapitalPercent(memberLogin)))*100);
			memberLogin.setSetPercent("214");			
			memberLogin.setPercent214(Double.parseDouble(df.format(payMoneyDAO.getVentureCapitalPercent(memberLogin)))*100);
			memberLogin.setSetPercent("215");			
			memberLogin.setPercent215(Double.parseDouble(df.format(payMoneyDAO.getVentureCapitalPercent(memberLogin)))*100);
			memberLogin.setSetPercent("216");			
			memberLogin.setPercent216(Double.parseDouble(df.format(payMoneyDAO.getVentureCapitalPercent(memberLogin)))*100);
			memberLogin.setSetPercent("217");			
			memberLogin.setPercent217(Double.parseDouble(df.format(payMoneyDAO.getVentureCapitalPercent(memberLogin)))*100);
			memberLogin.setSetPercent("218");			
			memberLogin.setPercent218(Double.parseDouble(df.format(payMoneyDAO.getVentureCapitalPercent(memberLogin)))*100);
			memberLogin.setSetPercent("219");			
			memberLogin.setPercent219(Double.parseDouble(df.format(payMoneyDAO.getVentureCapitalPercent(memberLogin)))*100);
			memberLogin.setGetPercent(Double.parseDouble(df.format((memberLogin.getPercent211()+memberLogin.getPercent212()+memberLogin.getPercent213()
					+memberLogin.getPercent214()+memberLogin.getPercent215()+memberLogin.getPercent216()
					+memberLogin.getPercent217()+memberLogin.getPercent218()+memberLogin.getPercent219())/9)));
			model.addObject("getPercent",memberLogin);
		}			
		return model;
	}
}
