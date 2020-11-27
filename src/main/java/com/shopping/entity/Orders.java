package com.shopping.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Orders 
{
	   @Id
	   @Column(name="orderid",unique=true,nullable=false)
	   private int orderid;
	   
	   @ManyToMany(mappedBy="order")
	   public Set<User> user = new HashSet<User>();
	   
	   private String ordername;
	   private double orderprice;
	   private String orderimage;
	   
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getOrdername() {
		return ordername;
	}
	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}
	public double getOrderprice() {
		return orderprice;
	}
	public void setOrderprice(double orderprice) {
		this.orderprice = orderprice;
	}
	public String getOrderimage() {
		return orderimage;
	}
	public void setOrderimage(String orderimage) {
		this.orderimage = orderimage;
	}
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
	   
	   
}
