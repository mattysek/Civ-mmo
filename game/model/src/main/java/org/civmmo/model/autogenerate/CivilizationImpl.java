package org.civmmo.model.autogenerate;

import org.civmmo.model.*;
import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity implementation class for Entity: Civilization
 *
 */
public class CivilizationImpl extends Civilization implements Serializable {

	private long id;
	private String name;
	private long gold;
	private long culture;
	private long science;
	private double happiness;
	private SocialPolicyImpl currentPolicy;
	private TechnologyImpl currentlyStudiedTechnology;
	private List<CivilizationImpl> enemies;
	private List<CivilizationImpl> allies;
	private List<SocialPolicyImpl> availableSocialPolicies;
	private List<PolicyImpl> unlockedPolicies;
	private List<TechnologyImpl> knownTechnologies;
	private List<CityImpl> cities;
	private List<UnitImpl> units;
	
	private static final long serialVersionUID = 1L;

	public CivilizationImpl() {
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
		this.currentPolicy = (SocialPolicyImpl)currentPolicy;
	}
	public Technology getCurrentlyStudiedTechnology() {
		return currentlyStudiedTechnology;
	}
	public void setCurrentlyStudiedTechnology(Technology currentlyStudiedTechnology) {
		this.currentlyStudiedTechnology = (TechnologyImpl)currentlyStudiedTechnology;
	}
	public List<Civilization> getEnemies() {
		return new ArrayList<>(enemies);
	}
	public void setEnemies(List<Civilization> enemies) {
		this.enemies = (List<CivilizationImpl>)(List<?>)enemies;
	}
	public List<Civilization> getAllies() {
		return new ArrayList<>(allies);
	}
	public void setAllies(List<Civilization> allies) {
		this.allies = (List<CivilizationImpl>)(List<?>)allies;
	}
	public List<SocialPolicy> getAvailableSocialPolicies() {
		return new ArrayList<>(availableSocialPolicies);
	}
	public void setAvailableSocialPolicies(
			List<SocialPolicy> availableSocialPolicies) {
		this.availableSocialPolicies = (List<SocialPolicyImpl>)(List<?>)availableSocialPolicies;
	}
	public List<Policy> getUnlockedPolicies() {
		return new ArrayList<>(unlockedPolicies);
	}
	public void setUnlockedPolicies(List<Policy> unlockedPolicies) {
		this.unlockedPolicies = (List<PolicyImpl>)(List<?>)unlockedPolicies;
	}
	public List<Technology> getKnownTechnologies() {
		return new ArrayList<>(knownTechnologies);
	}
	public void setKnownTechnologies(List<Technology> knownTechnologies) {
		this.knownTechnologies = (List<TechnologyImpl>)(List<?>)knownTechnologies;
	}
	public List<City> getCities() {
		return new ArrayList<>(cities);
	}
	public void setCities(List<City> cities) {
		this.cities = (List<CityImpl>)(List<?>)cities;
	}
	public List<Unit> getUnits() {
		return new ArrayList<>(units);
	}
	public void setUnits(List<Unit> units) {
		this.units = (List<UnitImpl>)(List<?>)units;
	}
}
