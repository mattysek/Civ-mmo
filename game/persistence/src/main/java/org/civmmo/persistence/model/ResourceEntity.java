package org.civmmo.persistence.model;

import org.civmmo.model.*;
import java.io.Serializable;
import java.lang.String;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;
import org.hibernate.search.annotations.Indexed;

/**
 * Entity implementation class for Entity: Resource
 *
 */
@Entity
@Indexed
public class ResourceEntity extends Resource implements Serializable {

	   
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable=false)
	private String name;
	private int food;
	private int production;
	private int gold;
	private double happiness;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Improvement improvement;
	@ManyToOne(cascade = CascadeType.ALL)
	private Technology revealedBy;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Building> requiredByBuildings;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Unit> requiredByUnits;
	@OneToMany(mappedBy="resource", cascade = CascadeType.ALL)
	private List<Tile> canBeFoundOnTiles;
	
	private static final long serialVersionUID = 1L;

	public ResourceEntity() {
		super();
	}   
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public int getFood() {
		return this.food;
	}

	public void setFood(int food) {
		this.food = food;
	}   
	public int getProduction() {
		return this.production;
	}

	public void setProduction(int production) {
		this.production = production;
	}   
	public int getGold() {
		return this.gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}   
	public double getHappiness() {
		return this.happiness;
	}

	public void setHappiness(double happiness) {
		this.happiness = happiness;
	}
	public Improvement getImprovement() {
		return improvement;
	}
	public void setImprovement(Improvement improvement) {
		this.improvement = improvement;
	}
	public Technology getRevealedBy() {
		return revealedBy;
	}
	public void setRevealedBy(Technology revealedBy) {
		this.revealedBy = revealedBy;
	}
	public List<Building> getRequiredByBuildings() {
		return requiredByBuildings;
	}
	public void setRequiredByBuildings(List<Building> requiredByBuildings) {
		this.requiredByBuildings = requiredByBuildings;
	}
	public List<Unit> getRequiredByUnits() {
		return requiredByUnits;
	}
	public void setRequiredByUnits(List<Unit> requiredByUnits) {
		this.requiredByUnits = requiredByUnits;
	}
	public List<Tile> getCanBeFoundOnTiles() {
		return canBeFoundOnTiles;
	}
	public void setCanBeFoundOnTiles(List<Tile> canBeFoundOnTiles) {
		this.canBeFoundOnTiles = canBeFoundOnTiles;
	}
}
