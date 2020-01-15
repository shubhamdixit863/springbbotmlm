package com.booking.com.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Users")
public class User {
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(name="NAME")
	private String name;
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	@Column(name="username" ,unique = true)
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="user_registration_date")
	private Date reg_date;
	@Column(name="is_Enabled")
	private Boolean isEnabled;
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
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
