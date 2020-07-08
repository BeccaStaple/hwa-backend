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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((collection == null) ? 0 : collection.hashCode());
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
		Stamp other = (Stamp) obj;
		if (collection == null) {
			if (other.collection != null)
				return false;
		} else if (!collection.equals(other.collection))
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
