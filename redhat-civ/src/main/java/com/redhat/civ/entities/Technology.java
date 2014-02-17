package com.redhat.civ.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Technology
 *
 */
@Entity

public class Technology implements Serializable {

	@Id
	@GeneratedValue
	private long id;
	@Column(nullable=false)
	private String name;
	private long cost;
	
	@OneToMany(mappedBy="revealedBy")
	private List<Resource> revealsResources;
	@ManyToMany
	private List<Building> revealsBuildings;
	@ManyToMany
	private List<Unit> revealsUnits;
	@ManyToMany
	private List<Technology> prerequisities;
	@ManyToMany
	private List<Civilization> knownBy;
	
	private static final long serialVersionUID = 1L;

	public Technology() {
		super();
	}   
	    
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public long getCost() {
		return this.cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Resource> getRevealsResources() {
		return revealsResources;
	}

	public void setRevealsResources(List<Resource> revealsResources) {
		this.revealsResources = revealsResources;
	}

	public List<Building> getRevealsBuildings() {
		return revealsBuildings;
	}

	public void setRevealsBuildings(List<Building> revealsBuildings) {
		this.revealsBuildings = revealsBuildings;
	}

	public List<Unit> getRevealsUnits() {
		return revealsUnits;
	}

	public void setRevealsUnits(List<Unit> revealsUnits) {
		this.revealsUnits = revealsUnits;
	}

	public List<Technology> getPrerequisities() {
		return prerequisities;
	}

	public void setPrerequisities(List<Technology> prerequisities) {
		this.prerequisities = prerequisities;
	}

	public List<Civilization> getKnownBy() {
		return knownBy;
	}

	public void setKnownBy(List<Civilization> knownBy) {
		this.knownBy = knownBy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cost ^ (cost >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Technology))
			return false;
		Technology other = (Technology) obj;
		if (cost != other.cost)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
   
}
