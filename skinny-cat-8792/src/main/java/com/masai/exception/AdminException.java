package com.masai.exception;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;

public class AdminException extends RuntimeException {
	
	
	public AdminException()
	{
		
	}
	
	public AdminException(String mess)
	{
		super(mess);
	}

}
