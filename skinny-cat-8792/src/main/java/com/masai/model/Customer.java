package com.masai.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	@NotNull(message = "First Name can't be Null")
	@NotBlank(message = "First Name can't be Blank")
	@NotEmpty(message = "First Name can't be Empty")
	private String firstName;
	
	@NotNull(message = "Last Name can't be Null")
	@NotBlank(message = "Last Name can't be Blank")
	@NotEmpty(message = "Last Name can't be Empty")
	private String lastName;
	
	@Email(message = "Enter valid Email")
	private String email;
	
	@Size(min=10,max=10, message = "Mobile should have 10 digit Only")
	private String mobileNumber;
	
	@Size(min=8,max=16,message = "Password should have Min=8 and Max=16 Character only")
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL)
	Set<Order> orders = new HashSet<>();
	

}
