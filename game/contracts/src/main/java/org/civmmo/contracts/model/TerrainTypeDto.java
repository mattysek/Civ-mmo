package org.civmmo.contracts.model;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

public class TerrainTypeDto implements Serializable {

	private long id;
	private String name;
	private int food;
	private int production;
	private int gold;
	private int movementCost;
	
	private CombatModifierDto combatModifier;
	private List<TileDto> ofTiles;
	
	private static final long serialVersionUID = 1L;

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
	public CombatModifierDto getCombatModifier() {
		return combatModifier;
	}
	public void setCombatModifier(CombatModifierDto combatModifier) {
		this.combatModifier = combatModifier;
	}
	public List<TileDto> getOfTiles() {
		return ofTiles;
	}
	public void setOfTiles(List<TileDto> ofTiles) {
		this.ofTiles = ofTiles;
	}
}
