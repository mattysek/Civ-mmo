package org.civmmo.model.autogenerate;

import org.civmmo.model.*;
import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;


/**
 * Entity implementation class for Entity: TerrainType
 *
 */
public class TerrainTypeImpl extends TerrainType implements Serializable {

	private long id;
	private String name;
	private int food;
	private int production;
	private int gold;
	private int movementCost;
	
	private CombatModifierImpl combatModifier;
	private List<TileImpl> ofTiles;
	
	private static final long serialVersionUID = 1L;

	public TerrainTypeImpl() {
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
		this.combatModifier = (CombatModifierImpl)combatModifier;
	}
	public List<Tile> getOfTiles() {
		return new ArrayList<>(ofTiles);
	}
	public void setOfTiles(List<Tile> ofTiles) {
		this.ofTiles = (List<TileImpl>)(List<?>)ofTiles;
	}
}
