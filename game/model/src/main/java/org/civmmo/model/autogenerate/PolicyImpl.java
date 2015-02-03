package org.civmmo.model.autogenerate;

import org.civmmo.model.*;
import java.io.Serializable;
import java.lang.String;

/**
 * Entity implementation class for Entity: Policy
 *
 */
public class PolicyImpl extends Policy implements Serializable {

	private long Id;
	private String name;
	private int cost;
	private SocialPolicyImpl socialPolicy;
	private static final long serialVersionUID = 1L;

	public PolicyImpl() {
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
		this.socialPolicy = (SocialPolicyImpl)socialPolicy;
	}
}
