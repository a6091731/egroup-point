package com.epoint.webapp.controller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.epoint.webapp.dao.MemberDAO;
import com.epoint.webapp.entity.Member;
import com.epoint.webapp.util.SecurityMD5;
import com.epoint.webapp.util.UUIDGenerator;
import com.epoint.webapp.util.HtmlUtil;
import com.epoint.webapp.util.Mail;

@Controller
public class MemberController {
ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");

	//會員登入呈現
	@RequestMapping(value = "/memberLogin", method = RequestMethod.GET)
	public ModelAndView memberLogin(HttpServletRequest request, HttpSession session) {
		ModelAndView model = new ModelAndView();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember == null){
			if(session.getAttribute("errorMsg") != null){
				String errorMsg = session.getAttribute("errorMsg").toString();
				session.removeAttribute("errorMsg");
				System.out.println("errorMsg="+errorMsg);
				//model.addObject("errorMsg", errorMsg);
			}			
			model.setViewName("memberLogin");
		}
		else
			model.setViewName("redirect:/index");
		return model;
	}
	
	//驗證帳號sendForm
	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	public ModelAndView checkLogin(@ModelAttribute Member member, HttpSession session, HttpServletRequest request) throws IOException {
		ModelAndView model = new ModelAndView();
		SecurityMD5 securityMD5 = new SecurityMD5();
		MemberDAO memberDAO = (MemberDAO)context.getBean("memberDAO");
		try {
			member.setPassword(securityMD5.encryptWords(member.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		member = memberDAO.checkLogin(member);
		//System.out.println("member.isLogin() : "+member.isLogin());
		if(member.isLogin()){
			session.setAttribute("loginMember", member);
			model.setViewName("redirect:"+request.getHeader("referer"));
		}
		else{
			session.setAttribute("errorMsg", "無效的帳號密碼或未驗證");
			model.setViewName("redirect:/memberLogin");
		}
		//System.out.println("model="+model.getViewName());
		return model;
	}
	
	//會員註冊頁面呈現
	@RequestMapping(value = "/memberRegister", method = RequestMethod.GET)
	public ModelAndView register(HttpSession session){
		ModelAndView model = new ModelAndView();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember != null)
			model.setViewName("redirect:/");
		else{			
			model.setViewName("memberRegister");
		}
		return model;
	}
	
	//會員註冊sendFrom
	@RequestMapping(value = "/addMember", method = RequestMethod.POST)
	public ModelAndView addMember(Member member, HttpServletRequest request, HttpSession session){
		ModelAndView model = new ModelAndView();
		MemberDAO memberDAO = (MemberDAO)context.getBean("memberDAO");
		SecurityMD5 securityMD5 = new SecurityMD5();
		//member.setRegisterNO(UUIDGenerator.getUUID());
		try {
			member.setPassword(securityMD5.encryptWords(member.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		memberDAO.addMember(member);
		session.setAttribute("loginMember", member);
		model.setViewName("index");
		/*HtmlUtil htmlUtil = new HtmlUtil();
		String subject = "創業e點通：會員註冊驗證";
		String message = "";
		try {
			message = htmlUtil.htmlToString(request.getServletContext().getRealPath("html/register.html"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Mail mail = new Mail();
		message = message.replaceAll("link_url", "http://www.proactive.tw/active?aid="+member.getRegisterNO());
		message = message.replaceAll("user_name", member.getName());
		mail.sendMail(subject, member.getAccount(), message);*/
		return model;
	}
	
	//會員註冊判斷是否已有此帳號 SendForm
	@RequestMapping(value = "/checkAccount", method = RequestMethod.POST)
	public @ResponseBody boolean checkAccount(String account){
		MemberDAO memberDAO = (MemberDAO)context.getBean("memberDAO");
		boolean flag = memberDAO.checkAccount(account);
		//System.out.println("flag="+flag);
		return flag;
	}
	
	@RequestMapping(value = "/forgotPassword1", method = RequestMethod.GET)
	public ModelAndView forgotPassword1(HttpServletRequest request, HttpSession session) {
		ModelAndView model = new ModelAndView();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember == null){						
			model.setViewName("forgotPassword1");
		}
		else
			model.setViewName("redirect:/");
		return model;
	}		
	
	//會員忘記密碼
	@RequestMapping(value = "/sendPasswordConfirm", method = RequestMethod.POST)
	public ModelAndView sendPasswordConfirm(String account, HttpServletRequest request) {
		ModelAndView model = new ModelAndView();		
		MemberDAO memberDAO = (MemberDAO) context.getBean("memberDAO");
		Member member = new Member();
		member = memberDAO.checkMember(account);
		System.out.println("member.getAccount="+member.getAccount()+",member.getStatus="+member.getStatus());
		if(member.getAccount()!=null && member.getStatus()==1){
			System.out.println("****1");
			//model.setViewName("redirect:/forgetPassword2");
			model.setViewName("redirect:/memberLogin");
			member.setResetNO(UUIDGenerator.getUUID());
			memberDAO.updateResetNO(member);
			HtmlUtil htmlUtil = new HtmlUtil();
			String subject = "創業e點通：忘記密碼";
			String message = "";
			try {
				message = htmlUtil.htmlToString(request.getServletContext().getRealPath("html/forgetPassword.html"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Mail mail = new Mail();
			message = message.replaceAll("link_url", "http://www.proactive.tw/resetPassword?aid="+member.getResetNO());
			message = message.replaceAll("user_name", member.getName());
			mail.sendMail(subject, member.getAccount(), message);			
		}
		else
			model.setViewName("redirect:/forgetPasswordFail");
		return model;
	}
	
	//重設密碼
	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public ModelAndView resetPassword(String password, String aid) {
		ModelAndView model = new ModelAndView();
		MemberDAO memberDAO = (MemberDAO) context.getBean("memberDAO");
		Member member = new Member();
		SecurityMD5 securityMD5 = new SecurityMD5();
		member.setResetNO(aid);
		member = memberDAO.getByResetNO(member);
		if(member.getAccount()!=null && member.getStatus()==1){
			try {
				password = securityMD5.encryptWords(password);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			member.setPassword(password);
			memberDAO.updatePassword(member);
			model.setViewName("redirect:/reset2");
		}
		else
			model.setViewName("redirect:/forgetPasswordFail");
		return model;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpSession session) {
		ModelAndView model = new ModelAndView("redirect:"+request.getHeader("referer"));
		request.getSession().invalidate();
		return model;
	}
}
