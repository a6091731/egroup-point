package com.epoint.webapp.controller;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.epoint.webapp.dao.FinancialPlanDAO;
import com.epoint.webapp.dao.MemberDAO;
import com.epoint.webapp.dao.PayMoneyDAO;
import com.epoint.webapp.dao.ProductDAO;
import com.epoint.webapp.dao.VentureChecklistDAO;
import com.epoint.webapp.entity.FinancialPlan;
import com.epoint.webapp.entity.HumanResourceContent;
import com.epoint.webapp.entity.MapSubclass;
import com.epoint.webapp.entity.Member;
import com.epoint.webapp.entity.Product;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Controller
public class WordController {
	ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	private Configuration configuration = new Configuration();
	
	@RequestMapping(value = "/exportWord", method = RequestMethod.GET)
	public ModelAndView exportWord(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		ModelAndView model = new ModelAndView();
		VentureChecklistDAO ventureChecklistDAO = (VentureChecklistDAO)context.getBean("ventureChecklistDAO");
		ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
		Member memberLogin = (Member)session.getAttribute("loginMember");
		if(memberLogin==null){
			model.setViewName("redirect:/memberLogin");
			return model;
		}else{
			String xml = "ventureChecklist.xml";
			String filePath = request.getServletContext().getRealPath("resources/word");
			File xmlFile = new File(filePath);
			String docFileName = "創業前檢核表.doc";
			Template template = null;
			configuration.setDefaultEncoding("UTF-8");
			Map<String, Object> dataMap = new HashMap<String, Object>();
			List<MapSubclass> allVentureContents = new ArrayList<MapSubclass>();
			
			memberLogin.setClassID(11);
			allVentureContents.addAll(ventureChecklistDAO.getVentureCheckListByMember(memberLogin));
			memberLogin.setClassID(12);
			allVentureContents.addAll(ventureChecklistDAO.getVentureCheckListByMember(memberLogin));
			memberLogin.setClassID(14);
			allVentureContents.addAll(ventureChecklistDAO.getVentureCheckListByMember(memberLogin));
			memberLogin.setClassID(15);
			allVentureContents.addAll(ventureChecklistDAO.getVentureCheckListByMember(memberLogin));
			memberLogin.setClassID(16);
			allVentureContents.addAll(ventureChecklistDAO.getVentureCheckListByMember(memberLogin));
			memberLogin.setClassID(17);
			allVentureContents.addAll(ventureChecklistDAO.getVentureCheckListByMember(memberLogin));
			//word換行
			for(MapSubclass m : allVentureContents){
				m.setContent(m.getContent().replaceAll("\\r\\n", "<w:br/>"));
			}
			HumanResourceContent HumanResource = ventureChecklistDAO.getHumanResourceContentByMember(memberLogin);
			List<Product> allProducts = productDAO.getAllProductList(memberLogin);
			if(HumanResource == null){
				HumanResource.setM0(0);
				HumanResource.setM1(0);
				HumanResource.setM2(0);
				HumanResource.setM3(0);
				HumanResource.setM4(0);
				HumanResource.setM5(0);
				HumanResource.setM6(0);
				HumanResource.setM7(0);
				HumanResource.setM8(0);
				HumanResource.setM9(0);
				HumanResource.setM10(0);
				HumanResource.setM11(0);
				HumanResource.setM12(0);
				
				HumanResource.setR0(0);
				HumanResource.setR1(0);
				HumanResource.setR2(0);
				HumanResource.setR3(0);
				HumanResource.setR4(0);
				HumanResource.setR5(0);
				HumanResource.setR6(0);
				HumanResource.setR7(0);
				HumanResource.setR8(0);
				HumanResource.setR9(0);
				HumanResource.setR10(0);
				HumanResource.setR11(0);
				HumanResource.setR12(0);
				
				HumanResource.setS0(0);
				HumanResource.setS1(0);
				HumanResource.setS2(0);
				HumanResource.setS3(0);
				HumanResource.setS4(0);
				HumanResource.setS5(0);
				HumanResource.setS6(0);
				HumanResource.setS7(0);
				HumanResource.setS8(0);
				HumanResource.setS9(0);
				HumanResource.setS10(0);
				HumanResource.setS11(0);
				HumanResource.setS12(0);
				
				HumanResource.setO0(0);
				HumanResource.setO1(0);
				HumanResource.setO2(0);
				HumanResource.setO3(0);
				HumanResource.setO4(0);
				HumanResource.setO5(0);
				HumanResource.setO6(0);
				HumanResource.setO7(0);
				HumanResource.setO8(0);
				HumanResource.setO9(0);
				HumanResource.setO10(0);
				HumanResource.setO11(0);
				HumanResource.setO12(0);
				
				HumanResource.setTotal0(0);
				HumanResource.setTotal1(0);
				HumanResource.setTotal2(0);
				HumanResource.setTotal3(0);
				HumanResource.setTotal4(0);
				HumanResource.setTotal5(0);
				HumanResource.setTotal6(0);
				HumanResource.setTotal7(0);
				HumanResource.setTotal8(0);
				HumanResource.setTotal9(0);
				HumanResource.setTotal10(0);
				HumanResource.setTotal11(0);
				HumanResource.setTotal12(0);
			}

			dataMap.put("name", memberLogin.getName());
			dataMap.put("allVentureContents", allVentureContents);
			dataMap.put("HumanResource", HumanResource);
			dataMap.put("allProducts", allProducts);
			try {
				configuration.setDirectoryForTemplateLoading(xmlFile);
				template = configuration.getTemplate(xml);
				File outFile = new File(docFileName);
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
				template.setEncoding("UTF-8");
				template.process(dataMap, out);
				
				int length = 0;
				ServletOutputStream op = response.getOutputStream();
				ServletContext context = request.getServletContext();
				String mimetype = context.getMimeType(docFileName);
				response.setContentType((mimetype != null) ? mimetype : "application/octet-stream");
				response.setContentLength((int) outFile.length());
				response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(docFileName.getBytes("UTF-8"), "ISO-8859-1"));
				byte[] bbuf = new byte[200];
				InputStream in = new BufferedInputStream(new FileInputStream(outFile));
	
				while ((in != null) && ((length = in.read(bbuf)) > 0)) {
					op.write(bbuf, 0, length);
				}
				in.close();
				op.flush();
				op.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TemplateException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@RequestMapping(value = "/exportFinancialPlan", method = RequestMethod.GET)
	public ModelAndView exportFinancialPlan(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		ModelAndView model = new ModelAndView();
		PayMoneyDAO payMoneyDAO = (PayMoneyDAO) context.getBean("payMoneyDAO");
		FinancialPlanDAO financialPlanDAO = (FinancialPlanDAO) context.getBean("financialPlanDAO");
		MemberDAO memberDAO = (MemberDAO) context.getBean("memberDAO");
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember==null){
			model.setViewName("redirect:/memberLogin");
			return model;
		}else{
			String xml = "financialPlan.xml";
			String filePath = request.getServletContext().getRealPath("resources/word");
			File xmlFile = new File(filePath);
			String docFileName = "資金規劃.doc";
			Template template = null;
			configuration.setDefaultEncoding("UTF-8");
			Map<String, Object> dataMap = new HashMap<String, Object>();
			String account = loginMember.getAccount();
			int avgCost = payMoneyDAO.getMonthlyCostByAccount(account);
			int fundLack = memberDAO.getFundLackByAccount(account);
			int demandMoneyForFirstYear = avgCost*3 + fundLack;
			List<FinancialPlan> usesPlans = financialPlanDAO.getFinancialPlansByItemID(account, 1);
			List<FinancialPlan> sourcePlans = financialPlanDAO.getFinancialPlansByItemID(account, 0);
			
			dataMap.put("name", loginMember.getName());
			dataMap.put("demandMoneyForFirstYear", demandMoneyForFirstYear);
			dataMap.put("avgCost", avgCost);
			dataMap.put("fundLack", fundLack);
			dataMap.put("usesPlans", usesPlans);
			dataMap.put("sourcePlans", sourcePlans);
			try {
				configuration.setDirectoryForTemplateLoading(xmlFile);
				template = configuration.getTemplate(xml);
				File outFile = new File(docFileName);
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
				template.setEncoding("UTF-8");
				template.process(dataMap, out);
				
				int length = 0;
				ServletOutputStream op = response.getOutputStream();
				ServletContext context = request.getServletContext();
				String mimetype = context.getMimeType(docFileName);
				response.setContentType((mimetype != null) ? mimetype : "application/octet-stream");
				response.setContentLength((int) outFile.length());
				response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(docFileName.getBytes("UTF-8"), "ISO-8859-1"));
				byte[] bbuf = new byte[200];
				InputStream in = new BufferedInputStream(new FileInputStream(outFile));
	
				while ((in != null) && ((length = in.read(bbuf)) > 0)) {
					op.write(bbuf, 0, length);
				}
				in.close();
				op.flush();
				op.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TemplateException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
