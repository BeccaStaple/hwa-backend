package com.qa.hwa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.NotNull;



@Entity(name = "stamp_collection")
public class StampCollection {

	@Id
	@GeneratedValue
	private long id;
	
	@Column
	@NotNull
	private double value;
	
	@Column
	@NotNull
	private String theme;
	
	public StampCollection() {
		
	}
	
	public StampCollection(double value, String theme) {
		super();
		this.value = value;
		this.theme= theme;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	
	
}
