package org.civmmo.persistence.model;

import org.civmmo.model.*;
import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import org.hibernate.search.annotations.Indexed;

/**
 * Entity implementation class for Entity: Technology
 *
 */
@Entity
@Indexed
public class TechnologyEntity extends Technology implements Serializable {

	@Id
	@GeneratedValue
	private long id;
	@Column(nullable=false)
	private String name;
	private long cost;
	
	@OneToMany(mappedBy="revealedBy", cascade = CascadeType.ALL)
	private List<Resource> revealsResources;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Building> revealsBuildings;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<UnitType> revealsUnits;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Technology> prerequisities;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Civilization> knownBy;
	
	private static final long serialVersionUID = 1L;

	public TechnologyEntity() {
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

	public List<UnitType> getRevealsUnits() {
		return revealsUnits;
	}

	public void setRevealsUnits(List<UnitType> revealsUnits) {
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
}
