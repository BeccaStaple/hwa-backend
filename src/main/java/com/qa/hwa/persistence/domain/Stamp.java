package com.qa.hwa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.NotNull;



@Entity(name = "stamp")
public class Stamp {

	@Id
	@GeneratedValue
	private long id;
	
	//need to work out how to add collection id and connect
	
	@Column(name = "name", length = 60)
	@NotNull
	private String name;
	
	@Column(name = "value")
	@NotNull
	private double value;
	
	@Column(name = "yearMade")
	@NotNull
	private long yearMade;
	
	
	
	public Stamp() {
		
	}
	
	public Stamp(String name, double value, long yearMade) {
		super();
		this.name = name;
		this.value = value;
		this.yearMade = yearMade;
	}

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public long getYearMade() {
		return yearMade;
	}

	public void setYearMade(long yearMade) {
		this.yearMade = yearMade;
	}
	
	
	
}