package org.civmmo.persistence.model;

import org.civmmo.model.*;
import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
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
	private List<ResourceEntity> revealsResources;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<BuildingEntity> revealsBuildings;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<UnitTypeEntity> revealsUnits;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<TechnologyEntity> prerequisities;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<CivilizationEntity> knownBy;
	
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
		return new ArrayList<>(revealsResources);
	}

	public void setRevealsResources(List<Resource> revealsResources) {
		this.revealsResources = (List<ResourceEntity>)(List<?>)revealsResources;
	}

	public List<Building> getRevealsBuildings() {
		return new ArrayList<>(revealsBuildings);
	}

	public void setRevealsBuildings(List<Building> revealsBuildings) {
		this.revealsBuildings = (List<BuildingEntity>)(List<?>)revealsBuildings;
	}

	public List<UnitType> getRevealsUnits() {
		return new ArrayList<>(revealsUnits);
	}

	public void setRevealsUnits(List<UnitType> revealsUnits) {
		this.revealsUnits = (List<UnitTypeEntity>)(List<?>)revealsUnits;
	}

	public List<Technology> getPrerequisities() {
		return new ArrayList<>(prerequisities);
	}

	public void setPrerequisities(List<Technology> prerequisities) {
		this.prerequisities = (List<TechnologyEntity>)(List<?>)prerequisities;
	}

	public List<Civilization> getKnownBy() {
		return new ArrayList<>(knownBy);
	}

	public void setKnownBy(List<Civilization> knownBy) {
		this.knownBy = (List<CivilizationEntity>)(List<?>)knownBy;
	}
}
