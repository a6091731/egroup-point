package com.epoint.webapp.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.epoint.webapp.dao.ProductDAO;
import com.epoint.webapp.dao.ProductSalesDAO;
import com.epoint.webapp.entity.Member;
import com.epoint.webapp.entity.Product;
import com.epoint.webapp.entity.ProductSales;
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
			System.out.println("memberLogin"+memberLogin.getCapitalDate());
			model.addObject("page", pageCount);
			model.addObject("getProductList1",getProductList);
			model.addObject("getProductList2", new Gson().toJson(getProductList));
		}
		
		return model;
	}	
	
	@RequestMapping(value = "/addProductSalseRevenueStructure", method = RequestMethod.POST)
	public ModelAndView addProductSalseRevenueStructure (HttpServletRequest request, HttpSession session) throws ParseException{
		String  monthDate[] = new String[13];
		int monthQuantity[] = new int[13];
		int getMonth;
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");		
		if(memberLogin!=null){			
			model.setViewName("redirect:/revenueStructure");
			ProductSalesDAO productSalesDAO = (ProductSalesDAO)context.getBean("productSalesDAO");
			String[] dateList = request.getParameterValues("salsDate");
			String[] quantityList = request.getParameterValues("salsQuantity");
			ProductSales productSales = new ProductSales();
			productSales.setAccount(memberLogin.getAccount());
			productSales.setId(request.getParameter("productID"));
			productSalesDAO.delProductSalesByMember(productSales);			
			for(int i = 0 ; i<dateList.length ; i++){	
				if(dateList[i]!="" && quantityList[i]!=""){					
					getMonth = Integer.parseInt(dateList[i].substring(5,7));
					monthDate[getMonth] = dateList[i];
					monthQuantity[getMonth] = monthQuantity[getMonth]+Integer.parseInt(quantityList[i]);					
				}
			}	
			
			for(int j = 0;j<monthDate.length;j++){
				if(monthDate[j]!=null && monthQuantity[j]!=0){
					productSales.setDate_string(monthDate[j]+"-01");
					productSales.setQuantity(monthQuantity[j]);			
					productSalesDAO.insertProductSales(productSales);
				}
			}
		}
		else
			model.setViewName("memberLogin");
		return model;
	}
	
	@RequestMapping(value = "/getProductSalesListByMemberID", method = RequestMethod.GET)
	public @ResponseBody List<ProductSales> getProductSalesListByMemberID (String  productID, HttpSession session) throws ParseException{
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");		
		if(memberLogin!=null){			
			model.setViewName("redirect:/revenueStructure");
			ProductSalesDAO productSalesDAO = (ProductSalesDAO)context.getBean("productSalesDAO");
			ProductSales productSales = new ProductSales();
			productSales.setAccount(memberLogin.getAccount());
			productSales.setId(productID);
			List<ProductSales> getProductSalesListByMemberID = productSalesDAO.getProductSalesListByMemberID(productSales);
			
			return getProductSalesListByMemberID;				
		}
		return null;	
	}
	
	@RequestMapping(value = "/addProductRevenueStructure", method = RequestMethod.POST)
	public ModelAndView addProductRevenueStructure (Product product, HttpServletRequest request, HttpSession session){
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");		
		if(memberLogin!=null){				
			
			product.setAccount(memberLogin.getAccount());
			ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
			productDAO.insetProduct(product);		
			int countProduct = productDAO.countProductByMember(memberLogin);
			int endPage =  countProduct%10==0 ? countProduct/10 : countProduct/10+1;
			System.out.println("countProduct"+countProduct);
			System.out.println("endPage"+endPage);
			model.setViewName("redirect:/revenueStructure?p="+endPage);
		}
		else
			model.setViewName("redirect:/");
		return model;
	}
	
	@RequestMapping(value = "/editProductRevenueStructure", method = RequestMethod.POST)
	public ModelAndView editProductRevenueStructure (Product product, HttpServletRequest request, HttpSession session){
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");		
		if(memberLogin!=null){				
			model.setViewName("redirect:/revenueStructure");
			product.setAccount(memberLogin.getAccount());
			ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
			productDAO.updateProduct(product);		
		}
		else
			model.setViewName("redirect:/");
		return model;
	}		
	
	@RequestMapping(value = "/delProductRevenueStructure", method = RequestMethod.GET)
	public @ResponseBody void delProductRevenueStructure (String  productID, HttpSession session) throws ParseException{
		ModelAndView model = new ModelAndView();
		Member memberLogin = (Member)session.getAttribute("loginMember");		
		if(memberLogin!=null){			
			ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
			Product product = new Product();
			product.setAccount(memberLogin.getAccount());
			product.setId(productID);
			productDAO.delProduct(product);		
			int countProduct = productDAO.countProductByMember(memberLogin);
			int endPage =  countProduct%10==0 ? countProduct/10 : countProduct/10+1;
			System.out.println("countProduct"+countProduct);
			System.out.println("endPage"+endPage);
			model.setViewName("redirect:/revenueStructure?p="+endPage);
		}
	}
}
