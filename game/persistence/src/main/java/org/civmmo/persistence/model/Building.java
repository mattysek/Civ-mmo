package org.civmmo.persistence.model;

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
public class Building implements Serializable {

	   
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable=false)
	private String name;
	private int cost;
	private int maintenence;
	private int specialistsSlots;
	
	@ManyToMany
	private List<Technology> requiredTechnologies;
	@ManyToMany
	private List<Resource> requiredResources;
	@ManyToMany
	private List<City> workedBy;
	@OneToMany(mappedBy="currentlyConstructedBuilding")
	private List<City> currentlyConstructedBy;
	
	private static final long serialVersionUID = 1L;

	public Building() {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cost;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + maintenence;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + specialistsSlots;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Building))
			return false;
		Building other = (Building) obj;
		if (cost != other.cost)
			return false;
		if (id != other.id)
			return false;
		if (maintenence != other.maintenence)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (specialistsSlots != other.specialistsSlots)
			return false;
		return true;
	}
   
}
