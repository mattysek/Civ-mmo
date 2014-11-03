package org.civmmo.persistence.model;

import org.civmmo.model.*;
import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import org.hibernate.search.annotations.Indexed;

/**
 * Entity implementation class for Entity: UnitType
 *
 */
@Entity
@Indexed
public class UnitTypeEntity extends UnitType implements Serializable {

	   
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable=false)
	private String name;
	
        @ManyToMany(cascade = CascadeType.ALL)
	private List<Action> actions;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Unit> units;
	@ManyToOne(cascade = CascadeType.ALL)
	private Promotion affectedPromotion;
	
	private static final long serialVersionUID = 1L;

	public UnitTypeEntity() {
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
	public List<Unit> getUnits() {
		return units;
	}
	public void setUnits(List<Unit> units) {
		this.units = units;
	}
	public Promotion getAffectedPromotion() {
		return affectedPromotion;
	}
	public void setAffectedPromotion(Promotion affectedPromotion) {
		this.affectedPromotion = affectedPromotion;
	}
        public List<Action> getActions() {
		return actions;
	}
	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
}
