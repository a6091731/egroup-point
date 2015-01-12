package com.epoint.webapp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epoint.webapp.entity.PayMoney;

@Controller
public class ExpenditureStructureController {
	ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
//	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	
	@RequestMapping(value = "/showExpenditure", method = RequestMethod.GET)
	public ModelAndView showExpenditure() throws IOException {
		ModelAndView model = new ModelAndView("founded");
		return model;
	}
	
	@RequestMapping(value = "/modiExpenditure", method = RequestMethod.POST)
	public void modiExpenditure(@ModelAttribute PayMoney paymoney, HttpSession session, HttpServletRequest request) throws IOException {
//		ModelAndView model = new ModelAndView();
//		PayMoneyDAO payMoneyDAO = (PayMoneyDAO) context.getBean("payMoneyDAO");
		System.out.println(paymoney.getMoney());
	}
}
