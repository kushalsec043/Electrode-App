
  package com.shopping.service;
  
 import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.authentication.DeleteService;
import com.shopping.entity.Orders;
import com.shopping.entity.Product;
  
  @Service
  public class OrderRepository 
  {
  
	  @Autowired
	  DeleteService service;
	  
	  @Autowired
	  Set<Orders> order;
	  
  public void add_toorder(Orders ord, int user_id) throws SQLException, ClassNotFoundException 
  { 
	  Connection con = service.getconnection();		
	  	  
	  int id = ord.getOrderid();
	  String image = ord.getOrderimage();
	  String name = ord.getOrdername();
	  double price = ord.getOrderprice();
	  
	  order = getOrder_orderstable();
	  
	  if(!order.contains(ord))
	  {
	  PreparedStatement pstmt = con.prepareStatement("Insert into orders (orderid, orderimage, ordername, orderprice) VALUE (?,?,?,?)");
	  pstmt.setInt(1, id);
	  pstmt.setString(2, image);
	  pstmt.setString(3, name);
	  pstmt.setDouble(4, price);
	  pstmt.executeUpdate();
	  }
	  
	  order = getOrderby_userid(user_id);
	  
	  if(!order.contains(ord))
	  {
	  PreparedStatement pstmt1 = con.prepareStatement("Select quantity, price from user_product where user_aid=? and cart_pid=?");
	  pstmt1.setInt(1, user_id);
	  pstmt1.setInt(2, ord.getOrderid());
	  ResultSet rs = pstmt1.executeQuery();
	  
	  int quantity = 0;
	  double total_price = 0;
	  if(rs.next())
	  {
	  quantity = rs.getInt("quantity");
	  total_price = ord.getOrderprice() * quantity;
	  }
		  
	  PreparedStatement pstmt2 = con.prepareStatement("Insert into user_order (user_aid, order_orderid, quantity, price) VALUE (?,?,?,?)");
	  pstmt2.setInt(1, user_id);
	  pstmt2.setInt(2, ord.getOrderid());
	  pstmt2.setInt(3, quantity);
	  pstmt2.setDouble(4, total_price);
	  
	  pstmt2.executeUpdate();  
	  }
	  
	  con.close();
  }
  
  private Set<Orders> getOrder_orderstable() throws ClassNotFoundException, SQLException 
  {
	  Connection con = service.getconnection();
	  String query = "SELECT * FROM orders";
	  PreparedStatement statement = con.prepareStatement(query);  
	  
	  Set<Orders> orders = new HashSet<Orders>();
	  
	  ResultSet rs = statement.executeQuery();
	  
	  while(rs.next())
	  {
		  Orders ord = new Orders();
    	  
    	  ord.setOrderid(rs.getInt("orderid"));
    	  ord.setOrderimage(rs.getString("orderimage"));
    	  ord.setOrdername(rs.getString("ordername"));
    	  ord.setOrderprice(rs.getInt("orderprice"));
    	  
    	  orders.add(ord);
	  }
	  
	  	con.close();
	  	return orders;
}

public Set<Orders> getOrderby_userid(int userid) throws ClassNotFoundException, SQLException 
  {
	  Connection con = service.getconnection();
	  String query = "select * from product p, user_order u where p.pid = u.order_orderid && u.user_aid = ?";
	  PreparedStatement statement = con.prepareStatement(query);
	  statement.setInt(1, userid); 
	  
	  ResultSet rs = statement.executeQuery();
	  
	  Set<Orders> orders = new HashSet<Orders>();
      
      while(rs.next())
      {
    	  Orders ord = new Orders();
    	  
    	  ord.setOrderid(rs.getInt("pid"));
    	  ord.setOrderimage(rs.getString("pimage"));
    	  ord.setOrdername(rs.getString("pname"));
    	  ord.setOrderprice(rs.getInt("pprice"));
    	  
    	  orders.add(ord);
      }
	  
      con.close();
	  return orders;      
  }

	public void remove_anorder(int userid, int orderid) throws ClassNotFoundException, SQLException
	{
		String query = "DELETE FROM user_order where user_aid=? and order_orderid=?";
        Connection con = service.getconnection();
        PreparedStatement statement = con.prepareStatement(query);
        
        statement.setInt(1, userid);
        statement.setInt(2, orderid);
        
        statement.executeUpdate();
        
        statement.close();
        con.close();
	}

	public Orders getOrderbyid(Integer orderid) throws ClassNotFoundException, SQLException 
	{
		  Orders ord = new Orders();
		  
		  Connection con = service.getconnection();
		  String query = "SELECT * FROM orders WHERE orderid = ?";
		  PreparedStatement statement = con.prepareStatement(query);    
		  statement.setInt(1, orderid); 
		  
		  ResultSet rs = statement.executeQuery();
	      
	      if(rs.next())
	      {
	    	  ord.setOrderid(rs.getInt("orderid"));
	    	  ord.setOrderimage(rs.getString("orderimage"));
	    	  ord.setOrdername(rs.getString("ordername"));
	    	  ord.setOrderprice(rs.getDouble("orderprice"));
	      }
		  
	      con.close();
		  return ord;
	}

	public int getorder_quantity(int aid, int pid) throws SQLException, ClassNotFoundException 
	{
		  Connection con = service.getconnection();
		  String query = "select quantity from user_order where user_aid=? and order_orderid=?";
		  PreparedStatement statement = con.prepareStatement(query);
		  statement.setInt(1, aid);
		  statement.setInt(2, pid);
		  
		  ResultSet rs = statement.executeQuery();		
		  
		  int quantity = 0;
		  if(rs.next())
		  {
			quantity = rs.getInt("quantity");  
		  }
		  return quantity;
	}
  
	public int getcart_quantity(int aid, int pid) throws SQLException, ClassNotFoundException 
	{
		  Connection con = service.getconnection();
		  String query = "select quantity from user_product where user_aid=? and cart_pid=?";
		  PreparedStatement statement = con.prepareStatement(query);
		  statement.setInt(1, aid);
		  statement.setInt(2, pid);
		  
		  ResultSet rs = statement.executeQuery();		
		  
		  int quantity = 0;
		  if(rs.next())
		  {
			quantity = rs.getInt("quantity");  
		  }
		  return quantity;
	}

	public Set<Orders> get_allorders() throws ClassNotFoundException, SQLException 
	{
		  Connection con = service.getconnection();
		  String query = "select * from orders o, user_order u where o.orderid=u.order_orderid";
		  PreparedStatement statement = con.prepareStatement(query);  
		  
		  Set<Orders> orders = new HashSet<Orders>();
		  
		  ResultSet rs = statement.executeQuery();
		  
		  while(rs.next())
		  {
			  Orders ord = new Orders();
	    	  
	    	  ord.setOrderid(rs.getInt("user_aid"));
	    	  ord.setOrderimage(rs.getString("orderimage"));
	    	  ord.setOrdername(rs.getString("ordername"));
	    	  ord.setOrderprice(rs.getInt("orderprice"));
	    	  
	    	  orders.add(ord);
		  }
		  
		  	con.close();
		  	return orders;
	}

	public Set<Orders> get_allordersof_a_user(Integer code) throws ClassNotFoundException, SQLException 
	{
		//select * from user_order as uo, orders as u where uo.user_aid=246 and uo.order_orderid=u.orderid;
		  Connection con = service.getconnection();
		  String query = "select * from user_order as uo, orders as u where uo.user_aid=? and uo.order_orderid=u.orderid";
		  PreparedStatement statement = con.prepareStatement(query);  
		  statement.setInt(1, code);
		  
		  Set<Orders> orders = new HashSet<Orders>();
		  
		  ResultSet rs = statement.executeQuery();
		  
		  while(rs.next())
		  {
			  Orders ord = new Orders();
	    	  
	    	  ord.setOrderid(rs.getInt("order_orderid"));
	    	  ord.setOrderimage(rs.getString("orderimage"));
	    	  ord.setOrdername(rs.getString("ordername"));
	    	  ord.setOrderprice(rs.getInt("orderprice"));
	    	  
	    	  orders.add(ord);
		  }
		  
		  	con.close();
		  	return orders;
	}

	public void getadminproduct_info(int aid, int code, HttpSession session) throws ClassNotFoundException, SQLException
	{
		Connection con = service.getconnection();
		  String query = "select * from user_order as uo, product as p where uo.order_orderid=p.pid and uo.user_aid=? and p.pid=?";
		  PreparedStatement statement = con.prepareStatement(query);  
		  statement.setInt(1, aid);
		  statement.setInt(2, code);
		  
		  ResultSet rs = statement.executeQuery();
		  
		  String image = ""; int quantity=0; String name=""; double price = 0;
		  if(rs.next())
		  {
			  image = rs.getString("pimage");
			  quantity = rs.getInt("quantity");
			  name = rs.getString("pname");
			  price = rs.getDouble("price");
		  }
		  
		  session.setAttribute("user_aid", rs.getString("user_aid"));
		  session.setAttribute("adminimage", image);
		  session.setAttribute("adminquantity", quantity);
		  session.setAttribute("adminname", name);
		  session.setAttribute("adminprice", price);
		  
		  con.close();
	}
  }
 