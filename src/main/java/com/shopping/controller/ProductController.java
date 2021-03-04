package com.shopping.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.shopping.entity.Product;
import com.shopping.service.ProductRepository;

@Controller
public class ProductController
{
		@Autowired
		ProductRepository repo;
		
		@Autowired
		Product pro;
		
		// ADD TO REPOOO
		@RequestMapping(value = "/addcontrol", method=RequestMethod.GET)
		public String addproduct()
		{
			return "addproduct";
		}
		
		@RequestMapping(value = "/addtorepo", method=RequestMethod.POST)
		public String productadded(@RequestParam String pname,@RequestParam double pprice,@RequestParam String pimage,Product product, ModelMap model) throws ClassNotFoundException, SQLException
		{
			int product_id = (int)(Math.random() * (1000 - 1 + 1) + 1);

			pro.setPid(product_id);
			pro.setPname(pname);
			pro.setPprice(pprice);
			pro.setPimage(pimage);
			
			model.put("ProductMessage","You Added a Product to Mart Repository!!!");
			repo.add_aproduct(pro);
			return "products";
		}
		
		//UPDATE REPOOO
		@RequestMapping(value = "/updatecontrol", method=RequestMethod.GET)
		public String updateproduct()
		{
			return "updateproduct";
		}

		
		@RequestMapping(value = "/updatetorepo", method=RequestMethod.POST)
		public String productupdated(@RequestParam int pid,Product product, ModelMap model) throws ClassNotFoundException, SQLException
		{
			Product exist = repo.findById(pid);
		
			if(exist.getPname().isEmpty())
			{
				model.put("IdMessage", "Enter a Valid Product Info.!!!");
				return "updateproduct";
			}
			
			//repo.deleteById(pid);
			
			model.put("ProductMessage","You Updated a Product from Mart Repository!!!");
			repo.update_aproduct(product);
			
			return "products";
		}
		
		//REMOVE REPOOO
		@RequestMapping(value = "/removecontrol", method=RequestMethod.GET)
		public String removeproduct()
		{
			return "removeproduct";
		}
		
		@RequestMapping(value = "/removerepo", method=RequestMethod.POST)
		public String productremoved(@RequestParam int pid,Product product, ModelMap model) throws ClassNotFoundException, SQLException
		{
			
			if(pro != null)
			{
			model.put("ProductMessage","You Removed a Product from Mart Repository!!!");
			repo.deleteById(pid);
			return "products";
			}
			else
			{
			model.put("IdMessage", "Enter a Valid ID!!!");
			return "removeproduct";
			}
		}
	}

