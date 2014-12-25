package com.epoint.webapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChartController {
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	
	@RequestMapping(value = "/showChart", method = RequestMethod.GET)
	public ModelAndView getChart(){
		ModelAndView model = new ModelAndView("chart");
		List<Map<String, String>> listData = new ArrayList<Map<String, String>>();
		for(int i = 1;i <= 5;i++){
			Map<String, String> item = new HashMap<String, String>();
			item.put("value", String.valueOf(i*100));
			String color = "#F7464A";
			if(i % 2 == 0){
				color = "#FFC870";
			}
			item.put("color", color);
//			item.put("highlight", "#FF5A5E");
			item.put("label", "label"+String.valueOf(i));
			listData.add(item);
		}
		model.addObject("dataList", listData);
		return model;
	}
}
