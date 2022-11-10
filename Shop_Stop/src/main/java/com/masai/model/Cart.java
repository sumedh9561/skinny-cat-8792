/**
 * 
 */
package com.masai.model;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
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
public class Cart {

	@Id
	private String cartId;

	@OneToOne
	private Customer customer;

	@OneToMany
	private Map<Product, Integer> products;

}
