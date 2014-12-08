package org.civmmo.persistence.model;

import org.civmmo.model.*;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import org.hibernate.search.annotations.Indexed;

/**
 * Entity implementation class for Entity: Action
 *
 */
@Entity
@Indexed
public class ActionEntity extends Action implements Serializable {
	
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable=false)
	private String name;
	
	@OneToMany(mappedBy="afectedAction", cascade = CascadeType.ALL)
	private List<CombatModifierEntity> combatModifiers;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<UnitTypeEntity> aplicableTo;
	
	private static final long serialVersionUID = 1L;

	public ActionEntity() {
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
	public List<CombatModifier> getCombatModifiers() {
		return new ArrayList<>(combatModifiers);
	}
	public void setCombatModifiers(List<CombatModifier> combatModifiers) {
		this.combatModifiers = (List<CombatModifierEntity>)(List<?>)combatModifiers;
	}
	public List<UnitType> getAplicableTo() {
		return new ArrayList<>(aplicableTo);
	}
	public void setAplicableTo(List<UnitType> aplicableTo) {
		this.aplicableTo = (List<UnitTypeEntity>)(List<?>)aplicableTo;
	}   
}
