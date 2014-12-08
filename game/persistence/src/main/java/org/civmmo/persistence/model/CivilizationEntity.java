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
	private SocialPolicyEntity currentPolicy;
	@ManyToOne(cascade = CascadeType.ALL)
	private TechnologyEntity currentlyStudiedTechnology;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<CivilizationEntity> enemies;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<CivilizationEntity> allies;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<SocialPolicyEntity> availableSocialPolicies;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<PolicyEntity> unlockedPolicies;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<TechnologyEntity> knownTechnologies;
	@OneToMany(mappedBy="ownedBy", cascade = CascadeType.ALL)
	private List<CityEntity> cities;
	@OneToMany(mappedBy="ownedBy", cascade = CascadeType.ALL)
	private List<UnitEntity> units;
	
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
		this.currentPolicy = (SocialPolicyEntity)currentPolicy;
	}
	public Technology getCurrentlyStudiedTechnology() {
		return currentlyStudiedTechnology;
	}
	public void setCurrentlyStudiedTechnology(Technology currentlyStudiedTechnology) {
		this.currentlyStudiedTechnology = (TechnologyEntity)currentlyStudiedTechnology;
	}
	public List<Civilization> getEnemies() {
		return new ArrayList<>(enemies);
	}
	public void setEnemies(List<Civilization> enemies) {
		this.enemies = (List<CivilizationEntity>)(List<?>)enemies;
	}
	public List<Civilization> getAllies() {
		return new ArrayList<>(allies);
	}
	public void setAllies(List<Civilization> allies) {
		this.allies = (List<CivilizationEntity>)(List<?>)allies;
	}
	public List<SocialPolicy> getAvailableSocialPolicies() {
		return new ArrayList<>(availableSocialPolicies);
	}
	public void setAvailableSocialPolicies(
			List<SocialPolicy> availableSocialPolicies) {
		this.availableSocialPolicies = (List<SocialPolicyEntity>)(List<?>)availableSocialPolicies;
	}
	public List<Policy> getUnlockedPolicies() {
		return new ArrayList<>(unlockedPolicies);
	}
	public void setUnlockedPolicies(List<Policy> unlockedPolicies) {
		this.unlockedPolicies = (List<PolicyEntity>)(List<?>)unlockedPolicies;
	}
	public List<Technology> getKnownTechnologies() {
		return new ArrayList<>(knownTechnologies);
	}
	public void setKnownTechnologies(List<Technology> knownTechnologies) {
		this.knownTechnologies = (List<TechnologyEntity>)(List<?>)knownTechnologies;
	}
	public List<City> getCities() {
		return new ArrayList<>(cities);
	}
	public void setCities(List<City> cities) {
		this.cities = (List<CityEntity>)(List<?>)cities;
	}
	public List<Unit> getUnits() {
		return new ArrayList<>(units);
	}
	public void setUnits(List<Unit> units) {
		this.units = (List<UnitEntity>)(List<?>)units;
	}
}
