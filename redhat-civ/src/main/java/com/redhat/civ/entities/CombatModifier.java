package com.redhat.civ.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CombatModifier
 *
 */
@Entity

public class CombatModifier implements Serializable {

	   
	@Id
	@GeneratedValue
	private long id;
	private float value;
	
	@ManyToOne
	private Action afectedAction;
	
	private static final long serialVersionUID = 1L;

	public CombatModifier() {
		super();
	}   
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public float getValue() {
		return this.value;
	}

	public void setValue(float value) {
		this.value = value;
	}
	public Action getAfectedAction() {
		return afectedAction;
	}
	public void setAfectedAction(Action afectedAction) {
		this.afectedAction = afectedAction;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + Float.floatToIntBits(value);
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CombatModifier))
			return false;
		CombatModifier other = (CombatModifier) obj;
		if (id != other.id)
			return false;
		if (Float.floatToIntBits(value) != Float.floatToIntBits(other.value))
			return false;
		return true;
	}
   
}
