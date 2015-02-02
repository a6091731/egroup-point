package com.epoint.webapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epoint.webapp.dao.PayItemDAO;
import com.epoint.webapp.dao.PayMoneyDAO;
import com.epoint.webapp.entity.Member;
import com.epoint.webapp.entity.PayItem;
import com.epoint.webapp.entity.PayMoney;

@Controller
public class CashFlowController {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");
	
	@RequestMapping(value = "/cashFlow", method = RequestMethod.GET)
	public ModelAndView cashFlow(HttpServletRequest request, HttpSession session) throws IOException {
		ModelAndView model = new ModelAndView();
		PayMoneyDAO payMoneyDAO = (PayMoneyDAO) context.getBean("payMoneyDAO");
		PayItemDAO payItemDAO = (PayItemDAO) context.getBean("payItemDAO");
		Member loginMember = (Member) session.getAttribute("loginMember");
//      if(loginMember != null){
//      	String account = loginMember.getAccount();
			String account = "admin";
            model.setViewName("cashFlow");
            List<PayMoney> totalMoneyBySubClass = payMoneyDAO.getMonthTotalMoneyByAccount(account);
            int[] monthTotalMoney = new int[12];
            for(PayMoney p : totalMoneyBySubClass){
            	//折線圖
            	int temp = Integer.parseInt(p.getDate().toString().substring(5, 7));
            	monthTotalMoney[temp-1] = p.getMonthTotal();
            }
            int selectedMonth = request.getParameter("mon")==null?1:Integer.parseInt(request.getParameter("mon"));
            String[] date_strings = {"-01-","-02-","-03-","-04-","-05-","-06-","-07-","-08-","-09-","-10-","-11-","-12-"};
            totalMoneyBySubClass = payMoneyDAO.getMonthTotalMoneyBySubClassID(account,date_strings[selectedMonth-1]);
            List<PayItem> allPayItem = new ArrayList<PayItem>();
            for(PayMoney p : totalMoneyBySubClass){
            	//編輯資料
            	allPayItem = payItemDAO.getAllPayItemBySubClassID(p.getSubClassID());
            	model.addObject("payItems", allPayItem);
            	List<PayMoney> allPayMoney = payMoneyDAO.getPayMoneyBySubClassStatus(account, p.getSubClassID(), 1);
            	model.addObject("sub_"+p.getSubClassID()+"_1", allPayMoney);
            	allPayMoney = payMoneyDAO.getPayMoneyBySubClassStatus(account, p.getSubClassID(), 2);
            	model.addObject("sub_"+p.getSubClassID()+"_2", allPayMoney);
            	allPayMoney = payMoneyDAO.getPayMoneyBySubClassStatus(account, p.getSubClassID(), 3);
            	model.addObject("sub_"+p.getSubClassID()+"_3", allPayMoney);
            }
            model.addObject("selectedMonth", selectedMonth);
            model.addObject("monthTotalMoney", monthTotalMoney);
            model.addObject("totalMoneyBySubClass", totalMoneyBySubClass);
//		}else{
//      	model.setViewName("redirect:/memberLogin");
//      }
        return model;
	}
}
