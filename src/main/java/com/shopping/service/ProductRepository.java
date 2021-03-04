
package com.shopping.service;
  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.authentication.DeleteService;
import com.shopping.entity.Product;
  
  @Service
  public class ProductRepository 
  {
	  @Autowired
	  DeleteService service;
	  
	  public Product findById(int pid) throws ClassNotFoundException, SQLException 
	  { 
		  Product pro = new Product();
		  
		  Connection con = service.getconnection();
		  String query = "SELECT * FROM product WHERE pid = ?";
		  PreparedStatement statement = con.prepareStatement(query);    
		  statement.setInt(1, pid); 
		  
		  ResultSet rs = statement.executeQuery();
	      
	      if(rs.next())
	      {
	    	  pro.setPid(rs.getInt("pid"));
	    	  pro.setPimage(rs.getString("pimage"));
	    	  pro.setPname(rs.getString("pname"));
	    	  pro.setPprice(rs.getInt("pprice"));
	      }
		  
	      con.close();
		  return pro;
	  }
	  
	  
	  public Set<Product> findAll() throws ClassNotFoundException, SQLException 
	  { 
		  Connection con = service.getconnection();
		  String query = "SELECT * FROM product";
		  PreparedStatement statement = con.prepareStatement(query);  
		  
		  Set<Product> products = new HashSet<Product>();
		  
		  ResultSet rs = statement.executeQuery();
		  
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
	  
	  public void add_tocart(int aid, int pid, int quantity, double price) throws SQLException, ClassNotFoundException 
	  {
		  Connection con = service.getconnection();		  
		  PreparedStatement pstmt = con.prepareStatement("Insert into user_product (user_aid, cart_pid, quantity, price) VALUE (?,?,?,?)");
		  pstmt.setInt(1, aid);
		  pstmt.setInt(2, pid);
		  pstmt.setInt(3, quantity);
		  pstmt.setDouble(4, price);
		  
		  pstmt.executeUpdate();
		  con.close();
	  }
  
	  public void add_aproduct(Product pro) throws ClassNotFoundException, SQLException 
	  { 
		  Connection con = service.getconnection();   
		  
		  int pid = pro.getPid();
		  String pimage = pro.getPimage();
		  String pname = pro.getPname();
		  double pprice = pro.getPprice();
		  
    	  PreparedStatement pstmt = con.prepareStatement("Insert into product (pid, pimage, pname, pprice) VALUE (?,?,?,?)");
    	  pstmt.setInt(1, pid);
    	  pstmt.setString(2, pimage);
    	  pstmt.setString(3, pname);
    	  pstmt.setDouble(4, pprice);
    	  
    	  pstmt.executeUpdate();
    	  
    	  con.close();
	  }
  
  public void deleteById(int pid) throws ClassNotFoundException, SQLException 
  { 
	  Connection con = service.getconnection();  
	  
	  PreparedStatement pstmt = con.prepareStatement("delete from product where pid=?");
	  pstmt.setInt(1, pid);
	  
	  pstmt.executeUpdate();
	  con.close();
  }

  public void update_aproduct(Product product) throws ClassNotFoundException, SQLException 
  {
	  Connection con = service.getconnection();   
	  
	  String pimage = product.getPimage();
	  String pname = product.getPname();
	  double pprice = product.getPprice();
	  
	  PreparedStatement pstmt = con.prepareStatement("update product set pimage=?, pname=?, pprice=? where pid=?");
	  pstmt.setString(1, pimage);
	  pstmt.setString(2, pname);
	  pstmt.setDouble(3, pprice);
	  pstmt.setInt(4, product.getPid());
	  
	  pstmt.executeUpdate();
	  
	  con.close();
  }



  
  }
 