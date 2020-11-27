package com.shopping.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entity.Orders;

public interface OrdersJpaRepository extends JpaRepository<Orders, Integer>
{

}
