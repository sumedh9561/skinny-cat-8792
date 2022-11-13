package com.masai.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.criteria.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.exception.OrderExcetion;
import com.masai.model.Orders;

public interface Orderdao  extends JpaRepository<Orders, Integer>{

	
	
	
	public List<Orders> findByorderDate(LocalDate date) throws  OrderExcetion;
	
//   @Query("select o form Orders o where o.address.city =?1")
//	public List<Orders> getOrderBycity(String city) throws OrderExcetion;
////   
////   
//   @Query("select o from Orders o where o.customer.mobilenumber = ?1")
//   public List<Orders> getOrderByUserId(String userId);
}
