
  package com.shopping.entity;
  
  import java.util.HashSet; import java.util.List; import java.util.Set;
  import javax.persistence.Column; import javax.persistence.Entity; 
  import javax.persistence.Id; import javax.persistence.ManyToMany;
  
  import org.springframework.stereotype.Component;
  
  @Entity 
  @Component
  public class Orders 
  {
  
  @Id
  @Column(name="orderid",unique=true,nullable=false) 
  private int orderid;
  
  //@ManyToMany(mappedBy="order") 
  //public Set<User> user = new HashSet<User>();
  
  private String ordername; 
  private double orderprice; 
  private String orderimage;
  
  public int getOrderid() 
  { 
	  return orderid; 
  } 
  
  public void setOrderid(int orderid) 
  { 
	  this.orderid = orderid; 
  } 
  
  public String getOrdername() 
  { 
	  return ordername; 
  } 
  
  public void setOrdername(String ordername) 
  { 
	  this.ordername = ordername; 
  } 
  
  public double getOrderprice() 
  { 
	  return orderprice; 
  } 
  
  public void setOrderprice(double orderprice) 
  { 
	  this.orderprice = orderprice; 
  } 
  
  public String getOrderimage() 
  { 
	  return orderimage; 
  } 
  
  public void setOrderimage(String orderimage) 
  { 
	  this.orderimage = orderimage; 
  }

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + orderid;
	result = prime * result + ((orderimage == null) ? 0 : orderimage.hashCode());
	result = prime * result + ((ordername == null) ? 0 : ordername.hashCode());
	long temp;
	temp = Double.doubleToLongBits(orderprice);
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
	Orders other = (Orders) obj;
	if (orderid != other.orderid)
		return false;
	if (orderimage == null) {
		if (other.orderimage != null)
			return false;
	} else if (!orderimage.equals(other.orderimage))
		return false;
	if (ordername == null) {
		if (other.ordername != null)
			return false;
	} else if (!ordername.equals(other.ordername))
		return false;
	if (Double.doubleToLongBits(orderprice) != Double.doubleToLongBits(other.orderprice))
		return false;
	return true;
} 
  
	/*
	 * public Set<User> getUser() { return user; }
	 * 
	 * public void setUser(Set<User> user) { this.user = user; }
	 */
  
  
  }
 