package com.qa.hwa.dto;


public class StampDto {

	private long id;

	private String name;

	private double value;

	private long yearMade;
	
	private long collectionId;
	
	public StampDto() {
		
	}

	
	public StampDto(long id, String name, double value, long yearMade, long collectionId) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.yearMade = yearMade;
		this.collectionId = collectionId;

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


	public long getCollectionId() {
		return collectionId;
	}


	public void setCollectionId(long collectionId) {
		this.collectionId = collectionId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (collectionId ^ (collectionId >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (yearMade ^ (yearMade >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StampDto other = (StampDto) obj;
		if (collectionId != other.collectionId)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		if (yearMade != other.yearMade)
			return false;
		return true;
	}






}
