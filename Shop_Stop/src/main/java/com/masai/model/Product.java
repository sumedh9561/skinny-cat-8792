/**
 * 
 */
package com.masai.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author tejas
 *
 */

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Product {

	@Id
	private String productId;

	private String productName;
	private Double price;
	private String colour;
	private String dimension;
	private String specification;
	private String manufacturer;
	
	@OneToOne
	private Category category;
	
	private Integer quantity;
	

	@Override
	public int hashCode() {
		return Objects.hash(category, colour, dimension, manufacturer, price, productName, quantity, specification);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Product other = (Product) obj;

		if (productId == other.productId)
			return false;

		return Objects.equals(category, other.category) && Objects.equals(colour, other.colour)
				&& Objects.equals(dimension, other.dimension) && Objects.equals(manufacturer, other.manufacturer)
				&& Objects.equals(price, other.price) && Objects.equals(productName, other.productName)
				&& Objects.equals(quantity, other.quantity) && Objects.equals(specification, other.specification);
	}

}
