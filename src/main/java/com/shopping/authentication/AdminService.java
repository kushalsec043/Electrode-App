package com.shopping.authentication;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.shopping.entity.Admin;
import com.shopping.service.AdminRepository;

@Service
public class AdminService 
{
	@Autowired
	AdminRepository repo;
	
	@Autowired
	Admin ad;

	public boolean validate(String uname, String password) throws ClassNotFoundException, SQLException 
	{
		ad = null;
		ad = repo.findByadname(uname);
		
		if(ad != null)
		{
		if(ad.getAdname().equals(uname) && ad.getAdpass().equals(password))
		{
			return true;
		}
		}
		return false;
	}

}
