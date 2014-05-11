package org.civmmo.contracts.model;

import java.io.Serializable;
import java.lang.String;

public class PolicyDto implements Serializable {

	private long Id;
	private String name;
	private int cost;
        
	private SocialPolicyDto socialPolicy;
        
	private static final long serialVersionUID = 1L;

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
	public SocialPolicyDto getSocialPolicy() {
		return socialPolicy;
	}
	public void setSocialPolicy(SocialPolicyDto socialPolicy) {
		this.socialPolicy = socialPolicy;
	}
}
