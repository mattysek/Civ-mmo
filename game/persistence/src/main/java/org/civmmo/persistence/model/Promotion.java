package org.civmmo.persistence.model;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import org.hibernate.search.annotations.Indexed;

/**
 * Entity implementation class for Entity: Promotion
 *
 */
@Entity
@Indexed
public class Promotion implements Serializable {

	   
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable=false)
	private String name;
	
	@OneToMany(mappedBy="affectedPromotion")
	private List<UnitType> affectedBy;
	@ManyToMany
	private List<Unit> units;
	@ManyToMany
	private List<Technology> prerequisities;
	
	private static final long serialVersionUID = 1L;

	public Promotion() {
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
	public List<UnitType> getAffectedBy() {
		return affectedBy;
	}
	public void setAffectedBy(List<UnitType> affectedBy) {
		this.affectedBy = affectedBy;
	}
	public List<Unit> getUnits() {
		return units;
	}
	public void setUnits(List<Unit> units) {
		this.units = units;
	}
	public List<Technology> getPrerequisities() {
		return prerequisities;
	}
	public void setPrerequisities(List<Technology> prerequisities) {
		this.prerequisities = prerequisities;
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
		if (!(obj instanceof Promotion))
			return false;
		Promotion other = (Promotion) obj;
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
