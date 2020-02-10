package com.booking.com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Recharges")
public class Recharges {
	
	@Id
	@Column(name="recharge_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	

}
