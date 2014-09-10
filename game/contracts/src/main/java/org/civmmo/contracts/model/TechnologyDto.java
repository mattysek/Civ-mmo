package org.civmmo.contracts.model;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

public class TechnologyDto implements Serializable {

	private long id;
	private String name;
	private long cost;
	
	private List<ResourceDto> revealsResources;
	private List<BuildingDto> revealsBuildings;
	private List<UnitTypeDto> revealsUnits;
	private List<TechnologyDto> prerequisities;
	private List<CivilizationDto> knownBy;
	
	private static final long serialVersionUID = 1L;
	    
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

	public List<ResourceDto> getRevealsResources() {
		return revealsResources;
	}

	public void setRevealsResources(List<ResourceDto> revealsResources) {
		this.revealsResources = revealsResources;
	}

	public List<BuildingDto> getRevealsBuildings() {
		return revealsBuildings;
	}

	public void setRevealsBuildings(List<BuildingDto> revealsBuildings) {
		this.revealsBuildings = revealsBuildings;
	}

	public List<UnitTypeDto> getRevealsUnits() {
		return revealsUnits;
	}

	public void setRevealsUnits(List<UnitTypeDto> revealsUnits) {
		this.revealsUnits = revealsUnits;
	}

	public List<TechnologyDto> getPrerequisities() {
		return prerequisities;
	}

	public void setPrerequisities(List<TechnologyDto> prerequisities) {
		this.prerequisities = prerequisities;
	}

	public List<CivilizationDto> getKnownBy() {
		return knownBy;
	}

	public void setKnownBy(List<CivilizationDto> knownBy) {
		this.knownBy = knownBy;
	}
}
