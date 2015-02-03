package org.civmmo.model.autogenerate;

import org.civmmo.model.*;
import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity implementation class for Entity: Resource
 *
 */
public class ResourceImpl extends Resource implements Serializable {

	private long id;
	private String name;
	private int food;
	private int production;
	private int gold;
	private double happiness;
	
	private ImprovementImpl improvement;
	private TechnologyImpl revealedBy;
	private List<BuildingImpl> requiredByBuildings;
	private List<UnitImpl> requiredByUnits;
	private List<TileImpl> canBeFoundOnTiles;
	
	private static final long serialVersionUID = 1L;

	public ResourceImpl() {
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
		this.improvement = (ImprovementImpl)improvement;
	}
	public Technology getRevealedBy() {
		return revealedBy;
	}
	public void setRevealedBy(Technology revealedBy) {
		this.revealedBy = (TechnologyImpl)revealedBy;
	}
	public List<Building> getRequiredByBuildings() {
		return new ArrayList<>(requiredByBuildings);
	}
	public void setRequiredByBuildings(List<Building> requiredByBuildings) {
		this.requiredByBuildings = (List<BuildingImpl>)(List<?>)requiredByBuildings;
	}
	public List<Unit> getRequiredByUnits() {
		return new ArrayList<>(requiredByUnits);
	}
	public void setRequiredByUnits(List<Unit> requiredByUnits) {
		this.requiredByUnits = (List<UnitImpl>)(List<?>)requiredByUnits;
	}
	public List<Tile> getCanBeFoundOnTiles() {
		return new ArrayList<>(canBeFoundOnTiles);
	}
	public void setCanBeFoundOnTiles(List<Tile> canBeFoundOnTiles) {
		this.canBeFoundOnTiles = (List<TileImpl>)(List<?>)canBeFoundOnTiles;
	}
}
