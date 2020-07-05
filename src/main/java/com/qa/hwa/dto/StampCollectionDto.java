package com.qa.hwa.dto;




public class StampCollectionDto {

	private long id;
	
	private String theme;
	
	private double value;
	
	public StampCollectionDto() {
		
	}

	public StampCollectionDto(long id, String theme, double value) {
		super();
		this.id = id;
		this.theme = theme;
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


	
	
}
