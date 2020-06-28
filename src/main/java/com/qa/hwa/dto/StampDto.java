package com.qa.hwa.dto;


public class StampDto {

	private long id;

	private String name;

	private double value;

	private long yearMade;

	
	public StampDto(long id, String name, double value, long yearMade) {
		super();
		this.id =id;
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