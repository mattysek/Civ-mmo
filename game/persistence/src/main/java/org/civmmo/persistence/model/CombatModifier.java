package org.civmmo.persistence.model;

import java.io.Serializable;

import javax.persistence.*;
import org.hibernate.search.annotations.Indexed;

/**
 * Entity implementation class for Entity: CombatModifier
 *
 */
@Entity
@Indexed
public class CombatModifier implements Serializable {

	   
	@Id
	@GeneratedValue
	private long id;
	private double value;
	
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.value) ^ (Double.doubleToLongBits(this.value) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CombatModifier other = (CombatModifier) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.value) != Double.doubleToLongBits(other.value)) {
            return false;
        }
        return true;
    }
        
   
}
