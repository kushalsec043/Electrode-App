package com.shopping.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.Dao.ProductJpaRepository;
import com.shopping.Dao.UserJpaRepository;
import com.shopping.entity.Product;
import com.shopping.entity.User;

@Controller
public class HomeController 
{
	@Autowired
	UserJpaRepository repo;
	
	@Autowired
	User user;
	
	@Autowired
	ProductJpaRepository productrepo;
	
	@Autowired
	List<Product> pro;
	
	@RequestMapping(value = "/products", method=RequestMethod.GET)
	public String products()
	{   
		return "products";
	}
	
	@RequestMapping(value = "/profile", method=RequestMethod.GET)
	public String profile(HttpSession session)
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
	
}
