package com.epoint.webapp.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.epoint.webapp.entity.Member;
import com.epoint.webapp.dao.MemberDAO;

public class MemberController {
ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLogin(HttpServletRequest request, HttpSession session) {
		ModelAndView model = new ModelAndView();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember == null){
			if(session.getAttribute("errorMsg") != null){
				String errorMsg = session.getAttribute("errorMsg").toString();
				session.removeAttribute("errorMsg");
				model.addObject("errorMsg", errorMsg);
			}
			
			//List<Menu> menuList = MenuUtil.getList(((MenuDAO)context.getBean("menuDAO")).getList(), 0);

			//model.addObject("menuList", menuList);
			model.setViewName("login");
		}
		else
			model.setViewName("redirect:/");
		return model;
	}
}
