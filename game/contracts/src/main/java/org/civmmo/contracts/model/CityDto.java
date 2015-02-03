package org.civmmo.contracts.model;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

public class CityDto implements Serializable {

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
        
	private TileDto center;
	private CivilizationDto ownedBy;
	private BuildingDto currentlyConstructedBuilding;
	private List<BuildingDto> constructedBuildings;
	private List<BuildingDto> workedBuildings;
	private List<TradeRouteDto> tradeRoutesFrom;
	private List<TradeRouteDto> tradeRoutesTo;
	private List<TileDto> visibleTiles;
	private List<TileDto> controledTiles;
        private List<UnitDto> units;
	private List<TileDto> workedTiles;
	private UnitDto currentlyConstructedUnit;
	
	private static final long serialVersionUID = 1L;

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
	public TileDto getCenter() {
		return center;
	}
	public void setCenter(TileDto center) {
		this.center = center;
	}
	public CivilizationDto getOwnedBy() {
		return ownedBy;
	}
	public void setOwnedBy(CivilizationDto ownedBy) {
		this.ownedBy = ownedBy;
	}
	public BuildingDto getCurrentlyConstructedBuilding() {
		return currentlyConstructedBuilding;
	}
	public void setCurrentlyConstructedBuilding(
			BuildingDto currentlyConstructedBuilding) {
		this.currentlyConstructedBuilding = currentlyConstructedBuilding;
	}
        public List<UnitDto> getAttackedBy() {
		return units;
	}
	public void setAttackedBy(List<UnitDto> units) {
		this.units = units;
	}
	public List<BuildingDto> getConstructedBuildings() {
		return constructedBuildings;
	}
	public void setConstructedBuildings(List<BuildingDto> constructedBuildings) {
		this.constructedBuildings = constructedBuildings;
	}
	public List<BuildingDto> getWorkedBuildings() {
		return workedBuildings;
	}
	public void setWorkedBuildings(List<BuildingDto> workedBuildings) {
		this.workedBuildings = workedBuildings;
	}
	public List<TradeRouteDto> getTradeRoutesFrom() {
		return tradeRoutesFrom;
	}
	public void setTradeRoutesFrom(List<TradeRouteDto> tradeRoutesFrom) {
		this.tradeRoutesFrom = tradeRoutesFrom;
	}
	public List<TradeRouteDto> getTradeRoutesTo() {
		return tradeRoutesTo;
	}
	public void setTradeRoutesTo(List<TradeRouteDto> tradeRoutesTo) {
		this.tradeRoutesTo = tradeRoutesTo;
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
	public List<TileDto> getWorkedTiles() {
		return workedTiles;
	}
	public void setWorkedTiles(List<TileDto> workedTiles) {
		this.workedTiles = workedTiles;
	}
	public UnitDto getCurrentlyConstructedUnit() {
		return currentlyConstructedUnit;
	}
	public void setCurrentlyConstructedUnit(UnitDto currentlyConstructedUnit) {
		this.currentlyConstructedUnit = currentlyConstructedUnit;
	}
	
}
