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

import com.epoint.webapp.dao.ProductDAO;
import com.epoint.webapp.dao.VentureChecklistDAO;
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
			HumanResourceContent HumanResource = ventureChecklistDAO.getHumanResourceContentByMember(memberLogin);
			List<Product> allProducts = productDAO.getAllProductList(memberLogin);
			if(HumanResource == null){
				HumanResource.setMQ0(0);
				HumanResource.setMQ1(0);
				HumanResource.setMQ2(0);
				HumanResource.setMQ3(0);
				HumanResource.setMQ4(0);
				HumanResource.setRQ0(0);
				HumanResource.setRQ1(0);
				HumanResource.setRQ2(0);
				HumanResource.setRQ3(0);
				HumanResource.setRQ4(0);
				HumanResource.setSQ0(0);
				HumanResource.setSQ1(0);
				HumanResource.setSQ2(0);
				HumanResource.setSQ3(0);
				HumanResource.setSQ4(0);
				HumanResource.setOQ0(0);
				HumanResource.setOQ1(0);
				HumanResource.setOQ2(0);
				HumanResource.setOQ3(0);
				HumanResource.setOQ4(0);
				HumanResource.setTotalQ0(0);
				HumanResource.setTotalQ1(0);
				HumanResource.setTotalQ2(0);
				HumanResource.setTotalQ3(0);
				HumanResource.setTotalQ4(0);
			}
			
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
}
