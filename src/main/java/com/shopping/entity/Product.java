package com.shopping.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Product 
{
   @Id 
   private int pid;
   
   @ManyToMany(mappedBy="cart")
	public Set<User> user = new HashSet<User>();
   
   private String pname;
   private double pprice;
   private String pimage;


public int getPid() {
	return pid;
}
public void setPid(int pid2) {
	this.pid = pid2;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public double getPprice() {
	return pprice;
}
public void setPprice(double pprice) {
	this.pprice = pprice;
}
public String getPimage() {
	return pimage;
}
public void setPimage(String pimage) {
	this.pimage = pimage;
}
@Override
public String toString() {
	return "Product [pname=" + pname + ", pprice=" + pprice + ", pimage=" + pimage + "]";
}
   
   
}
