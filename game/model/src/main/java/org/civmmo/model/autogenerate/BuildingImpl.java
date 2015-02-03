package org.civmmo.model.autogenerate;

import org.civmmo.model.*;
import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity implementation class for Entity: Building
 *
 */
public class BuildingImpl extends Building implements Serializable {

	   
	private long id;
	private String name;
	private int cost;
	private int maintenence;
	private int specialistsSlots;
	
	private List<TechnologyImpl> requiredTechnologies;
	private List<ResourceImpl> requiredResources;
	private List<CityImpl> workedBy;
	private List<CityImpl> currentlyConstructedBy;
	
	private static final long serialVersionUID = 1L;

	public BuildingImpl() {
		super();
	}   
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
	public List<Technology> getRequiredTechnologies() {
		return new ArrayList<>(requiredTechnologies);
	}
	public void setRequiredTechnologies(List<Technology> requiredTechnologies) {
		this.requiredTechnologies = (List<TechnologyImpl>)(List<?>)requiredTechnologies;
	}
	public List<Resource> getRequiredResources() {
		return new ArrayList<>(requiredResources);
	}
	public void setRequiredResources(List<Resource> requiredResources) {
		this.requiredResources = (List<ResourceImpl>)(List<?>)requiredResources;
	}
	public List<City> getWorkedBy() {
		return new ArrayList<>(workedBy);
	}
	public void setWorkedBy(List<City> workedBy) {
		this.workedBy = (List<CityImpl>)(List<?>)workedBy;
	}
	public List<City> getCurrentlyConstructedBy() {
		return new ArrayList<>(currentlyConstructedBy);
	}
	public void setCurrentlyConstructedBy(List<City> currentlyConstructedBy) {
		this.currentlyConstructedBy = (List<CityImpl>)(List<?>)currentlyConstructedBy;
	}
	
}
