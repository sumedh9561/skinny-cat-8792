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
		
		   Session cs  = sdo.findByuuid(key);
		   
		   
		   if(cs == null) {
				throw new LoginException("Please provide a valid key to update a customer");
			}
		   else
		   {
			  
			   
			   Optional<Product> optproduct = pdo.findById(productId);
			   
			   if(optproduct.isEmpty())
			   {
				   throw new ProductException("Product Out Of Stock");
			   }
			   
			   Product current = optproduct.get();
			   
			   if(current.getQuantity() >= quantity)
			   {
				   Integer n = current.getQuantity()-quantity;
				   
				   String s = current.getProductName();
				   Map<String, ProductDto>  ss = new HashMap<>();
				     
				   ProductDto pd = new ProductDto();
				   
				   pdo.save(current);
				   pd.setQuantity(quantity);
				   
			     
				   ss.put(s, pd);
				   
				    Optional<Customer> name =  cus.findById(cs.getUserId());
				    
				    
				    Customer cc = name.get();
				     
				   
				   Cart go = new Cart();
				    
				    
				    
				   go.setCustomer(cc);
				   go.setS(ss);
				   
				   cartdao.save(go);
				   return go;
			   }
			   else
			   {
				   throw new ProductException("something went wrong");
			   }
			   
		   }
		  
	}

	@Override
	public List<ProductDto> removeProductfromCart(Integer productId, String key)
			throws CartException, LoginException, ProductException {
		// TODO Auto-generated method stub
		
		
		
		Session s = sdo.findByuuid(key);
		
		if(s==null)
		{
			throw new LoginException("You are Not Authorized to Delete the Product");
		}
		else
		{
			
			Optional<ProductDto> pd = pdao.findById(productId);
			
			if(pd.isEmpty())
			{
				throw new CartException("No Product in the cart");
			}
			
			ProductDto pdc = pd.get();
			
			cartdao.deleteById(productId);
			
			List<ProductDto> lip = new ArrayList<ProductDto>();
			
			lip.add(pdc);
			
			return lip;
			
			
		}
		
	}

	@Override
	public List<ProductDto> updateProductQuantity(Integer productId, Integer quantity, String key)
			throws CartException, LoginException, ProductException {
		// TODO Auto-generated method stub
		
		
		Session s = sdo.findByuuid(key);
		
		
		if(s==null)
		{
			throw new LoginException("You are not Authorized to Update the Product");
		}
		else
		{
			Optional<Product> pd = pdo.findById(productId);
			
			Product pc = pd.get();
			
			String name = pc.getProductName();
			if(pc.getQuantity()>=quantity)
			{
				
			  Map<String, ProductDto> pe = new HashMap<String, ProductDto>();
			  
			  ProductDto sip = new ProductDto();
			  
			  sip.setQuantity(quantity);
			  pe.put(name, sip);
			  
			  Optional<Customer> nam =  cus.findById(s.getUserId());
			    
			    
			    Customer cc = nam.get();
			     
			   
			   Cart go = new Cart();
			    
			    
			    
			   go.setCustomer(cc);
			   go.setS(pe);
			   cartdao.save(go);
			  
			  List<ProductDto> lip = new ArrayList<ProductDto>();
			  
			  lip.add(sip);
			  return lip;
			}
			else
			{
				throw new ProductException("Proudct is limited");
			}
			
		}
		
	}

	@Override
	public Cart removeAllproduct(String key) throws CartException, LoginException {
		// TODO Auto-generated method stub
		
		Session s = sdo.findByuuid(key);
		
		if(s==null)
		{
			throw new LoginException("You are not Authorized to delter");
		}
		else
		{
			cartdao.deleteAll();
			
			Cart ss = new  Cart();
			return ss;
		}
		
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
	    	 
	    	 List<ProductDto> s = pdao.findAll();
	    	 
	    	 return s;
	     }
		
	}

}
