package com.shopping.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.entity.Orders;
import com.shopping.entity.Product;
import com.shopping.entity.User;
import com.shopping.service.OrderRepository;
import com.shopping.service.ProductRepository;
import com.shopping.service.UserRepository;

@Controller
public class HomeController 
{
	@Autowired
	UserRepository repo;
	
	@Autowired
	User user;
	
	@Autowired
	ProductRepository productrepo;
	
	@Autowired
	OrderRepository orderrepo;
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	List<Product> pro;
	
	@RequestMapping(value = "/products", method=RequestMethod.GET)
	public String products()
	{   
		return "products";
	}
	
	@RequestMapping(value = "/profile", method=RequestMethod.GET)
	public String profile(HttpSession session) throws ClassNotFoundException, SQLException
	{
		String name = session.getAttribute("username").toString();
		
		if(name == null)
		{
			return "welcome";
		}
		
		user = repo.findByaname(name);
		
		session.setAttribute("user", user);
		
		return "profile";
	}
	
	@RequestMapping(value = "/help", method=RequestMethod.GET)
	public String help()
	{
		return "help";
	}
	
	@RequestMapping(value = "/about", method=RequestMethod.GET)
	public String about()
	{
		return "about";
	}
	
	@RequestMapping(value = "/logout", method=RequestMethod.GET)
	public String logout(ModelMap model, HttpSession session)
	{
		session.removeAttribute("username");
		session.invalidate();
		
		model.clear();
		model.put("errorMessage","Login Now to view recent activity");
		return "login";
	}
	
	@RequestMapping({"/viewuserorders"})
	public String viewuserinfo(HttpSession session,  @RequestParam(value = "code", defaultValue = "") Integer code) throws ClassNotFoundException, SQLException
	{
		Set<Orders> orders = orderrepo.get_allordersof_a_user(code);
		
		if(orders.isEmpty())
		{
			session.removeAttribute("orders");
			session.setAttribute("noorders", "->>> No Orders!!!");
		}
		else
		{
			session.removeAttribute("noorders");
			session.setAttribute("orders", orders);
		}
		
	    user = userrepo.findBycode(code);
		session.setAttribute("user", user);
		return "singleuserorders";
	}
	
	@RequestMapping({"/viewproductinfo"})
	public String viewproductinfo(HttpSession session,  @RequestParam(value = "code", defaultValue = "") String code) throws ClassNotFoundException, SQLException
	{
		return "productinfopage";
	}
	
}
