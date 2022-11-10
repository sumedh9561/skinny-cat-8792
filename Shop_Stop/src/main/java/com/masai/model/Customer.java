/**
 * 
 */
package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Customer {

	@Id
	private String customerId;

	private String firstName;
	private String lastName;
	private String mobileNumber;
	
	@OneToOne
	private Address address;

	private String email;
}
