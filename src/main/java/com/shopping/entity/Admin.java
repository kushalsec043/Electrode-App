
  package com.shopping.entity;
  
  import javax.persistence.Column; 
  import javax.persistence.Entity; 
  import javax.persistence.Id;
  
  import org.springframework.stereotype.Component;
  
  @Entity 
  @Component
  public class Admin 
  {
  
  @Id
  @Column(name="adminid",unique=true,nullable=false) 
  private int adminid;
  private String adname; 
  private String adpass;
  
  public int getAdminid() 
  { 
	  return adminid; 
  } 
  public void setAdminid(int adminid) 
  { 
	  this.adminid = adminid; 
  } 
  
  public String getAdname() 
  { 
	  return adname;
  } 
  
  public void setAdname(String adname) 
  { 
	  this.adname = adname; 
  }
  
  public String getAdpass() 
  { 
	  return adpass; 
  } 
  
  public void setAdpass(String adpass) 
  { 
	  this.adpass = adpass; 
  }
  
  
  }
 