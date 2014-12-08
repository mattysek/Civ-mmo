package org.civmmo.persistence.model;

import org.civmmo.model.*;
import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import org.hibernate.search.annotations.Indexed;

/**
 * Entity implementation class for Entity: Promotion
 *
 */
@Entity
@Indexed
public class PromotionEntity extends Promotion implements Serializable {

	   
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable=false)
	private String name;
	
	@OneToMany(mappedBy="affectedPromotion", cascade = CascadeType.ALL)
	private List<UnitTypeEntity> affectedBy;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<UnitEntity> units;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<TechnologyEntity> prerequisities;
	
	private static final long serialVersionUID = 1L;

	public PromotionEntity() {
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
		this.affectedBy = (List<UnitTypeEntity>)(List<?>)affectedBy;
	}
	public List<Unit> getUnits() {
		return new ArrayList<>(units);
	}
	public void setUnits(List<Unit> units) {
		this.units = (List<UnitEntity>)(List<?>)units;
	}
	public List<Technology> getPrerequisities() {
		return new ArrayList<>(prerequisities);
	}
	public void setPrerequisities(List<Technology> prerequisities) {
		this.prerequisities = (List<TechnologyEntity>)(List<?>)prerequisities;
	}
}
