package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.ProductException;
import com.masai.model.Product;
import com.masai.repository.ProductDao;

@Service
public class ProductServiceimpl  implements ProductService{

	
	@Autowired
	private ProductDao dd;
	
	
	@Override
	public List<Product> viewAllproduct() throws ProductException {
		// TODO Auto-generated method stub
		
		    List<Product> s = dd.findAll();
		   
		    if(s.isEmpty())
		    {
		    	throw new ProductException("There is no product ");
		    	
		    }
		
		return s;
	}

	@Override
	public Product updateProduct(Product product) throws ProductException {
		// TODO Auto-generated method stub
		
		
		            Product s = dd.save(product);
		return s;
	}

	@Override
	public Product viewProduct(Integer id) throws ProductException {
		// TODO Auto-generated method stub
		
		  Optional<Product> s = dd.findById(id);
		  
		  
		  if(s.isEmpty())
		  {
			  throw new ProductException("No Product found");
		  }
		  else
		  {
			  Product ss = s.get();
			  return ss;
		  }
		
	}

	@Override
	public List<Product> viewProudctbyCategory(String cname) throws ProductException {
		// TODO Auto-generated method stub
		
		List<Product> s = dd.viewbyCategoryName(cname);
		
		return s;
	}

	@Override
	public Product removeProduct(Integer pid) throws ProductException {
		// TODO Auto-generated method stub
		
		 Optional<Product> ss = dd.findById(pid);
		 
		 
		 if(ss.isEmpty())
		 {
			 throw new ProductException("Product not found");
		 }
		 else
		 {
			 Product s = ss.get();
			 return s;
		 }
	
	}

	@Override
	public Product addProduct(Product product) throws ProductException {
		// TODO Auto-generated method stub
		
		  
		
		return dd.save(product);
	}

}
