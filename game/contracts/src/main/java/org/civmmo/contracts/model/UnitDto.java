package org.civmmo.contracts.model;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

public class UnitDto implements Serializable {

	private long id;
	private String name;
	private int cost;
	private int movementPoints;
	private int combatStrength;
	private int rangedCombatStrength;
	private int range;
	private int hitPoints;
	private int experience;
        
	private TileDto position;
	private List<ActionDto> actions;
	private List<UnitTypeDto> types;
	private List<PromotionDto> promotions;
	private List<CityDto> currentlyConstructedBy;
	private CivilizationDto ownedBy;
	private List<TileDto> visibleTiles;
	private List<TileDto> controledTiles;
	
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
	public int getCost() {
		return this.cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}   
	public int getMovementPoints() {
		return this.movementPoints;
	}

	public void setMovementPoints(int movementPoints) {
		this.movementPoints = movementPoints;
	}   
	public int getCombatStrength() {
		return this.combatStrength;
	}

	public void setCombatStrength(int combatStrength) {
		this.combatStrength = combatStrength;
	}   
	public int getRangedCombatStrength() {
		return this.rangedCombatStrength;
	}

	public void setRangedCombatStrength(int rangedCombatStrength) {
		this.rangedCombatStrength = rangedCombatStrength;
	}   
	public int getRange() {
		return this.range;
	}

	public void setRange(int range) {
		this.range = range;
	}   
	public int getHitPoints() {
		return this.hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}   
	public int getExperience() {
		return this.experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
	public TileDto getPosition() {
		return position;
	}
	public void setPosition(TileDto position) {
		this.position = position;
	}
	public List<ActionDto> getActions() {
		return actions;
	}
	public void setActions(List<ActionDto> actions) {
		this.actions = actions;
	}
	public List<UnitTypeDto> getTypes() {
		return types;
	}
	public void setTypes(List<UnitTypeDto> types) {
		this.types = types;
	}
	public List<PromotionDto> getPromotions() {
		return promotions;
	}
	public void setPromotions(List<PromotionDto> promotions) {
		this.promotions = promotions;
	}
	public List<CityDto> getCurrentlyConstructedBy() {
		return currentlyConstructedBy;
	}
	public void setCurrentlyConstructedBy(List<CityDto> currentlyConstructedBy) {
		this.currentlyConstructedBy = currentlyConstructedBy;
	}
	public CivilizationDto getOwnedBy() {
		return ownedBy;
	}
	public void setOwnedBy(CivilizationDto ownedBy) {
		this.ownedBy = ownedBy;
	}
	public List<TileDto> getVisibleTiles() {
		return visibleTiles;
	}
	public void setVisibleTiles(List<TileDto> visibleTiles) {
		this.visibleTiles = visibleTiles;
	}
	public List<TileDto> getControledTiles() {
		return controledTiles;
	}
	public void setControledTiles(List<TileDto> controledTiles) {
		this.controledTiles = controledTiles;
	}
	
}
