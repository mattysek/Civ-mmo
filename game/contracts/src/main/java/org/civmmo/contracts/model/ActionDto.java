package org.civmmo.contracts.model;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

public class ActionDto implements Serializable {
    
	private long id;
	private String name;
	
	private List<CombatModifierDto> combatModifiers;
	private List<UnitTypeDto> aplicableTo;
	
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
	public List<CombatModifierDto> getCombatModifiers() {
		return combatModifiers;
	}
	public void setCombatModifiers(List<CombatModifierDto> combatModifiers) {
		this.combatModifiers = combatModifiers;
	}
	public List<UnitTypeDto> getAplicableTo() {
		return aplicableTo;
	}
	public void setAplicableTo(List<UnitTypeDto> aplicableTo) {
		this.aplicableTo = aplicableTo;
	}
   
}
