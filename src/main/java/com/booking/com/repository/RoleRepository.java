package com.booking.com.repository;

import org.springframework.data.repository.CrudRepository;

import com.booking.com.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	
	public Role findByName(String name);

}
