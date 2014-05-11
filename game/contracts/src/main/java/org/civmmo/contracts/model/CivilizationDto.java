package org.civmmo.contracts.model;

import java.io.Serializable;
import java.lang.String;
import java.util.List;
import java.util.Objects;

public class CivilizationDto implements Serializable {

	private long id;
	private String name;
	private long gold;
	private long culture;
	private long science;
	private double happiness;
        
	private SocialPolicyDto currentPolicy;
	private TechnologyDto currentlyStudiedTechnology;
	private List<CivilizationDto> enemies;
	private List<CivilizationDto> allies;
	private List<SocialPolicyDto> availableSocialPolicies;
	private List<PolicyDto> unlockedPolicies;
	private List<TechnologyDto> knownTechnologies;
	private List<CityDto> cities;
	private List<UnitDto> units;
	
	private static final long serialVersionUID = 1L;
 
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
	public SocialPolicyDto getCurrentPolicy() {
		return currentPolicy;
	}
	public void setCurrentPolicy(SocialPolicyDto currentPolicy) {
		this.currentPolicy = currentPolicy;
	}
	public TechnologyDto getCurrentlyStudiedTechnology() {
		return currentlyStudiedTechnology;
	}
	public void setCurrentlyStudiedTechnology(TechnologyDto currentlyStudiedTechnology) {
		this.currentlyStudiedTechnology = currentlyStudiedTechnology;
	}
	public List<CivilizationDto> getEnemies() {
		return enemies;
	}
	public void setEnemies(List<CivilizationDto> enemies) {
		this.enemies = enemies;
	}
	public List<CivilizationDto> getAllies() {
		return allies;
	}
	public void setAllies(List<CivilizationDto> allies) {
		this.allies = allies;
	}
	public List<SocialPolicyDto> getAvailableSocialPolicies() {
		return availableSocialPolicies;
	}
	public void setAvailableSocialPolicies(
			List<SocialPolicyDto> availableSocialPolicies) {
		this.availableSocialPolicies = availableSocialPolicies;
	}
	public List<PolicyDto> getUnlockedPolicies() {
		return unlockedPolicies;
	}
	public void setUnlockedPolicies(List<PolicyDto> unlockedPolicies) {
		this.unlockedPolicies = unlockedPolicies;
	}
	public List<TechnologyDto> getKnownTechnologies() {
		return knownTechnologies;
	}
	public void setKnownTechnologies(List<TechnologyDto> knownTechnologies) {
		this.knownTechnologies = knownTechnologies;
	}
	public List<CityDto> getCities() {
		return cities;
	}
	public void setCities(List<CityDto> cities) {
		this.cities = cities;
	}
	public List<UnitDto> getUnits() {
		return units;
	}
	public void setUnits(List<UnitDto> units) {
		this.units = units;
	}
}
