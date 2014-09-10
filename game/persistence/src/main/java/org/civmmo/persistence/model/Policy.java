package org.civmmo.persistence.model;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;
import org.hibernate.search.annotations.Indexed;

/**
 * Entity implementation class for Entity: Policy
 *
 */
@Entity
@Indexed
public class Policy implements Serializable {

	@Id
	@GeneratedValue
	private long Id;
	@Column(nullable=false)
	private String name;
	private int cost;
	@ManyToOne(cascade = CascadeType.ALL)
	private SocialPolicy socialPolicy;
	private static final long serialVersionUID = 1L;

	public Policy() {
		super();
	}   
	public long getId() {
		return this.Id;
	}

	public void setId(long Id) {
		this.Id = Id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public int getCost() {
		return this.cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	public SocialPolicy getSocialPolicy() {
		return socialPolicy;
	}
	public void setSocialPolicy(SocialPolicy socialPolicy) {
		this.socialPolicy = socialPolicy;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (Id ^ (Id >>> 32));
		result = prime * result + cost;
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
		if (!(obj instanceof Policy))
			return false;
		Policy other = (Policy) obj;
		if (Id != other.Id)
			return false;
		if (cost != other.cost)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
   
}
