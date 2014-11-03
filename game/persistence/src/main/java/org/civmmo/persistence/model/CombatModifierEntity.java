package org.civmmo.persistence.model;

import org.civmmo.model.*;
import java.io.Serializable;

import javax.persistence.*;
import org.hibernate.search.annotations.Indexed;

/**
 * Entity implementation class for Entity: CombatModifier
 *
 */
@Entity
@Indexed
public class CombatModifierEntity extends CombatModifier implements Serializable {

	   
	@Id
	@GeneratedValue
	private long id;
	private double value;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Action afectedAction;
	
	private static final long serialVersionUID = 1L;

	public CombatModifierEntity() {
		super();
	}   
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
	public Action getAfectedAction() {
		return afectedAction;
	}
	public void setAfectedAction(Action afectedAction) {
		this.afectedAction = afectedAction;
	}
}
