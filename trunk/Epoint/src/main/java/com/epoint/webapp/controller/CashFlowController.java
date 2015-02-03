package com.epoint.webapp.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.epoint.webapp.dao.PayItemDAO;
import com.epoint.webapp.dao.PayMoneyDAO;
import com.epoint.webapp.entity.Member;
import com.epoint.webapp.entity.PayItem;
import com.epoint.webapp.entity.PayMoney;
import com.epoint.webapp.entity.ProductSales;
import com.epoint.webapp.form.CashFlowForm;

@Controller
public class CashFlowController {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");
	
	@RequestMapping(value = "/cashFlow", method = RequestMethod.GET)
	public ModelAndView cashFlow(HttpServletRequest request, HttpSession session) throws IOException {
		ModelAndView model = new ModelAndView();
		PayMoneyDAO payMoneyDAO = (PayMoneyDAO) context.getBean("payMoneyDAO");
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
            model.addObject("selectedMonth", selectedMonth);
            model.addObject("monthTotalMoney", monthTotalMoney);
            model.addObject("totalMoneyBySubClass", totalMoneyBySubClass);
//		}else{
//      	model.setViewName("redirect:/memberLogin");
//      }
        return model;
	}
	
	@RequestMapping(value = "/getPayMoneyDetailBySubClassID", method = RequestMethod.GET)
	public @ResponseBody CashFlowForm getPayMoneyDetailBySubClassID(int subClassID, HttpSession session) throws ParseException{
		ModelAndView model = new ModelAndView();
		PayItemDAO payItemDAO = (PayItemDAO) context.getBean("payItemDAO");
		PayMoneyDAO payMoneyDAO = (PayMoneyDAO) context.getBean("payMoneyDAO");
		Member memberLogin = (Member)session.getAttribute("loginMember");
//		if(memberLogin!=null){
//      	String account = loginMember.getAccount();
			String account = "admin";
			model.setViewName("redirect:/cashFlow");
			CashFlowForm cashFlowForm = new CashFlowForm();
			List<PayItem> itemList = payItemDAO.getAllPayItemBySubClassID(subClassID);
			List<PayMoney> tempList = new ArrayList<PayMoney>();
			for(int i = 0;i < itemList.size();i++){
				PayItem item = itemList.get(i);
				tempList = payMoneyDAO.getPayMoneyByItemID(account, item.getItemID());
				switch(i){
					case 0:
						cashFlowForm.setList1(tempList);
						break;
					case 1:
						cashFlowForm.setList2(tempList);
						break;
					case 2:
						cashFlowForm.setList3(tempList);
						break;
					case 3:
						cashFlowForm.setList4(tempList);
						break;
					case 4:
						cashFlowForm.setList5(tempList);
						break;
					case 5:
						cashFlowForm.setList6(tempList);
						break;
					case 6:
						cashFlowForm.setList7(tempList);
						break;
				}
			}
			cashFlowForm.setPayItemList(itemList);
			return cashFlowForm;
//		}
//		return null;
	}
}
