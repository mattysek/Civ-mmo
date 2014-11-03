package org.civmmo.contracts.model;

import java.io.Serializable;
import java.lang.String;
import java.util.List;
import java.util.Objects;

public class ResourceDto implements Serializable {

	private long id;
	private String name;
	private int food;
	private int production;
	private int gold;
	private double happiness;
	
	private ImprovementDto improvement;
	private TechnologyDto revealedBy;
	private List<BuildingDto> requiredByBuildings;
	private List<UnitDto> requiredByUnits;
	private List<TileDto> canBeFoundOnTiles;
	
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
	public double getHappiness() {
		return this.happiness;
	}

	public void setHappiness(double happiness) {
		this.happiness = happiness;
	}
	public ImprovementDto getImprovement() {
		return improvement;
	}
	public void setImprovement(ImprovementDto improvement) {
		this.improvement = improvement;
	}
	public TechnologyDto getRevealedBy() {
		return revealedBy;
	}
	public void setRevealedBy(TechnologyDto revealedBy) {
		this.revealedBy = revealedBy;
	}
	public List<BuildingDto> getRequiredByBuildings() {
		return requiredByBuildings;
	}
	public void setRequiredByBuildings(List<BuildingDto> requiredByBuildings) {
		this.requiredByBuildings = requiredByBuildings;
	}
	public List<UnitDto> getRequiredByUnits() {
		return requiredByUnits;
	}
	public void setRequiredByUnits(List<UnitDto> requiredByUnits) {
		this.requiredByUnits = requiredByUnits;
	}
	public List<TileDto> getCanBeFoundOnTiles() {
		return canBeFoundOnTiles;
	}
	public void setCanBeFoundOnTiles(List<TileDto> canBeFoundOnTiles) {
		this.canBeFoundOnTiles = canBeFoundOnTiles;
	}
}
