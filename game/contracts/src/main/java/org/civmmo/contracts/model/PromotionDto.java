package org.civmmo.contracts.model;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

public class PromotionDto implements Serializable {

	private long id;
	private String name;
	
	private List<UnitTypeDto> affectedBy;
	private List<UnitDto> units;
	private List<TechnologyDto> prerequisities;
	
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
	public List<UnitTypeDto> getAffectedBy() {
		return affectedBy;
	}
	public void setAffectedBy(List<UnitTypeDto> affectedBy) {
		this.affectedBy = affectedBy;
	}
	public List<UnitDto> getUnits() {
		return units;
	}
	public void setUnits(List<UnitDto> units) {
		this.units = units;
	}
	public List<TechnologyDto> getPrerequisities() {
		return prerequisities;
	}
	public void setPrerequisities(List<TechnologyDto> prerequisities) {
		this.prerequisities = prerequisities;
	}
}
