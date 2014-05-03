package org.civmmo.persistence.model;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import org.hibernate.search.annotations.Indexed;

/**
 * Entity implementation class for Entity: TerrainType
 *
 */
@Entity
@Indexed
public class TerrainType implements Serializable {

	   
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable=false)
	private String name;
	private int food;
	private int production;
	private int gold;
	private int movementCost;
	
	@ManyToOne
	private CombatModifier combatModifier;
	@OneToMany(mappedBy="terrainType")
	private List<Tile> ofTiles;
	
	private static final long serialVersionUID = 1L;

	public TerrainType() {
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
	public int getMovementCost() {
		return this.movementCost;
	}

	public void setMovementCost(int movementCost) {
		this.movementCost = movementCost;
	}
	public CombatModifier getCombatModifier() {
		return combatModifier;
	}
	public void setCombatModifier(CombatModifier combatModifier) {
		this.combatModifier = combatModifier;
	}
	public List<Tile> getOfTiles() {
		return ofTiles;
	}
	public void setOfTiles(List<Tile> ofTiles) {
		this.ofTiles = ofTiles;
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
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + movementCost;
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
		if (!(obj instanceof TerrainType))
			return false;
		TerrainType other = (TerrainType) obj;
		if (food != other.food)
			return false;
		if (gold != other.gold)
			return false;
		if (id != other.id)
			return false;
		if (movementCost != other.movementCost)
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
