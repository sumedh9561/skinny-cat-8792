package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.exception.CustomerException;
import com.masai.model.Cart;
import com.masai.model.Customer;

public interface CartDao  extends JpaRepository<Cart, Integer>{

	
	
	public Cart findByCustomer(Customer customer) throws CustomerException;
	
	
	@Query("select c from Cart c where c.customer.customerId=?1")
	public Cart getCart(Integer custId);
	
	
	
}
