
  package com.shopping.Dao;
  
  import org.springframework.data.jpa.repository.JpaRepository;
  
  import com.shopping.entity.Product;
  
  public interface ProductJpaRepository extends JpaRepository<Product, Integer>
  { Product findBypname(String pname);
  
  Product findBypid(int pid);
  
  }
 