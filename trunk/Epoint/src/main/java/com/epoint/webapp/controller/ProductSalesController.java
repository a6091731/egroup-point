package com.epoint.webapp.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epoint.webapp.dao.ProductDAO;
import com.epoint.webapp.dao.ProductSalesDAO;
import com.epoint.webapp.dao.VentureChecklistDAO;
import com.epoint.webapp.entity.MapClass;
import com.epoint.webapp.entity.MapSubclass;
import com.epoint.webapp.entity.Member;
import com.epoint.webapp.entity.Product;
import com.epoint.webapp.entity.ProductSales;
import com.epoint.webapp.util.DateConversion;
import com.epoint.webapp.util.PageCount;
import com.google.gson.Gson;

@Controller
public class ProductSalesController {
	
	ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");

	@RequestMapping(value = "/revenueStructure", method = RequestMethod.GET)
	public ModelAndView revenueStructure (HttpServletRequest request, HttpSession session){
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");
		if(memberLogin==null)
			model.setViewName("memberLogin");
		else{
			model.setViewName("revenueStructure");
			
			/*MapClass mapClass = new MapClass();
			mapClass.setId(1);
			mapClass.setAccount(memberLogin.getAccount());
			List<MapClass> getVentureCheckMenuList = ventureChecklistDAO.getMapClassList(mapClass);
			
			memberLogin.setClassID(15);
			List<MapSubclass> getVentureCheckListByMember= ventureChecklistDAO.getVentureCheckListByMember(memberLogin);
						*/
			//get data from request
			int pageNow = request.getParameter("p")==null?1:Integer.parseInt(request.getParameter("p"));
			
			//set pager
			int pageSize = 10;
			ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
			int count = productDAO.countProductByMember(memberLogin);
			String pageUrl = "revenueStructure";
			PageCount pageCount = new PageCount(pageNow, pageSize, count, pageUrl);
			pageCount.calculate();
			
			//getProduct			
			List<Product> getProductList = productDAO.getProductListSum(memberLogin,pageCount.getStart(), pageSize);
			/*ProductSalesDAO productSalesDAO = (ProductSalesDAO)context.getBean("productSalesDAO");
			productSalesDAO.productSalseCountByMember()*/
			
			model.addObject("page", pageCount);
			model.addObject("getProductList1",getProductList);
			model.addObject("getProductList2", new Gson().toJson(getProductList));
		}
		
		return model;
	}	
	
	@RequestMapping(value = "/addProductSalse", method = RequestMethod.POST)
	public ModelAndView addProductSalse (HttpServletRequest request, HttpSession session){
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");		
		if(memberLogin!=null){			
			model.setViewName("redirect:/revenueStructure");
			ProductSalesDAO productSalesDAO = (ProductSalesDAO)context.getBean("productSalesDAO");
			String id[] = request.getParameterValues("salsDate");
			String[] dateList = request.getParameterValues("salsDate");
			String[] quantityList = request.getParameterValues("salsQuantity");
			ProductSales productSales = new ProductSales();
			productSales.setAccount(memberLogin.getAccount());
			for(int i = 0 ; i<dateList.length ; i++){
				productSalesDAO.insertProductSales(productSales);
				productSales.setDateString(dateList[i]);
				productSales.setQuantity(Integer.parseInt(quantityList[i]));
			}
		}
		else
			model.setViewName("memberLogin");
		return model;
	}
	
}
