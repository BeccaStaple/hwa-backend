package com.qa.hwa.dto;

import java.util.List;


public class StampCollectionDto {

	private long id;
	
	private double value;
	
	private String theme;
	
	private List<StampDto> stampDto;

	public StampCollectionDto(String theme, double value, List<StampDto> stampDto) {
		super();
		this.value = value;
		this.theme = theme;
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
