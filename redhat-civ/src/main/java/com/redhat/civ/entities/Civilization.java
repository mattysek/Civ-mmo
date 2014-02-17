package com.redhat.civ.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Civilization
 *
 */
@Entity

public class Civilization implements Serializable {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private long gold;
	private long culture;
	private long science;
	private float happiness;
	@ManyToOne
	private SocialPolicy currentPolicy;
	@ManyToOne
	private Technology currentlyStudiedTechnology;
	@ManyToMany
	private List<Civilization> enemies;
	@ManyToMany
	private List<Civilization> allies;
	@ManyToMany
	private List<SocialPolicy> availableSocialPolicies;
	@ManyToMany
	private List<Policy> unlockedPolicies;
	@ManyToMany
	private List<Technology> knownTechnologies;
	@OneToMany(mappedBy="ownedBy")
	private List<City> cities;
	@OneToMany(mappedBy="ownedBy")
	private List<Unit> units;
	
	private static final long serialVersionUID = 1L;

	public Civilization() {
		super();
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public long getGold() {
		return this.gold;
	}

	public void setGold(long gold) {
		this.gold = gold;
	}   
	public long getCulture() {
		return this.culture;
	}

	public void setCulture(long culture) {
		this.culture = culture;
	}   
	public long getScience() {
		return this.science;
	}

	public void setScience(long science) {
		this.science = science;
	}   
	public float getHappiness() {
		return this.happiness;
	}

	public void setHappiness(float happiness) {
		this.happiness = happiness;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public SocialPolicy getCurrentPolicy() {
		return currentPolicy;
	}
	public void setCurrentPolicy(SocialPolicy currentPolicy) {
		this.currentPolicy = currentPolicy;
	}
	public Technology getCurrentlyStudiedTechnology() {
		return currentlyStudiedTechnology;
	}
	public void setCurrentlyStudiedTechnology(Technology currentlyStudiedTechnology) {
		this.currentlyStudiedTechnology = currentlyStudiedTechnology;
	}
	public List<Civilization> getEnemies() {
		return enemies;
	}
	public void setEnemies(List<Civilization> enemies) {
		this.enemies = enemies;
	}
	public List<Civilization> getAllies() {
		return allies;
	}
	public void setAllies(List<Civilization> allies) {
		this.allies = allies;
	}
	public List<SocialPolicy> getAvailableSocialPolicies() {
		return availableSocialPolicies;
	}
	public void setAvailableSocialPolicies(
			List<SocialPolicy> availableSocialPolicies) {
		this.availableSocialPolicies = availableSocialPolicies;
	}
	public List<Policy> getUnlockedPolicies() {
		return unlockedPolicies;
	}
	public void setUnlockedPolicies(List<Policy> unlockedPolicies) {
		this.unlockedPolicies = unlockedPolicies;
	}
	public List<Technology> getKnownTechnologies() {
		return knownTechnologies;
	}
	public void setKnownTechnologies(List<Technology> knownTechnologies) {
		this.knownTechnologies = knownTechnologies;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	public List<Unit> getUnits() {
		return units;
	}
	public void setUnits(List<Unit> units) {
		this.units = units;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (culture ^ (culture >>> 32));
		result = prime * result + (int) (gold ^ (gold >>> 32));
		result = prime * result + Float.floatToIntBits(happiness);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (science ^ (science >>> 32));
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
		if (!(obj instanceof Civilization))
			return false;
		Civilization other = (Civilization) obj;
		if (culture != other.culture)
			return false;
		if (gold != other.gold)
			return false;
		if (Float.floatToIntBits(happiness) != Float
				.floatToIntBits(other.happiness))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (science != other.science)
			return false;
		return true;
	}
   
}
