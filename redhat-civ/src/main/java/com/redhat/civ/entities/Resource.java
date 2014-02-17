package com.redhat.civ.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Resource
 *
 */
@Entity

public class Resource implements Serializable {

	   
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable=false)
	private String name;
	private int food;
	private int production;
	private int gold;
	private float happiness;
	
	@ManyToOne
	private Improvement improvement;
	@ManyToOne
	private Resource revealedBy;
	@ManyToMany
	private List<Building> requiredByBuildings;
	@ManyToMany
	private List<Unit> requiredByUnits;
	@OneToMany(mappedBy="resource")
	private List<Tile> canBeFoundOnTiles;
	
	private static final long serialVersionUID = 1L;

	public Resource() {
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
	public float getHappiness() {
		return this.happiness;
	}

	public void setHappiness(float happiness) {
		this.happiness = happiness;
	}
	public Improvement getImprovement() {
		return improvement;
	}
	public void setImprovement(Improvement improvement) {
		this.improvement = improvement;
	}
	public Resource getRevealedBy() {
		return revealedBy;
	}
	public void setRevealedBy(Resource revealedBy) {
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
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + food;
		result = prime * result + gold;
		result = prime * result + Float.floatToIntBits(happiness);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + production;
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
		if (!(obj instanceof Resource))
			return false;
		Resource other = (Resource) obj;
		if (food != other.food)
			return false;
		if (gold != other.gold)
			return false;
		if (Float.floatToIntBits(happiness) != Float
				.floatToIntBits(other.happiness))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (production != other.production)
			return false;
		return true;
	}
   
}
