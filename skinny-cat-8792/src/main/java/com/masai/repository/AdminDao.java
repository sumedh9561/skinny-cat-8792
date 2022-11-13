package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Admin;
import com.masai.model.Customer;

public interface AdminDao  extends JpaRepository<Admin, Integer>{
	
	public Admin findByemail(String email);

}