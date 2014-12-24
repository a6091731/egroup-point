package com.epoint.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class IndexController {
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	
	@RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
	public ModelAndView model (HttpServletRequest request, HttpSession session) {
	ModelAndView model= new ModelAndView();
	return model;
	}
}
