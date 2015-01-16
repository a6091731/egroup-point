package com.epoint.webapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epoint.webapp.dao.PayMoneyDAO;
import com.epoint.webapp.entity.Member;
import com.epoint.webapp.entity.PayMoney;
import com.epoint.webapp.form.ExpenditureForm;

@Controller
public class ExpenditureStructureController {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
			"spring-module.xml");

	// ApplicationContext context = new
	// ClassPathXmlApplicationContext("spring-module.xml");

	@RequestMapping(value = "/showExpenditure", method = RequestMethod.GET)
	public ModelAndView showExpenditure(HttpSession session) throws IOException {
		ModelAndView model = new ModelAndView();
		PayMoneyDAO payMoneyDAO = (PayMoneyDAO) context.getBean("payMoneyDAO");
		Member loginMember = (Member) session.getAttribute("loginMember");
		if(loginMember != null){
		String account = loginMember.getAccount();
//		String account = "admin";
			PayMoney foundedPayMoney = payMoneyDAO.getSinglePayMoneyByItemID(
					account, 2111);
			PayMoney designPayMoney = payMoneyDAO.getSinglePayMoneyByItemID(
					account, 2112);
			List<PayMoney> cardPayMoney = payMoneyDAO.getPayMoneyByItemID(account,
					2113);
			List<PayMoney> lawyerPayMoney = payMoneyDAO.getPayMoneyByItemID(
					account, 2114);
			List<PayMoney> accountPayMoney = payMoneyDAO.getPayMoneyByItemID(
					account, 2115);
			List<PayMoney> dynamicPayMoney = new ArrayList<PayMoney>();
			int[] dynamicTypeCount = { cardPayMoney.size(), lawyerPayMoney.size(),
					accountPayMoney.size() };
			dynamicPayMoney.addAll(cardPayMoney);
			dynamicPayMoney.addAll(lawyerPayMoney);
			dynamicPayMoney.addAll(accountPayMoney);
			model.addObject("foundedPayMoney", foundedPayMoney);
			model.addObject("designPayMoney", designPayMoney);
			model.addObject("dynamicPayMoney", dynamicPayMoney);
			model.addObject("dynamicTypeCount", dynamicTypeCount);
			model.addObject("cardPayMoney",cardPayMoney);
			model.addObject("lawyerPayMoney",lawyerPayMoney);
			model.addObject("accountPayMoney",accountPayMoney);
			model.addObject("cardCount",cardPayMoney.size());
			model.addObject("lawyerCount",lawyerPayMoney.size());
			model.addObject("accountCount",accountPayMoney.size());
			model.setViewName("founded");
		}else{
		 model.setViewName("redirect:/");
		}
		return model;
	}

	@RequestMapping(value = "/addExpenditure", method = RequestMethod.POST)
	public ModelAndView addExpenditure(
			@ModelAttribute ExpenditureForm expenditureForm,
			HttpSession session, HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		PayMoneyDAO payMoneyDAO = (PayMoneyDAO) context.getBean("payMoneyDAO");
		Member loginMember = (Member) session.getAttribute("loginMember");
		PayMoney payMoney = new PayMoney();
		if(loginMember != null){
		String account = loginMember.getAccount();
//		String account = "admin";
			payMoney.setAccount(account);
	
			PayMoney foundedPayMoney = payMoneyDAO.getSinglePayMoneyByItemID(account, 2111);
			PayMoney designPayMoney = payMoneyDAO.getSinglePayMoneyByItemID(account, 2112);
			List<PayMoney> cardPayMoney = payMoneyDAO.getPayMoneyByItemID(account,2113);
			List<PayMoney> lawyerPayMoney = payMoneyDAO.getPayMoneyByItemID(account, 2114);
			List<PayMoney> accountPayMoney = payMoneyDAO.getPayMoneyByItemID(account, 2115);
			List<PayMoney> oldDynamicPayMoney = new ArrayList<PayMoney>();
			oldDynamicPayMoney.addAll(cardPayMoney);
			oldDynamicPayMoney.addAll(lawyerPayMoney);
			oldDynamicPayMoney.addAll(accountPayMoney);
			List<PayMoney> oldFixedPayMoney = new ArrayList<PayMoney>();
			oldFixedPayMoney.add(foundedPayMoney);
			oldFixedPayMoney.add(designPayMoney);
	
			List<PayMoney> fixedPayMoney = expenditureForm.getFixedPayMoney();
			List<PayMoney> dynamicPayMoney = expenditureForm.getDynamicPayMoney();
			List<PayMoney> deletedPayMoney = expenditureForm.getDeletedPayMoney();
			for (int i = 0; i < fixedPayMoney.size(); i++) {
				PayMoney oldObject = oldFixedPayMoney.get(i);
				PayMoney newObject = fixedPayMoney.get(i);
				if (oldObject.getDate() == null) {
					int recordID = payMoneyDAO.getPayRecord(account,newObject.getID());
					payMoney.setID(newObject.getID());
					payMoney.setRecord(recordID);
					payMoney.setDate_string(newObject.getDate_string() + "-01");
					payMoney.setMoney(newObject.getMoney());
					payMoneyDAO.addPayMoney(payMoney);
				} else if (!oldObject.getDate().equals(newObject.getDate_string() + "-01")
						|| oldObject.getMoney() != newObject.getMoney()) {
					newObject.setAccount(account);
					newObject.setDate_string(newObject.getDate_string() + "-01");
					payMoneyDAO.modiPayMoney(newObject);
				}
			}
			if (deletedPayMoney != null) {
				for (PayMoney p : deletedPayMoney) {
					p.setAccount(account);
					payMoneyDAO.delPayMoney(p);
				}
			}
			for (int i = 0; i < oldDynamicPayMoney.size(); i++) {
				PayMoney oldObject = oldDynamicPayMoney.get(i);
				PayMoney newObject = dynamicPayMoney.get(i);
	
				if (newObject.getID() == 0)
					continue;
	
				if (!oldObject.getDate().equals(newObject.getDate_string() + "-01")
						|| oldObject.getMoney() != newObject.getMoney()) {
					newObject.setAccount(account);
					newObject.setDate_string(newObject.getDate_string() + "-01");
					payMoneyDAO.modiPayMoney(newObject);
				} else {
					continue;
				}
			}
			if (oldDynamicPayMoney.size() > 0
					&& oldDynamicPayMoney.size() < dynamicPayMoney.size()) {
				for (int i = oldDynamicPayMoney.size(); i < dynamicPayMoney.size(); i++) {
					PayMoney newObject = dynamicPayMoney.get(i);
					payMoney.setID(newObject.getID());
					int recordID = payMoneyDAO.getPayRecord(account,newObject.getID());
					payMoney.setRecord(recordID);
					payMoney.setDate_string(newObject.getDate_string() + "-01");
					payMoney.setMoney(newObject.getMoney());
					payMoneyDAO.addPayMoney(payMoney);
				}
			}
			model.setViewName("redirect:/showExpenditure");
		}else{
		model.setViewName("redirect:/");
		}
		return model;
	}
}
