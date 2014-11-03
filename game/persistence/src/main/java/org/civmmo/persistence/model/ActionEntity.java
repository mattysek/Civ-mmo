package org.civmmo.persistence.model;

import org.civmmo.model.*;

import java.io.Serializable;
import java.lang.String;
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
	private List<CombatModifier> combatModifiers;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<UnitType> aplicableTo;
	
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
		return combatModifiers;
	}
	public void setCombatModifiers(List<CombatModifier> combatModifiers) {
		this.combatModifiers = combatModifiers;
	}
	public List<UnitType> getAplicableTo() {
		return aplicableTo;
	}
	public void setAplicableTo(List<UnitType> aplicableTo) {
		this.aplicableTo = aplicableTo;
	}   
}
