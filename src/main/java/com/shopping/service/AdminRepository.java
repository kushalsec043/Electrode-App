
  package com.shopping.service;
  
  import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.authentication.DeleteService;
import com.shopping.entity.Admin;
import com.shopping.entity.User;
  
  @Service
  public class AdminRepository 
  {
  
	  @Autowired
	  DeleteService service;
	  
  public Admin findByadname(String uname) throws ClassNotFoundException, SQLException 
  {
	  Admin u1 = new Admin();
	  
	  Connection con = service.getconnection();
	  String query = "SELECT * FROM admin WHERE adname = ?";
	  PreparedStatement statement = con.prepareStatement(query);    
	  statement.setString(1, uname); 
	  
      ResultSet rs = statement.executeQuery();
      
      if(rs.next())
      {
      u1.setAdminid(rs.getInt("adminid"));
      u1.setAdname(rs.getString("adname"));
      u1.setAdpass(rs.getString("adpass"));
      }
      else
      {
    	  return null;
      }
    
    con.close();
	return u1;
  }
  
  }
 