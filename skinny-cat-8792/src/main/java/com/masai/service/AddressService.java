package com.masai.service;

import java.util.List;

import com.masai.exception.AddressException;
import com.masai.exception.LoginException;
import com.masai.model.Address;

public interface AddressService {

	
	
	public Address addAddress(Address add , String key) throws AddressException, LoginException;
	
	public Address updateAddress(Address add, String key) throws AddressException , LoginException;
	
	public String removeAddress(Integer addressId,String key) throws AddressException, LoginException;
	
	public List<Address> viewAlladdress();
	
	public Address viewAddress(Integer id) throws AddressException;
	
}
