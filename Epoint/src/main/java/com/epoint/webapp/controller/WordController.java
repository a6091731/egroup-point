package com.epoint.webapp.controller;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Controller
public class WordController {
ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
private Configuration configuration = new Configuration();
	
	@RequestMapping(value = "/exportWord", method = RequestMethod.GET)
	public @ResponseBody void exportWord(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String xml = "ventureChecklist.xml";
		String filePath = request.getServletContext().getRealPath("resources/word");
		File xmlFile = new File(filePath);
		String docFileName = "創業E點通.doc";
		Template template = null;
		configuration.setDefaultEncoding("UTF-8");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("content", "各位大四專題同學好，簡述十二月專題相關事項：/n12月17日到12月19日：領取燒錄光碟片及登記驗收時間/n1.登記時間為每日08:30～11:30；13:30～16:30/n2.同學在登記時，順便領取空白光碟片、並請逕自下載專題系統測試同意書及使用及授權展示同意書/n3.光碟燒錄請參閱「專題系統程式光碟製作實施辦法」，所需內容請務必參照規定，若有遺漏者，恕不接受，請重新製作。/n4.使用及展示授權同意書功用：系上對於同學們的專題系統保證只在教學上使用；請各組同學務必親自簽名/n/n12月22日到12月26日：光碟驗收及繳交專題文件電子檔/n1.驗收目的主要確認光碟內容是否正確確實，若發生光碟內容不齊全等狀況，請同學修正補齊。/n光碟驗收重點：/n一)光碟燒錄格式是否正確，四個資料夾均需建立(請參閱專題系統程式光碟製作實施辦法)，分別放置相關檔案，根目錄下需包含安裝說明、操作說明、專題發表PPT及成果影片/n二)文件格式內容/n(1)目錄：章節是否均從奇數頁開始/n(2)奇偶數頁首格式是否正確/n(3)安裝說明及操作說明是否詳盡/n三)測試同意書、文件送印同意書及使用授權書是否已繳交/n2.驗收地點在系辦公室(LM306)，各組攜帶製作好的光碟片來驗收。/n3.專題文件電子檔繳交注意事項:/n附於光碟內，需註明各章節順序。/n繳交前將'文件完稿同意書'請指導老師簽名；然後連同光碟片一齊交至助教辦公室/n每份專題文件不得少於90頁。/n驗收時同時繳交專題系統測試同意書及使用及授權展示同意書。/n4.光碟測試全部於12月26日(五)結束，若逾期未完成光碟製作，將通知指導老師，且不予完成專題實作。/n/n12月31日前：實驗室及電腦設備歸還/n各組在繳交系統及文件光碟後，開始辦理實驗室電腦設備、磁卡歸還事宜。 (詳細歸還手續由育潔助教另行公告)/n除非有特殊理由需延後歸還，則所有專題組請於12月31日(三)前辦妥歸還手續，敬請配合！/n黃圩君助教 2014/12/9");
		dataMap.put("product1", "產品1");
		dataMap.put("number1", 111);
		dataMap.put("product2", "產品2");
		dataMap.put("number2", 222);
		dataMap.put("number", 456);
		dataMap.put("total", "數字總和");
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
}
