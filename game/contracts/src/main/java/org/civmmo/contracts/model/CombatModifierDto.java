package org.civmmo.contracts.model;

import java.io.Serializable;

public class CombatModifierDto implements Serializable {

	private long id;
	private double value;
        
	private ActionDto afectedAction;
	
	private static final long serialVersionUID = 1L;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	public ActionDto getAfectedAction() {
		return afectedAction;
	}
	public void setAfectedAction(ActionDto afectedAction) {
		this.afectedAction = afectedAction;
	}
}
