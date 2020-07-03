package com.qa.hwa.persistence.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;



@Entity(name = "stamp_collection")
public class StampCollection {

	@Id
	@GeneratedValue
	private long id;
	
	@Column
	@NotNull
	private String theme;
	
	@Column
	@NotNull
	private double value;
	
	@OneToMany(mappedBy = "collection")
	private List<Stamp> stamp;
	
	public StampCollection() {
		
	}
	
	public StampCollection(String theme, double value) {
		super();
		this.theme= theme;
		this.value = value;
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

	public List<Stamp> getStamp() {
		return stamp;
	}

	public void setStamp(List<Stamp> stamp) {
		this.stamp = stamp;
	}
	
	
	
}
