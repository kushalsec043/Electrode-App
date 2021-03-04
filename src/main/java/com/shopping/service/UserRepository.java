
package com.shopping.service;
  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.authentication.DeleteService;
import com.shopping.entity.CardInfo;
import com.shopping.entity.Orders; 
import com.shopping.entity.Product; 
import com.shopping.entity.User;
  
  @Service
  public class UserRepository 
  {
	  @Autowired
	  DeleteService service;
  
  public User findByaname(String uname) throws ClassNotFoundException, SQLException
  {   
	  User u1 = new User();
	  
	  Connection con = service.getconnection();
	  String query = "SELECT * FROM user WHERE aname = ?";
	  PreparedStatement statement = con.prepareStatement(query);    
	  statement.setString(1, uname); 
	  
      ResultSet rs = statement.executeQuery();
      
      if(rs.next())
      {
      u1.setAid(rs.getInt("aid"));
      u1.setAname(rs.getString("aname"));
      u1.setEmail(rs.getString("email"));
      u1.setPsw(rs.getString("psw"));
      u1.setAname(rs.getString("aname"));
      u1.setContact(rs.getString("contact"));
      }
      else
      {
    	  return null;
      }
    
    con.close();
	return u1;
  }
  
  public void saveuser(User user) throws ClassNotFoundException, SQLException 
  { 
	  Connection con = service.getconnection();   
	  int random_int = (int)(Math.random() * (1000 - 1 + 1) + 1);
	  
    	  String user_name = user.getAname();
    	  String user_email = user.getEmail();
    	  String user_psw = user.getPsw();
    	  String user_address = user.getAddress();
    	  String user_contact = user.getContact();
    	  
    	  PreparedStatement pstmt = con.prepareStatement("Insert into user (aid, aname, email, psw, address, contact) VALUE (?,?,?,?,?,?)");
    	  pstmt.setInt(1, random_int);
    	  pstmt.setString(2, user_name);
    	  pstmt.setString(3, user_email);
    	  pstmt.setString(4, user_psw);
    	  pstmt.setString(5, user_address);
    	  pstmt.setString(6, user_contact);
    	 
          pstmt.executeUpdate();
  
	  con.close();
  }
  
  public Set<Product> getCart(int userid) throws ClassNotFoundException, SQLException 
  { 
	  Connection con = service.getconnection();
	  String query = "select * from product p, user_product u where p.pid = u.cart_pid && u.user_aid = ?";
	  PreparedStatement statement = con.prepareStatement(query);
	  statement.setInt(1, userid); 
	  
	  ResultSet rs = statement.executeQuery();
	  
	  Set<Product> products = new HashSet<Product>();
      
      while(rs.next())
      {
    	  Product pro = new Product();
    	  
    	  pro.setPid(rs.getInt("pid"));
    	  pro.setPimage(rs.getString("pimage"));
    	  pro.setPname(rs.getString("pname"));
    	  pro.setPprice(rs.getInt("pprice"));
    	  
    	  products.add(pro);
      }
	  
      con.close();
	  return products;    
  }

	public void update_userinfo(int user_id, String aname, String email, String address, String contact) throws ClassNotFoundException, SQLException 
	{
		  Connection con = service.getconnection();
		  PreparedStatement pstmt = con.prepareStatement("update user set aname=?, email=?, address=?, contact=? where aid=?");
		  pstmt.setString(1, aname);
		  pstmt.setString(2, email);
		  pstmt.setString(3, address);
		  pstmt.setString(4, contact);
		  pstmt.setInt(5, user_id);
		  
		  pstmt.executeUpdate();
		  
		  con.close();
	}

	public void updatecardinfo(int aid, String cardname, String cardno, String expirn, int cvv) throws ClassNotFoundException, SQLException 
	{
		  Connection con = service.getconnection();
		  PreparedStatement pstmt = con.prepareStatement("update cardinfo set nameon=?, cardno=?, expirn=?, cvv=? where user_id=?");
		  pstmt.setString(1, cardname);
		  pstmt.setString(2, cardno);
		  pstmt.setString(3, expirn);
		  pstmt.setInt(4, cvv);
		  pstmt.setInt(5, aid);
		  
		  pstmt.executeUpdate();
		  
		  con.close();
	}

	public CardInfo findcard_byid(int aid) throws ClassNotFoundException, SQLException 
	{
		  Connection con = service.getconnection();
		  String query = "select * from cardinfo where user_id = ?";
		  PreparedStatement statement = con.prepareStatement(query);
		  statement.setInt(1, aid); 
		  
		  ResultSet rs = statement.executeQuery();
		  
		  CardInfo card = new CardInfo();
		  
		  if(rs.next())
		  {
			  card.setNameon(rs.getString("nameon"));
			  card.setCard_no(rs.getString("cardno"));
			  card.setExpirn(rs.getString("expirn"));
			  card.setCvv(rs.getInt("cvv"));
			  
			  return card;
		  }
		  
		return card;
	}

	public void addcardinfo(int aid, String cardname, String cardno, String expirn, int cvv) throws ClassNotFoundException, SQLException 
	{
	  Connection con = service.getconnection();   
      PreparedStatement pstmt = con.prepareStatement("Insert into cardinfo (user_id, nameon, cardno, expirn, cvv) VALUE (?,?,?,?,?)");
   	  pstmt.setInt(1, aid);
   	  pstmt.setString(2, cardname);
   	  pstmt.setString(3, cardno);
   	  pstmt.setString(4, expirn);
   	  pstmt.setInt(5, cvv);
   	 
      pstmt.executeUpdate();
 
	  con.close();
		
	}

	public Set<User> get_allusers() throws ClassNotFoundException, SQLException
	{
		 Connection con = service.getconnection();
		  String query = "SELECT * FROM user";
		  PreparedStatement statement = con.prepareStatement(query);  
		  
		  Set<User> users = new HashSet<User>();
		  
		  ResultSet rs = statement.executeQuery();
		  
		  while(rs.next())
		  {
			  User use = new User();
	    	  
	    	  use.setAid(rs.getInt("aid"));
	    	  use.setAname(rs.getString("aname"));
	    	  use.setEmail(rs.getString("email"));
	    	  use.setPsw(rs.getString("psw"));
	    	  use.setAddress(rs.getString("address"));
	    	  use.setContact(rs.getString("contact"));
	    	  
	    	  users.add(use);
		  }
		  
		  	con.close();
		  	return users;
	}

	public User findBycode(Integer code) throws ClassNotFoundException, SQLException 
	{
		 Connection con = service.getconnection();
		  String query = "SELECT * FROM user where aid=?";
		  PreparedStatement statement = con.prepareStatement(query);  
		  statement.setInt(1, code);
		  
		  ResultSet rs = statement.executeQuery();
		  
		  User use = new User();
		  if(rs.next())
		  {
	    	  
	    	  use.setAid(rs.getInt("aid"));
	    	  use.setAname(rs.getString("aname"));
	    	  use.setEmail(rs.getString("email"));
	    	  use.setPsw(rs.getString("psw"));
	    	  use.setAddress(rs.getString("address"));
	    	  use.setContact(rs.getString("contact"));  
		  }
		  
		  	con.close();
		  	
		return use;
	}
  
  }
 