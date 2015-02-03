package org.civmmo.model.autogenerate;

import org.civmmo.model.*;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import uk.co.jemos.podam.common.PodamCollection;


/**
 * Entity implementation class for Entity: Action
 *
 */
public class ActionImpl extends Action implements Serializable {
	
	private long id;
	private String name;
	
	private List<CombatModifierImpl> combatModifiers;
	private List<UnitTypeImpl> aplicableTo;
	
	private static final long serialVersionUID = 1L;

	public ActionImpl() {
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
		this.combatModifiers = (List<CombatModifierImpl>)(List<?>)combatModifiers;
	}
	public List<UnitType> getAplicableTo() {
		return new ArrayList<>(aplicableTo);
	}
	public void setAplicableTo(List<UnitType> aplicableTo) {
		this.aplicableTo = (List<UnitTypeImpl>)(List<?>)aplicableTo;
	}   
}
