/**
 * 
 */
package com.masai.services;

import com.masai.model.Cart;
import com.masai.model.Product;

/**
 * @author tejas
 *
 */
public interface CartService {

	public Cart deleteallproducts(Cart cart);

	public Cart viewallproducts(Cart cart);

	public Cart insertproduct(Cart cart, Product product, Integer quantity);

	public Cart deleteproduct(Cart cart, Product product);

	public Cart udpateproductquantity(Cart cart, Product product, Integer quantity);
	
}
