package com.softtek.academia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "state")
public class State {

	@Id 
	@Column(name = "state_id")
	private long state_id;
	
//	@Column(name = "description" )
	private String description;
	
//	@Column(name = "shipping_zone_id")
	private String shipping_zone_id;

	
	public long getState_id() {
		return state_id;
	}


	public void setState_id(long state_id) {
		this.state_id = state_id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getShipping_zone_id() {
		return shipping_zone_id;
	}


	public void setShipping_zone_id(String shipping_zone_id) {
		this.shipping_zone_id = shipping_zone_id;
	}


	@Override
	public String toString() {
		return "State [ state_id =" + state_id + ", description =" + description + ", shipping_zone_id =" + shipping_zone_id
				+ " ]";
	}
	
	
}
