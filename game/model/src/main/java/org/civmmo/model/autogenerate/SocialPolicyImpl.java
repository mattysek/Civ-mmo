package org.civmmo.model.autogenerate;

import org.civmmo.model.*;
import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;


/**
 * Entity implementation class for Entity: SocialPolicy
 *
 */
public class SocialPolicyImpl extends SocialPolicy implements Serializable {

	private long id;
	private String name;
	private int baseCost;
	
	private List<CivilizationImpl> currentlyUsedBy;
	private List<PolicyImpl> policies;
	
	private static final long serialVersionUID = 1L;

	public SocialPolicyImpl() {
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
		this.currentlyUsedBy = (List<CivilizationImpl>)(List<?>)currentlyUsedBy;
	}
	public List<Policy> getPolicies() {
		return new ArrayList<>(policies);
	}
	public void setPolicies(List<Policy> policies) {
		this.policies = (List<PolicyImpl>)(List<?>)policies;
	}
}
