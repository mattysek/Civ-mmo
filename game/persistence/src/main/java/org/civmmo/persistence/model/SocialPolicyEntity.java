package org.civmmo.persistence.model;

import org.civmmo.model.*;
import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import org.hibernate.search.annotations.Indexed;

/**
 * Entity implementation class for Entity: SocialPolicy
 *
 */
@Entity
@Indexed
public class SocialPolicyEntity extends SocialPolicy implements Serializable {

	@Id
	@GeneratedValue
	private long id;
	@Column(nullable=false)
	private String name;
	private int baseCost;
	
	@OneToMany(mappedBy="currentPolicy", cascade = CascadeType.ALL)
	private List<CivilizationEntity> currentlyUsedBy;
	@OneToMany(mappedBy="socialPolicy", cascade = CascadeType.ALL)
	private List<PolicyEntity> policies;
	
	private static final long serialVersionUID = 1L;

	public SocialPolicyEntity() {
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Civilization> getCurrentlyUsedBy() {
		return new ArrayList<>(currentlyUsedBy);
	}
	public void setCurrentlyUsedBy(List<Civilization> currentlyUsedBy) {
		this.currentlyUsedBy = (List<CivilizationEntity>)(List<?>)currentlyUsedBy;
	}
	public List<Policy> getPolicies() {
		return new ArrayList<>(policies);
	}
	public void setPolicies(List<Policy> policies) {
		this.policies = (List<PolicyEntity>)(List<?>)policies;
	}
}
