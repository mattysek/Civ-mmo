package org.civmmo.contracts.model;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

public class SocialPolicyDto implements Serializable {

	private Long id;
	private String name;
	private int baseCost;
	
	private List<CivilizationDto> currentlyUsedBy;
	private List<PolicyDto> policies;
	
	private static final long serialVersionUID = 1L;

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
	public List<CivilizationDto> getCurrentlyUsedBy() {
		return currentlyUsedBy;
	}
	public void setCurrentlyUsedBy(List<CivilizationDto> currentlyUsedBy) {
		this.currentlyUsedBy = currentlyUsedBy;
	}
	public List<PolicyDto> getPolicies() {
		return policies;
	}
	public void setPolicies(List<PolicyDto> policies) {
		this.policies = policies;
	}
}
