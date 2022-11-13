package com.masai.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dto.ProductDto;
import com.masai.exception.CartException;
import com.masai.exception.LoginException;
import com.masai.exception.OrderExcetion;
import com.masai.exception.ProductException;
import com.masai.model.Cart;
import com.masai.model.Session;
import com.masai.repository.CartDao;
import com.masai.repository.CustomerDao;
import com.masai.repository.ProductDao;
import com.masai.repository.ProductDtoDao;
import com.masai.repository.SessionDao;

import io.swagger.models.auth.In;

import com.masai.model.Customer;
import com.masai.model.Product;
@Service
public class CartServiceimpl  implements CartService{

	
	  private static final String Customer = null;

	@Autowired
	  private CartDao cartdao;
	   
	  @Autowired
	  private ProductDao pdo;
	  
	  @Autowired
	  private ProductDtoDao pdao;
	  
	  @Autowired
	  private SessionDao sdo;
	  
	   @Autowired
	  private CustomerDao cus;
	
	
	@Override
	public Cart addProductToCart(Integer productId, Integer quantity, String key)
			throws CartException, LoginException, ProductException {
		// TODO Auto-generated method stub
		
		   Session currentCustomer  = sdo.findByuuid(key);
		   
		   
		   if(currentCustomer == null) {
				throw new LoginException("Please provide a valid key to update a customer");
			}
		   else
		   {
			
			   Optional<Product> optProduct = pdo.findById(productId) ;
				
				if(optProduct.isEmpty()) {
					throw new ProductException("No product available with id :"+ productId) ;
				}
				Integer s = currentCustomer.getUserId();
				
				Optional<Customer> fin = cus.findById(s);
				
				
				Customer or = fin.get();
				Product currentProduct = optProduct.get();
				
				if(currentProduct.getQuantity() < quantity) {
					throw new ProductException("Product quantity not available or Out of stock") ;
				}
				
				Cart customerCart = cartdao.getCart(or.getCustomerId());
				
				if(customerCart == null) { // user is adding first time in the cart 
					
					customerCart = new Cart();
					
				
					customerCart.setCustomer(or);
					
					List<ProductDto> list = customerCart.getProducts();
					
					ProductDto productDto = new ProductDto( currentProduct.getProductId(),
															currentProduct.getProductName(),
															currentProduct.getPrice(), 
															currentProduct.getColor(), 
															currentProduct.getDimension(),
															currentProduct.getManufacture(),
															quantity);
					
					currentProduct.setQuantity(currentProduct.getQuantity() - quantity);
					
					list.add(productDto);
					
					
					cartdao.save(customerCart) ;
					pdo.save(currentProduct);
					
					return customerCart;
						
				}
				else {
					
					List<ProductDto> list = customerCart.getProducts();
					
					ProductDto productDto = new ProductDto( currentProduct.getProductId(),
															currentProduct.getProductName(),
															currentProduct.getPrice(), 
															currentProduct.getColor(), 
															currentProduct.getDimension(),
															currentProduct.getManufacture(), 
															quantity);
					
					currentProduct.setQuantity(currentProduct.getQuantity() - quantity);
					
					list.add(productDto);
					
					
					cartdao.save(customerCart) ;
					pdo.save(currentProduct);
					 
					return customerCart;
			   
				}
	}
	}

	@Override
	public List<ProductDto> removeProductfromCart(Integer productId, String key)
			throws CartException, LoginException, ProductException {
		// TODO Auto-generated method stub
		
		
		
		Session currentCustomer = sdo.findByuuid(key);
		
		if(currentCustomer==null)
		{
			throw new LoginException("You are Not Authorized to Delete the Product");
		}
          Optional<ProductDto> optProduct = pdao.findById(productId) ;
		
		if(optProduct.isEmpty()) {
			throw new ProductException("No product available with id :"+ productId) ;
		}
		else
		{
			Integer s = currentCustomer.getUserId();
			
			Optional<Customer> fin = cus.findById(s);
			
			
			Customer or = fin.get();
			
			
			ProductDto currentProduct = optProduct.get();
			
			Cart customerCart = cartdao.getCart(or.getCustomerId());
			
			
			if(customerCart==null)
			{
				throw new OrderExcetion("NO order found for this ");
			}
			else
			{
				cartdao.deleteById(productId);
				
				cartdao.save(customerCart);
				List<ProductDto> list = customerCart.getProducts();
				
				
				return list;
				
			}
		}
		
		
					
		
	}

	@Override
	public List<ProductDto> updateProductQuantity(Integer productId, Integer quantity, String key)
			throws CartException, LoginException, ProductException {
		// TODO Auto-generated method stub
		
		
		Session currentCustomer = sdo.findByuuid(key);
		
		
		if(currentCustomer==null)
		{
			throw new LoginException("You are not Authorized to Update the Product");
		}
		
          Optional<Product> optProduct = pdo.findById(productId) ;
		
		if(optProduct.isEmpty()) {
			throw new ProductException("No product available with id :"+ productId) ;
		}
		
		Product currentProduct = optProduct.get();
		
		if(currentProduct.getQuantity() < quantity) {
			throw new ProductException("Product Out of stock") ;
		}
		
		
          Integer s = currentCustomer.getUserId();
		
		Optional<Customer> fin = cus.findById(s);
		
		
		Customer or = fin.get();
		
		
//		Product currentProduct = optProduct.get();
		
		Cart customerCart = cartdao.getCart(or.getCustomerId());
		
		
	
		
		if(customerCart != null) {
			
			List<ProductDto> list = customerCart.getProducts();
			
			boolean flag = false;
			
			for(ProductDto productdto : list) {
				
				if(productdto.getProductId() == productId) {
					
					flag = true;
					
					currentProduct.setQuantity(currentProduct.getQuantity() - quantity);
					productdto.setQuantity(productdto.getQuantity() + quantity);
					
					pdo.save(currentProduct) ;
					pdao.save(productdto) ;
					
					break;
				}
				
			}
			
			if(!flag) {
				throw new ProductException("There was no product in your cart with this id: "+" "+productId) ;
			}
			
			return list;
		}
		else {
			throw new ProductException("You have no product in the cart to update the quantity");
		}
		
		
		
		
		
		
		
		
		
		
		
	}

	@Override
	public Cart removeAllproduct(String key) throws CartException, LoginException {
		// TODO Auto-generated method stub
		
		Session currentCustomer = sdo.findByuuid(key);
		
		if(currentCustomer==null)
		{
			throw new LoginException("You are not Authorized to delter");
		}
		
		
		
        Integer s = currentCustomer.getUserId();
		
		Optional<Customer> fin = cus.findById(s);
		
		
		Customer or = fin.get();
		
		
//		Product currentProduct = optProduct.get();
		
		Cart customerCart = cartdao.getCart(or.getCustomerId());
		
	
		
		List<ProductDto> list = customerCart.getProducts();
		System.out.println("Hi");
		if(list.size() > 0) {
			
			
			for(ProductDto productDto : list) {
				
				Optional<Product> opt = pdo.findById(productDto.getProductId()) ;
				
				Product currentProduct = opt.get();
				
				currentProduct.setQuantity(currentProduct.getQuantity() + productDto.getQuantity());
				
				pdao.delete(productDto);
				
				pdo.save(currentProduct) ;
			}
			
		}
		
		customerCart.setProducts(new ArrayList<>());
		
		return cartdao.save(customerCart) ;
		
	}

	@Override
	public List<ProductDto> viewAllProducts(String key) throws CartException, LoginException {
		// TODO Auto-generated method stub
		
		 
	    Session ss  = sdo.findByuuid(key);
	    
	     if(ss==null)
	     {
	    	 throw new LoginException("You are not Authorized to Check Cart");
	     }
	     else
	     {
	    	 Integer s = ss.getUserId();
	 		
	 		Optional<Customer> fin = cus.findById(s);
	 		
	 		
	 		Customer or = fin.get();
	 		
	 		
//	 		Product currentProduct = optProduct.get();
	 		
	 		Cart customerCart = cartdao.getCart(or.getCustomerId());
	    	 
//	    	 Cart customerCart = cartdao.findByCustomer(currentCustomer);
	 		
	 		if(customerCart == null) {
	 			throw new CartException("You dont have anything in your cart");
	 		}
	 		
	 		return customerCart.getProducts();
	     }
		
	}

}
