
  package com.shopping.Dao;
  
  import java.util.List;
  
  import org.springframework.data.jpa.repository.JpaRepository; import
  org.springframework.data.jpa.repository.Query;
  
  import com.shopping.entity.User;
  
  public interface UserJpaRepository extends JpaRepository<User, Integer> {
  User findByaname(String aname);
  
  List<User> findByaidGreaterThan(int i);
  
  @Query("from User where aid=?1 order by aname") List<User>
  findByaidSorted(int aid); }
 