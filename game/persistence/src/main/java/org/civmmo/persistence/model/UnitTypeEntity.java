package org.civmmo.persistence.model;

import org.civmmo.model.*;
import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
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
	private List<ActionEntity> actions;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<UnitEntity> units;
	@ManyToOne(cascade = CascadeType.ALL)
	private PromotionEntity affectedPromotion;
	
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
		return new ArrayList<>(units);
	}
	public void setUnits(List<Unit> units) {
		this.units = (List<UnitEntity>)(List<?>)units;
	}
	public Promotion getAffectedPromotion() {
		return affectedPromotion;
	}
	public void setAffectedPromotion(Promotion affectedPromotion) {
		this.affectedPromotion = (PromotionEntity)affectedPromotion;
	}
        public List<Action> getActions() {
		return new ArrayList<>(actions);
	}
	public void setActions(List<Action> actions) {
		this.actions = (List<ActionEntity>)(List<?>)actions;
	}
}
