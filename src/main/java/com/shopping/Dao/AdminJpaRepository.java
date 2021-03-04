
  package com.shopping.Dao;
  
  import org.springframework.data.jpa.repository.JpaRepository;
  
  import com.shopping.entity.Admin;
  
  public interface AdminJpaRepository extends JpaRepository<Admin, Integer> {
  Admin findByadname(String adname); }
 