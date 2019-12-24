package com.softtek.academia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class City {

	@Id
	@Column(name="city_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long city_id;
	
	private String description;
	
	@ManyToOne()
	@JoinColumn(name="state_id", nullable = false)
	private State state;

	public long getCity_id() {
		return city_id;
	}

	public void setCity_id(long city_id) {
		this.city_id = city_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "City [city_id=" + city_id + ", description=" + description + ", state=" + state + "]";
	}
	
	

	
	
}
