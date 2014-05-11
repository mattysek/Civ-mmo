package org.civmmo.contracts.model;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

public class BuildingDto implements Serializable {

	private long id;
	private String name;
	private int cost;
	private int maintenence;
	private int specialistsSlots;
	
	private List<TechnologyDto> requiredTechnologies;
	private List<ResourceDto> requiredResources;
	private List<CityDto> workedBy;
	private List<CityDto> currentlyConstructedBy;
	
	private static final long serialVersionUID = 1L;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public int getCost() {
		return this.cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}   
	public int getMaintenence() {
		return this.maintenence;
	}

	public void setMaintenence(int maintenence) {
		this.maintenence = maintenence;
	}   
	public int getSpecialistsSlots() {
		return this.specialistsSlots;
	}

	public void setSpecialistsSlots(int specialistsSlots) {
		this.specialistsSlots = specialistsSlots;
	}
	public List<TechnologyDto> getRequiredTechnologies() {
		return requiredTechnologies;
	}
	public void setRequiredTechnologies(List<TechnologyDto> requiredTechnologies) {
		this.requiredTechnologies = requiredTechnologies;
	}
	public List<ResourceDto> getRequiredResources() {
		return requiredResources;
	}
	public void setRequiredResources(List<ResourceDto> requiredResources) {
		this.requiredResources = requiredResources;
	}
	public List<CityDto> getWorkedBy() {
		return workedBy;
	}
	public void setWorkedBy(List<CityDto> workedBy) {
		this.workedBy = workedBy;
	}
	public List<CityDto> getCurrentlyConstructedBy() {
		return currentlyConstructedBy;
	}
	public void setCurrentlyConstructedBy(List<CityDto> currentlyConstructedBy) {
		this.currentlyConstructedBy = currentlyConstructedBy;
	}
}
