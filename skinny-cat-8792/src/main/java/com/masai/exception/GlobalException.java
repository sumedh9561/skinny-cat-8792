package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;





@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> validationException(MethodArgumentNotValidException me){
		
		ErrorDetails ed = new ErrorDetails();
		ed.setTimeStamp(LocalDateTime.now());
		ed.setMessage("Validation Error");
		ed.setDescription(me.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<ErrorDetails> customerException(CustomerException ce, WebRequest we){
		
		ErrorDetails ed = new ErrorDetails();
		
		ed.setTimeStamp(LocalDateTime.now());
		ed.setMessage(ce.getMessage());
		ed.setDescription(we.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> otherException(Exception e,WebRequest we){
		
		ErrorDetails ed = new ErrorDetails();
		
		ed.setTimeStamp(LocalDateTime.now());
		ed.setMessage(e.getMessage());
		ed.setDescription(we.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
		
	}
	
	

}
