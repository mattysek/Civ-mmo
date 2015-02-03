package org.civmmo.model.autogenerate;

import org.civmmo.model.*;
import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity implementation class for Entity: Promotion
 *
 */
public class PromotionImpl extends Promotion implements Serializable {

	private long id;
	private String name;
	
	private List<UnitTypeImpl> affectedBy;
	private List<UnitImpl> units;
	private List<TechnologyImpl> prerequisities;
	
	private static final long serialVersionUID = 1L;

	public PromotionImpl() {
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
	public List<UnitType> getAffectedBy() {
		return new ArrayList<>(affectedBy);
	}
	public void setAffectedBy(List<UnitType> affectedBy) {
		this.affectedBy = (List<UnitTypeImpl>)(List<?>)affectedBy;
	}
	public List<Unit> getUnits() {
		return new ArrayList<>(units);
	}
	public void setUnits(List<Unit> units) {
		this.units = (List<UnitImpl>)(List<?>)units;
	}
	public List<Technology> getPrerequisities() {
		return new ArrayList<>(prerequisities);
	}
	public void setPrerequisities(List<Technology> prerequisities) {
		this.prerequisities = (List<TechnologyImpl>)(List<?>)prerequisities;
	}
}
