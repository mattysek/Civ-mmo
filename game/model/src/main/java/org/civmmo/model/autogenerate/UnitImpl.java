package org.civmmo.model.autogenerate;

import org.civmmo.model.*;
import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity implementation class for Entity: Unit
 *
 */
public class UnitImpl extends Unit implements Serializable {

	private long id;
	private String name;
	private int cost;
	private int movementPoints;
	private int combatStrength;
	private int rangedCombatStrength;
	private int range;
	private int hitPoints;
	private int experience;
        
	private TileImpl position;
	
	private List<UnitTypeImpl> types;
	private List<PromotionImpl> promotions;
	private List<CityImpl> currentlyConstructedBy;
	private CivilizationImpl ownedBy;
	private List<TileImpl> visibleTiles;
	private List<TileImpl> controledTiles;
	private List<UnitImpl> units;
	
	private static final long serialVersionUID = 1L;

	public UnitImpl() {
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
	public Tile getPosition() {
		return position;
	}
	public void setPosition(Tile position) {
		this.position = (TileImpl)position;
	}
	public List<UnitType> getTypes() {
		return new ArrayList<>(types);
	}
	public void setTypes(List<UnitType> types) {
		this.types = (List<UnitTypeImpl>)(List<?>)types;
	}
	public List<Promotion> getPromotions() {
		return new ArrayList<>(promotions);
	}
	public void setPromotions(List<Promotion> promotions) {
		this.promotions = (List<PromotionImpl>)(List<?>)promotions;
	}
	public List<City> getCurrentlyConstructedBy() {
		return new ArrayList<>(currentlyConstructedBy);
	}
	public void setCurrentlyConstructedBy(List<City> currentlyConstructedBy) {
		this.currentlyConstructedBy = (List<CityImpl>)(List<?>)currentlyConstructedBy;
	}
	public Civilization getOwnedBy() {
		return ownedBy;
	}
	public void setOwnedBy(Civilization ownedBy) {
		this.ownedBy = (CivilizationImpl)ownedBy;
	}
	public List<Tile> getVisibleTiles() {
		return new ArrayList<>(visibleTiles);
	}
	public void setVisibleTiles(List<Tile> visibleTiles) {
		this.visibleTiles = (List<TileImpl>)(List<?>)visibleTiles;
	}
	public List<Tile> getControledTiles() {
		return new ArrayList<>(controledTiles);
	}
	public void setControledTiles(List<Tile> controledTiles) {
		this.controledTiles = (List<TileImpl>)(List<?>)controledTiles;
	}

    @Override
    public List<Unit> getAttackedBy() {
        return new ArrayList<>(units);
    }

    @Override
    public void setAttackedBy(List<Unit> units) {
        this.units = (List<UnitImpl>)(List<?>)units;
    }
	
}
