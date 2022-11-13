package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Session;

public interface SessionDao  extends JpaRepository<Session, Integer>{

	
	public Session findByuuid(String uuid);
	
}
