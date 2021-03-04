package com.shopping.authentication;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopping.entity.User;
import com.shopping.service.UserRepository;

@Service
public class LoginService 
{
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	User u;

	public boolean validateUser(String uname, String password) throws ClassNotFoundException, SQLException 
	{
		u = null;
		u = userrepo.findByaname(uname);
		
		if(u != null)
		{
		if(u.getAname().equals(uname) && u.getPsw().equals(password))
		{
			return true;
		}
		}
		return false;
	}
	
	public void adduser(User user) throws ClassNotFoundException, SQLException
	{
		userrepo.saveuser(user);
	}

}
