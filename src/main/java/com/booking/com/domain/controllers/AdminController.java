package com.booking.com.domain.controllers;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.booking.com.domain.UserDomain;
import com.booking.com.entity.Role;
import com.booking.com.service.RoleService;
import com.booking.com.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	final String apikey="JP33oPyyr33nQ6z91UyPVCJcedraydUGpTg";
	final String registered_mobile="7840066333";
	
	
	
	  @RequestMapping(value="/home",method=RequestMethod.GET)
		public String homePageAdmin(Model model)
		{
		  System.out.println("received");
	    	
	     return "admin/index";
		}
	    
	    @RequestMapping(value="/accounts",method=RequestMethod.GET)
		public String userRegistrationPageAdmin(Model model)
		{
	    	
	     return "admin/accounts";
		}
	    
	
	    @RequestMapping(value="/recharges",method=RequestMethod.GET)
			public String rechargePageAdmin(Model model)
			{
		    	
		     return "admin/recharges";
			}
		    
	    
	  
	  /**
	   * POST CONTROLLERS  
	   */
	    
	    
	    
	    @RequestMapping(value="/user",method=RequestMethod.POST)
		public String registerUser(@RequestParam Optional<String> pan,@RequestParam Optional<String> gst,@RequestParam Optional<Long> mobile,@RequestParam Optional<String> address,@RequestParam Optional<String> email, @RequestParam Optional<Boolean> isEnabled,@RequestParam Optional<String> username,@RequestParam Optional<String> password,@RequestParam Optional<String> name,@RequestParam Optional<String> role)
		{
			UserDomain user=new UserDomain();
			user.setIsEnabled(isEnabled.orElseGet(()->true));
			user.setName(name.orElseGet(()->"demo"));
			user.setUsername(username.orElseGet(()->"user"));
			String pass=password.orElseGet(()->"1234");
			String role_=role.orElseGet(()->"user");
			Set<Role> set=new HashSet();
			set.add(roleService.getRoleByRoleName(role_));
			user.setPassword(bCryptPasswordEncoder.encode(pass));
			user.setRoles(set);
			java.sql.Date reg_date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			user.setReg_date(reg_date);
			userService.saveUser(user);
			
			
			
			return "User Saved";
			
		}
		
	    
	    /**
	     * Checking Api Balance 
	     * @return
	     */
	    
	    
	    @RequestMapping(value="/checkbalance",method=RequestMethod.GET)
	    @ResponseBody
		public String checkApiBalance()
		{
	    	final String uri = "https://www.pay2u.in/Pay2UAPI/RechargeAPI.aspx?MobileNo=7840066333&APIKey=JP33oPyyr33nQ6z91UyPVCJcedraydUGpTg&REQTYPE=BAL&RESPTYPE=JSON";
	        
	    	 RestTemplate restTemplate = new RestTemplate();
	    	    String result = restTemplate.getForObject(uri, String.class);
	    	     
	    	    System.out.println(result);
			
			
			return result;
			
		}
	    
	    
	/*
	 * Mobile Recharged
	 * */
	
	    @RequestMapping(value="/mobileRecharge",method=RequestMethod.POST)
	    @ResponseBody
		public String mobileRecharge(@RequestParam Optional<Long> mobilenumber,@RequestParam Optional<String> servicecode,@RequestParam Optional<Integer> amount,@RequestParam Optional<Integer> stv)
		{
//final String uri = "https://www.pay2u.in/Pay2UAPI/RechargeAPI.aspx? MobileNo="+[MobileNo]+"&APIKey="+[APIKey]+"&REQTYPE=RECH&REFNO="+[REFNO]+"& SERCODE="+[ServiceCode]+"&CUSTNO="+[ConsumerNo]+"&REFMOBILENO="+[CustomerMo bileNo]&AMT=[AMOUNT]&STV=[IsSTV]&RESPTYPE=JSON";
	        
	    	 RestTemplate restTemplate = new RestTemplate();
	    	    //String result = restTemplate.getForObject(uri, String.class);
	    	     
	    	    //System.out.println(result);
			
			
			return "";
			
		}
	    
	    
}
