package org.civmmo.persistence.model;

import org.civmmo.model.*;
import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import org.hibernate.search.annotations.Indexed;

/**
 * Entity implementation class for Entity: Building
 *
 */
@Entity
@Indexed
public class BuildingEntity extends Building implements Serializable {

	   
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable=false)
	private String name;
	private int cost;
	private int maintenence;
	private int specialistsSlots;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Technology> requiredTechnologies;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Resource> requiredResources;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<City> workedBy;
	@OneToMany(mappedBy="currentlyConstructedBuilding", cascade = CascadeType.ALL)
	private List<City> currentlyConstructedBy;
	
	private static final long serialVersionUID = 1L;

	public BuildingEntity() {
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
		return requiredTechnologies;
	}
	public void setRequiredTechnologies(List<Technology> requiredTechnologies) {
		this.requiredTechnologies = requiredTechnologies;
	}
	public List<Resource> getRequiredResources() {
		return requiredResources;
	}
	public void setRequiredResources(List<Resource> requiredResources) {
		this.requiredResources = requiredResources;
	}
	public List<City> getWorkedBy() {
		return workedBy;
	}
	public void setWorkedBy(List<City> workedBy) {
		this.workedBy = workedBy;
	}
	public List<City> getCurrentlyConstructedBy() {
		return currentlyConstructedBy;
	}
	public void setCurrentlyConstructedBy(List<City> currentlyConstructedBy) {
		this.currentlyConstructedBy = currentlyConstructedBy;
	}
	
}
