package com.epoint.webapp.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.epoint.webapp.dao.PayItemDAO;
import com.epoint.webapp.dao.PayMoneyDAO;
import com.epoint.webapp.dao.ProductSalesDAO;
import com.epoint.webapp.entity.Member;
import com.epoint.webapp.entity.PayItem;
import com.epoint.webapp.entity.PayMoney;
import com.epoint.webapp.entity.Product;
import com.epoint.webapp.entity.ProductSales;
import com.epoint.webapp.form.CashFlowForm;
import com.epoint.webapp.form.ExpenditureForm;
import com.google.gson.Gson;

@Controller
public class CashFlowController {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");
	
	@RequestMapping(value = "/cashFlow", method = RequestMethod.GET)
	public ModelAndView cashFlow(HttpServletRequest request, HttpSession session) throws IOException {
		ModelAndView model = new ModelAndView();
		PayMoneyDAO payMoneyDAO = (PayMoneyDAO) context.getBean("payMoneyDAO");
		ProductSalesDAO productSalesDAO = (ProductSalesDAO) context.getBean("productSalesDAO");
		Member loginMember = (Member) session.getAttribute("loginMember");
		if(loginMember != null){
			String account = loginMember.getAccount();
			model.setViewName("cashFlow");
            List<PayMoney> totalExpenditureByAccount = payMoneyDAO.getTotalExpenditureByAccount(account);
            List<ProductSales> totalIncomeByAccount = productSalesDAO.getMonTotalIncomeByAccoun(account);
            
            //宣告兩個陣列，至多12個月，儲存每月的花費
            int[] monthTotalExpenditure = new int[12];
            int[] monthTotalIncome = new int[12];
            //每月支出金額--------------            
            if(totalExpenditureByAccount!=null)
	            for(PayMoney p : totalExpenditureByAccount){
	            	//折線圖
	            	int temp = Integer.parseInt(p.getDate().toString().substring(5, 7));
	            	monthTotalExpenditure[temp-1] = p.getMonthTotal();
	            }            
            //每月收入金額--------------
            if(totalIncomeByAccount!=null)
	            for(ProductSales s : totalIncomeByAccount){
	            	//折線圖
	            	int temp = Integer.parseInt(s.getDate().toString().substring(5, 7));
	            	monthTotalIncome[temp-1] = s.getMonthIncome();
	           	}
            
            //抓取選擇月份
            int selectedMonth = request.getParameter("mon")==null?1:Integer.parseInt(request.getParameter("mon"));
            String[] date_strings = {"-01-","-02-","-03-","-04-","-05-","-06-","-07-","-08-","-09-","-10-","-11-","-12-"};
           
            //當月支出金額--------------   
            List<PayMoney> totalExpenditureBySubClass = payMoneyDAO.getMonthTotalMoneyBySubClassID(account,date_strings[selectedMonth-1]);
           
            //當月收入金額--------------
            List<ProductSales> totalIncomeByMemberDate = productSalesDAO.getMonthTotalIncomeByMemberDate(account,date_strings[selectedMonth-1]);
                       
            model.addObject("getMember", loginMember);
            model.addObject("selectedMonth", selectedMonth);
            model.addObject("monthTotalExpenditure", monthTotalExpenditure);
            model.addObject("monthTotalIncome", monthTotalIncome);            
            model.addObject("totalExpenditureBySubClass", totalExpenditureBySubClass);
            model.addObject("totalIncomeByMemberDate1", totalIncomeByMemberDate);
			model.addObject("totalIncomeByMemberDate2", new Gson().toJson(totalIncomeByMemberDate));
		}else{
			model.setViewName("memberLogin");
		}
        return model;
	}
	
	@RequestMapping(value = "/getPayMoneyDetailBySubClassID", method = RequestMethod.GET)
	public @ResponseBody CashFlowForm getPayMoneyDetailBySubClassID(int subClassID, HttpSession session) throws ParseException{
		ModelAndView model = new ModelAndView();
		PayItemDAO payItemDAO = (PayItemDAO) context.getBean("payItemDAO");
		PayMoneyDAO payMoneyDAO = (PayMoneyDAO) context.getBean("payMoneyDAO");
		Member memberLogin = (Member)session.getAttribute("loginMember");
		if(memberLogin!=null){
			String account = memberLogin.getAccount();
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
		}
		return null;
	}
	
	@RequestMapping(value = "/addCashFlow", method = RequestMethod.POST)
    public ModelAndView addCashFlow(@ModelAttribute ExpenditureForm expenditureForm, String mon, HttpSession session, HttpServletRequest request) throws IOException {
		ModelAndView model = new ModelAndView();
		PayMoneyDAO payMoneyDAO = (PayMoneyDAO) context.getBean("payMoneyDAO");
		PayItemDAO payItemDAO = (PayItemDAO) context.getBean("payItemDAO");
		Member loginMember = (Member) session.getAttribute("loginMember");
		PayMoney payMoney = new PayMoney();
		if(loginMember != null){
			String account = loginMember.getAccount();
            payMoney.setAccount(account);
            int subClassID = Integer.parseInt(expenditureForm.getSubClass());
            List<PayItem> allPayItem = payItemDAO.getAllPayItemBySubClassID(subClassID);
            List<PayMoney> oldFixedPayMoney = new ArrayList<PayMoney>();
            List<PayMoney> oldDynamicPayMoney = new ArrayList<PayMoney>();
            for(PayItem item : allPayItem){
            	if(item.getStatus() == 2){
            		List<PayMoney> tempPayMoney = payMoneyDAO.getPayMoneyByItemID(account,item.getItemID());
                    oldDynamicPayMoney.addAll(tempPayMoney);
                }else{
                	List<PayMoney> tempPayMoney = payMoneyDAO.getPayMoneyByItemID(account,item.getItemID());
                	oldFixedPayMoney.addAll(tempPayMoney);
                }
            }
            List<PayMoney> fixedPayMoney = expenditureForm.getFixedPayMoney();
            List<PayMoney> dynamicPayMoney = expenditureForm.getDynamicPayMoney();
            List<PayMoney> deletedPayMoney = expenditureForm.getDeletedPayMoney();
            //固定成本
            Map<Integer,Integer> tempFixedCostRecord = new HashMap<Integer,Integer>();
            for(int i = 0;i < oldFixedPayMoney.size();i++){
            	tempFixedCostRecord.put(oldFixedPayMoney.get(i).getID(),i);
            }
            if(fixedPayMoney != null){
            	for (int i = 0; i < fixedPayMoney.size(); i++) {
            		PayMoney newObject = fixedPayMoney.get(i);
            		if(oldFixedPayMoney.size() == 0){
                    	int recordID = payMoneyDAO.getPayRecord(account,newObject.getID());
                        payMoney.setID(newObject.getID());
                        payMoney.setRecord(recordID);
                        payMoney.setDate_string(newObject.getDate_string() + "-01");
                        payMoney.setMoney(newObject.getMoney());
                        payMoneyDAO.addPayMoney(payMoney);
                     }else{
                    	 if(fixedPayMoney.size() == oldFixedPayMoney.size()){//沒有缺資料，直接修改
                     		PayMoney oldObject = oldFixedPayMoney.get(i);
                             if (!oldObject.getDate().equals(newObject.getDate_string() + "-01")
                             		|| oldObject.getMoney() != newObject.getMoney()) {
                             	newObject.setAccount(account);
                                 newObject.setDate_string(newObject.getDate_string() + "-01");
                                 payMoneyDAO.modiPayMoney(newObject);
                             }
                     	}else{//有缺
                     		if(tempFixedCostRecord.containsKey(newObject.getID())){
                     			PayMoney oldObject = oldFixedPayMoney.get(tempFixedCostRecord.get(newObject.getID()));
                                if (!oldObject.getDate().equals(newObject.getDate_string() + "-01")
                                	|| oldObject.getMoney() != newObject.getMoney()) {
                                	newObject.setAccount(account);
                                    newObject.setDate_string(newObject.getDate_string() + "-01");
                                    payMoneyDAO.modiPayMoney(newObject);
                                }
                     		}else{
                         		int recordID = payMoneyDAO.getPayRecord(account,newObject.getID());
                                 payMoney.setID(newObject.getID());
                                 payMoney.setRecord(recordID);
                                 payMoney.setDate_string(newObject.getDate_string() + "-01");
                                 payMoney.setMoney(newObject.getMoney());
                                 payMoneyDAO.addPayMoney(payMoney);
                     		}
                     	}
                    }
            	}
            }
            //刪除
            if (deletedPayMoney != null) {
            	for (PayMoney p : deletedPayMoney) {
                	p.setAccount(account);
                    payMoneyDAO.delPayMoney(p);
                }
            }
            //動態新增
            if(dynamicPayMoney != null){
            	for (int i = 0; i < dynamicPayMoney.size(); i++) {
                	PayMoney newObject = dynamicPayMoney.get(i);
                    if (newObject.getID() == 0){//被刪除
                    	continue;
                    }else{
                    	if(oldDynamicPayMoney.size() > 0 && oldDynamicPayMoney.size() > i){//有舊資料
                        	PayMoney oldObject = oldDynamicPayMoney.get(i);
                        	if (!oldObject.getDate().equals(newObject.getDate_string() + "-01")
                        			|| oldObject.getMoney() != newObject.getMoney()) {//有修改
                            	newObject.setAccount(account);
                                newObject.setDate_string(newObject.getDate_string() + "-01");
                                payMoneyDAO.modiPayMoney(newObject);
                            }
                        }else{//沒有舊資料
                        	payMoney.setID(newObject.getID());
                            int recordID = payMoneyDAO.getPayRecord(account,newObject.getID());
                            payMoney.setRecord(recordID);
                            payMoney.setDate_string(newObject.getDate_string() + "-01");
                            payMoney.setMoney(newObject.getMoney());
                            payMoneyDAO.addPayMoney(payMoney);
                        }
                    }
            	}
            }
                   
            model.setViewName("redirect:/cashFlow?mon="+mon);
		}else{
			model.setViewName("redirect:/");
		}
        return model;
    }
	
	@RequestMapping(value = "/addProductSalseCashFlow", method = RequestMethod.POST)
	public ModelAndView addProductSalseRevenueStructure (HttpServletRequest request, HttpSession session) throws ParseException{
		String  monthDate[] = new String[13];
		int monthQuantity[] = new int[13];
		int getMonth;
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");		
		if(memberLogin!=null){			
			model.setViewName("redirect:/cashFlow");
			ProductSalesDAO productSalesDAO = (ProductSalesDAO)context.getBean("productSalesDAO");
			String[] dateList = request.getParameterValues("salsDate");
			String[] quantityList = request.getParameterValues("salsQuantity");
			ProductSales productSales = new ProductSales();
			productSales.setAccount(memberLogin.getAccount());
			productSales.setId(request.getParameter("productID"));
			productSalesDAO.delProductSalesByMember(productSales);			
			for(int i = 0 ; i<dateList.length ; i++){	
				if(dateList[i]!="" && quantityList[i]!=""){					
					getMonth = Integer.parseInt(dateList[i].substring(5,7));
					monthDate[getMonth] = dateList[i];
					monthQuantity[getMonth] = monthQuantity[getMonth]+Integer.parseInt(quantityList[i]);					
				}
			}	
			
			for(int j = 0;j<monthDate.length;j++){
				if(monthDate[j]!=null && monthQuantity[j]!=0){
					productSales.setDate_string(monthDate[j]+"-01");
					productSales.setQuantity(monthQuantity[j]);			
					productSalesDAO.insertProductSales(productSales);
				}
			}
		}
		else
			model.setViewName("memberLogin");
		return model;
	}
}
