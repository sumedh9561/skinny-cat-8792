package com.masai.model;

import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;



public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	
	@Size(min = 3, max = 25, message = "Product Name should contain min 3 character." )
	private String productName;
	
	@Min(value = 1, message = "Please Enter a valid price")
	private Double price;
	
	
	private String color;
	
	private String dimension;
	
	private String manufacturer;
	
	@Min(value = 1, message = "Please Enter a valid quantity.")
	private Integer quantity;
	
	@Embedded
	private Category category;

	public Product(
			@Size(min = 3, max = 25, message = "Product Name should contain min 3 character.") String productName,
			@Min(value = 1, message = "Please Enter a valid price") Double price, String color, String dimension,
			String manufacturer, @Min(value = 1, message = "Please Enter a valid quantity.") Integer quantity,
			Category category) {
		super();
		this.productName = productName;
		this.price = price;
		this.color = color;
		this.dimension = dimension;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.category = category;
	}
}
