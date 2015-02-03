package org.civmmo.model.autogenerate;

import org.civmmo.model.*;
import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;


/**
 * Entity implementation class for Entity: Technology
 *
 */
public class TechnologyImpl extends Technology implements Serializable {

	private long id;
	private String name;
	private long cost;
	
	private List<ResourceImpl> revealsResources;
	private List<BuildingImpl> revealsBuildings;
	private List<UnitTypeImpl> revealsUnits;
	private List<TechnologyImpl> prerequisities;
	private List<CivilizationImpl> knownBy;
	
	private static final long serialVersionUID = 1L;

	public TechnologyImpl() {
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
		this.revealsResources = (List<ResourceImpl>)(List<?>)revealsResources;
	}

	public List<Building> getRevealsBuildings() {
		return new ArrayList<>(revealsBuildings);
	}

	public void setRevealsBuildings(List<Building> revealsBuildings) {
		this.revealsBuildings = (List<BuildingImpl>)(List<?>)revealsBuildings;
	}

	public List<UnitType> getRevealsUnits() {
		return new ArrayList<>(revealsUnits);
	}

	public void setRevealsUnits(List<UnitType> revealsUnits) {
		this.revealsUnits = (List<UnitTypeImpl>)(List<?>)revealsUnits;
	}

	public List<Technology> getPrerequisities() {
		return new ArrayList<>(prerequisities);
	}

	public void setPrerequisities(List<Technology> prerequisities) {
		this.prerequisities = (List<TechnologyImpl>)(List<?>)prerequisities;
	}

	public List<Civilization> getKnownBy() {
		return new ArrayList<>(knownBy);
	}

	public void setKnownBy(List<Civilization> knownBy) {
		this.knownBy = (List<CivilizationImpl>)(List<?>)knownBy;
	}
}
