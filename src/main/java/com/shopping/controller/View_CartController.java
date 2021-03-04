package com.shopping.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import com.shopping.authentication.DeleteService;
import com.shopping.entity.CardInfo;
import com.shopping.entity.Orders;
import com.shopping.entity.Product;
import com.shopping.entity.User;
import com.shopping.service.OrderRepository;
import com.shopping.service.ProductRepository;
import com.shopping.service.UserRepository;

@Controller
public class View_CartController 
{
	@Autowired
	DeleteService del;
	
	@Autowired
	ProductRepository repo;
	
	@Autowired
	User user;
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	OrderRepository orderrepo;
	
	@Autowired
	Product pro;
	
	@Autowired
	Orders ord;
	
	@Autowired
	Set<Product> product;
	
	@Autowired
	Set<Orders> order;
	
	@Autowired
	CardInfo card;
	
	@Autowired
	DeleteService service;
	
	@RequestMapping({"/viewproduct"})
	public String viewproduct(HttpSession session,  @RequestParam(value = "code", defaultValue = "") Integer code) throws ClassNotFoundException, SQLException
	{
		  if (code != null && code > 0) 
		  {
	            pro = repo.findById(code);
	            
	            if (pro != null) 
		        {
	            	session.setAttribute("viewproduct", pro);
		        }
	      }
		  return "viewproduct";
	}
		
		@RequestMapping(value = "/yourcart", method=RequestMethod.GET)
		public String addtoyourcart(ModelMap model, HttpSession session) throws ClassNotFoundException, SQLException
		{
			String present_user = session.getAttribute("username").toString();
			if(present_user == null)
			{
				return "welcome";
			}
			
			    user = userrepo.findByaname(present_user);
				
				product = (Set<Product>) userrepo.getCart(user.getAid());
				
				if(!product.isEmpty())
				{
				session.setAttribute("shpcart", product);
				session.setAttribute("yourcart", "");
				return "yourcart";
				}
				else
				{
			    session.setAttribute("shpcart", product);
				model.put("noitems", "No items in your cart at the moment!! Check your orders...");
				session.setAttribute("yourcart", "");
				return "yourcart";
				}
		}
		
		@RequestMapping(value = "/addtocartrepo", method=RequestMethod.POST)
		public String yourcart(@RequestParam int quantity, @RequestParam int code, ModelMap model, HttpSession session) throws ClassNotFoundException, SQLException
		{
			String present_user = session.getAttribute("username").toString();
			
			if(present_user == null)
			{
				return "welcome";
			}
			
			System.out.println("quantity");
			
			user = userrepo.findByaname(present_user);
			pro = repo.findById(code);
					
			//userrepo.getCart().add(pro);
			//userrepo.saveuser(user);
			
			product = (Set<Product>) userrepo.getCart(user.getAid());
			
			if(!product.contains(pro))
			{
				
			//Price calculation as per quantity
			double price = pro.getPprice() * quantity;
				
			repo.add_tocart(user.getAid(), pro.getPid(), quantity, price);
			product = (Set<Product>) userrepo.getCart(user.getAid());
			session.setAttribute("shpcart", product);
			session.setAttribute("alreadyadded", "You have added <__" + pro.getPname() + "__> !! < Check your CART > !!");
			return "yourcart";
			}
			else
			{
			session.setAttribute("alreadyadded", "You have already added this item to your Cart!!!");
			return "homepage";
			}
		}
		
		@RequestMapping(value = "/orderspage", method=RequestMethod.GET)
		public String orderslist(HttpSession session, ModelMap model) throws ClassNotFoundException, SQLException
		{
			String present_user = session.getAttribute("username").toString();
			
			if(present_user == null)
			{
				return "welcome";
			}
			
			user = userrepo.findByaname(present_user);
			
			order = orderrepo.getOrderby_userid(user.getAid());
			
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
			
			pro = (Product) repo.findById(code);
			
			boolean result = del.delete_user_product(user.getAid(), pro.getPid());
			
			product = (Set<Product>) userrepo.getCart(user.getAid());
			if(!product.isEmpty())
			{
			session.setAttribute("shpcart", product);
			session.setAttribute("yourcart", "You removed <__" + pro.getPname() + "__> from your cart!!!");
			return "yourcart";
			}
			else
			{
		    session.setAttribute("shpcart", product);
			model.put("noitems", "No items in your cart at the moment!! Check your orders...");
			return "yourcart";
			}
		}
		
		@RequestMapping(value = "/confimationpage", method=RequestMethod.GET)
		public String confirmation_page(@RequestParam(value = "code", defaultValue = "") Integer code, HttpSession session, ModelMap model) throws ClassNotFoundException, SQLException
		{   
			if (code != null && code > 0) 
			  {
		            pro = (Product) repo.findById(code);
		            session.setAttribute("universal_code", code);
		            
		            if (pro != null) 
			        {
		            	session.setAttribute("cartproduct", pro);
		            	
		            	String present_user = session.getAttribute("username").toString();
		    			user = userrepo.findByaname(present_user);
		    			
		    			int quantity = orderrepo.getcart_quantity(user.getAid(), pro.getPid());
		    			session.setAttribute("cart_quantity", quantity);
		    			
		    			session.setAttribute("cart_price", pro.getPprice()*quantity);
			        }
		      }
			return "viewcartdetails";
		}
		
		@RequestMapping(value = "/cardinfopage", method=RequestMethod.GET)
		public String cardinfo(HttpSession session) throws ClassNotFoundException, SQLException
		{   
			String present_user = session.getAttribute("username").toString();
			user = userrepo.findByaname(present_user);
			
			card = userrepo.findcard_byid(user.getAid());
						
			session.setAttribute("usercard", card);
			
			session.setAttribute("presentuser", user);

			return "cardinfo";
		}
		
		
		
		@RequestMapping(value = "/updatecardinfo", method=RequestMethod.POST)
		public String card_to_orderspage(@RequestParam String aname,@RequestParam String email,@RequestParam String address,@RequestParam String contact,
				@RequestParam String cardname,@RequestParam String cardno,@RequestParam String expirn,@RequestParam int cvv,HttpSession session, ModelMap model) throws ClassNotFoundException, SQLException
		{   
			String present_user = session.getAttribute("username").toString();
			user = userrepo.findByaname(present_user);

			userrepo.update_userinfo(user.getAid(), aname, email, address, contact);
			
			user = userrepo.findByaname(aname);
			session.setAttribute("username", aname);
			
			card = userrepo.findcard_byid(user.getAid());
			
			if(card.getCard_no() == null)
			{
			userrepo.addcardinfo(user.getAid(), cardname, cardno, expirn, cvv);
			}
			else if(card.getNameon() != cardname || card.getCard_no() != cardno || card.getExpirn() != expirn || card.getCvv() != cvv)
			{
			userrepo.updatecardinfo(user.getAid(), cardname, cardno, expirn, cvv);
			}
			
			int code = (int) session.getAttribute("universal_code");
						
			if(present_user == null)
			{
				return "welcome";
			}
			
			present_user = session.getAttribute("username").toString();
			user = userrepo.findByaname(present_user);
			
			pro = (Product) repo.findById(code);
			
			ord.setOrderid(pro.getPid());
			ord.setOrderimage(pro.getPimage());
			ord.setOrdername(pro.getPname());
			ord.setOrderprice(pro.getPprice());
			
			orderrepo.add_toorder(ord, user.getAid());
			
			int quantity = orderrepo.getorder_quantity(user.getAid(), ord.getOrderid());
			double price = quantity * ord.getOrderprice();
			session.setAttribute("order", ord);
			session.setAttribute("ord_quantity", quantity);
			session.setAttribute("order_price", price);
			
			//userrepo.getOrder().add(ord);
			//userrepo.saveuser(user);
			
			order = (Set<Orders>) orderrepo.getOrderby_userid(user.getAid());
			model.addAttribute("orders", order);
			
			boolean result = del.delete_user_product(user.getAid(), pro.getPid());
			
			product = (Set<Product>) userrepo.getCart(user.getAid());
			
			if(!product.isEmpty())
			{
			session.setAttribute("shpcart", product);
			return "orderplaced";
			}
			else
			{
		    session.setAttribute("shpcart", product);
			model.put("noitems", "Check your orders for now!!!");
			return "orderplaced";
			}
		}
		
		@RequestMapping(value = "/cartcheckout", method=RequestMethod.GET)
		public String cartcheckout(int code, HttpSession session, ModelMap model) throws ClassNotFoundException, SQLException
		{
			String present_user = session.getAttribute("username").toString();
			
			if(present_user == null)
			{
				return "welcome";
			}
			
			user = userrepo.findByaname(present_user);
			
			pro = (Product) repo.findById(code);
			
			ord.setOrderid(pro.getPid());
			ord.setOrderimage(pro.getPimage());
			ord.setOrdername(pro.getPname());
			ord.setOrderprice(pro.getPprice());
			
			orderrepo.add_toorder(ord, user.getAid());
			
			//userrepo.getOrder().add(ord);
			//userrepo.saveuser(user);
			
			order = (Set<Orders>) orderrepo.getOrderby_userid(user.getAid());
			model.addAttribute("orders", order);
			
			boolean result = del.delete_user_product(user.getAid(), pro.getPid());
			
			product = (Set<Product>) userrepo.getCart(user.getAid());
			
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
		public String myorders(HttpSession session, ModelMap model) throws ClassNotFoundException, SQLException
		{
			String present_user = session.getAttribute("username").toString();
			
			if(present_user == null)
			{
				return "welcome";
			}
			
			user = userrepo.findByaname(present_user);
			
			order = orderrepo.getOrderby_userid(user.getAid());
			
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
		public String vieworder(@RequestParam(value = "code", defaultValue = "") Integer code, HttpSession session, ModelMap model) throws ClassNotFoundException, SQLException
		{
			  if (code != null && code > 0) 
			  {
		            pro = (Product) repo.findById(code);
		            
		            if (pro != null) 
			        {
		            	session.setAttribute("viewproduct", pro);
		            	
		            	String present_user = session.getAttribute("username").toString();
		    			user = userrepo.findByaname(present_user);
		    			
		    			int quantity = orderrepo.getorder_quantity(user.getAid(), pro.getPid());
		    			session.setAttribute("order_quantity", quantity);
		    			
		    			session.setAttribute("order_price", pro.getPprice()*quantity);
			        }
		      }
			  return "vieworderdetails";
		}
		
		@RequestMapping(value = "/vieworderbyuser", method=RequestMethod.GET)
		public String vieworderbyuser(@RequestParam(value = "code", defaultValue = "") Integer code, HttpSession session, ModelMap model) throws ClassNotFoundException, SQLException
		{
			User user = (User) session.getAttribute("user");
			
			orderrepo.getadminproduct_info(user.getAid(), code, session);
			
			return "viewadminproduct";
		}
		
		
		@RequestMapping(value = "/cancelorder", method=RequestMethod.GET)
		public String cancelorder(@RequestParam(value = "code", defaultValue = "") Integer code, HttpSession session, ModelMap model) throws ClassNotFoundException, SQLException
		{
			String present_user = session.getAttribute("username").toString();
			
			if(present_user == null)
			{
				return "welcome";
			}
			
			user = userrepo.findByaname(present_user);
			ord = orderrepo.getOrderbyid(code);
			
	        order = orderrepo.getOrderby_userid(user.getAid());
			
			if(order.isEmpty())
			{
				model.put("emptyorder", "You have no orders right now!!!");
				return "orders";
			}
			else
			  {
				   orderrepo.remove_anorder(user.getAid(), ord.getOrderid());
				   
		           //userrepo.getOrder().remove(ord);
		           //userrepo.saveuser(user);
		           
		           order = orderrepo.getOrderby_userid(user.getAid());
		           model.addAttribute("orders", order);
		           
		           if(order.isEmpty())
		           {
		        	   model.put("emptyorder", "You have no orders right now!!!");
		           }
		           return "orders";
		      }
		}
		}
