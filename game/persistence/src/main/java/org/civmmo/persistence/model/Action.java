package org.civmmo.persistence.model;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Action
 *
 */
@Entity
public class Action implements Serializable {
	
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable=false)
	private String name;
	
	@OneToMany(mappedBy="afectedAction")
	private List<CombatModifier> combatModifiers;
	@ManyToMany
	private List<Unit> aplicableTo;
	
	private static final long serialVersionUID = 1L;

	public Action() {
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
	public List<Unit> getAplicableTo() {
		return aplicableTo;
	}
	public void setAplicableTo(List<Unit> aplicableTo) {
		this.aplicableTo = aplicableTo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (!(obj instanceof Action))
			return false;
		Action other = (Action) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
   
}
