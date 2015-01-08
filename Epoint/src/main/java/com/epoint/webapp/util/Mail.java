package com.epoint.webapp.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;



import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;


public class Mail {
	private static final Logger log = Logger.getLogger(Mail.class.getName());
	private String Senduser = "epoint.egroup@gmail.com";
	private String Senduserpwd = "egroup23622508";
	private String HostName = "smtp.gmail.com";
	private String SSLSmtpPort = "587";
	public void sendMail(String subject,String recipient,String message){
		System.out.println("*****email0");
		try {
			HtmlEmail email = new HtmlEmail();
			email.setHostName(HostName);
			email.setSmtpPort(587);
			email.setAuthenticator(new DefaultAuthenticator(Senduser, Senduserpwd));
			//email.setDebug(true);
			email.setSSLOnConnect(true);
			email.setCharset("UTF-8");
			email.setSubject(subject);
		    email.setFrom(Senduser, "創業e點通");
		    email.setHtmlMsg(message);
		    email.addTo(recipient, "收件者");
		    email.send();
		} catch (EmailException e) {
		    e.printStackTrace();
		}	
	}
	/*public void sendMailForRecipients(String subject,String recipient[],String message){

		try {
			HtmlEmail email = new HtmlEmail();
			email.setHostName(HostName);
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator(Senduser, Senduserpwd));
			email.setDebug(true);
			email.getMailSession().getProperties().put("mail.smtps.auth", "true");
			email.getMailSession().getProperties().put("mail.debug", "true");
			email.getMailSession().getProperties().put("mail.smtps.port", SSLSmtpPort);
			email.getMailSession().getProperties().put("mail.smtps.socketFactory.port", SSLSmtpPort);
			email.getMailSession().getProperties().put("mail.smtps.socketFactory.class",   "javax.net.ssl.SSLSocketFactory");
			email.getMailSession().getProperties().put("mail.smtps.socketFactory.fallback", "false");
			email.getMailSession().getProperties().put("mail.smtp.starttls.enable", "true");
			email.setCharset("UTF-8");
			email.setSubject(subject);
		    email.setFrom(Senduser, "馴錢師財商研究中心");
		    email.setHtmlMsg(message);
		    for(int i=0; i<recipient.length; i++){
		    	email.addTo(recipient[i], "收件者");
		    }
		    email.send();
		} catch (EmailException e) {
		    e.printStackTrace();
		}	
	}

	public void sendMailHtml(String subject,String recipient,String message){

		try {
			HtmlEmail email = new HtmlEmail();
			email.setHostName(HostName);
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator(Senduser, Senduserpwd));
			email.setDebug(true);
			email.getMailSession().getProperties().put("mail.smtps.auth", "true");
			email.getMailSession().getProperties().put("mail.debug", "true");
			email.getMailSession().getProperties().put("mail.smtps.port", SSLSmtpPort);
			email.getMailSession().getProperties().put("mail.smtps.socketFactory.port", SSLSmtpPort);
			email.getMailSession().getProperties().put("mail.smtps.socketFactory.class",   "javax.net.ssl.SSLSocketFactory");
			email.getMailSession().getProperties().put("mail.smtps.socketFactory.fallback", "false");
			email.getMailSession().getProperties().put("mail.smtp.starttls.enable", "true");
			email.setCharset("UTF-8");
			email.setSubject(subject);
		    email.setFrom(Senduser, "馴錢師財商研究中心");
		    email.setContent(message, "text/html; charset=utf-8");
		    email.addTo(recipient, "收件者");
		    email.send();
		} catch (EmailException e) {
		    e.printStackTrace();
		}	
	}

	public String htmlToString (String FilePath) throws FileNotFoundException{
		String data="";
		String result="";
		FileInputStream ins = new FileInputStream(FilePath);
		try {
			if (ins == null) {} else {
				BufferedReader br = new BufferedReader(
					    new InputStreamReader(new FileInputStream(FilePath), "UTF-8"));
				while ((data = br.readLine()) != null) {
					result+=data;
					System.out.println(data);
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("html msg:"+result);
		return result;
	}*/
}
