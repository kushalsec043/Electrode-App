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

import com.shopping.Dao.OrdersJpaRepository;
import com.shopping.Dao.ProductJpaRepository;
import com.shopping.Dao.UserJpaRepository;
import com.shopping.authentication.DeleteService;
import com.shopping.entity.Orders;
import com.shopping.entity.Product;
import com.shopping.entity.User;

@Controller
public class View_CartController 
{
	@Autowired
	DeleteService del;
	
	@Autowired
	ProductJpaRepository repo;
	
	@Autowired
	User user;
	
	@Autowired
	UserJpaRepository userrepo;
	
	@Autowired
	OrdersJpaRepository orderrepo;
	
	@Autowired
	Product pro;
	
	@Autowired
	Orders ord;
	
	@Autowired
	Set<Product> product;
	
	@Autowired
	Set<Orders> order;
	
	@RequestMapping({"/viewproduct"})
	public String viewproduct(HttpSession session,  @RequestParam(value = "code", defaultValue = "") Integer code)
	{
		  if (code != null && code > 0) 
		  {
	            pro = repo.findById(code).orElse(null);
	            
	            if (pro != null) 
		        {
	            	session.setAttribute("viewproduct", pro);
		        }
	      }
		  return "viewproduct";
	}
		
		@RequestMapping(value = "/yourcart", method=RequestMethod.GET)
		public String addtoyourcart(ModelMap model, HttpSession session)
		{
			String present_user = session.getAttribute("username").toString();
			if(present_user == null)
			{
				return "welcome";
			}
			
			user = userrepo.findByaname(present_user);
				
				product = (Set<Product>) user.getCart();
				
				if(!product.isEmpty())
				{
				session.setAttribute("shpcart", product);
				return "yourcart";
				}
				else
				{
			    session.setAttribute("shpcart", product);
				model.put("noitems", "No items in your cart at the moment!! Check your orders...");
				return "yourcart";
				}
		}
		
		@RequestMapping(value = "/addtocartrepo", method=RequestMethod.GET)
		public String yourcart(@RequestParam(value = "code", defaultValue = "") Integer code, ModelMap model, HttpSession session)
		{
			String present_user = session.getAttribute("username").toString();
			
			if(present_user == null)
			{
				return "welcome";
			}
			
			user = userrepo.findByaname(present_user);
			
			pro = repo.findById(code).orElse(null);
			
				user.getCart().add(pro);
				userrepo.save(user);
				
				product = (Set<Product>) user.getCart();
				session.setAttribute("shpcart", product);
				return "yourcart";
		}
		
		@RequestMapping(value = "/orderspage", method=RequestMethod.GET)
		public String orderslist(HttpSession session, ModelMap model)
		{
			String present_user = session.getAttribute("username").toString();
			
			if(present_user == null)
			{
				return "welcome";
			}
			
			user = userrepo.findByaname(present_user);
			
			order = user.getOrder();
			
			if(!order.isEmpty())
			{
				model.addAttribute("orders", order);
				return "orders";
			}
			else
			{
				model.put("emptyorder", "You have no orders placed!!!");
				return "orders";
			}
		}
		
		@RequestMapping(value = "/removecartrepo", method=RequestMethod.GET)
		public String removeitemfromcart(@RequestParam(value = "code", defaultValue = "") Integer code, HttpSession session, ModelMap model) throws ClassNotFoundException, SQLException
		{
			
			String present_user = session.getAttribute("username").toString();
			
			if(present_user == null)
			{
				return "welcome";
			}
			
			user = userrepo.findByaname(present_user);
			
			pro = repo.findById(code).orElse(null);
			
			boolean result = del.delete_user_product(user.getAid(), pro.getPid());
			
			product = (Set<Product>) user.getCart();
			if(!product.isEmpty())
			{
			session.setAttribute("shpcart", product);
			return "yourcart";
			}
			else
			{
		    session.setAttribute("shpcart", product);
			model.put("noitems", "No items in your cart at the moment!! Check your orders...");
			return "yourcart";
			}
		}
		
		@RequestMapping(value = "/cartcheckout", method=RequestMethod.GET)
		public String cartcheckout(@RequestParam(value = "code", defaultValue = "") Integer code, HttpSession session, ModelMap model) throws ClassNotFoundException, SQLException
		{
			String present_user = session.getAttribute("username").toString();
			
			if(present_user == null)
			{
				return "welcome";
			}
			
			user = userrepo.findByaname(present_user);
			
			pro = repo.findById(code).orElse(null);
			
			ord.setOrderid(pro.getPid());
			ord.setOrderimage(pro.getPimage());
			ord.setOrdername(pro.getPname());
			ord.setOrderprice(pro.getPprice());
			
			orderrepo.save(ord);
			user.getOrder().add(ord);
			userrepo.save(user);
			
			order = (Set<Orders>) user.getOrder();
			model.addAttribute("orders", order);
			
			boolean result = del.delete_user_product(user.getAid(), pro.getPid());
			
			product = (Set<Product>) user.getCart();
			
			if(!product.isEmpty())
			{
			session.setAttribute("shpcart", product);
			return "yourcart";
			}
			else
			{
		    session.setAttribute("shpcart", product);
			model.put("noitems", "Check your orders for now!!!");
			return "yourcart";
			}
				
			}
		
		@RequestMapping(value = "/myorders", method=RequestMethod.GET)
		public String myorders(HttpSession session, ModelMap model)
		{
			String present_user = session.getAttribute("username").toString();
			
			if(present_user == null)
			{
				return "welcome";
			}
			
			user = userrepo.findByaname(present_user);
			
			order = user.getOrder();
			
			if(!order.isEmpty())
			{
				model.addAttribute("orders", order);
				return "orders";
			}
			else
			{
				model.put("emptyorder", "You have no orders placed!!!");
				return "orders";
			}
			
		}
		
		@RequestMapping(value = "/vieworder", method=RequestMethod.GET)
		public String vieworder(@RequestParam(value = "code", defaultValue = "") Integer code, HttpSession session, ModelMap model)
		{
			  if (code != null && code > 0) 
			  {
		            pro = repo.findById(code).orElse(null);
		            
		            if (pro != null) 
			        {
		            	session.setAttribute("viewproduct", pro);
			        }
		      }
			  return "vieworderdetails";
		}
		
		@RequestMapping(value = "/cancelorder", method=RequestMethod.GET)
		public String cancelorder(@RequestParam(value = "code", defaultValue = "") Integer code, HttpSession session, ModelMap model)
		{
			String present_user = session.getAttribute("username").toString();
			
			if(present_user == null)
			{
				return "welcome";
			}
			
			user = userrepo.findByaname(present_user);
			
			order = user.getOrder();
			
			if(order.isEmpty())
			{
				model.put("emptyorder", "You have no orders right now!!!");
				return "orders";
			}
			else
			  {
				   ord = orderrepo.findById(code).orElse(null);
				   
		           user.getOrder().remove(ord);
		           userrepo.save(user);
		           
		           order = user.getOrder();
		           model.addAttribute("orders", order);
		           
		           if(order.isEmpty())
		           {
		        	   model.put("emptyorder", "You have no orders right now!!!");
		           }
		           return "orders";
		      }
		}
		}
