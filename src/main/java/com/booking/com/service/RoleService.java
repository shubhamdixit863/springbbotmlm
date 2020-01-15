package com.booking.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.com.entity.Role;
import com.booking.com.repository.RoleRepository;
@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	public Role getRoleByRoleName(String role)
	{
	 	return roleRepository.findByName(role);
	}

}
