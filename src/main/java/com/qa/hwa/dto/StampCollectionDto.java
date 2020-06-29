package com.qa.hwa.dto;

import java.util.List;


public class StampCollectionDto {

	private long id;
	
	private String theme;
	
	private double value;
	
	private List<StampDto> stampDto;
	
	public StampCollectionDto() {
		
	}

	public StampCollectionDto(long id, String theme, double value, List<StampDto> stampDto) {
		super();
		this.id = id;
		this.theme = theme;
		this.value = value;
		this.stampDto = stampDto;
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

	public List<StampDto> getStamp() {
		return stampDto;
	}

	public void setStamp(List<StampDto> stampDto) {
		this.stampDto = stampDto;
	}
	
	
}
