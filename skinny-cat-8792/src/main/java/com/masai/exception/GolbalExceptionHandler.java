package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GolbalExceptionHandler {

	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> validatioException(MethodArgumentNotValidException e, WebRequest req)
	{
		
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),"Validation Error", HttpStatus.NON_AUTHORITATIVE_INFORMATION, e.getBindingResult().getFieldError().getDefaultMessage());
         return new ResponseEntity<MyErrorDetails>(err,HttpStatus.NON_AUTHORITATIVE_INFORMATION);
	}
	
	

	@ExceptionHandler(AddressException.class)
	public ResponseEntity<MyErrorDetails> AddressExceptionHandler(AddressException e, WebRequest re)
	{
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setHttpstatus(HttpStatus.BAD_REQUEST);
		err.setDetails(re.getDescription(false));
	
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(AdminException.class)
	public ResponseEntity<MyErrorDetails> AdminxceptionHandler(AdminException e, WebRequest re)
	{
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setHttpstatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		err.setDetails(re.getDescription(false));
	
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		
	}
	
	@ExceptionHandler(CartException.class)
	public ResponseEntity<MyErrorDetails> CartExceptionHandler(CartException e, WebRequest re)
	{
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setHttpstatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		err.setDetails(re.getDescription(false));
	
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		
	}
	
	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<MyErrorDetails> CategoryExceptionHandler(CategoryException e, WebRequest re)
	{
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setHttpstatus(HttpStatus.BAD_REQUEST);
		err.setDetails(re.getDescription(false));
	
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyErrorDetails>CustomerExceptionHandler(CustomerException e, WebRequest re)
	{
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setHttpstatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		err.setDetails(re.getDescription(false));
	
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		
	}
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails> LoginExceptionHandler(LoginException e, WebRequest re)
	{
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setHttpstatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		err.setDetails(re.getDescription(false));
	
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		
	}
	
	@ExceptionHandler(OrderExcetion.class)
	public ResponseEntity<MyErrorDetails> OrderExceptionHandler(OrderExcetion e, WebRequest re)
	{
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setHttpstatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		err.setDetails(re.getDescription(false));
	
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		
	}
	
	
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<MyErrorDetails> ProductExceptionHandler(ProductException e, WebRequest re)
	{
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setHttpstatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		err.setDetails(re.getDescription(false));
	
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		
	}
	  
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> otherexceptio(Exception e, WebRequest re)
	{
  MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setHttpstatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		err.setDetails(re.getDescription(false));
	
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
	
}