package com.booking.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.com.domain.UserDomain;
import com.booking.com.entity.User;
import com.booking.com.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	public UserRepository userRepository;
	
	public UserDomain getUserByUsername(String username)
	{  User user= userRepository.findByUsername(username);
		UserDomain userDomain=new UserDomain();
		userDomain.setUsername(user.getUsername());
		userDomain.setPassword(user.getPassword());
		userDomain.setName(user.getName());
		userDomain.setReg_date(user.getReg_date());
		userDomain.setIsEnabled(user.getIsEnabled());
		userDomain.setRoles(user.getRoles());
		
		return userDomain;
	}
	
	public User saveUser(UserDomain user_)
	{
		User user=new User();
		user.setIsEnabled(user_.getIsEnabled());
		user.setName(user_.getName());
		user.setPassword(user_.getPassword());
		user.setUsername(user_.getUsername());
		user.setReg_date(user_.getReg_date());
		user.setRoles(user_.getRoles());
		
		return userRepository.save(user);
		
	}
	

}
