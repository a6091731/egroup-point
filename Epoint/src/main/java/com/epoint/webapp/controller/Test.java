package com.epoint.webapp.controller;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Test {
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
    public ModelAndView test() throws Exception {
		ModelAndView model = new ModelAndView("test");
		return model;
	}

}
