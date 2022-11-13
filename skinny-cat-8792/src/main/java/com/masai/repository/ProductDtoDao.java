package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.dto.ProductDto;

public interface ProductDtoDao extends JpaRepository<ProductDto, Integer> {

	
	
}
