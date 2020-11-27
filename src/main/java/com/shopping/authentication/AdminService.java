package com.shopping.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.shopping.Dao.AdminJpaRepository;
import com.shopping.Dao.UserJpaRepository;
import com.shopping.entity.Admin;
import com.shopping.entity.User;

@Service
public class AdminService 
{
	@Autowired
	AdminJpaRepository repo;
	
	@Autowired
	Admin ad;

	public boolean validate(String uname, String password) 
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
