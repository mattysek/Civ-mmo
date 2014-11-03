package org.civmmo.persistence.model;

import org.civmmo.model.*;
import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.*;
import org.hibernate.search.annotations.Indexed;

/**
 * Entity implementation class for Entity: Civilization
 *
 */
@Entity
@Indexed
public class CivilizationEntity extends Civilization implements Serializable {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private long gold;
	private long culture;
	private long science;
	private double happiness;
	@ManyToOne(cascade = CascadeType.ALL)
	private SocialPolicy currentPolicy;
	@ManyToOne(cascade = CascadeType.ALL)
	private Technology currentlyStudiedTechnology;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Civilization> enemies;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Civilization> allies;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<SocialPolicy> availableSocialPolicies;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Policy> unlockedPolicies;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Technology> knownTechnologies;
	@OneToMany(mappedBy="ownedBy", cascade = CascadeType.ALL)
	private List<City> cities;
	@OneToMany(mappedBy="ownedBy", cascade = CascadeType.ALL)
	private List<Unit> units;
	
	private static final long serialVersionUID = 1L;

	public CivilizationEntity() {
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
	public double getHappiness() {
		return this.happiness;
	}

	public void setHappiness(double happiness) {
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
}
