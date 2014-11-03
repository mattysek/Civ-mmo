package org.civmmo.persistence.model;

import org.civmmo.model.*;
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
public class PolicyEntity extends Policy implements Serializable {

	@Id
	@GeneratedValue
	private long Id;
	@Column(nullable=false)
	private String name;
	private int cost;
	@ManyToOne(cascade = CascadeType.ALL)
	private SocialPolicy socialPolicy;
	private static final long serialVersionUID = 1L;

	public PolicyEntity() {
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
}
