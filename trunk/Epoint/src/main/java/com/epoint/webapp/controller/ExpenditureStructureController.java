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

import com.epoint.webapp.dao.PayItemDAO;
import com.epoint.webapp.dao.PayMoneyDAO;
import com.epoint.webapp.entity.Member;
import com.epoint.webapp.entity.PayItem;
import com.epoint.webapp.entity.PayMoney;
import com.epoint.webapp.form.ExpenditureForm;

@Controller
public class ExpenditureStructureController {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");

	@RequestMapping(value = "/founded", method = RequestMethod.GET)
	public ModelAndView founded(HttpSession session) throws IOException {
		ModelAndView model = new ModelAndView();
		PayMoneyDAO payMoneyDAO = (PayMoneyDAO) context.getBean("payMoneyDAO");
		Member loginMember = (Member) session.getAttribute("loginMember");
//      if(loginMember != null){
//      	String account = loginMember.getAccount();
            String account = "admin";
            List<PayMoney> fixedPayMoney = new ArrayList<PayMoney>();
            fixedPayMoney.add(payMoneyDAO.getSinglePayMoneyByItemID(account, 2111));
            fixedPayMoney.add(payMoneyDAO.getSinglePayMoneyByItemID(account, 2112));
            List<PayMoney> cardPayMoney = payMoneyDAO.getPayMoneyByItemID(account,2113);
            List<PayMoney> lawyerPayMoney = payMoneyDAO.getPayMoneyByItemID(account, 2114);
            List<PayMoney> accountPayMoney = payMoneyDAO.getPayMoneyByItemID(account, 2115);
            List<PayMoney> dynamicPayMoney = new ArrayList<PayMoney>();
            int[] dynamicTypeCount = { cardPayMoney.size(), lawyerPayMoney.size(),accountPayMoney.size() };
            dynamicPayMoney.addAll(cardPayMoney);
            dynamicPayMoney.addAll(lawyerPayMoney);
            dynamicPayMoney.addAll(accountPayMoney);
            model.addObject("fixedPayMoney", fixedPayMoney);
            model.addObject("dynamicPayMoney", dynamicPayMoney);
            model.addObject("dynamicTypeCount", dynamicTypeCount);
            model.setViewName("founded");
//		}else{
//      	model.setViewName("redirect:/");
//      }
            return model;
	}
       
        @RequestMapping(value = "/placeComplete", method = RequestMethod.GET)
        public ModelAndView placeComplete(HttpSession session) throws IOException {
                ModelAndView model = new ModelAndView();
                PayMoneyDAO payMoneyDAO = (PayMoneyDAO) context.getBean("payMoneyDAO");
                Member loginMember = (Member) session.getAttribute("loginMember");
//              if(loginMember != null){
//              String account = loginMember.getAccount();
                String account = "admin";
                        List<PayMoney> fixedPayMoney = new ArrayList<PayMoney>();
                        fixedPayMoney.add(payMoneyDAO.getSinglePayMoneyByItemID(account, 2121));
                        fixedPayMoney.add(payMoneyDAO.getSinglePayMoneyByItemID(account, 2122));
                        fixedPayMoney.add(payMoneyDAO.getSinglePayMoneyByItemID(account, 2123));
                        fixedPayMoney.add(payMoneyDAO.getSinglePayMoneyByItemID(account, 2124));
                        List<PayMoney> decoratedPayMoney = payMoneyDAO.getPayMoneyByItemID(account,2125);
                        List<PayMoney> equipmentPayMoney = payMoneyDAO.getPayMoneyByItemID(account, 2126);
                        List<PayMoney> deskPayMoney = payMoneyDAO.getPayMoneyByItemID(account, 2127);
                        List<PayMoney> dynamicPayMoney = new ArrayList<PayMoney>();
                        int[] dynamicTypeCount = { decoratedPayMoney.size(), equipmentPayMoney.size(),deskPayMoney.size() };
                        dynamicPayMoney.addAll(decoratedPayMoney);
                        dynamicPayMoney.addAll(equipmentPayMoney);
                        dynamicPayMoney.addAll(deskPayMoney);
                        model.addObject("fixedPayMoney", fixedPayMoney);
                        model.addObject("dynamicPayMoney", dynamicPayMoney);
                        model.addObject("dynamicTypeCount", dynamicTypeCount);
                        model.setViewName("placeComplete");
//              }else{
//               model.setViewName("redirect:/");
//              }
                return model;
        }
       
        @RequestMapping(value = "/personPlace", method = RequestMethod.GET)
        public ModelAndView personPlace(HttpSession session) throws IOException {
                ModelAndView model = new ModelAndView();
                PayMoneyDAO payMoneyDAO = (PayMoneyDAO) context.getBean("payMoneyDAO");
                Member loginMember = (Member) session.getAttribute("loginMember");
//              if(loginMember != null){
//              String account = loginMember.getAccount();
                String account = "admin";
                        List<PayMoney> fixedPayMoney = new ArrayList<PayMoney>();
                        fixedPayMoney.add(payMoneyDAO.getSinglePayMoneyByItemID(account, 2131));
                        fixedPayMoney.add(payMoneyDAO.getSinglePayMoneyByItemID(account, 2132));
                        List<PayMoney> officialPayMoney = payMoneyDAO.getPayMoneyByItemID(account,2133);
                        List<PayMoney> trainingPayMoney = payMoneyDAO.getPayMoneyByItemID(account, 2134);
                        List<PayMoney> dynamicPayMoney = new ArrayList<PayMoney>();
                        int[] dynamicTypeCount = { officialPayMoney.size(), trainingPayMoney.size()};
                        dynamicPayMoney.addAll(officialPayMoney);
                        dynamicPayMoney.addAll(trainingPayMoney);
                        model.addObject("fixedPayMoney", fixedPayMoney);
                        model.addObject("dynamicPayMoney", dynamicPayMoney);
                        model.addObject("dynamicTypeCount", dynamicTypeCount);
                        model.setViewName("personPlace");
//              }else{
//               model.setViewName("redirect:/");
//              }
                return model;
        }
       
        @RequestMapping(value = "/equipmentBuild", method = RequestMethod.GET)
        public ModelAndView equipmentBuild(HttpSession session) throws IOException {
                ModelAndView model = new ModelAndView();
                PayMoneyDAO payMoneyDAO = (PayMoneyDAO) context.getBean("payMoneyDAO");
                Member loginMember = (Member) session.getAttribute("loginMember");
//              if(loginMember != null){
//              String account = loginMember.getAccount();
                String account = "admin";
                        List<PayMoney> cleaningPayMoney = payMoneyDAO.getPayMoneyByItemID(account,2141);
                        List<PayMoney> buyingPayMoney = payMoneyDAO.getPayMoneyByItemID(account, 2142);
                        List<PayMoney> dynamicPayMoney = new ArrayList<PayMoney>();
                        int[] dynamicTypeCount = { cleaningPayMoney.size(), buyingPayMoney.size()};
                        dynamicPayMoney.addAll(cleaningPayMoney);
                        dynamicPayMoney.addAll(buyingPayMoney);
                        model.addObject("dynamicPayMoney", dynamicPayMoney);
                        model.addObject("dynamicTypeCount", dynamicTypeCount);
                        model.setViewName("equipmentBuild");
//              }else{
//               model.setViewName("redirect:/");
//              }
                return model;
        }
       
        @RequestMapping(value = "/trialProduction", method = RequestMethod.GET)
        public ModelAndView trialProduction(HttpSession session) throws IOException {
                ModelAndView model = new ModelAndView();
                PayMoneyDAO payMoneyDAO = (PayMoneyDAO) context.getBean("payMoneyDAO");
                Member loginMember = (Member) session.getAttribute("loginMember");
//              if(loginMember != null){
//              String account = loginMember.getAccount();
                String account = "admin";
                        List<PayMoney> materialPayMoney = payMoneyDAO.getPayMoneyByItemID(account,2151);
                        List<PayMoney> consultingPayMoney = payMoneyDAO.getPayMoneyByItemID(account, 2152);
                        List<PayMoney> dynamicPayMoney = new ArrayList<PayMoney>();
                        int[] dynamicTypeCount = { materialPayMoney.size(), consultingPayMoney.size()};
                        dynamicPayMoney.addAll(materialPayMoney);
                        dynamicPayMoney.addAll(consultingPayMoney);
                        model.addObject("dynamicPayMoney", dynamicPayMoney);
                        model.addObject("dynamicTypeCount", dynamicTypeCount);
                        model.setViewName("trialProduction");
//              }else{
//               model.setViewName("redirect:/");
//              }
                return model;
        }
       
        @RequestMapping(value = "/procureMaterial", method = RequestMethod.GET)
        public ModelAndView procureMaterial(HttpSession session) throws IOException {
                ModelAndView model = new ModelAndView();
                PayMoneyDAO payMoneyDAO = (PayMoneyDAO) context.getBean("payMoneyDAO");
                Member loginMember = (Member) session.getAttribute("loginMember");
//              if(loginMember != null){
//              String account = loginMember.getAccount();
                String account = "admin";
                        List<PayMoney> materialPayMoney = payMoneyDAO.getPayMoneyByItemID(account,2161);
                        List<PayMoney> decoratingPayMoney = payMoneyDAO.getPayMoneyByItemID(account, 2162);
                        List<PayMoney> dynamicPayMoney = new ArrayList<PayMoney>();
                        int[] dynamicTypeCount = { materialPayMoney.size(), decoratingPayMoney.size()};
                        dynamicPayMoney.addAll(materialPayMoney);
                        dynamicPayMoney.addAll(decoratingPayMoney);
                        model.addObject("dynamicPayMoney", dynamicPayMoney);
                        model.addObject("dynamicTypeCount", dynamicTypeCount);
                        model.setViewName("procureMaterial");
//              }else{
//               model.setViewName("redirect:/");
//              }
                return model;
        }
       
        @RequestMapping(value = "/trialOperation", method = RequestMethod.GET)
        public ModelAndView trialOperation(HttpSession session) throws IOException {
                ModelAndView model = new ModelAndView();
                PayMoneyDAO payMoneyDAO = (PayMoneyDAO) context.getBean("payMoneyDAO");
                Member loginMember = (Member) session.getAttribute("loginMember");
//              if(loginMember != null){
//              String account = loginMember.getAccount();
                String account = "admin";
                        List<PayMoney> activityPayMoney = payMoneyDAO.getPayMoneyByItemID(account,2171);
                        List<PayMoney> part_timePayMoney = payMoneyDAO.getPayMoneyByItemID(account, 2172);
                        List<PayMoney> dynamicPayMoney = new ArrayList<PayMoney>();
                        int[] dynamicTypeCount = { activityPayMoney.size(), part_timePayMoney.size()};
                        dynamicPayMoney.addAll(activityPayMoney);
                        dynamicPayMoney.addAll(part_timePayMoney);
                        model.addObject("dynamicPayMoney", dynamicPayMoney);
                        model.addObject("dynamicTypeCount", dynamicTypeCount);
                        model.setViewName("trialOperation");
//              }else{
//               model.setViewName("redirect:/");
//              }
                return model;
        }
       
        @RequestMapping(value = "/developmentMarket", method = RequestMethod.GET)
        public ModelAndView developmentMarket(HttpSession session) throws IOException {
                ModelAndView model = new ModelAndView();
                PayMoneyDAO payMoneyDAO = (PayMoneyDAO) context.getBean("payMoneyDAO");
                Member loginMember = (Member) session.getAttribute("loginMember");
//              if(loginMember != null){
//              String account = loginMember.getAccount();
                String account = "admin";
                        List<PayMoney> travelPayMoney = payMoneyDAO.getPayMoneyByItemID(account,2181);
                        List<PayMoney> socialPayMoney = payMoneyDAO.getPayMoneyByItemID(account, 2182);
                        List<PayMoney> dynamicPayMoney = new ArrayList<PayMoney>();
                        int[] dynamicTypeCount = { travelPayMoney.size(), socialPayMoney.size()};
                        dynamicPayMoney.addAll(travelPayMoney);
                        dynamicPayMoney.addAll(socialPayMoney);
                        model.addObject("dynamicPayMoney", dynamicPayMoney);
                        model.addObject("dynamicTypeCount", dynamicTypeCount);
                        model.setViewName("developmentMarket");
//              }else{
//               model.setViewName("redirect:/");
//              }
                return model;
        }
       
        @RequestMapping(value = "/marketing", method = RequestMethod.GET)
        public ModelAndView marketing(HttpSession session) throws IOException {
                ModelAndView model = new ModelAndView();
                PayMoneyDAO payMoneyDAO = (PayMoneyDAO) context.getBean("payMoneyDAO");
                Member loginMember = (Member) session.getAttribute("loginMember");
//              if(loginMember != null){
//              String account = loginMember.getAccount();
                String account = "admin";
                        List<PayMoney> paperAdPayMoney = payMoneyDAO.getPayMoneyByItemID(account,2191);
                        List<PayMoney> electricalAdPayMoney = payMoneyDAO.getPayMoneyByItemID(account, 2192);
                        List<PayMoney> physicalAdPayMoney = payMoneyDAO.getPayMoneyByItemID(account, 2193);
                        List<PayMoney> dynamicPayMoney = new ArrayList<PayMoney>();
                        int[] dynamicTypeCount = { paperAdPayMoney.size(), electricalAdPayMoney.size(), physicalAdPayMoney.size()};
                        dynamicPayMoney.addAll(paperAdPayMoney);
                        dynamicPayMoney.addAll(electricalAdPayMoney);
                        dynamicPayMoney.addAll(physicalAdPayMoney);
                        model.addObject("dynamicPayMoney", dynamicPayMoney);
                        model.addObject("dynamicTypeCount", dynamicTypeCount);
                        model.setViewName("marketing");
//              }else{
//               model.setViewName("redirect:/");
//              }
                return model;
        }

        @RequestMapping(value = "/addExpenditure", method = RequestMethod.POST)
        public ModelAndView addExpenditure(@ModelAttribute ExpenditureForm expenditureForm,
                        HttpSession session, HttpServletRequest request) throws IOException {
                ModelAndView model = new ModelAndView();
                PayMoneyDAO payMoneyDAO = (PayMoneyDAO) context.getBean("payMoneyDAO");
                PayItemDAO payItemDAO = (PayItemDAO) context.getBean("payItemDAO");
                Member loginMember = (Member) session.getAttribute("loginMember");
                PayMoney payMoney = new PayMoney();
//              if(loginMember != null){
//              String account = loginMember.getAccount();
                String account = "admin";
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
                                                PayMoney oldObject = oldFixedPayMoney.get(i);
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
                       
                        if(subClassID == 211){
                                model.setViewName("redirect:/placeComplete");
                        }else if(subClassID == 212){
                                model.setViewName("redirect:/personPlace");
                        }else if(subClassID == 213){
                                model.setViewName("redirect:/equipmentBuild");
                        }else if(subClassID == 214){
                                model.setViewName("redirect:/trialProduction");
                        }else if(subClassID == 215){
                                model.setViewName("redirect:/procureMaterial");
                        }else if(subClassID == 216){
                                model.setViewName("redirect:/trialOperation");
                        }else if(subClassID == 217){
                                model.setViewName("redirect:/developmentMarket");
                        }else if(subClassID == 218){
                                model.setViewName("redirect:/marketing");
                        }else if(subClassID == 219){
                                model.setViewName("redirect:/founded");
                        }
//              }else{
//              model.setViewName("redirect:/");
//              }
                return model;
        }
       
}
