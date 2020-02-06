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
import org.springframework.web.bind.annotation.RestController;

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
	    
	
	
	

}
