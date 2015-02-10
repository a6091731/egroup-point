package com.epoint.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epoint.webapp.dao.ProductDAO;
import com.epoint.webapp.dao.VentureChecklistDAO;
import com.epoint.webapp.entity.MapClass;
import com.epoint.webapp.entity.MapSubclass;
import com.epoint.webapp.entity.Member;
import com.epoint.webapp.entity.Product;
import com.epoint.webapp.util.PageCount;
import com.google.gson.Gson;

@Controller
public class ProductController {
	ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");

	@RequestMapping(value = "/showAllProductDescribe", method = RequestMethod.GET)
	public ModelAndView showAllProductDescribe (HttpServletRequest request, HttpSession session){
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");
		if(memberLogin==null)
			model.setViewName("memberLogin");
		else{
			model.setViewName("showAllProductDescribe");
			VentureChecklistDAO ventureChecklistDAO = (VentureChecklistDAO)context.getBean("ventureChecklistDAO");
			MapClass mapClass = new MapClass();
			mapClass.setId(1);
			mapClass.setAccount(memberLogin.getAccount());
			List<MapClass> getVentureCheckMenuList = ventureChecklistDAO.getMapClassList(mapClass);
			
			memberLogin.setClassID(15);
			List<MapSubclass> getVentureCheckListByMember= ventureChecklistDAO.getVentureCheckListByMember(memberLogin);
						
			//get data from request
			int pageNow = request.getParameter("p")==null?1:Integer.parseInt(request.getParameter("p"));
			
			//set pager
			int pageSize = 10;
			ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
			int count = productDAO.countProductByMember(memberLogin);
			String pageUrl = "showAllProductDescribe";
			PageCount pageCount = new PageCount(pageNow, pageSize, count, pageUrl);
			pageCount.calculate();
			
			//getProduct
			List<Product> getProductList = new ArrayList<Product>();
			getProductList = productDAO.getProductList(memberLogin,pageCount.getStart(), pageSize);	
			
			model.addObject("page", pageCount);
			model.addObject("getVentureCheckMenuList",getVentureCheckMenuList);
			model.addObject("getVentureCheckListByMember", getVentureCheckListByMember);
			model.addObject("getVentureCheckMenuListNow",getVentureCheckMenuList.get(0).getNow());
			model.addObject("getProductList1",getProductList);
			model.addObject("getProductList2", new Gson().toJson(getProductList));
		}
		
		return model;
	}	
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public ModelAndView addProduct (Product product, HttpServletRequest request, HttpSession session){
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");		
		if(memberLogin!=null){				
			model.setViewName("redirect:/showAllProductDescribe");
			product.setAccount(memberLogin.getAccount());
			ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
			productDAO.insetProduct(product);		
		}
		else
			model.setViewName("redirect:/");
		return model;
	}
	
	@RequestMapping(value = "/editProduct", method = RequestMethod.POST)
	public ModelAndView editProduct (Product product, HttpServletRequest request, HttpSession session){
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");		
		if(memberLogin!=null){				
			model.setViewName("redirect:/showAllProductDescribe");
			product.setAccount(memberLogin.getAccount());
			ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
			productDAO.updateProduct(product);		
		}
		else
			model.setViewName("redirect:/");
		return model;
	}
}
