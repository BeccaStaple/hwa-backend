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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((stamp == null) ? 0 : stamp.hashCode());
		result = prime * result + ((theme == null) ? 0 : theme.hashCode());
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		StampCollection other = (StampCollection) obj;
		if (id != other.id)
			return false;
		if (stamp == null) {
			if (other.stamp != null)
				return false;
		} else if (!stamp.equals(other.stamp))
			return false;
		if (theme == null) {
			if (other.theme != null)
				return false;
		} else if (!theme.equals(other.theme))
			return false;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		return true;
	}
	
	
	
}
