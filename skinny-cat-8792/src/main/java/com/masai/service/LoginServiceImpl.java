package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.model.Admin;
import com.masai.model.Customer;
import com.masai.model.Login;
import com.masai.model.Session;
import com.masai.repository.AdminDao;
import com.masai.repository.CustomerDao;
import com.masai.repository.SessionDao;

import net.bytebuddy.utility.RandomString;
@Service
public class LoginServiceImpl  implements LoginService{

	
	 
	@Autowired
	private CustomerDao cus;
	
	@Autowired
	private SessionDao ses;
	
	
	@Autowired
	private AdminDao ad;
	
	@Override
	public String logIntoAccount(Login dto) throws LoginException {
		// TODO Auto-generated method stub
		
		  if(dto.getRoll().equalsIgnoreCase("admin"))
		  {
			  Admin ads  = ad.findByemail(dto.getEmail());
			  
			  if(ads == null)
			  {
				  throw new LoginException("OOps Login failed Pleas try again");
			  }
			  
			  Optional<Session> validCustomerSessionOpt =  ses.findById(ads.getAdminId());
			  
			  if(validCustomerSessionOpt.isPresent()) {
					
					throw new LoginException("User already Logged In with this number");
					
				}
			  
			  
			     if(ads.getPassword().equals(dto.getPassword()))
			     {
			    	 String key= RandomString.make(6);
			    	 
			    	 Session ss = new Session(ads.getAdminId(), key, LocalDateTime.now());
			    	 
			    	 ses.save(ss);
			    	 return ss.toString();
			     }
			     else
			     {
			    	 throw new LoginException("Please Enter a valid password");
			     }
			  
			      
			  
		  }
		  else
		  {
			  Customer existingCustomer=  cus.findByemail(dto.getEmail());
			  
			  
			  if(existingCustomer == null) {
					
					throw new LoginException("Please Enter a valid email  and password");
					
					 
				}
			  
			  
			  Optional<Session> validCustomerSessionOpt =  ses.findById(existingCustomer.getCustomerId());
			  
			  
			  if(validCustomerSessionOpt.isPresent()) {
					
					throw new LoginException("User already Logged In with this number");
					
				}
			  
			  
			  if(existingCustomer.getPassword().equals(dto.getPassword())) {
					
					String key= RandomString.make(6);
					
					
					
					Session currentUserSession = new Session(existingCustomer.getCustomerId(),key,LocalDateTime.now());
					
					ses.save(currentUserSession);

					return currentUserSession.toString();
				}
			  else
			  {
				  throw new LoginException("Pleas enter the valid email or password");
			  }
			  
		  }
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {
		// TODO Auto-generated method stub
		Session validCustomerSession = ses.findByuuid(key);
		if(validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
ses.delete(validCustomerSession);
		
		
		return "Logged Out !";
	}
	
	
	

}
