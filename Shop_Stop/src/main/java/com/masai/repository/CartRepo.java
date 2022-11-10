/**
 * 
 */
package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Cart;
import com.masai.model.Product;

/**
 * @author tejas
 *
 */

@Repository
public interface CartRepo extends JpaRepository<Cart, String> {



}
