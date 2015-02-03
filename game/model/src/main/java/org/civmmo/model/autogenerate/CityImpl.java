package org.civmmo.model.autogenerate;

import org.civmmo.model.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity implementation class for Entity: City
 *
 */
public class CityImpl extends City implements Serializable {

	private String name;  
	private long id;
	private int range;
	private int food;
	private int production;
	private int gold;
	private int science;
	private int culture;
	private int hitPoints;
	private int citizens;
        
	private TileImpl center;
	
	private CivilizationImpl ownedBy;
	private BuildingImpl currentlyConstructedBuilding;
	private List<BuildingImpl> constructedBuildings;
	private List<BuildingImpl> workedBuildings;
	private List<TradeRouteImpl> tradeRoutesFrom;
	private List<TradeRouteImpl> tradeRoutesTo;
	private List<TileImpl> visibleTiles;
	private List<TileImpl> controledTiles;
	private List<TileImpl> workedTiles;
	private UnitImpl currentlyConstructedUnit;
	private List<UnitImpl> units;
	
	private static final long serialVersionUID = 1L;

	public CityImpl() {
		super();
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public int getRange() {
		return this.range;
	}

	public void setRange(int range) {
		this.range = range;
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
	public int getScience() {
		return this.science;
	}

	public void setScience(int science) {
		this.science = science;
	}   
	public int getCulture() {
		return this.culture;
	}

	public void setCulture(int culture) {
		this.culture = culture;
	}   
	public int getHitPoints() {
		return this.hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}   
	public int getCitizens() {
		return this.citizens;
	}

	public void setCitizens(int citizens) {
		this.citizens = citizens;
	}
	public Tile getCenter() {
		return center;
	}
	public void setCenter(Tile center) {
		this.center = (TileImpl)center;
	}
	public Civilization getOwnedBy() {
		return ownedBy;
	}
	public void setOwnedBy(Civilization ownedBy) {
		this.ownedBy = (CivilizationImpl)ownedBy;
	}
	public Building getCurrentlyConstructedBuilding() {
		return currentlyConstructedBuilding;
	}
	public void setCurrentlyConstructedBuilding(
			Building currentlyConstructedBuilding) {
		this.currentlyConstructedBuilding = (BuildingImpl)currentlyConstructedBuilding;
	}
	public List<Building> getConstructedBuildings() {
		return new ArrayList<>(constructedBuildings);
	}
	public void setConstructedBuildings(List<Building> constructedBuildings) {
		this.constructedBuildings = (List<BuildingImpl>)(List<?>)constructedBuildings;
	}
	public List<Building> getWorkedBuildings() {
		return new ArrayList<>(workedBuildings);
	}
	public void setWorkedBuildings(List<Building> workedBuildings) {
		this.workedBuildings = (List<BuildingImpl>)(List<?>)workedBuildings;
	}
	public List<TradeRoute> getTradeRoutesFrom() {
		return new ArrayList<>(tradeRoutesFrom);
	}
	public void setTradeRoutesFrom(List<TradeRoute> tradeRoutesFrom) {
		this.tradeRoutesFrom = (List<TradeRouteImpl>)(List<?>)tradeRoutesFrom;
	}
	public List<TradeRoute> getTradeRoutesTo() {
		return new ArrayList<>(tradeRoutesTo);
	}
	public void setTradeRoutesTo(List<TradeRoute> tradeRoutesTo) {
		this.tradeRoutesTo = (List<TradeRouteImpl>)(List<?>)tradeRoutesTo;
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
	public List<Tile> getWorkedTiles() {
		return new ArrayList<>(workedTiles);
	}
	public void setWorkedTiles(List<Tile> workedTiles) {
		this.workedTiles = (List<TileImpl>)(List<?>)workedTiles;
	}
	public Unit getCurrentlyConstructedUnit() {
		return currentlyConstructedUnit;
	}
	public void setCurrentlyConstructedUnit(Unit currentlyConstructedUnit) {
		this.currentlyConstructedUnit = (UnitImpl)currentlyConstructedUnit;
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
