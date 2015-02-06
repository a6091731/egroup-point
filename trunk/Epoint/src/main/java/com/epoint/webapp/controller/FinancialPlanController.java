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

import com.epoint.webapp.dao.FinancialPlanDAO;
import com.epoint.webapp.dao.MemberDAO;
import com.epoint.webapp.dao.PayMoneyDAO;
import com.epoint.webapp.entity.FinancialPlan;
import com.epoint.webapp.entity.Member;
import com.epoint.webapp.form.FinancialPlanForm;

@Controller
public class FinancialPlanController {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");
	
	@RequestMapping(value = "/financialPlan", method = RequestMethod.GET)
	public ModelAndView founded(HttpSession session) throws IOException {
		ModelAndView model = new ModelAndView();
		PayMoneyDAO payMoneyDAO = (PayMoneyDAO) context.getBean("payMoneyDAO");
		FinancialPlanDAO financialPlanDAO = (FinancialPlanDAO) context.getBean("financialPlanDAO");
		MemberDAO memberDAO = (MemberDAO) context.getBean("memberDAO");
		Member loginMember = (Member) session.getAttribute("loginMember");
		if(loginMember != null){
			model.setViewName("financialPlan");
			String account = loginMember.getAccount();
			int avgCost = payMoneyDAO.getMonthlyCostByAccount(account);
			int fundLack = memberDAO.getFundLackByAccount(account);
			List<FinancialPlan> usesPlans = financialPlanDAO.getFinancialPlansByItemID(account, 1);
			List<FinancialPlan> sourcePlans = financialPlanDAO.getFinancialPlansByItemID(account, 0);
			model.addObject("avgCost", avgCost);
			model.addObject("fundLack", fundLack);
			model.addObject("usesPlans", usesPlans);
			model.addObject("sourcePlans", sourcePlans);
			model.setViewName("financialPlan");		
		}else{
			model.setViewName("memberLogin");
		}
		return model;
	}
	
	@RequestMapping(value = "/addFinancialPlan", method = RequestMethod.POST)
	public ModelAndView addFinancialPlan(@ModelAttribute FinancialPlanForm financialPlanForm,
            HttpSession session, HttpServletRequest request) throws IOException {
		ModelAndView model = new ModelAndView();
		FinancialPlanDAO financialPlanDAO = (FinancialPlanDAO) context.getBean("financialPlanDAO");
		MemberDAO memberDAO = (MemberDAO) context.getBean("memberDAO");
		FinancialPlan financialPlan = new FinancialPlan();
		Member loginMember = (Member) session.getAttribute("loginMember");
		if(loginMember != null){
			String account = loginMember.getAccount();
			memberDAO.modiFundLackBy(account, financialPlanForm.getLackMoney());
			financialPlan.setAccount(account);
			List<FinancialPlan> oldUsesPlans = financialPlanDAO.getFinancialPlansByItemID(account, 1);
			List<FinancialPlan> oldSourcePlans = financialPlanDAO.getFinancialPlansByItemID(account, 0);
			List<FinancialPlan> dynamicPlans = financialPlanForm.getDynamicPlans();
			List<FinancialPlan> newUsesPlans = financialPlanForm.getUsesPlans();
			List<FinancialPlan> newSourcePlans = financialPlanForm.getSourcePlans();
			List<FinancialPlan> deletedPlans = financialPlanForm.getDeletedPlans();
			
			if(deletedPlans != null){
				for(FinancialPlan p : deletedPlans){
					p.setAccount(account);
					financialPlanDAO.delFinancialPlan(p);
				}
			}
			if(newUsesPlans != null){
				for(int i = 0; i < newUsesPlans.size(); i++){
					FinancialPlan newObject = newUsesPlans.get(i);
					newObject.setAccount(account);
					newObject.setProperty(1);
					if (newObject.getRecord() == 0){
						continue;
					}else{
						if(oldUsesPlans.size() > 0 && oldUsesPlans.size() > i){//有舊資料
							FinancialPlan oldObject = oldUsesPlans.get(i);
							if(!oldObject.getName().equals(newObject.getName()) || 
									oldObject.getMoney() != newObject.getMoney()){
								financialPlanDAO.modiFinancialPlan(newObject);
							}
						}
					}
				}
			}
			if(newSourcePlans != null){
				for(int i = 0; i < newSourcePlans.size(); i++){
					FinancialPlan newObject = newSourcePlans.get(i);
					newObject.setAccount(account);
					newObject.setProperty(0);
					if (newObject.getRecord() == 0){
						continue;
					}else{
						if(oldSourcePlans.size() > 0 && oldSourcePlans.size() > i){//有舊資料
							FinancialPlan oldObject = oldSourcePlans.get(i);
							if(!oldObject.getName().equals(newObject.getName()) || 
									oldObject.getMoney() != newObject.getMoney()){
								financialPlanDAO.modiFinancialPlan(newObject);
							}
						}
					}
				}
			}
			if(dynamicPlans != null){
				for(FinancialPlan p : dynamicPlans){
					if(p.getName() != null){
						p.setAccount(account);
						int record = financialPlanDAO.getRecordByProperty(account, p.getProperty());
						p.setRecord(record);
						financialPlanDAO.addFinancialPlan(p);
					}
				}
			}
			model.setViewName("redirect:/financialPlan");
		}else{
			 model.setViewName("memberLogin");
		}
		return model;
	}
}
