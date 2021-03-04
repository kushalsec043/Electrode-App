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
import com.shopping.authentication.AdminService;
import com.shopping.authentication.LoginService;
import com.shopping.entity.Orders;
import com.shopping.entity.Product;
import com.shopping.entity.User;
import com.shopping.service.OrderRepository;
import com.shopping.service.ProductRepository;
import com.shopping.service.UserRepository;

@Controller
public class LoginController
{
	@Autowired
	LoginService service;
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	ProductRepository productrepo;
	
	@Autowired
	OrderRepository orderrepo;
	
	@Autowired
	AdminService admin;
	
	@Autowired
	Set<Product> pro;
	
	@Autowired
	User user;
	
	@RequestMapping(value = "/")
	public ModelAndView welcomepage(ModelMap model)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");
		
		return mv;
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String LoginPage(ModelMap model)
	{
		model.put("errorMessage", "Login if your a member / Else Sign Up");
		return "login";
	}
	
	@RequestMapping(value = "/signup", method=RequestMethod.GET)
	public String SignUpPage()
	{
		return "signup";
	}
	
	@RequestMapping(value = "/signedup", method=RequestMethod.POST)
	public String SignedUp(@RequestParam String aname,@RequestParam String psw,@RequestParam String email,@RequestParam String address,@RequestParam String contact, User user, ModelMap model) throws ClassNotFoundException, SQLException
	{
		// Insert Data to database
		user.setAname(aname);
		user.setPsw(psw);
		user.setEmail(email);
		
		if(address == null)
		{
			user.setAddress("");
		}
		else
		{
			user.setAddress(address);
		}
		
		if(contact == null)
		{
			user.setContact("");
		}
		else
		{
			user.setContact(contact);
		}
		
		service.adduser(user);
		model.put("errorMessage","You're Signed In!! Login Now");
		return "login";
	}
	
	@RequestMapping(value = "/homepage", method=RequestMethod.POST)
	public String handleloginrequest(
			@RequestParam String aname,
			@RequestParam String psw, 
			ModelMap model, HttpSession session) throws ClassNotFoundException, SQLException
	{
		if(service.validateUser(aname, psw))
		{
		model.put("aname", aname);
		model.put("psw", psw);
		
		session.setAttribute("username", aname);
		
		// Resolve it to view using viewresolver....
		pro = productrepo.findAll();
		session.setAttribute("product", pro);
		session.setAttribute("alreadyadded","");
		return "homepage";
		}
		else
		{
			model.put("errorMessage","Invalid Credentials / Sign Up if not a member");
			return "login";
		}
		
	}
	
	@RequestMapping(value = "/admin", method=RequestMethod.GET)
	public String adminpage(ModelMap model)
	{
		model.put("adminmessage", "Need Authorization to customize homepage!!!");
		return "adminpage";
	}
	
	@RequestMapping(value = "/admintoproduct", method=RequestMethod.POST)
	public String adminpagetoproducts(@RequestParam String adname,
		@RequestParam String adpass, 
		ModelMap model, HttpSession session) throws ClassNotFoundException, SQLException
	{
	if(admin.validate(adname, adpass))
	{
	return "products";
	}
	else
	{
		model.put("adminmessage","Invalid Credentials / Get a Valid Admin UserName & PassWord");
		return "adminpage";
	}
	}
	
	@RequestMapping(value = "/admintoorders", method=RequestMethod.GET)
	public String admintoorders(HttpSession session) throws ClassNotFoundException, SQLException
	{
		Set<User> users = userrepo.get_allusers();
		session.setAttribute("users", users);
		
		return "Allordersinfo";
	}
	
	@RequestMapping(value = "/productspage", method=RequestMethod.GET)
	public String orderstoproducts()
	{
		return "products";
	}
	
	@RequestMapping(value = "/homepage", method=RequestMethod.GET)
	public String homepage(HttpSession session, ModelMap model) throws ClassNotFoundException, SQLException
	{
		// Resolve it to view using viewresolver....
		model.put("getid", "");
		
		pro = productrepo.findAll();
		session.setAttribute("product", pro);
		session.setAttribute("alreadyadded","");
		return "homepage";
	}
	
	@RequestMapping(value = "/homepagegetid", method=RequestMethod.GET)
	public String homepagegetid(HttpSession session, ModelMap model) throws ClassNotFoundException, SQLException
	{
		// Resolve it to view using viewresolver....
		model.put("getid", "ID on top of the product!!! Please Refer.");
		
		pro = productrepo.findAll();
		session.setAttribute("product", pro);
		return "homepage";
	}
	
	
}
