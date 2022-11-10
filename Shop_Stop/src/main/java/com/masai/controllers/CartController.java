/**
 * 
 */
package com.masai.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Cart;
import com.masai.model.Product;
import com.masai.services.CartServiceImplementation;

/**
 * @author tejas
 *
 */

@RestController
public class CartController {

	private CartServiceImplementation cartserviceimplementation;

	public ResponseEntity<Cart> removeAllProducts(Cart cart) {
		
		
		
	};

	public ResponseEntity<Cart> viewAllProducts(Cart cart) {
	};

	public ResponseEntity<Cart> removeProductFromCart(Cart cart, Product product) {
	};

	public ResponseEntity<Cart> udpateProductQuantity(Cart cart, Product product, Integer quantity) {
	};

	public ResponseEntity<Cart> addProductToCart(Cart cart, Product product, Integer quantity) {
		
		
		
	};

}
