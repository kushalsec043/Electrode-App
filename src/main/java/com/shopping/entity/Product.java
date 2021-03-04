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

@Entity
@Component
public class Product 
{
   @Id 
   private int pid;
   private String pname;
   private double pprice;
   private String pimage;

   //@ManyToMany
   //public Set<User> user = new HashSet<User>();

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
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + pid;
	result = prime * result + ((pimage == null) ? 0 : pimage.hashCode());
	result = prime * result + ((pname == null) ? 0 : pname.hashCode());
	long temp;
	temp = Double.doubleToLongBits(pprice);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Product other = (Product) obj;
	if (pid != other.pid)
		return false;
	if (pimage == null) {
		if (other.pimage != null)
			return false;
	} else if (!pimage.equals(other.pimage))
		return false;
	if (pname == null) {
		if (other.pname != null)
			return false;
	} else if (!pname.equals(other.pname))
		return false;
	if (Double.doubleToLongBits(pprice) != Double.doubleToLongBits(other.pprice))
		return false;
	return true;
}
   
   
}
