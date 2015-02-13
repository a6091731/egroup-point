package com.epoint.webapp.controller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.mail.Flags.Flag;
import javax.mail.Session;
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
				model.addObject("errorMsg", errorMsg);
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
		model.setViewName("redirect:/index");
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
			model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value = "/forgotPassword2", method = RequestMethod.GET)
	public ModelAndView forgotPassword2(HttpServletRequest request, HttpSession session) {
		ModelAndView model = new ModelAndView();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember == null){						
			model.setViewName("forgotPassword2");
		}
		else
			model.setViewName("index");
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
			//model.setViewName("redirect:/forgetPassword2");
			System.out.println("123");
			model.setViewName("redirect:/forgotPassword2");
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
			message = message.replaceAll("link_url", "http://54.92.77.173/memberResetPassword1?aid="+member.getResetNO());
			System.out.println("member.getResetNO()="+member.getResetNO());
			message = message.replaceAll("user_name", member.getName());
			mail.sendMail(subject, member.getAccount(), message);			
		}
		else
			model.setViewName("redirect:/forgetPasswordFail");
		return model;
	}
	
	@RequestMapping(value = "/memberModiPassword1", method = RequestMethod.GET)
	public ModelAndView memberModiPassword1(String password, String aid, HttpServletRequest request,
			HttpSession session) {
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");
		if(memberLogin==null)
			model.setViewName("memberLogin");
		else{
			if(session.getAttribute("errorMsg") != null){
				String errorMsg = session.getAttribute("errorMsg").toString();
				session.removeAttribute("errorMsg");
				model.addObject("errorMsg", errorMsg);
			}			
			model.setViewName("memberModiPassword1");
			model.addObject("getMemebr", memberLogin);
		}			
		return model;
	}
	
	@RequestMapping(value = "/memberModiPassword2", method = RequestMethod.GET)
	public ModelAndView memberModiPassword2(String password, String aid, HttpServletRequest request,
			HttpSession session) {
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");
		if(memberLogin==null)
			model.setViewName("memberLogin");
		else{			
			model.setViewName("memberModiPassword2");
		}			
		return model;
	}
	
	//重設密碼
	@RequestMapping(value = "/modiPassword", method = RequestMethod.POST)
	public ModelAndView modiPassword(String oldPassword, String newPassword1,HttpServletRequest request,
			HttpSession session) {
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");
		if(memberLogin==null)
			model.setViewName("redirect:/dmemberLogin");
		else{
			SecurityMD5 securityMD5 = new SecurityMD5();
			try {
				oldPassword = securityMD5.encryptWords(oldPassword);
				MemberDAO memberDAO = (MemberDAO) context.getBean("memberDAO");	
				boolean flag = memberDAO.checkMemberPassword(memberLogin.getAccount(), oldPassword);
				if(flag ==true)
				{
					String newPassword = securityMD5.encryptWords(newPassword1);
					memberLogin.setPassword(newPassword);
					memberDAO.updatePassword(memberLogin);
					System.out.println("修改成功");
					model.setViewName("redirect:/memberModiPassword2");
				}
				else{
					model.setViewName("redirect:/memberModiPassword1");
					session.setAttribute("errorMsg", "您輸入的舊密碼錯誤，請在確認一次");
				}
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return model;
		}
		
			
		/*
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
			model.setViewName("redirect:/forgetPasswordFail");*/
		return model;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpSession session) {
		ModelAndView model = new ModelAndView("redirect:"+request.getHeader("referer"));
		request.getSession().invalidate();
		return model;
	}
	
	@RequestMapping(value = "/memberModi1", method = RequestMethod.GET)
	public ModelAndView memberEdit(HttpServletRequest request, HttpSession session) {
		ModelAndView model = new ModelAndView();	
		Member memberLogin = (Member)session.getAttribute("loginMember");
		if(memberLogin==null){
			model.setViewName("memberLogin");;
		}else {
			model.setViewName("memberModi1");
			model.addObject("getMember", memberLogin);
		}
		return model;
	}
	
	@RequestMapping(value = "/memberModi2", method = RequestMethod.GET)
	public ModelAndView memberModi2(HttpServletRequest request, HttpSession session) {
		ModelAndView model = new ModelAndView();	
		Member memberLogin = (Member)session.getAttribute("loginMember");
		if(memberLogin==null){
			model.setViewName("memberLogin");;
		}else {
			model.setViewName("memberModi2");
		}
		return model;
	}
	
	@RequestMapping(value = "/modiMember", method = RequestMethod.POST)
	public ModelAndView modiMember1(HttpServletRequest request, HttpSession session,
			Member member) {
		ModelAndView model = new ModelAndView();	
		Member memberLogin = (Member)session.getAttribute("loginMember");
		if(memberLogin==null){
			model.setViewName("redirect:/memberLogin");;
		}else {
			model.setViewName("redirect:/memberModi2");
			MemberDAO memberDAO = (MemberDAO) context.getBean("memberDAO");
			memberLogin.setName(member.getName());
			memberLogin.setPhone(member.getPhone());
			memberLogin.setEmail(member.getEmail());
			memberDAO.modieMember(memberLogin);
			model.addObject("getMember", memberLogin);
		}
		return model;
	}
	
	@RequestMapping(value = "/memberResetPassword1", method = RequestMethod.GET)
	public ModelAndView memberResetPassword1(String aid) {
		ModelAndView model = new ModelAndView();
		MemberDAO memberDAO = (MemberDAO) context.getBean("memberDAO");
		Member member = new Member();
		member.setResetNO(aid);
		member = memberDAO.getByResetNO(member);
		if(member.getAccount()!=null && member.getStatus()==1){
			model.addObject("aid", aid);
			model.setViewName("memberResetPassword1");
		}
		else
			model.setViewName("memberResetPasswordFail");
		return model;
	}
	
	@RequestMapping(value = "/memberResetPassword2", method = RequestMethod.GET)
	public ModelAndView memberResetPassword2() {
		ModelAndView model = new ModelAndView();
		model.setViewName("memberResetPassword2");
		return model;
	}
	
	@RequestMapping(value = "/memberResetPasswordFail", method = RequestMethod.GET)
	public ModelAndView memberResetPasswordFail() {
		ModelAndView model = new ModelAndView();
		model.setViewName("memberResetPasswordFail");
		return model;
	}
	
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
			model.setViewName("redirect:/memberModiPassword2");
		}
		else
			model.setViewName("redirect:/memberResetPasswordFail");
		return model;
	}
}
