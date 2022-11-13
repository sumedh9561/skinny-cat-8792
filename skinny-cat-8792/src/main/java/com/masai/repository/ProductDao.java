package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.Product;
import java.util.List;
public interface ProductDao  extends JpaRepository<Product, Integer>{

	
	
	@Query("select p from Product p where p.category.categoryName=?1")
	public List<Product> viewbyCategoryName(String cname);
	
}
