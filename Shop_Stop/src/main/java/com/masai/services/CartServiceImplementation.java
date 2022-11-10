/**
 * 
 */
package com.masai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Cart;
import com.masai.model.Product;
import com.masai.repository.CartRepo;

/**
 * @author tejas
 *
 */

@Service
public class CartServiceImplementation implements CartService {
	
	@Autowired
	private CartRepo cartrepo;
	
	@Override
	public Cart deleteallproducts(Cart cart) {
		
		
		
		return null;
	}

	@Override
	public Cart viewallproducts(Cart cart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart insertproduct(Cart cart, Product product, Integer quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart deleteproduct(Cart cart, Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart udpateproductquantity(Cart cart, Product product, Integer quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
