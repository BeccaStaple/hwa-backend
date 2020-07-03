package com.qa.hwa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;



@Entity(name = "stamp")
public class Stamp {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "name", length = 60)
	@NotNull
	private String name;
	
	@Column(name = "value")
	@NotNull
	private double value;
	
	@Column(name = "yearMade")
	@NotNull
	private long yearMade;
	


	@ManyToOne(targetEntity = StampCollection.class)
	private StampCollection collection;
	
	
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
	
	public StampCollection getCollection() {
		return collection;
	}

	public void setCollection(StampCollection collection) {
		this.collection = collection;
	}
	
}
