package com.redhat.civ.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: SocialPolicy
 *
 */
@Entity

public class SocialPolicy implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String name;
	private int baseCost;
	
	@OneToMany(mappedBy="currentPolicy")
	private List<Civilization> currentlyUsedBy;
	@OneToMany(mappedBy="socialPolicy")
	private List<Policy> policies;
	
	private static final long serialVersionUID = 1L;

	public SocialPolicy() {
		super();
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public int getBaseCost() {
		return this.baseCost;
	}

	public void setBaseCost(int baseCost) {
		this.baseCost = baseCost;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Civilization> getCurrentlyUsedBy() {
		return currentlyUsedBy;
	}
	public void setCurrentlyUsedBy(List<Civilization> currentlyUsedBy) {
		this.currentlyUsedBy = currentlyUsedBy;
	}
	public List<Policy> getPolicies() {
		return policies;
	}
	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + baseCost;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (!(obj instanceof SocialPolicy))
			return false;
		SocialPolicy other = (SocialPolicy) obj;
		if (baseCost != other.baseCost)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
   
}
