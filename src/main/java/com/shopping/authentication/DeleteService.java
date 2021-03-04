package com.shopping.authentication;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class DeleteService
{
	
	public static Connection getconnection() throws ClassNotFoundException, SQLException
	{
		String url = "jdbc:mysql://localhost:3306/employees_database";
        String name = "root";
        String pass = "password123";
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, name, pass);
        
		return con;
	}
	
	public static boolean delete_user_product(int userid, int productid) throws ClassNotFoundException, SQLException
	{
	        String query = "DELETE FROM user_product where user_aid=? and cart_pid=?";
	        Connection con = getconnection();
	        PreparedStatement statement = con.prepareStatement(query);
	        
	        statement.setInt(1, userid);
	        statement.setInt(2, productid);
	        
	        int rows = statement.executeUpdate();
	        
	        if(rows > 0)
	        {
	        	System.out.println("The user info. is updated");
	        	return true;
	        }
	        
	        statement.close();
	        con.close();
			return false;
	}
	
	
}
