package com.booking.com.domain;

import java.sql.Date;
import java.util.Set;

import com.booking.com.entity.Role;


public class UserDomain {
	public long id;
	public String name;
    public String username;
	public String password;
	public Date reg_date;
	public Boolean isEnabled;
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> set) {
		this.roles = set;
	}
	public Set<Role> roles;
	public Boolean getIsEnabled() {
		return isEnabled;
	}
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

}
